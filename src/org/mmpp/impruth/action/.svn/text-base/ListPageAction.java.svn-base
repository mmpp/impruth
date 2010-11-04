package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.ListBook;
import org.mmpp.impruth.action.service.ListPageActionService;
import org.mmpp.impruth.action.service.ListPageActionServiceImpl;
import org.mmpp.impruth.service.ShelfService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 一覧ページ動的処理
 * @author mmpp kou
 *
 */
public class ListPageAction extends AbstractBookShlfServicePageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute(){
		return SUCCESS;
	}
	/**
	 * 書籍サービス
	 */
	private ListPageActionService _listPageActionService=null;
	public ListPageActionService getListPageActionService(){
		if(_listPageActionService==null){
			_listPageActionService = new ListPageActionServiceImpl();
			_listPageActionService.setShelfService(getShelfService());
		}
		return _listPageActionService;
	}
	
	private java.util.List<ListBook> _books = null;
	
	public java.util.List<ListBook> getBooks(){
		if(_books==null){
			_books = getListPageActionService().list();
		}
		
		return _books;
	}

}
