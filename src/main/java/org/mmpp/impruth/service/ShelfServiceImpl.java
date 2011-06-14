package org.mmpp.impruth.service;

import java.util.LinkedList;
import java.util.List;

import javassist.NotFoundException;

import org.mmpp.impruth.model.ShelfObject;

public class ShelfServiceImpl implements ShelfService {

	private java.util.Map<String,java.util.List<Integer>> _shelfObjects=null;
	private MediaService _mediaService;
	public ShelfServiceImpl(){
		super();
	}
	public void setMediaService(MediaService mediaService){
		this._mediaService = mediaService;
	}
	public MediaService getMediaService(){
		return this._mediaService;
	}
	public ShelfObject find(String userName,Integer id) throws NotFoundException {
		if(!getUserShelf(userName).contains(id)){
			throw new NotFoundException("指定の書籍情報は存在しておりません");
		}
		
		return getMediaService().find(id);
	}

	/**
	 * ユーザ所有の書籍一覧
	 * @param userName ユーザ 
	 * @return
	 */
	private java.util.List<Integer> getUserShelf(String userName) {
		return getShelfObjects().get(userName);
	}
	private java.util.Map<String,java.util.List<Integer>> getShelfObjects(){
		if(_shelfObjects==null){
			_shelfObjects = new java.util.LinkedHashMap<String,java.util.List<Integer>>();
			// TODO イニシャライズ
		}
		return _shelfObjects;
	}

	public List<ShelfObject> findAll(String userName) {
		List<ShelfObject> shelfResults = new LinkedList<ShelfObject>();
		for(Integer id : getUserShelf(userName)){
			shelfResults.add(getMediaService().find(id));
		}
		
		return shelfResults;
	}
	public ShelfObject createNew(String userName) {
		return getMediaService().createNew();
	}
	public ShelfObject insert(String userName,ShelfObject shelfObject) {

		ShelfObject shelfObjectResult = getMediaService().insert(shelfObject);

		this.getShelfObjects().get(userName).add(shelfObjectResult.getId());
		
		return shelfObjectResult;
	}
	public ShelfObject remove(String userName,Integer id) throws NotFoundException {
		ShelfObject shelfObjectResult = find(userName, id);
		this.getShelfObjects().get(userName).remove(shelfObjectResult.getId());

		return shelfObjectResult;
	}

}
