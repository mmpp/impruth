package org.mmpp.impruth.service;

import javassist.NotFoundException;

import org.mmpp.impruth.service.model.Release;

/**
 * バーコード検索サービス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public interface BarcodeService {
	/**
	 * バーコードをスキャンします
	 * @param barcode バーコード
	 * @return スキャン結果
	 * @throws NotFoundException
	 */
	public Release scan(String barcode) throws NotFoundException;

}
