package org.mmpp.impruth.action.models;

import org.mmpp.impruth.service.model.Release;

/**
 * バーコード検索JSON結果
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class ScanBarcodeJsonBook {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * タイトル
	 */
	private String _title;
	/**
	 * 通巻表記
	 */
	private String _number;
	/**
	 * 著者
	 */
	private String _authorName;
	/**
	 * 出版社
	 */
	private String _publishCompanyName;
	/**
	 * バーコード
	 */
	private String _barcode;

	/**
	 * 管理ID
	 */
	private String _id;

	/**
	 * 発売日
	 */
	private String _releaseDate;

	/**
	 * 画像Url
	 */
	private String _imageUrl;

	/**
	 * アマゾンID
	 */
	private String _asin;
	/**
	 * タイトルを取得します
	 * @return タイトル
	 */
	public String getTitle() {
		return _title;
	}
	/**
	 * タイトルを格納します
	 * @param title タイトル
	 */
	public void setTitle(String title) {
		this._title = title;
	}
	/**
	 * 通巻表記を取得します
	 * @return 通巻表記
	 */
	public String getNumber() {
		return _number;
	}
	/**
	 * 通巻表記を格納します
	 * @param number 通巻表記
	 */
	public void setNumber(String number) {
		this._number = number;
	}
	/**
	 * 著者名を取得します
	 * @return 著者名
	 */
	public String getAuthorName() {
		return _authorName;
	}
	/**
	 * 著者名を格納します
	 * @param authorName 著者名
	 */
	public void setAuthorName(String authorName) {
		this._authorName = authorName;
	}
	/**
	 * 出版社名を取得します
	 * @return 出版社名
	 */
	public String getPublishCompanyName() {
		return _publishCompanyName;
	}
	/**
	 * 出版社名を格納します
	 * @param publishCompanyName 出版社名
	 */
	public void setPublishCompanyName(String publishCompanyName) {
		this._publishCompanyName = publishCompanyName;
	}
	/**
	 * 管理IDを取得します
	 * @return 管理ID
	 */
	public String getId() {
		return _id;
	}
	/**
	 * 管理IDを格納します
	 * @param id 管理ID
	 */
	public void setId(String id) {
		_id = id;		
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
		_barcode = barcode;		
	}
	/**
	 * リリース日を格納します
	 * @param releaseDate リリース日
	 */
	public String getReleaseDate() {
		return _releaseDate;
	}
	/**
	 * リリース日を取得します
	 * @return リリース日
	 */
	public void setReleaseDate(String releaseDate){
		_releaseDate = releaseDate;
	}
	/**
	 * 画像URLを取得します
	 * @return 画像URL
	 */
	public String getImageUrl() {
		return _imageUrl;
	}
	/**
	 * 画像URLを格納します
	 * @param imageUrl 画像URL
	 */
	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}
	/**
	 * アマゾンコードを取得します
	 * @return アマゾンコード
	 */
	public String getASIN() {
		return _asin;
	}
	/**
	 * アマゾンコードを格納します
	 * @param asin アマゾンコード
	 */
	public void setASIN(String asin) {
		_asin = asin;
	}
	/**
	 * リリース情報からバーコード検索結果JSONクラスを生成します
	 * @param release リリース情報
	 * @return バーコード検索結果JSONクラス
	 */
	public static ScanBarcodeJsonBook valueOf(Release release) {
		ScanBarcodeJsonBook jsonBook = new ScanBarcodeJsonBook();
		jsonBook.setBarcode(release.getBarcode());
		jsonBook.setAuthorName(release.getAuthorName());
		jsonBook.setTitle(release.getTitle());
		jsonBook.setPublishCompanyName(release.getPublishCompanyName());
		jsonBook.setId(String.valueOf(release.getId()));
		jsonBook.setReleaseDate("");
		jsonBook.setASIN(release.getASIN());
		jsonBook.setImageUrl(release.getImageUrl());
		return jsonBook;
	}
}
