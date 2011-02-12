package org.mmpp.impruth.action;

import java.io.FileNotFoundException;

import org.mmpp.impruth.action.models.MediaListTableBook;
import org.mmpp.impruth.action.service.MediaListPageActionService;
import org.mmpp.impruth.action.service.MediaListPageActionServiceImpl;

/**
 * 一覧ページ動的処理
 * @author mmpp kou
 *
 */
public class ListPageAction extends AbstractMediaServicePageAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String execute(){
		return SUCCESS;
	}
	/**
	 * 書籍サービス
	 */
	private MediaListPageActionService _listPageActionService=null;
	public MediaListPageActionService getListPageActionService(){
		if(_listPageActionService==null){
			_listPageActionService = new MediaListPageActionServiceImpl();
			_listPageActionService.setMediaService(getMediaService());
		}
		return _listPageActionService;
	}
	
	private java.util.List<MediaListTableBook> _books = null;
	
	public java.util.List<MediaListTableBook> getBooks(){
		if(_books==null){
			_books = getListPageActionService().list();
		}
		
		return _books;
	}


	/**
	 * 画像イメージデータ取得アクション
	 * @return
	 * @throws Exception
	 */
	public String readImage() throws Exception{
		return "dataFile";
	}
	public java.io.File getPicutureFile(){
		return new java.io.File("/home/kou/画像",getFileName());
	}
	public String _fileName;
	public void setFileName(String filename){
		_fileName = filename;
	}
	public String getFileName(){
		return _fileName;
	}
	private java.io.InputStream _istPicture = null;

	private java.io.InputStream getFileInputStream(){
//		if(_istPicture==null){
			try {
				_istPicture = new java.io.FileInputStream(getPicutureFile());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
//		}
		return _istPicture;
	}
	public String getContentType(){
		return "image/jpeg";
	}
	private java.io.InputStream _fileInputStream=null;

	public java.io.InputStream getDataStream(){
//		if(_fileInputStream==null){
		
//			try {
//				sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
//				byte[] ba64 = decoder.decodeBuffer(getImageBase64Value());
//				_fileInputStream = new java.io.ByteArrayInputStream(ba64);

				_fileInputStream = getFileInputStream();
				
//			} catch ( java.io.IOException e) {
//				e.printStackTrace();
//			} 

//		}
				
		return _fileInputStream;
	}
	
}
