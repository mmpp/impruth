package org.mmpp.impruth.service;

import org.mmpp.impruth.service.model.Book;


/**
 * 書籍情報サービスインタフェイス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public interface BookService {

	/**
	 * 書籍情報を取得します
	 * @param pageNo ページ番号
	 * @param pageView ページ件数
	 * @return 書籍情報
	 */
	public java.util.List<Book> select(int pageNo,int pageView);

	/**
	 * 書籍件数を取得します
	 * @return 書籍件数
	 */
	public int getTotalCount();

	/**
	 * 書籍情報を取得します
	 * @param isbn バーコード
	 * @return 書籍情報
	 */
	public Book find(String isbn);
	
}
