package org.mmpp.impruth.action;

import org.mmpp.impruth.action.models.BookJson;
import org.mmpp.impruth.service.BookService;
import org.mmpp.impruth.service.model.Book;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 書籍情報をJSON形式で取得するページアクション
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BookJsonAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 表示ページ番号
	 */
	private int _pageNo = 1;
	/**
	 * ページ表示件数
	 */
	private int _pageView = 28;
	/**
	 * 書籍情報サービス
	 */
	private BookService _bookService=null;
	
	/**
	 * 表示ページ番号を取得します
	 * @return 表示ページ番号
	 */
	public int getPageNo(){
		return _pageNo;
	}
	/**
	 * ページ表示件数を格納します
	 * @param pageView ページ表示件数
	 */
	public void setPageView(int pageView){
		_pageView = pageView;
	}
	/**
	 * ページ表示件数を取得します
	 * @return ページ表示件数
	 */
	public int getPageView(){
		return _pageView;
	}
	/**
	 * 表示ページ番号を格納します
	 * @param pageNo 表示ページ番号
	 */
	public void setPageNo(int pageNo){
		_pageNo = pageNo;
	}
	/**
	 * 蓄積書籍数を取得します
	 * @return 蓄積書籍数 
	 */
	public int getTotalCount(){
		return getBookService().getTotalCount();
	}
	/**
	 * 書籍情報を取得します
	 * @return 書籍情報
	 */
	public java.util.List<BookJson> getResults(){
		java.util.List<BookJson> results = new java.util.LinkedList<BookJson>();
		
		for(Book book : getBookService().select(getPageNo(), getPageView()))
			results.add(BookJson.valueOf(book));
		return results;
	}
	/**
	 * 書籍情報サービスを格納します
	 * @param bookService 書籍情報サービス
	 */
	public void setBookService(BookService bookService) {
		_bookService = bookService;
	}
	/**
	 * 書籍情報サービスを取得します
	 * @return 書籍情報サービス
	 */
	private BookService getBookService(){
		return _bookService;
	}
}
