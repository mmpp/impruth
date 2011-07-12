package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.ShelfBook;
import org.mmpp.impruth.action.models.ShelfBookImpl;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 所有書籍情報アクションクラス
 * @author mmpp kou
 *
 */
public class ShelfPageAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 蔵書情報
	 */
	private ShelfBook _shelfBook = null;
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	public String onClickMeneHope(){
		return "hope_list";
	}
	
	public String onClickMeneAdd(){
		_shelfBook = new ShelfBookImpl();
		return SUCCESS;
	}
	public String onClickReset(){
		_shelfBook = null;
		System.out.println("resrt");
		return SUCCESS;
	}

	public ShelfBook getShelfBook(){
		return _shelfBook;
	}
	public void setShelfBook(ShelfBook shelfBook){
		_shelfBook = shelfBook;
	}
	
}
