package org.mmpp.impruth.action;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.mmpp.impruth.action.models.OwnBookListElement;
import org.mmpp.impruth.model.OwnBook;
import org.mmpp.impruth.service.OwnBookService;
import org.mmpp.simplelogin.action.UserAware;
import org.mmpp.simplelogin.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class OwnListPageAction extends ActionSupport implements UserAware,OwnBookServiceAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() {
		return SUCCESS;
	}

	private User _user;
	@Override
	public void setUser(User user) {
		_user = user;
	}
	public User getUser( ) {
		return _user;
	}
	
	public java.util.List<OwnBookListElement> getOwnBooks(){
		// Caused by: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: org.mmpp.simplelogin.model.User.ownBooks, no session or session was closed
		// return getOwnBookListElements(getUser( ).getOwnBooks());
		return getOwnBookListElements(getUser());
	}
	private List<OwnBookListElement> getOwnBookListElements(User user) {
		return getOwnBookListElements(getOwnBookService().findOwnBooksByUser(user));
	}
	private OwnBookService _ownBookService;
	private OwnBookService getOwnBookService() {
		return _ownBookService;
	}
	public void setOwnBookService(OwnBookService ownBookService) {
		_ownBookService = ownBookService;
	}
	private List<OwnBookListElement> getOwnBookListElements(Set<OwnBook> ownBooks) {
		 java.util.List<OwnBookListElement> ownBookListElements = new java.util.LinkedList<OwnBookListElement>();
		for(OwnBook ownBook:ownBooks){
			ownBookListElements.add(OwnBookListElement.valueOf(ownBook));
		}
		java.util.Collections.sort( ownBookListElements , new Comparator<OwnBookListElement>() {

			@Override
			public int compare(OwnBookListElement ownBook1, OwnBookListElement ownBook2) {
				return ownBook1.getBarcode().compareTo(ownBook2.getBarcode());
			}
		});
		return ownBookListElements;
	}
	private OwnBookListElement _ownBook;
	public OwnBookListElement getOwnBook(){
		return _ownBook;
	}
	public void setOwnBook(OwnBookListElement ownBook){
		_ownBook = ownBook;
	}
	public String onClickAddOwnBook(){
		_ownBook = new OwnBookListElement();
		return INPUT;
	}
	
	public String onClickRegist(){
		// TODO 新規登録処理
		getOwnBookService().registOwnBook(getUser(),getOwnBook().getBarcode());
		return SUCCESS;
	}
}
