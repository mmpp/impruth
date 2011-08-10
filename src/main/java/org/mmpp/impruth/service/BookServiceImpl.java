package org.mmpp.impruth.service;

import java.util.List;

import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 書籍情報サービス実装クラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class BookServiceImpl implements BookService{
	/**
	 * ログ
	 */
	protected static Logger log = LoggerFactory.getLogger( BookServiceImpl.class ); 
	/**
	 * リリース情報サービス
	 */
	private ReleaseService _releaseService=null;
	/**
	 * リリース情報サービスを格納します
	 * @param releaseService リリース情報サービス
	 */
	public void setReleaseService(ReleaseService releaseService){
		_releaseService = releaseService;
	}
	/**
	 * リリース情報サービスを取得します
	 * @return リリース情報サービス
	 */
	public ReleaseService getReleaseService(){
		return _releaseService;
	}
	/**
	 * 取得結果格納変数
	 */
	private List<Book> _select =null ;
	@Override
	public List<Book> select(int pageNo, int pageView) {
		_select = new java.util.LinkedList<Book>();
		List<ReleaseInformation> results = getReleaseService().findAll();
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
		return getReleaseService().getTotalCount();
	}
	@Override
	public Book find(String isbn) {
		ReleaseInformation result = getReleaseService().find(isbn);
		if(result==null)
			return null;
		
		return Book.valueOf(result);
	}

}
