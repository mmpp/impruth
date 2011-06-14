package org.mmpp.impruth.model;

/**
 * 希望書籍情報詳細情報
 * @author mmpp kou
 *
 */
public class HopeBookInformation {
	/**
	 * 書籍名
	 */
	private String _title;
	/**
	 * 著者
	 */
	private String _authorName;
	
	/**
	 * 出版社
	 */
	private String _publisherName;
	
	/**
	 * 書籍種別
	 */
	private String _bookKind;
	/**
	 * 発売日
	 */
	private String _releaseDate;
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		this._title = title;
	}
	public String getAuthorName() {
		return _authorName;
	}
	public void setAuthorName(String authorName) {
		this._authorName = authorName;
	}
	public String getPublisherName() {
		return _publisherName;
	}
	public void setPublisherName(String publisherName) {
		this._publisherName = publisherName;
	}
	public String getBookKind() {
		return _bookKind;
	}
	public void setBookKind(String bookKind) {
		this._bookKind = bookKind;
	}
	public String getReleaseDate() {
		return _releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this._releaseDate = releaseDate;
	}

	
}
