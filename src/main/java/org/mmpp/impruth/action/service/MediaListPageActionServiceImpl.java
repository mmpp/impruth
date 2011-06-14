package org.mmpp.impruth.action.service;

import java.util.LinkedList;
import java.util.List;

import org.mmpp.impruth.action.models.MediaListTableBook;
import org.mmpp.impruth.model.ShelfObject;
import org.mmpp.impruth.service.MediaService;

public class MediaListPageActionServiceImpl implements MediaListPageActionService {

	public MediaListPageActionServiceImpl(){
		super();
	}
	private MediaService _mediaService;
	private List<MediaListTableBook> _list = null;
	public List<MediaListTableBook> list() {
		if(_list==null){
			_list = new LinkedList<MediaListTableBook>();
			for(ShelfObject book : getService().findAll()){
				MediaListTableBook listBook = castListBook(book);
				_list.add(listBook);
			}
		}
		return _list;
	}


	public void setMediaService(MediaService service) {
		_mediaService = service;		
	}
	private MediaService getService(){
		return _mediaService;
	}
	private MediaListTableBook castListBook(ShelfObject shelfObject) {
		return MediaListTableBook.valueOf(shelfObject);
	}

}
