package org.mmpp.impruth.action.service;

/**
 * ログインしてからユーザのIDを引き渡せるインターフェイス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public interface LoginAccessable {
	/**
	 * ログインIDを引き渡します
	 * @param userid ログインID
	 */
	public void setUserID(String userid);

}
