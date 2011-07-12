package org.mmpp.impruth.action;

import org.mmpp.impruth.service.MediaService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 統合メディア情報管理ページ抽象クラス
 * @author mmpp kou
 *
 */
public abstract class AbstractMediaServicePageAction extends ActionSupport implements MediaServiceAware{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * メディア情報サービス
	 */
	private MediaService _mediaService=null;
	
	public MediaService getMediaService(){
		return _mediaService;
	}
	public void setMediaService(MediaService mediaService){
		_mediaService = mediaService;
	}
}
