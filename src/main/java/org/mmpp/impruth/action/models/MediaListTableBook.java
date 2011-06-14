package org.mmpp.impruth.action.models;

import org.mmpp.impruth.model.ShelfObject;

/**
 * 一覧ページ表示書籍情報
 * @author mmpp kou
 *
 */
public class MediaListTableBook {
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
	 * 管理ID
	 */
	private Integer _id;
	
	private String _pictureFilename;
	
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		this._title = title;
	}
	public String getNumber() {
		return _number;
	}
	public void setNumber(String number) {
		this._number = number;
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
	
	public String getPictureFilename(){
		return _pictureFilename;
	}
	public void setPictureFilename(String filename){
		_pictureFilename = filename;
	}

	public void setId(Integer id) {
		_id = id;		
	}
	public Integer getId() {

		return _id;
	}
	public static MediaListTableBook valueOf(ShelfObject shelfObject) {
		MediaListTableBook listBook = new MediaListTableBook();
		listBook.setTitle(shelfObject.getTitle());
		listBook.setNumber(shelfObject.getNumberValue());
		listBook.setPublishCompanyName(shelfObject.getPublishCompanyName());
		listBook.setAuthorName(shelfObject.getAuthorName());
		listBook.setPublishCompanyName(shelfObject.getPublishCompanyName());
		listBook.setId(shelfObject.getId());
		listBook.setPictureFilename(shelfObject.getPictureFilename());
		return listBook;
	}
}
