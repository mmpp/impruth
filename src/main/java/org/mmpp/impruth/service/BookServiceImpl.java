package org.mmpp.impruth.service;

import java.util.List;

import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookServiceImpl implements BookService{
	/**
	 * ログ
	 */
	protected static Logger log = LoggerFactory.getLogger( BookServiceImpl.class ); 
	private ReleaseService _releaseService=null;
	public void setReleaseService(ReleaseService releaseService){
		_releaseService = releaseService;
	}
	public ReleaseService getReleaseService(){
		return _releaseService;
	}
	private int _totalCount ;
	private List<Book> _select =null ;
	@Override
	public List<Book> select(int pageNo, int pageView) {
		_select = new java.util.LinkedList<Book>();
		List<ReleaseInformation> results = getReleaseService().findAll();
		_totalCount = results.size();
		int firstNum = (pageNo-1) * pageView;
		int lastNum = pageNo * pageView ;
		log.info(firstNum+" - " + lastNum);
		if(lastNum>results.size()){
			lastNum = results.size();
		}
		
		for(int i = firstNum ; i < lastNum ; i ++){
			ReleaseInformation shelfObject = results.get(i);
			_select.add(Book.valueOf(shelfObject));
		}
		return _select;
	}

	@Override
	public int getTotalCount() {
		return _totalCount;
	}

}
