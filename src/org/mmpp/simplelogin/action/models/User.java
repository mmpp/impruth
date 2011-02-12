package org.mmpp.simplelogin.action.models;
/**
 * ユーザアカウント情報格納クラス
 * @author mmpp kou
 *
 */
public class User {

	private String _email;
	private String _password;
	private String _firstName;
	private String _lastName;
	private String _organization;
	private boolean _notification;
	
	
	
	public String getEmailAddress() {
		return _email;
	}



	public String getPassword() {
		return _password;
	}



	public String getFirstName() {
		return _firstName;
	}



	public String getLastName() {
		return _lastName;
	}



	public String getOrganization() {
		return _organization;
	}



	public boolean isNotification() {
		return _notification;
	}



	public void setEmailAddress(String email) {
		this._email = email;
	}



	public void setPassword(String password) {
		this._password = password;
	}



	public void setFirstName(String firstName) {
		this._firstName = firstName;
	}



	public void setLastName(String lastName) {
		this._lastName = lastName;
	}



	public void setOrganization(String organization) {
		this._organization = organization;
	}



	public void setNotification(boolean notification) {
		this._notification = notification;
	}



	public static User valueOf(String email, String password, String firstName,String lastName, String organization, boolean notification) {
		User user = new User();
		user.setEmailAddress(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setOrganization(organization);
		user.setNotification(notification);
		return user;
	}



	public static User valueOf(org.mmpp.simplelogin.model.User currentUser) {
		User user = new User();
		user.setEmailAddress(currentUser.getEmailAddress());
		user.setPassword(currentUser.getPassword());
		user.setFirstName(currentUser.getFirstName());
		user.setLastName(currentUser.getLastName());
		user.setOrganization(currentUser.getOrganization());
		user.setNotification(currentUser.isNotification());
		return user;
	}

}
