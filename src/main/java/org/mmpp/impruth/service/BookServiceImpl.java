package org.mmpp.impruth.service;

import java.util.List;

import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 書籍情報サービス実装クラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BookServiceImpl implements BookService{
	/**
	 * ログ
	 */
	protected static Logger log = LoggerFactory.getLogger( BookServiceImpl.class ); 
	/**
	 * リリース情報サービス
	 */
	private ReleaseService _releaseService=null;
	/**
	 * リリース情報サービスを格納します
	 * @param releaseService リリース情報サービス
	 */
	public void setReleaseService(ReleaseService releaseService){
		_releaseService = releaseService;
	}
	/**
	 * リリース情報サービスを取得します
	 * @return リリース情報サービス
	 */
	public ReleaseService getReleaseService(){
		return _releaseService;
	}
	@Override
	public List<Book> select(int pageNo, int pageView) {
		List<ReleaseInformation> results = getReleaseService().find(pageView,pageNo);
		return castReleaseInformations2Books(results);
	}
	/**
	 * DBマッピングリリース情報を書籍情報に変換します
	 * @param releaseInformations DBマッピングリリース情報
	 * @return 書籍情報
	 */
	private List<Book> castReleaseInformations2Books(List<ReleaseInformation> releaseInformations){
		java.util.List<Book>  books = new java.util.LinkedList<Book>();
		for(ReleaseInformation shelfObject:releaseInformations){
			books.add(Book.valueOf(shelfObject));
		}
		return books;
	}
	
	@Override
	public int getTotalCount() {
		return getReleaseService().getTotalCount();
	}
	@Override
	public Book find(String isbn) {
		ReleaseInformation result = getReleaseService().find(isbn);
		if(result==null)
			return null;
		
		return Book.valueOf(result);
	}
	@Override
	public List<Book> select(int pageNo, int pageView, String search) {
		List<ReleaseInformation> results = getReleaseService().find(pageView,pageNo,search);
		return castReleaseInformations2Books(results);
	}
	@Override
	public int getTotalCount(String title) {
		return getReleaseService().getTotalCount(title);
	}

}
