package org.mmpp.impruth.action.models;

import org.mmpp.impruth.service.model.Book;

/**
 * JSON通信用 書籍情報モデル
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BookJson {

	/**
	 * 書籍タイトル
	 */
	private String _title;
	/**
	 * 著者名
	 */
	private String _author;
	/**
	 * バーコード
	 */
	private String _barcode;
	/**
	 * 表紙画像のURLアドレス
	 */
	public String _imageUrl;
	/**
	 * デフォルトコンストラクタ
	 */
	private BookJson(){
		
	}
	/**
	 * 書籍タイトルを取得します
	 * @return 書籍タイトル
	 */
	public String getTitle() {
		return _title;
	}
	/**
	 * 書籍タイトルを格納します
	 * @param title 書籍タイトル
	 */
	public void setTitle(String title) {
		this._title = title;
	}
	/**
	 * 著者名を取得します
	 * @return 著者名
	 */
	public String getAuthor() {
		return _author;
	}
	/**
	 * 著者名を格納します
	 * @param author 著者名
	 */
	public void setAuthor(String author) {
		this._author = author;
	}
	/**
	 * バーコードを取得します
	 * @return バーコード
	 */
	public String getBarcode() {
		return _barcode;
	}
	/**
	 * バーコードを格納します
	 * @param barcode バーコード
	 */
	public void setBarcode(String barcode) {
		this._barcode = barcode;
	}
	/**
	 * 表紙イメージのURLを取得します
	 * @return 表紙イメージのURL ( null :画像無し)
	 */
	public String getImageUrl() {
		return _imageUrl;
	}
	/**
	 *  表紙イメージのURLを格納します
	 * @param imageUrl 表紙イメージのURL
	 */
	public void setImageUrl(String imageUrl){
		_imageUrl = imageUrl;
	}
	
	/**
	 * 書籍(JSON)情報を取得します
	 * @param book ビジネス層　書籍情報
	 * @return 書籍情報(JSON)
	 */
	public static BookJson valueOf(Book book) {
		BookJson bookJson = new BookJson();
		bookJson.setTitle(book.getTitle());
		bookJson.setAuthor(book.getAuthor());
		bookJson.setBarcode(book.getBarcode());
		bookJson.setImageUrl(book.getImageUrl());
		return bookJson;
	}
	
}
