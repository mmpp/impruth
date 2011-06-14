package org.mmpp.impruth.action.models;

/**
 * 所蔵書籍情報カラムインターフェイス
 * @author mmpp kou
 *
 */
public interface ShelfBook {
	/**
	 * 書籍名
	 * @return
	 */
	public String getTitle();
	/**
	 * 著者名
	 * @return
	 */
	public String getAuthorName();
	/**
	 * 出版社名
	 * @return
	 */
	public String getPublishCompanyName();

	/**
	 * 書籍種別
	 * @return
	 */
	public String getObjectKind();
	/**
	 * 発売日
	 * @return
	 */
	public java.util.Date getReleaseDate();
	/**
	 * 登録日
	 * @return
	 */
	public java.util.Date getUpdateDate();
}
