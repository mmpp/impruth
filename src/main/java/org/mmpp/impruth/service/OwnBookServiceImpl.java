package org.mmpp.impruth.service;

import java.util.Set;


import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.mmpp.impruth.model.OwnBook;
import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.model.User;

/**
 * 蔵書サービス実装クラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class OwnBookServiceImpl extends AbstractHibernateService implements OwnBookService , HibernateTemplateWare {

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
		Criteria criteria = getSession().createCriteria(ReleaseInformation.class);
		criteria.add(Restrictions.eq("barcode", barcode));
		ReleaseInformation tmpReleaseInformation = (ReleaseInformation)criteria.uniqueResult();
		OwnBook bookOwn = new OwnBook(user.getId(),tmpReleaseInformation.getId());
		// メモリ上でのリレーション追加 TODO 本来は不要
		user.getBooks().add(tmpReleaseInformation);
		
		getHibernateTemplate().save(bookOwn);
		return null;
	}
	@Override
	public int findCountBook(User user) {
		// http://docs.jboss.org/hibernate/core/3.5/reference/ja-JP/html/querycriteria.html
		// http://ryoji.sakura.ne.jp/mt/archives/2005/05/hibernate_crite_1.html
		// http://www.syboos.jp/hibernate/doc/20080821182623833.html
	    Criteria crit = getSession().createCriteria(OwnBook.class);
	    crit.add(Restrictions.eq("userId",user.getId()));

	    Integer rowCount = (Integer)crit.setProjection(Projections.rowCount()).uniqueResult();
		return rowCount.intValue();
	}

	@SuppressWarnings("unchecked")
	private java.util.List<OwnBook>  findUserBooks(User user){ 
		return getHibernateTemplate().find(SELECT_OWNBOOKS,user.getId());
	}
}
