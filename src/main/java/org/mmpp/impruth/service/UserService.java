package org.mmpp.impruth.service;

import org.mmpp.simplelogin.model.User;

/**
 * ユーザ情報サービス
 * @author kou
 *
 */
public interface UserService {

	/**
	 * セッション切れのユーザ情報を再取得します
	 * @param user ユーザ情報
	 * @return 新しいユーザ情報
	 */
	public User releadUser(User user);
}
