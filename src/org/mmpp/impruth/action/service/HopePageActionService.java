package org.mmpp.impruth.action.service;

import java.util.List;

import org.mmpp.impruth.action.models.HopeTableBook;

/**
 * 希望書籍一覧サービス
 * @author mmpp kou
 *
 */
public interface HopePageActionService {


	/**
	 * 画面表示を行うサービス一覧を取得します
	 */
	public List<HopeTableBook> list();

}
