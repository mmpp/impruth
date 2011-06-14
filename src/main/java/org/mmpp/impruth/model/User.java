package org.mmpp.impruth.model;

/**
 * ユーザ情報
 * @author mmpp kou
 *
 */
public class User {

	/**
	 * ユーザアカウント
	 */
	private String _account;

	/**
	 * ユーザ表記名
	 */
	private String _userName;

	public String getAccount() {
		return _account;
	}

	public void setAccount(String account) {
		this._account = account;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		this._userName = userName;
	}
	
	
}
