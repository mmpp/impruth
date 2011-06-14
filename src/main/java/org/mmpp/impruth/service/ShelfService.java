package org.mmpp.impruth.service;

import javassist.NotFoundException;

import org.mmpp.impruth.model.ShelfObject;

/**
 * メディア管理本棚サービス
 * @author mmpp kou
 *
 */
public interface ShelfService {

	/**
	 * メディアサービス要求インターフェイス
	 * @param mediaService 統合メディアサービス
	 */
	public void setMediaService(MediaService mediaService);

	/**
	 * ユーザの所有情報一覧
	 * @param userName 該当ユーザ
	 * @return 所有本一覧の返却
	 */
	public java.util.List<ShelfObject> findAll(String userName);
	
	/**
	 * 本を探し出します　
	 * @param id ユニークキー
	 * @return 本情報
	 * @throws NotFoundException 
	 */
	public ShelfObject find(String userName,Integer id) throws NotFoundException;

	/**
	 * 新しい本を作成します
	 * @return 本情報
	 */
	public ShelfObject createNew(String userName);

	/**
	 * ユーザ書庫に書籍を登録します
	 * @param userName ユーザ情報
	 * @param shelfObject 登録書籍情報
	 */
	public ShelfObject insert(String userName,ShelfObject shelfObject);

	/**
	 * 当該情報を削除します
	 * @param id 削除対象書籍ID
	 * @return 削除書籍情報
	 * @throws NotFoundException 
	 */
	public ShelfObject remove(String userName,Integer id) throws NotFoundException;
	
}
