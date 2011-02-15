package org.mmpp.impruth.service;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.mmpp.impruth.model.OwnBook;
import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.simplelogin.model.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class OwnBookServiceImpl implements OwnBookService , HibernateTemplateWare {

    private HibernateTemplate _hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
    	this._hibernateTemplate = hibernateTemplate;
    }
    public HibernateTemplate getHibernateTemplate(){
    	return _hibernateTemplate;
    }

	@Override
	public Set<OwnBook> findOwnBooksByUser(User user) {
		java.util.List<OwnBook> results =  getHibernateTemplate().find("select o FROM OwnBook o  where userId = "+user.getId());
		java.util.Set<OwnBook> ownBooks = new java.util.HashSet<OwnBook>();
		for(OwnBook ownBook : results){
			ownBooks.add(ownBook);
		}
		return ownBooks;
	}
	@Override
	public OwnBook registOwnBook(User user, String barcode) {

		String slectSql = "select o FROM OwnBook o ,ReleaseInformation r where o.releaseId = r.id and o.userId = "+user.getId() + " and r.barcode = '"+barcode+"'";
		java.util.List<OwnBook> results = getHibernateTemplate().find(slectSql);
		if(results.size()!=0)
			return null;
//		String insertSql = "insert OWN_BOOK(user_id,barcode) values("+user.getId() + ",'"+barcode+"')";
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		User tmpUser = (User)(hibernateTemplate.find("select u FROM User u where id = "+user.getId())).get(0);
		ReleaseInformation tmpReleaseInformation = (ReleaseInformation)(hibernateTemplate.find("select r FROM ReleaseInformation r where barcode = '"+barcode+"'")).get(0);
		
//		tmpUser.getOwnBooks().add(ownBook);
		OwnBook ownBook = new OwnBook(tmpUser.getId(),tmpReleaseInformation.getId());
		hibernateTemplate.save(ownBook);
//		hibernateTemplate.flush();
//		Query query = entityManager.createQuery(insertSql);
//		query.executeUpdate();

		results = hibernateTemplate.find(slectSql);
		if(results.size()!=1)
			return null;
			
		return (OwnBook) results.get(0);
	}

}
