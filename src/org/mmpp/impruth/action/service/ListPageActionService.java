package org.mmpp.impruth.action.service;

import java.util.List;

import org.mmpp.impruth.action.models.ListBook;
import org.mmpp.impruth.service.ShelfService;

/**
 * 書籍一覧アクションページ用の提供サービスインタフェイス
 * @author mmpp kou
 *
 */
public interface ListPageActionService {

	/**
	 * 書籍情報サービスを渡します
	 * @param shelfService
	 */
	public void setShelfService(ShelfService shelfService);

	/**
	 * 表示書籍一覧を取得します
	 * @return 書籍一覧
	 */
	public List<ListBook> list();

}
