package org.mmpp.impruth.service;

import org.mmpp.impruth.action.models.NewBook;
import org.mmpp.impruth.model.ShelfObject;

/**
 * メディア管理本棚サービス
 * @author mmpp kou
 *
 */
public interface ShelfService {

	/**
	 * 本一覧情報を取得します
	 * @return 本一覧情報
	 */
	public java.util.List<ShelfObject> findAll();
	
	/**
	 * 本を探し出します　
	 * @param id ユニークキー
	 * @return 本情報
	 */
	public ShelfObject find(Integer id);

	/**
	 * 新しい本を作成します
	 * @return 本情報
	 */
	public ShelfObject createNew();

	/**
	 * 登録します
	 * @param shelfObject
	 */
	public ShelfObject insert(ShelfObject shelfObject);

	/**
	 * 当該情報を削除します
	 * @param id 削除対象書籍ID
	 * @return 削除書籍情報
	 */
	public ShelfObject delete(Integer id);
	
}
