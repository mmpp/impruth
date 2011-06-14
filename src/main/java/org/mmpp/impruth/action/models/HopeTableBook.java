package org.mmpp.impruth.action.models;

import org.mmpp.impruth.model.HopeBook;
import org.mmpp.impruth.model.HopeBookUserInformation;
import org.mmpp.impruth.model.ShelfObject;
import org.mmpp.impruth.model.User;

/**
 * 希望書籍一覧表時用クラス
 * @author mmpp kou
 *
 */
public class HopeTableBook {
	
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

	/**
	 * 登録日
	 */
	private String _updateDate;
	
	/**
	 * 希望レベル(S,A,B,C,D,E)
	 */
	private String _level;

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


	public String getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this._updateDate = updateDate;
	}

	public String getLevel() {
		return _level;
	}

	public void setLevel(String level) {
		this._level = level;
	}
	public static HopeTableBook valueOf(HopeBook bookInformation) {
		HopeTableBook hopeTableBook = new HopeTableBook();
		
		hopeTableBook.setTitle(castTitle(bookInformation.getShelfObject()));
		hopeTableBook.setAuthorName(castAuthorName(bookInformation.getShelfObject()));
		hopeTableBook.setPublisherName(castPublisherName(bookInformation.getShelfObject()));
		hopeTableBook.setBookKind(bookInformation.getShelfObject().getObjectKind());
		hopeTableBook.setReleaseDate(castReleaseDate(bookInformation.getShelfObject()));
		hopeTableBook.setUpdateDate(castUpdateDate(bookInformation.getHopeInformation()));
		hopeTableBook.setLevel(bookInformation.getHopeInformation().getLevel().toString());
		return hopeTableBook;
	}
	/**
	 * ユーザ希望情報から登録日を抽出します
	 * @param hopeInformation ユーザ希望情報
	 * @return 登録日時
	 */
	private static String castUpdateDate(HopeBookUserInformation hopeInformation) {
		return (hopeInformation.getUpdateDate());
	}
	private static String castString2Date(java.util.Date date){
		if(date==null)
			return "";
		try {
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy/MM/dd");
			return format.format(date);
		} catch (Exception e) {
		}
		return "";
			
	}
	/**
	 * 書籍情報から発売日を生成します
	 * @param shelfObject 書籍情報
	 * @return 発売日情報
	 */
	private static String castReleaseDate(ShelfObject shelfObject) {
		return castString2Date(shelfObject.getReleaseDate());
	}
	private static String castPublisherName(ShelfObject shelfObject) {
		StringBuffer buf = new StringBuffer();
		buf.append(shelfObject.getPublishCompanyName());
		if(shelfObject.getPublishSeriesName().length()>0){
			buf.append(" ");
			buf.append(shelfObject.getPublishSeriesName());
		}
		return buf.toString();
	}
	/**
	 * オブジェクト情報から著者情報を取得します
	 * @param shelfObject 
	 * @return
	 */
	private static String castAuthorName(ShelfObject shelfObject) {
		StringBuffer buf = new StringBuffer();
		buf.append(shelfObject.getAuthorName());
		return buf.toString();
	}
	/**
	 * オブジェクト情報から書籍のタイトルを取得します
	 * @param shelfObject
	 * @return
	 */
	private static String castTitle(ShelfObject shelfObject) {
		StringBuffer buf = new StringBuffer();
		buf.append(shelfObject.getTitle());
		if(shelfObject.getNumberValue().length()>0){
			buf.append(" ");
			buf.append("(");
			buf.append(shelfObject.getNumberValue());
			buf.append(")");
		}
		if(shelfObject.getSubtitle().length()>0){
			buf.append(" ");
			buf.append(shelfObject.getSubtitle());
		}
		return buf.toString();
	}

	
	
}
