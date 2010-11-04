package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.DetailBook;
import org.mmpp.impruth.action.models.ListBook;
import org.mmpp.impruth.model.ShelfObject;
import org.mmpp.impruth.service.ShelfService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 詳細ページアクション
 * @author mmpp kou
 *
 */
public class DetailPageAction  extends AbstractBookShlfServicePageAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute(){
		return SUCCESS;
	}
	private Integer _id;
	public void setId(Integer id){
		_id = id;
	}
	public Integer getId(){
		return _id;
	}
	private DetailBook _detailBook=null;
	
	public DetailBook getDetailBook(){
		if(_detailBook==null){
			_detailBook = DetailBook.valueOf(getShelfService().find(getId()));
		}
		return _detailBook;
	}

}
