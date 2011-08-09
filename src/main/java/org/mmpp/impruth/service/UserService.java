package org.mmpp.impruth.service;

import org.mmpp.impruth.model.User;

/**
 * ユーザ情報サービス
 * @author kou
 *
 */
public interface UserService {

	/**
	 * ユーザ情報を検索します
	 * @param userID ユーザID
	 * @return ユーザ情報
	 */
	public User find(String userID);
}
