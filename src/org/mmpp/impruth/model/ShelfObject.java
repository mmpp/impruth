package org.mmpp.impruth.model;

import java.util.Date;

/**
 * 書籍管理情報
 * @author mmpp kou
 *
 */
public class ShelfObject {

	/**
	 * タイトル
	 */
	private String _title;
	/**
	 * タイトル読みかな
	 */
	private String _titleKana;
	/**
	 * 通巻番号
	 */
	private Integer _number;

	/**
	 * 通巻表記
	 */
	private String _numberValue;
	/**
	 * 著者
	 */
	private String _authorName;
	/**
	 * 出版社
	 */
	private String _publishCompanyName;
	
	/**
	 * 管理ID
	 */
	private Integer _id;
	
	/**
	 * バーコード
	 */
	private String _barcode;
	private String _pictureFilename;
	/**
	 * 書籍サブタイトル
	 */
	private String _subtitle;
	/**
	 * 発売日
	 */
	private Date _releaseDate;
	
	/**
	 * 出版種別名
	 */
	private String _publishSeriesName;
	/**
	 * オブジェクトの種別を格納します
	 */
	private String _objectKind;

	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		this._title = title;
	}
	public String getTitleKana() {
		return _titleKana;
	}
	public void setTitleKana(String titleKana) {
		this._titleKana = titleKana;
	}

	public Integer getNumber() {
		return _number;
	}
	public void setNumber(Integer number) {
		this._number = number;
	}
	public void setNumberValue(String numberValue) {
		this._numberValue = numberValue;
	}
	public String getNumberValue() {
		return _numberValue;
	}
	public String getAuthorName() {
		return _authorName;
	}
	public void setAuthorName(String authorName) {
		this._authorName = authorName;
	}
	public String getPublishCompanyName() {
		return _publishCompanyName;
	}
	public void setPublishCompanyName(String publishCompanyName) {
		this._publishCompanyName = publishCompanyName;
	}
	public void setId(Integer id) {
		_id = id;		
	}
	public Integer getId() {
		return _id;
	}
	public String getBarcode() {
		return _barcode;
	}
	public void setBarcode(String barcode) {
		_barcode = barcode;
	}
	public String getPictureFilename(){
		return _pictureFilename;
	}
	public void setPictureFilename(String filename){
		_pictureFilename = filename;
	}
	public void setSubtitle(String subtitle) {
		this._subtitle = subtitle;
	}
	public String getSubtitle() {
		return _subtitle;
	}
	public void setReleaseDate(Date releaseDate) {
		this._releaseDate = releaseDate;
	}
	public java.util.Date getReleaseDate() {
		return this._releaseDate;
	}
	public void setPublishSeriesName(String publishSeriesName) {
		this._publishSeriesName = publishSeriesName;
	}
	public String getPublishSeriesName() {
		return this._publishSeriesName;
	}
	public void setObjectKind(String objectKind) {
		this._objectKind = objectKind;
	}

	public String getObjectKind(){
		return this._objectKind;
	}
}
