package org.mmpp.impruth.service;

import java.util.Set;

import org.mmpp.impruth.model.OwnBook;
import org.mmpp.impruth.model.User;

/**
 * 所有書籍情報サービス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public interface OwnBookService {
	/**
	 * ユーザ情報から所有書籍情報を取得します
	 * @param user
	 * @return
	 */
	public Set<OwnBook> findOwnBooksByUser(User user);

	/**
	 * 所有書籍情報を登録します
	 * @param user ユーザ情報
	 * @param barcode バーコード
	 */
	public OwnBook registOwnBook(User user,String barcode);

	/**
	 * 所有書籍件数を取得します
	 * @param user ユーザ情報
	 * @return 所有書籍件数
	 */
	public int findCountBook(User user);

	/**
	 * ユーザ蔵書情報を取得します
	 * @param user ユーザ
	 * @param pageCount 表示件数
	 * @param pageNumber 表示ページ数 (1..)
	 * @return ユーザ蔵書情報
	 */
	public Set<OwnBook> findOwnBooksByUser(User user, int pageCount, int pageNumber);


}
