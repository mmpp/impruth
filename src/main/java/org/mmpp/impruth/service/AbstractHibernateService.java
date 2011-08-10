package org.mmpp.impruth.service;

import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Hibernate利用サービスの抽象クラス
 * @author mmpp wataru
 *
 */
public class AbstractHibernateService {
	/**
	 * 内部格納HibernateTemplateクラス
	 */
	private HibernateTemplate _hibernateTemplate;
	/**
	 * HibernateTemplateを格納します
	 * @param hibernateTemplate HibernateTemplate
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		this._hibernateTemplate = hibernateTemplate;
	}
	/**
	 * HibernateTemplateを取得します
	 * @return HibernateTemplate
	 */
	protected HibernateTemplate getHibernateTemplate(){
		return _hibernateTemplate;
	}

	/**
	 * DB接続セッション格納変数
	 */
	private org.hibernate.Session _session ;
	/**
	 * DB接続セッションを取得します
	 * @return DB接続セッション
	 */
	protected org.hibernate.Session getSession(){
		if(!(_session!=null&&_session.isOpen())){
			_session = getHibernateTemplate().getSessionFactory().openSession();
		}
		return _session;
	}
	
	protected Criteria addPagingCriteria(Criteria criteria, int pageView, int pageNumber){
		int firstCount = (pageNumber-1)*pageView;

		criteria.setMaxResults(pageView);
		criteria.setFirstResult(firstCount);
		return criteria;
	}
}
