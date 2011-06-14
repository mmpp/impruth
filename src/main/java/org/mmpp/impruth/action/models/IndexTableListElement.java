package org.mmpp.impruth.action.models;

import org.mmpp.impruth.model.ReleaseInformation;

/**
 * メディア情報一覧ページの一覧テーブルの一行の表示内容
 * @author kou
 *
 */
public class IndexTableListElement {

	private String _title;
	private String _author;
	private String _barcode;
	
	public String getTitle() {
		return _title;
	}

	public String getAuthor() {
		return _author;
	}

	public String getBarcode() {
		return _barcode;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public void setBarcode(String barcode) {
		_barcode = barcode;
	}

	/**
	 * DB内部のリリース情報から書籍一覧テーブル情報へ変換します
	 * @param releaseInformation リリース情報
	 * @return 書籍一覧テーブル情報
	 */
	public static IndexTableListElement valueOf(ReleaseInformation releaseInformation) {
		IndexTableListElement indexTableListElement = new IndexTableListElement();
		indexTableListElement.setTitle(releaseInformation.getTitle());
		indexTableListElement.setAuthor(releaseInformation.getAuthor());
		indexTableListElement.setBarcode(releaseInformation.getBarcode());
		return indexTableListElement;
	}

}
