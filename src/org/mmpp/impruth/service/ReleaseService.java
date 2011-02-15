package org.mmpp.impruth.service;

import org.mmpp.impruth.model.ReleaseInformation;

/**
 * リリース情報取得サービス
 * @author kou
 *
 */
public interface ReleaseService {
	 /**
	  * 情報を検索する
	  * @param barcode
	  * @return
	  */
	public ReleaseInformation find(String barcode);
	/**
	 * 
	 * @param releaseId
	 * @return
	 */
	public ReleaseInformation findReleaseInformationById(int releaseId);

	/**
	 * 情報を保存します
	 * @param releaseInformation
	 */
	public void save(ReleaseInformation releaseInformation);
}
