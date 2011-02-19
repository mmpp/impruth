package org.mmpp.impruth.action;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.mmpp.impruth.action.models.OwnBookListElement;
import org.mmpp.impruth.action.models.OwnListPageType;
import org.mmpp.impruth.model.OwnBook;
import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.service.OwnBookService;
import org.mmpp.impruth.service.ReleaseService;
import org.mmpp.simplelogin.action.UserAware;
import org.mmpp.simplelogin.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class OwnListPageAction extends ActionSupport implements UserAware,OwnBookServiceAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int DEFAULT_LINE_BOOK_COUNT=8;

	/**
	 * 標準のページ表示書籍数
	 */
	public final int DEFAULT_PAGE_COUNT=40;
	/**
	 * 表示ページデータ件数
	 */
	private int _pageCount = DEFAULT_PAGE_COUNT;

	/**
	 * ページの表示タイプ
	 */
	private OwnListPageType _showType=OwnListPageType.LIST;
	/**
	 * ページ表示タイプを格納します
	 * @param showType ページ表示タイプ
	 */
	public void setShowType(OwnListPageType showType){
		_showType = showType;
	}
	/**
	 * ページ表示タイプを取得します
	 * @return ページ表示タイプ
	 */
	public OwnListPageType getShowType(){
		return _showType ;
	}
	/**
	 * ページの表示件数を取得します
	 * @return
	 */
	public int getPageCount(){
		return _pageCount;
	}
	/**
	 * 現在表示ページ番号
	 */
	private int _pageNumber = 1;
	/**
	 * 表示ページ番号を取得する
	 * @return ページ番号
	 */
	public int getPageNumber(){
		return _pageNumber;
	}
	/**
	 * 表示ページ番号を格納します
	 * @param pageNumber ページ番号
	 */
	public void setPageNumber(int pageNumber){
		_pageNumber = pageNumber;
	}
	
	public String execute() {
		if(getShowType()==OwnListPageType.IMAGE)
			return "imagelist";
		return SUCCESS;
	}

	private User _user;
	@Override
	public void setUser(User user) {
		_user = user;
	}
	public User getUser( ) {
		return _user;
	}
	
	public java.util.List<OwnBookListElement> getOwnBooks(){
		// Caused by: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: org.mmpp.simplelogin.model.User.ownBooks, no session or session was closed
		// return getOwnBookListElements(getUser( ).getOwnBooks());
		return getOwnBookListElements(getUser());
	}
	private List<OwnBookListElement> getOwnBookListElements(User user) {
		return getOwnBookListElements(getOwnBookService().findOwnBooksByUser(user,getPageCount(),getPageNumber()));
	}
	private ReleaseInformation findReleaseInformation(OwnBook ownBook) {
		return getReleaseService().findReleaseInformationById(ownBook.getReleaseId());
	}
	private OwnBookService _ownBookService;
	private OwnBookService getOwnBookService() {
		return _ownBookService;
	}
	public void setOwnBookService(OwnBookService ownBookService) {
		_ownBookService = ownBookService;
	}
	private ReleaseService _releaseService;

	public void setReleaseService(ReleaseService releaseService) {
		this._releaseService = releaseService;
	}
	public ReleaseService getReleaseService() {
		return _releaseService;
	}
	private List<OwnBookListElement> getOwnBookListElements(Set<OwnBook> ownBooks) {
		 java.util.List<OwnBookListElement> ownBookListElements = new java.util.LinkedList<OwnBookListElement>();
		for(OwnBook ownBook:ownBooks){
			ownBookListElements.add(OwnBookListElement.valueOf(ownBook,findReleaseInformation(ownBook)));
		}
		java.util.Collections.sort( ownBookListElements , new Comparator<OwnBookListElement>() {

			@Override
			public int compare(OwnBookListElement ownBook1, OwnBookListElement ownBook2) {
				return ownBook1.getBarcode().compareTo(ownBook2.getBarcode());
			}
		});
		return ownBookListElements;
	}
	private OwnBookListElement _ownBook;
	public OwnBookListElement getOwnBook(){
		return _ownBook;
	}
	public void setOwnBook(OwnBookListElement ownBook){
		_ownBook = ownBook;
	}
	public String onClickAddOwnBook(){
		_ownBook = new OwnBookListElement();
		return INPUT;
	}
	
	public String onClickRegist(){
		// 新規登録処理
		getOwnBookService().registOwnBook(getUser(),getOwnBook().getBarcode());
		return execute();
	}
	public String onClickChangeImageList(){
		setShowType(OwnListPageType.IMAGE);
		return execute();
	}
	public String onClickChangeList(){
		setShowType(OwnListPageType.LIST);
		return execute();
	}
	
	/**
	 * ユーザ所有登録書籍件数
	 * @return 登録件数
	 */
	public int getTotalBookCount(){
		if(_totalBookCount<0){
			_totalBookCount = getOwnBookService().findCountBook(getUser());
		}
		
		return _totalBookCount;
	}
	private int _totalBookCount=-1;
	
	private int _pageMaxNumber=-1;
	/**
	 * 最大表示ページ番号を取得する
	 * @return 最大表示ページ番号
	 */
	public int getPageMaxNumber(){
		if(_pageMaxNumber<0){
			_pageMaxNumber = getTotalBookCount() / getPageCount();
			if((getTotalBookCount() % getPageCount())>0){
				_pageMaxNumber++;
			}
		}
		return _pageMaxNumber;
	}
	public String onClickPrePage(){
		if(_pageNumber>0)
			_pageNumber--;
		return execute();
	}
	public String onClickNextPage(){
		if(_pageNumber<=getPageMaxNumber())
			_pageNumber++;
		return execute();
	}
}
