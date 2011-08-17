package org.mmpp.impruth.action;

import org.mmpp.impruth.service.MediaService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 統合メディア情報管理ページ抽象クラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public abstract class AbstractMediaServicePageAction extends ActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * メディア情報サービス
	 */
	private MediaService _mediaService=null;
	/**
	 * メディア情報サービスを取得します
	 * @return メディア情報サービス
	 */
	public MediaService getMediaService(){
		return _mediaService;
	}
	
	/**
	 * メディア情報サービスを格納します
	 * @param mediaService メディア情報サービス
	 */
	public void setMediaService(MediaService mediaService){
		_mediaService = mediaService;
	}
}
