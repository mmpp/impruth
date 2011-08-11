package org.mmpp.impruth.action;

import org.apache.commons.codec.binary.Base64;
import org.mmpp.impruth.action.models.BookJson;
import org.mmpp.impruth.service.BookService;
import org.mmpp.impruth.service.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 書籍情報をJSON形式で取得するページアクション
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BookJsonAction extends ActionSupport{
	/**
	 * ログ
	 */
	protected static Logger log = LoggerFactory.getLogger( BookJsonAction.class ); 

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
	 * 検索タイトルを格納する変数
	 */
	private String _title=null;
	
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
		if(getTitle()!=null)
			return getBookService().getTotalCount(getTitle());

		return getBookService().getTotalCount();
	}
	/**
	 * 書籍情報を取得します
	 * @return 書籍情報
	 */
	public java.util.List<BookJson> getResults(){
		java.util.List<BookJson> results = new java.util.LinkedList<BookJson>();
		java.util.List<Book> books;
		// 検索を行うかの判断
		if(getTitle()!=null){
			books = getBookService().select(getPageNo(), getPageView(),getTitle());
		}else{
			books = getBookService().select(getPageNo(), getPageView());
		}
		for(Book book : books)
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
	/**
	 * タイトルで検索します
	 * @param title タイトル
	 */
	public void setTitle(String title){
		_title = new String(Base64.decodeBase64(title.getBytes()));
	}
	/**
	 * 検索タイトルを取得します
	 * @return 検索タイトル
	 */
	public String getTitle(){
		return _title;
	}
}
