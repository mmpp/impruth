package org.mmpp.simplelogin.service;

import org.mmpp.simplelogin.model.User;

/**
 * ユーザ情報を取得するサービス
 * @author kou
 *
 */
public interface LoginService {

	/**
	 * Eメールアドレスよりユーザ情報を取得する
	 * @param emailAddress
	 * @return
	 */
	public User findUserByEmailAddress(String emailAddress);
}
