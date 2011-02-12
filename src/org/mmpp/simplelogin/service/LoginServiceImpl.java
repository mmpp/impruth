package org.mmpp.simplelogin.service;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.mmpp.simplelogin.model.User;


public class LoginServiceImpl implements LoginService{

    private javax.persistence.EntityManager _em;

    @PersistenceContext
    public void setEntityManager(javax.persistence.EntityManager em) {
        this._em = em;
    }
    private javax.persistence.EntityManager getEntityManager() {
        return _em;
    }

	public User findUserByEmailAddress(String emailAddress) {
		if(emailAddress.indexOf(" ")>=0)
			return null;
       Query query = getEntityManager().createQuery("select u FROM User u where emailAddress = '"+emailAddress+"'");
       java.util.List<User> results =  query.getResultList();
        if(results.size()!=1)
        	return null;
        return results.get(0);
	}

}
