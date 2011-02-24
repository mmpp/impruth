package org.mmpp.impruth.service;

import java.util.Set;


import org.mmpp.impruth.model.OwnBook;
import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.simplelogin.model.User;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OwnBookServiceImpl implements OwnBookService , HibernateTemplateWare {

    private HibernateTemplate _hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
    	this._hibernateTemplate = hibernateTemplate;
    }
    public HibernateTemplate getHibernateTemplate(){
    	return _hibernateTemplate;
    }

    private final String SELECT_OWNBOOKS = "select o FROM OwnBook o,ReleaseInformation r where o.releaseId = r.id and o.userId = ? order by r.barcode ";
	@Override
	public Set<OwnBook> findOwnBooksByUser(User user) {
		java.util.List<OwnBook> results =  findUserBooks(user);
		java.util.Set<OwnBook> ownBooks = new java.util.HashSet<OwnBook>();
		for(OwnBook ownBook : results){
			ownBooks.add(ownBook);
		}
		return ownBooks;
	}

	@Override
	public Set<OwnBook> findOwnBooksByUser(User user, int pageCount, int pageNumber) {
		java.util.List<OwnBook> results =  findUserBooks(user);
		java.util.Set<OwnBook> ownBooks = new java.util.HashSet<OwnBook>();
		int firstCount = (pageNumber-1)*pageCount;
		int lastCount = pageNumber*pageCount;
		for(OwnBook ownBook : results){
			int i = results.indexOf(ownBook);
			if(firstCount>i)
				continue;
			if(lastCount<=i)
				continue;

			ownBooks.add(ownBook);
		}
		return ownBooks;

	}
	@Override
	public OwnBook registOwnBook(User user, String barcode) {

//		String slectSql = "select o FROM OwnBook o ,ReleaseInformation r where o.releaseId = r.id and o.userId = "+user.getId() + " and r.barcode = '"+barcode+"'";
//		java.util.List<OwnBook> results = getHibernateTemplate().find(slectSql);
		String slectSql = "select o FROM OwnBook o ,ReleaseInformation r where o.releaseId = r.id and o.userId = ? and r.barcode = ?";
		java.util.List<OwnBook> results = getHibernateTemplate().find(slectSql,new Object[]{user.getId(),barcode});
		if(results.size()!=0)
			return null;
//		String insertSql = "insert OWN_BOOK(user_id,barcode) values("+user.getId() + ",'"+barcode+"')";
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		User tmpUser = (User)(hibernateTemplate.find("select u FROM User u where id = ?",user.getId())).get(0);
		ReleaseInformation tmpReleaseInformation = (ReleaseInformation)(hibernateTemplate.find("select r FROM ReleaseInformation r where barcode = ? ",barcode)).get(0);
		
//		tmpUser.getOwnBooks().add(ownBook);
		OwnBook ownBook = new OwnBook(tmpUser.getId(),tmpReleaseInformation.getId());
		hibernateTemplate.save(ownBook);
//		hibernateTemplate.flush();
//		Query query = entityManager.createQuery(insertSql);
//		query.executeUpdate();

		results = hibernateTemplate.find(slectSql,new Object[]{user.getId(),barcode});
		if(results.size()!=1)
			return null;
			
		return (OwnBook) results.get(0);
	}
	@Override
	public int findCountBook(User user) {
		return DataAccessUtils.intResult( getHibernateTemplate().find("select count(*) FROM OwnBook o  where userId = "+user.getId()));
	}

	private java.util.List<OwnBook>  findUserBooks(User user){ 
		return getHibernateTemplate().find(SELECT_OWNBOOKS,user.getId());
	}
}
