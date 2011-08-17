package org.mmpp.impruth.service;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.mmpp.impruth.model.ReleaseInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 書籍リリース情報サービス実装クラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class ReleaseServiceImpl extends AbstractHibernateService implements ReleaseService,HibernateTemplateWare {
	/**
	 * ログ
	 */
	protected static Logger log = LoggerFactory.getLogger( ReleaseServiceImpl.class ); 


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

	@SuppressWarnings("unchecked")
	@Override
	public List<ReleaseInformation> findAll() {
		return getFindAllCriteria().list();
	}
	/**
	 * 全件取得のCriteriaを取得します
	 * @return Criteria
	 */
	private Criteria getFindAllCriteria(){
		Criteria criteria = getSession().createCriteria(ReleaseInformation.class);
		criteria.addOrder(Order.asc("barcode"));	
		return criteria;
	}
	@Override
	public int getTotalCount() {
	    Criteria crit = getSession().createCriteria(ReleaseInformation.class);
	    Integer rowCount = (Integer)crit.setProjection(Projections.rowCount()).uniqueResult();
		return rowCount.intValue();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ReleaseInformation> find(int pageView, int pageNo) {
		Criteria criteria = getFindAllCriteria();
		return addPagingCriteria(criteria, pageView, pageNo).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ReleaseInformation> find(int pageView, int pageNo, String search) {
		log.info(search);
		Criteria criteria = getFindAllCriteria();
		criteria.add(getLogicalExpression(search) );
		return addPagingCriteria(criteria, pageView, pageNo).list();
	}
	@Override
	public int getTotalCount(String search) {
		Criteria criteria = getSession().createCriteria(ReleaseInformation.class);
		criteria.add( getLogicalExpression(search) );
		Integer rowCount = (Integer)criteria.setProjection(Projections.rowCount()).uniqueResult();
		return rowCount.intValue();
	}
	
	private LogicalExpression getLogicalExpression(String search){
		return Restrictions.or( Restrictions.like("title", "%"+search+"%") ,Restrictions.like("author", "%"+search+"%"));
	}
}
