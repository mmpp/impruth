package org.mmpp.impruth.model;

// Generated 2011/02/24 21:32:15 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * ReleaseInformation generated by hbm2java
 */
public class ReleaseInformation implements java.io.Serializable {

	private int id;
	private String title;
	private String author;
	private String barcode;
	private String publisher;
	private String publisherCode;
	private String releaseDate;
	private String amazonId;
	private String amazonImage;
	private Set users = new HashSet(0);

	public ReleaseInformation() {
	}

	public ReleaseInformation(String title, String author, String barcode) {
		this.title = title;
		this.author = author;
		this.barcode = barcode;
	}

	public ReleaseInformation(String title, String author, String barcode,
			String publisher, String publisherCode, String releaseDate,
			String amazonId, String amazonImage, Set users) {
		this.title = title;
		this.author = author;
		this.barcode = barcode;
		this.publisher = publisher;
		this.publisherCode = publisherCode;
		this.releaseDate = releaseDate;
		this.amazonId = amazonId;
		this.amazonImage = amazonImage;
		this.users = users;
	}

	public int getId() {
		return this.id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisherCode() {
		return this.publisherCode;
	}

	public void setPublisherCode(String publisherCode) {
		this.publisherCode = publisherCode;
	}

	public String getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getAmazonId() {
		return this.amazonId;
	}

	public void setAmazonId(String amazonId) {
		this.amazonId = amazonId;
	}

	public String getAmazonImage() {
		return this.amazonImage;
	}

	public void setAmazonImage(String amazonImage) {
		this.amazonImage = amazonImage;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}
