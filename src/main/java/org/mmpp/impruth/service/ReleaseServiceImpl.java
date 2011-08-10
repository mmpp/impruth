package org.mmpp.impruth.service;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.mmpp.impruth.model.ReleaseInformation;

/**
 * 書籍リリース情報サービス実装クラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class ReleaseServiceImpl extends AbstractHibernateService implements ReleaseService,HibernateTemplateWare {


	@Override
	public ReleaseInformation find(String barcode) {
		return executeCriteria(Restrictions.eq("barcode", barcode));
	}
	@Override
	public void save(ReleaseInformation releaseInformation) {
		getHibernateTemplate().save(releaseInformation);
	}
	@Override
	public ReleaseInformation findReleaseInformationById(int releaseId) {
		return executeCriteria(Restrictions.eq("id", Integer.valueOf(releaseId)));
	}
	/**
	 * 検索条件からDBからリリース情報を取得します
	 * @param criterion 検索条件
	 * @return 検索結果
	 */
	private ReleaseInformation executeCriteria(Criterion criterion){
		Criteria criteria = getSession().createCriteria(ReleaseInformation.class);
		criteria.add(criterion);
		return (ReleaseInformation)criteria.uniqueResult();

	}

	/**
	 * 書籍情報を取得します
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReleaseInformation> findAll() {
		Criteria criteria = getSession().createCriteria(ReleaseInformation.class);
		criteria.addOrder(Order.asc("barcode"));	
		return criteria.list();
	}
	@Override
	public int getTotalCount() {
	    Criteria crit = getSession().createCriteria(ReleaseInformation.class);
	    Integer rowCount = (Integer)crit.setProjection(Projections.rowCount()).uniqueResult();
		return rowCount.intValue();
	}
}
