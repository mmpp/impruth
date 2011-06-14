package org.mmpp.impruth.service;

import org.mmpp.impruth.model.HopeBook;

/**
 * ユーザ希望書籍管理サービス
 * @author mmpp kou
 *
 */
public interface HopeService {
	
	/**
	 * メディアサービス要求インターフェイス
	 * @param mediaService 統合メディアサービス
	 */
	public void setMediaService(MediaService mediaService);
	
	public java.util.List<HopeBook> findAll(String userName);

}
