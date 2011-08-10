package org.mmpp.impruth.service;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
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

	@SuppressWarnings("unchecked")
	@Override
	public java.util.List<OwnBook> findOwnBooksByUser(User user) {
		Criteria criteria = getSession().createCriteria(OwnBook.class);
		criteria.add(Restrictions.eq("userId",user.getId()));
		return (java.util.List<OwnBook>)criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public java.util.List<OwnBook> findOwnBooksByUser(User user, int pageView, int pageNumber) {
		Criteria criteria = getSession().createCriteria(OwnBook.class);
		criteria.add(Restrictions.eq("userId",user.getId()));
		return (java.util.List<OwnBook>)addPagingCriteria(criteria,pageView,pageNumber).list();

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

}
