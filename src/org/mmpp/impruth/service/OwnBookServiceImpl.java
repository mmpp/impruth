package org.mmpp.impruth.service;

import java.util.Set;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.mmpp.impruth.model.OwnBook;
import org.mmpp.simplelogin.model.User;

public class OwnBookServiceImpl implements OwnBookService {

    private javax.persistence.EntityManager _em;

    @PersistenceContext
    public void setEntityManager(javax.persistence.EntityManager em) {
        this._em = em;
    }
    private javax.persistence.EntityManager getEntityManager() {
        return _em;
    }

	@Override
	public Set<OwnBook> findOwnBooksByUser(User user) {
		Query query = getEntityManager().createQuery("select o FROM OwnBook o where user_id = "+user.getId());
		java.util.List<OwnBook> results =  query.getResultList();
		java.util.Set<OwnBook> ownBooks = new java.util.HashSet<OwnBook>();
		for(OwnBook ownBook : results){
			ownBooks.add(ownBook);
		}
		return ownBooks;
	}

}
