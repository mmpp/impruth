package org.mmpp.impruth.service;

import java.util.LinkedList;
import java.util.List;

import org.mmpp.impruth.model.ShelfObject;

public class ShelfServiceImpl implements ShelfService {

	private List<ShelfObject> _shelfObjects=null;
	
	public ShelfServiceImpl(){
		super();
	}
	@Override
	public ShelfObject find(Integer id) {
		for(ShelfObject shelfObject : findAll()){
			if(shelfObject.getId().equals(id))
				return shelfObject;
		}
		return null;
	}

	@Override
	public List<ShelfObject> findAll() {

		if(_shelfObjects==null){
			_shelfObjects = new LinkedList<ShelfObject>();
			{
				ShelfObject shelfObject = new ShelfObject();
				shelfObject.setTitle("ONE PIECE");
				shelfObject.setNumber(1);
				shelfObject.setNumberValue("1");
				shelfObject.setAuthorName("尾田 栄一郎");
				shelfObject.setPublishCompanyName("集英社");
				shelfObject.setId(_shelfObjects.size());
				_shelfObjects.add(shelfObject);
			}
			{
				ShelfObject shelfObject = new ShelfObject();
				shelfObject.setTitle("無限のリヴァイアス コンプリートアートワークス");
				shelfObject.setNumberValue("");
				shelfObject.setAuthorName("VA");
				shelfObject.setPublishCompanyName("新紀元社");
				shelfObject.setId(_shelfObjects.size());
				_shelfObjects.add(shelfObject);
			}
		}
		return _shelfObjects;
	}
	@Override
	public ShelfObject createNew() {
		ShelfObject shelfObject = new ShelfObject();
		shelfObject.setId(_shelfObjects.size()+1);

		return shelfObject;
	}
	@Override
	public ShelfObject insert(ShelfObject shelfObject) {
		shelfObject.setId(_shelfObjects.size()+1);
		_shelfObjects.add(shelfObject);
		return shelfObject;
	}
	@Override
	public ShelfObject delete(Integer id) {
		ShelfObject shelfObject = find(id);
		_shelfObjects.remove(shelfObject);
		return shelfObject;
	}

}
