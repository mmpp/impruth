package org.mmpp.impruth.service;

import org.mmpp.impruth.model.ReleaseInformation;

/**
 * リリース情報取得サービス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public interface ReleaseService {
	 /**
	  * 情報を検索する
	  * @param barcode
	  * @return
	  */
	public ReleaseInformation find(String barcode);
	 /**
	  * リリース情報一覧を取得します
	  * @return リリース情報一覧
	  */
	public java.util.List<ReleaseInformation> findAll();
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
	/**
	 * 情報総数を取得します
	 * @return 情報総数
	 */
	public int getTotalCount();
}
