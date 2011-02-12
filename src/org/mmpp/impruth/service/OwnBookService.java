package org.mmpp.impruth.service;

import java.util.Set;

import org.mmpp.impruth.model.OwnBook;
import org.mmpp.simplelogin.model.User;

/**
 * 所有書籍情報サービス
 * @author kou
 *
 */
public interface OwnBookService {
	/**
	 * ユーザ情報から所有書籍情報を取得します
	 * @param user
	 * @return
	 */
	public Set<OwnBook> findOwnBooksByUser(User user);

}
