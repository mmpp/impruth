package org.mmpp.impruth.action.models;

import org.mmpp.impruth.service.model.Book;

/**
 * JSON通信用 書籍情報モデル
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BookJson {

	private String _title;
	private String _author;
	private String _barcode;
	/**
	 * 表紙画像のURLアドレス
	 */
	public String _imageUrl;

	private BookJson(){
		
	}
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		this._title = title;
	}
	public String getAuthor() {
		return _author;
	}
	public void setAuthor(String author) {
		this._author = author;
	}
	public String getBarcode() {
		return _barcode;
	}
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
	 * 
	 * @param book
	 * @return
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
