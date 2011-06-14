package org.mmpp.impruth.action.models;

import java.text.ParseException;

import org.mmpp.impruth.model.ShelfObject;

/**
 * 新規作成書籍表示用モデル
 * @author mmpp kou
 *
 */
public class NewBook implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * タイトル
	 */
	private String _title;
	/**
	 * タイトル読みかな
	 */
	private String _titleKana;
	/**
	 * 通巻表記
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
	 * 
	 */
	private String _barcode;

	/**
	 * 管理ID
	 */
	private Integer _id;
	
	
	private String _releaseDate;
	private String _publishSeriesName;
	
	private String _subtitle;
	
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

	public void setBarcode(String barcode) {
		_barcode = barcode;		
	}
	public String getBarcode() {

		return _barcode;
	}
	
	public String getReleaseDate() {
		return _releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this._releaseDate = releaseDate;
	}
	public String getPublishSeriesName() {
		return _publishSeriesName;
	}
	public void setPublishSeriesName(String publishSeriesName) {
		this._publishSeriesName = publishSeriesName;
	}

	public String getSubtitle() {
		return _subtitle;
	}
	public void setSubtitle(String subtitle) {
		this._subtitle = subtitle;
	}

	
	/**
	 * 変換
	 * @param shelfObject
	 * @return
	 */
	public static NewBook valueOf(ShelfObject shelfObject) {
		NewBook newBook = new NewBook();
		newBook.setTitle(shelfObject.getTitle());
		newBook.setTitleKana(shelfObject.getTitleKana());
		newBook.setNumber(shelfObject.getNumber());
		newBook.setNumberValue(shelfObject.getNumberValue());
		newBook.setPublishCompanyName(shelfObject.getPublishCompanyName());
		newBook.setAuthorName(shelfObject.getAuthorName());
		newBook.setPublishCompanyName(shelfObject.getPublishCompanyName());
		newBook.setId(shelfObject.getId());
		newBook.setBarcode(shelfObject.getBarcode());

		return newBook;
	}
	public ShelfObject toShelfBook() {
		ShelfObject shelfObject =new ShelfObject();
		shelfObject.setTitle(getTitle());
		shelfObject.setTitleKana(getTitleKana());
		shelfObject.setNumber(getNumber());
		shelfObject.setNumberValue(getNumberValue());
		shelfObject.setPublishCompanyName(getPublishCompanyName());
		shelfObject.setAuthorName(getAuthorName());
		shelfObject.setPublishCompanyName(getPublishCompanyName());
		shelfObject.setId(getId());
		shelfObject.setBarcode(getBarcode());

		shelfObject.setSubtitle(getSubtitle());
		if(getReleaseDate().length()>0){
			try {
				shelfObject.setReleaseDate(new java.text.SimpleDateFormat("yyyy/MM/dd").parse(getReleaseDate().replaceAll("-", "/")));
			} catch (ParseException e) {
			}
		}
		shelfObject.setPublishSeriesName(getPublishSeriesName());
		
		return shelfObject;
	}
}
