package org.mmpp.impruth.service;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.mmpp.impruth.model.ReleaseInformation;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * 書籍リリース情報サービス実装クラス
 * @author kou
 *
 */
public class ReleaseServiceImpl implements ReleaseService,HibernateTemplateWare {

	/**
	 * 内部格納HibernateTemplateクラス
	 */
	private HibernateTemplate _hibernateTemplate;
	@Override
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		this._hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate(){
		return _hibernateTemplate;
	}

	@Override
	public ReleaseInformation find(String barcode) {
//		return findSql("select r from ReleaseInformation r where barcode = ?",barcode);
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
	 * DB接続セッション格納変数
	 */
	private org.hibernate.Session _session ;
	/**
	 * DB接続セッションを取得します
	 * @return
	 */
	private org.hibernate.Session getSession(){
		if(!(_session!=null&&_session.isOpen())){
			_session = getHibernateTemplate().getSessionFactory().openSession();
		}
		return _session;
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
}
