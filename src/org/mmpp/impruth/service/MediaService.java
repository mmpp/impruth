package org.mmpp.impruth.service;

import org.mmpp.impruth.model.ShelfObject;

/**
 * メディア情報統合管理サービス
 * @author mmpp kou
 *
 */
public interface MediaService {


	/**
	 * メディア一覧情報を取得します
	 * @return メディア一覧情報
	 */
	public java.util.List<ShelfObject> findAll();


	/**
	 * メディアを探し出します　
	 * @param id ユニークキー
	 * @return メディア情報
	 */
	public ShelfObject find(Integer id);
	

	/**
	 * メディア情報を新規作成します
	 * @return メディア情報
	 */
	public ShelfObject createNew();

	/**
	 * メディア情報を登録します
	 * @param shelfObject 登録メディア情報
	 * @return 登録結果メディア情報
	 */
	public ShelfObject insert(ShelfObject shelfObject);

	/**
	 * 当該メディア情報を削除します
	 * @param id 削除対象メディアID
	 * @return 削除対象メディア情報
	 */
	public ShelfObject delete(Integer id);

}
