package org.mmpp.impruth.service;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.mmpp.impruth.model.User;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UserServiceImpl implements UserService, HibernateTemplateWare {

    private HibernateTemplate _hibernateTemplate;

	@Override
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
    	this._hibernateTemplate = hibernateTemplate;
    }
    public HibernateTemplate getHibernateTemplate(){
    	return _hibernateTemplate;
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
	@Override
	public User find(String userID) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("emailAddress",userID));
		return (User)criteria.uniqueResult();
	}
}
