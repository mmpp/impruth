package org.mmpp.impruth.action;

import org.mmpp.impruth.service.BookService;
import org.mmpp.impruth.service.model.Book;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 書籍情報ページアクション
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class DetailPageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 書籍情報サービス格納変数
	 */
	private BookService _bookService;
	

	/**
	 * 詳細情報表示ISBNコード
	 */
	private String _isbn=null;
	/**
	 * バーコードを格納します
	 * @param isbn バーコード
	 */
	public void setIsbn(String isbn) {
		_isbn = isbn;
	}
	/**
	 * バーコードを取得します
	 * @return バーコード
	 */
	public String getIsbn() {
		return _isbn;
	}
	/**
	 * 書籍情報サービスを格納します
	 * @param releaseService 書籍情報サービス
	 */
	public void setBookService(BookService bookService) {
		_bookService = bookService;		
	}
	/**
	 * 書籍情報サービスを取得します
	 * @return 書籍情報サービス
	 */
	public BookService getBookService() {
		return _bookService;		
	}


	/**
	 * 詳細情報を取得します
	 * @return 詳細情報
	 */
	public org.mmpp.impruth.action.models.DetailPageElement getDetail() {
		if(getBookService()==null)
			return null;
		String isbn = getIsbn();
		if(isbn==null)
			return null;
		Book book = getBookService().find(isbn);
		org.mmpp.impruth.action.models.DetailPageElement result = org.mmpp.impruth.action.models.DetailPageElement.valueOf(book);
		return result;
	}

}
