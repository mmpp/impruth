package org.mmpp.impruth.service;

import java.util.List;

import org.mmpp.impruth.model.ReleaseInformation;

/**
 * リリース情報取得サービス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public interface ReleaseService {
	 /**
	  * リリース情報を取得します
	  * @param barcode バーコード
	  * @return リリース情報
	  */
	public ReleaseInformation find(String barcode);
	 /**
	  * リリース情報一覧を取得します
	  * @return リリース情報一覧
	  */
	public java.util.List<ReleaseInformation> findAll();
	/**
	 * リリース情報を取得します
	 * @param releaseId リリース管理番号
	 * @return リリース情報
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
	/**
	 * リリース情報をページに表示して取得します
	 * @param pageView 表示件数
	 * @param pageNo ページ番号
	 * @return リリース情報一覧
	 */
	public List<ReleaseInformation> find(int pageView, int pageNo);
	/**
	 * リリース情報を検索してページングして表示します
	 * @param pageView 表示件数
	 * @param pageNo ページ番号
	 * @param title 検索タイトル
	 * @return リリース情報一覧
	 */
	public List<ReleaseInformation> find(int pageView, int pageNo, String title);
	/**
	 * 情報総数を取得します
	 * @param title 検索タイトル
	 * @return 情報総数
	 */
	public int getTotalCount(String title);
}
