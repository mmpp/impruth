package org.mmpp.impruth.service.model;

import org.mmpp.impruth.model.ReleaseInformation;

/**
 * 書籍情報モデル
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class Book {

	/**
	 * 書籍タイトル格納変数
	 */
	private String _title;
	/**
	 * 著者名格納変数
	 */
	private String _author;
	/**
	 * バーコード格納変数
	 */
	private String _barcode;
	
	/**
	 * 表紙画像のURLアドレス
	 */
	public String _imageUrl;
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Book(){
		
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
	 * @param author
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
	public void setBarcode(String barcode){
		_barcode = barcode;
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
	 * 書籍情報を変換します
	 * @param releaseInformation DB内部蔵書情報
	 * @return ビジネス層書籍情報
	 */
	public static Book valueOf(ReleaseInformation releaseInformation) {
		Book book = new Book();
		book.setTitle(releaseInformation.getTitle());
		book.setAuthor(releaseInformation.getAuthor());
		book.setBarcode(releaseInformation.getBarcode());
		book.setImageUrl(releaseInformation.getAmazonImage());
		return book;
	}
	
}
