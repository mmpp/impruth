package org.mmpp.impruth.action.models;

public class BookJson {

	private String _title;
	private String _author;
	private String _price;
	public BookJson(String title,String author,String price){
		_title = title;
		_author = author;
		_price = price;
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
	public String getPrice() {
		return _price;
	}
	public void setPrice(String price) {
		this._price = price;
	}
	
}
