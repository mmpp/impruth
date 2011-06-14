package org.mmpp.impruth.action.service;

import java.util.List;

import org.mmpp.impruth.action.models.HopeTableBook;
import org.mmpp.impruth.service.HopeService;

public class HopePageActionServiceImpl implements HopePageActionService {

	public HopePageActionServiceImpl(HopeService hopeService){
		super();
		_hopeService = hopeService;
	}
	public List<HopeTableBook> list() {
		List<HopeTableBook> results = new java.util.LinkedList<HopeTableBook>();
		for(org.mmpp.impruth.model.HopeBook bookInformation : this.getService().findAll("wataru775")){
			HopeTableBook hopeTableBook = HopeTableBook.valueOf(bookInformation);
			
			results.add(hopeTableBook);
		}
		
		return results;
	}

	private final HopeService _hopeService;
	
	private HopeService getService() {
		return _hopeService;
	}

}
