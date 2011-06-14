package org.mmpp.simplelogin.service;

import org.mmpp.simplelogin.model.User;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class LoginServiceImpl implements LoginService{

    private HibernateTemplate _hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
    	this._hibernateTemplate = hibernateTemplate;
    }
    public HibernateTemplate getHibernateTemplate(){
    	return _hibernateTemplate;
    }

	public User findUserByEmailAddress(String emailAddress) {
		if(emailAddress.indexOf(" ")>=0)
			return null;
		java.util.List<User> results =  getHibernateTemplate().find("select u FROM User u where emailAddress = '"+emailAddress+"'");
        if(results.size()!=1)
        	return null;
        return results.get(0);
	}

}
