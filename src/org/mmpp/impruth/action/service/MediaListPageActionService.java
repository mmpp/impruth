package org.mmpp.impruth.action.service;

import java.util.List;

import org.mmpp.impruth.action.models.MediaListTableBook;
import org.mmpp.impruth.service.MediaService;

/**
 * 書籍一覧アクションページ用の提供サービスインタフェイス
 * @author mmpp kou
 *
 */
public interface MediaListPageActionService {

	/**
	 * メディア情報サービスを渡します
	 * @param mediaService
	 */
	public void setMediaService(MediaService mediaService);

	/**
	 * 表示書籍一覧を取得します
	 * @return 書籍一覧
	 */
	public List<MediaListTableBook> list();

}
