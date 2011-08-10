package org.mmpp.impruth.action.models;

import org.mmpp.impruth.model.OwnBook;
import org.mmpp.impruth.model.ReleaseInformation;

/**
 * 所有書籍情報表示カラム情報
 * @author kou
 *
 */
public class OwnBookListElement {
	/**
	 * バーコード
	 */
	private String _barcode;
	/**
	 * 書籍タイトル
	 */
	private String _title;
	/**
	 * 著者
	 */
	private String _author;
	/**
	 * 出版社
	 */
	private String _publisher;

	/**
	 * 表紙絵Url
	 */
	private String _imageUrl;
	
	public String getBarcode() {
		return _barcode;
	}
	public void setBarcode(String barcode) {
		this._barcode = barcode;
	}
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		this._title = title;
	}
	public String getAuthor() {
		return _author;
	}
	public void setAuthor(String author) {
		this._author = author;
	}
	public String getPublisher() {
		return _publisher;
	}
	public void setPublisher(String publisher) {
		this._publisher = publisher;
	}
	public void setImageUrl(String imageUrl) {
		this._imageUrl = imageUrl;
	}
	public String getImageUrl() {
		return _imageUrl;
	}
	public static OwnBookListElement valueOf(OwnBook ownBook,ReleaseInformation release) {
		return valueOf(release.getBarcode(),
			release.getTitle(),
			release.getAuthor(),
			release.getPublisher(),
			release.getAmazonImage());
	}
	public static OwnBookListElement valueOf(ReleaseInformation releaseInformation) {
		return valueOf(releaseInformation.getBarcode(),
				releaseInformation.getTitle(),
				releaseInformation.getAuthor(),
				releaseInformation.getPublisher(),
				releaseInformation.getAmazonImage());
	}
	public static OwnBookListElement valueOf(String barcode,String title,String author,String publisher,String amazonImage){
		OwnBookListElement ownBookListElement = new OwnBookListElement();
		ownBookListElement.setBarcode(barcode);
		ownBookListElement.setTitle(title);
		ownBookListElement.setAuthor(author);
		ownBookListElement.setPublisher(publisher);
		ownBookListElement.setImageUrl(amazonImage);
		return ownBookListElement;
	}
	public static OwnBookListElement valueOf(OwnBook ownBook) {
		ReleaseInformation release = ownBook.getRelease();
		return valueOf(release.getBarcode(),
				release.getTitle(),
				release.getAuthor(),
				release.getPublisher(),
				release.getAmazonImage());
	}
	
}
