package org.mmpp.simplelogin.model;

// Generated 2011/02/12 22:05:41 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private int id;
	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
	private String organization;
	private boolean notification;
	private Set ownBooks = new HashSet(0);

	public User() {
	}

	public User(String emailAddress, String password) {
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public User(String emailAddress, String password, String firstName,
			String lastName, String organization, boolean notification,
			Set ownBooks) {
		this.emailAddress = emailAddress;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.organization = organization;
		this.notification = notification;
		this.ownBooks = ownBooks;
	}

	public int getId() {
		return this.id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public boolean isNotification() {
		return this.notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public Set getOwnBooks() {
		return this.ownBooks;
	}

	public void setOwnBooks(Set ownBooks) {
		this.ownBooks = ownBooks;
	}

}
