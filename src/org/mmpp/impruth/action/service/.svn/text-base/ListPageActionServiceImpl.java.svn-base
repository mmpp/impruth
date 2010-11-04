package org.mmpp.impruth.action.service;

import java.util.LinkedList;
import java.util.List;

import org.mmpp.impruth.action.models.ListBook;
import org.mmpp.impruth.model.ShelfObject;
import org.mmpp.impruth.service.ShelfService;

public class ListPageActionServiceImpl implements ListPageActionService {

	public ListPageActionServiceImpl(){
		super();
	}
	private ShelfService _shelfService;
	private List<ListBook> _list = null;
	@Override
	public List<ListBook> list() {
		if(_list==null){
			_list = new LinkedList<ListBook>();
			for(ShelfObject book : _shelfService.findAll()){
				ListBook listBook = castListBook(book);
				_list.add(listBook);
			}
		}
		return _list;
	}


	@Override
	public void setShelfService(ShelfService service) {
		_shelfService = service;		
	}
	private ListBook castListBook(ShelfObject shelfObject) {
		return ListBook.valueOf(shelfObject);
	}

}
