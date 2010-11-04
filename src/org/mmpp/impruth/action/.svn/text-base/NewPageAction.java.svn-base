package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.NewBook;
import org.mmpp.impruth.model.ShelfObject;
import org.mmpp.impruth.service.ShelfService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 新規作成ページ
 * @author mmpp kou
 *
 */
public class NewPageAction extends AbstractBookShlfServicePageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NewBook _newBook= null;
	
	public String execute(){
		if(_currentId==null)
			return INPUT;
		_currentId = getShelfService().insert(_newBook.toShelfBook()).getId();
		return SUCCESS;
	}
	private Integer _currentId=null;
	public Integer getCurrentId(){
		if(_currentId==null){
			_currentId = getNewBook().getId();
		}
		return _currentId;
	}
	public void setCurrentId(Integer id){
		_currentId = id;
	}
	public NewBook getNewBook(){
		if(_newBook==null){
			ShelfObject shelfObject = getShelfService().createNew();
			_newBook = NewBook.valueOf(shelfObject);
		}
		return _newBook;
	}
	public void setNewBook(NewBook newBook){
		_newBook = newBook;
	}
	/**
	 * バーコードの入力値からWebから情報を抽出します
	 * @return ページ結果
	 */
	public String scanBarcode(){
		System.out.println(" scanBarcode : " + _newBook.getBarcode());
		return INPUT;
	}
}
