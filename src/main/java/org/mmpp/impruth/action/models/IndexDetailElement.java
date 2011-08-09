package org.mmpp.impruth.action.models;

import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.model.Book;

/**
 * 書籍詳細情報画面の表示要素
 * @author mmpp wataru
 *
 */
public class IndexDetailElement {

	private String _title;
	private String _barcode;
	private String _author;
	private String _imageUrl;
	
	public String getTitle() {
		return _title;
	}

	public String getAuthor() {
		return _author;
	}

	public String getBarcode() {
		return _barcode;
	}
	public String getImageUrl() {
		return _imageUrl;
	}

	public void setBarcode(String barcode) {
		this._barcode = barcode;
	}

	public void setAuthor(String author) {
		this._author = author;
	}

	public void setTitle(String title) {
		this._title = title;
	}

	public void setImageUrl(String imageUrl) {
		this._imageUrl = imageUrl;
	}
	public static IndexDetailElement valueOf(Book book) {
		IndexDetailElement indexDetailElement = new IndexDetailElement();
		indexDetailElement.setTitle(book.getTitle());
		indexDetailElement.setAuthor(book.getAuthor());
		indexDetailElement.setBarcode(book.getBarcode());
		indexDetailElement.setImageUrl(book.getImageUrl());
		return indexDetailElement;
	}

}
