package org.mmpp.impruth.action.models;

import org.mmpp.impruth.model.ReleaseInformation;

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
	public static IndexDetailElement valueOf(ReleaseInformation releaseInformation) {
		IndexDetailElement indexDetailElement = new IndexDetailElement();
		indexDetailElement.setTitle(releaseInformation.getTitle());
		indexDetailElement.setAuthor(releaseInformation.getAuthor());
		indexDetailElement.setBarcode(releaseInformation.getBarcode());
		indexDetailElement.setImageUrl(releaseInformation.getAmazonImage());
		return indexDetailElement;
	}

}
