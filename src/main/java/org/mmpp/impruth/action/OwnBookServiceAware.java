package org.mmpp.impruth.action;

import org.mmpp.impruth.service.OwnBookService;

/**
 * 所有書籍情報サービス保有アクション
 * @author kou
 *
 */
public interface OwnBookServiceAware {
	/**
	 * 所有書籍情報サービス
	 * @param ownBookService 所有書籍情報サービス
	 */
	public void setOwnBookService(OwnBookService ownBookService);
}
