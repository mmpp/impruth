package org.mmpp.impruth.action;

import org.mmpp.impruth.service.ShelfService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractBookShlfServicePageAction extends ActionSupport implements ApplicationContextAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 書籍サービス
	 */
	private ShelfService _shelfService=null;
	
	public ShelfService getShelfService(){
		if(_shelfService==null){
			_shelfService = ((ShelfService)getApplicationContext().getBean("shelfService"));
		}
		return _shelfService;
	}
	
	private ApplicationContext _applicationContext;
	private ApplicationContext getApplicationContext(){
		return _applicationContext;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		_applicationContext = applicationContext;
	}
}
