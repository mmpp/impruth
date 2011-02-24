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
import org.mmpp.impruth.service.UserService;
import org.mmpp.simplelogin.action.UserAware;
import org.mmpp.simplelogin.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class OwnListPageAction extends ActionSupport implements UserAware,OwnBookServiceAware,Preparable{

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
	/**
	 * ユーザ情報を再取得します
	 */
	protected void reloadUser( ) {
		setUser(getUserService().releadUser(_user));
	}
	
	public java.util.List<OwnBookListElement> getOwnBooks(){
		// Caused by: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: org.mmpp.simplelogin.model.User.ownBooks, no session or session was closed
		// return getOwnBookListElements(getUser( ).getOwnBooks());

		
		return getOwnBookListElements(getUser());
	}
	private List<OwnBookListElement> getOwnBookListElements(User user) {
		return getOwnBookListElements(user.getBooks());
//		return getOwnBookListElements(getOwnBookService().findOwnBooksByUser(user,getPageCount(),getPageNumber()));
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

	private UserService _userService;
	public void setUserService(UserService userService){
		_userService = userService;
	}
	private UserService getUserService(){
		return _userService;
	}

	public void setReleaseService(ReleaseService releaseService) {
		this._releaseService = releaseService;
	}
	public ReleaseService getReleaseService() {
		return _releaseService;
	}
	/**
	 * 表示書籍一覧を変換します
	 * @param ownBooks 書籍情報DB情報
	 * @return 表表示書籍一覧
	 */
//	private List<OwnBookListElement> getOwnBookListElements(Set<OwnBook> ownBooks) {
//		 java.util.List<OwnBookListElement> ownBookListElements = new java.util.LinkedList<OwnBookListElement>();
//		for(OwnBook ownBook:ownBooks){
//			ownBookListElements.add(OwnBookListElement.valueOf(ownBook,findReleaseInformation(ownBook)));
//		}
//		java.util.Collections.sort( ownBookListElements , new Comparator<OwnBookListElement>() {
//
//			@Override
//			public int compare(OwnBookListElement ownBook1, OwnBookListElement ownBook2) {
//				return ownBook1.getBarcode().compareTo(ownBook2.getBarcode());
//			}
//		});
//		return ownBookListElements;
//	}
	/**
	 * 一時編集書籍情報格納変数
	 */
	private OwnBookListElement _ownBook;
	/**
	 * 編集書籍情報を取得します
	 * @return
	 */
	public OwnBookListElement getOwnBook(){
		return _ownBook;
	}
	/**
	 * 編集書籍情報を格納します
	 * @param ownBook
	 */
	public void setOwnBook(OwnBookListElement ownBook){
		_ownBook = ownBook;
	}
	/**
	 * [メニュー]-[新規登録]ボタン処理
	 * @return
	 */
	public String onClickAddOwnBook(){
		_ownBook = new OwnBookListElement();
		return INPUT;
	}
	/**
	 * 新規登録ボタン処理
	 * @return
	 */
	public String onClickRegist(){
		// 新規登録処理
		getOwnBookService().registOwnBook(getUser(),getOwnBook().getBarcode());
		return execute();
	}
	/**
	 * [メニュー]-[画像一覧]ボタン処理
	 * @return
	 */
	public String onClickChangeImageList(){
		setShowType(OwnListPageType.IMAGE);
		return execute();
	}

	/**
	 * [メニュー]-[表一覧]ボタン処理
	 * @return
	 */
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
//			_totalBookCount = getOwnBookService().findCountBook(getUser());
			_totalBookCount = getUser().getBooks().size();
		}
		
		return _totalBookCount;
	}
	/**
	 * 総蔵書件数
	 */
	private int _totalBookCount=-1;
	/**
	 * 最大表示ページ数
	 */
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
	/**
	 * ページ戻りボタンクリック処理
	 * @return 結果
	 */
	public String onClickPrePage(){
		if(_pageNumber>0)
			_pageNumber--;
		return execute();
	}
	/**
	 * ページ送りボタンクリック処理
	 * @return 結果
	 */
	public String onClickNextPage(){
		if(_pageNumber<=getPageMaxNumber())
			_pageNumber++;
		return execute();
	}
	

	private List<OwnBookListElement> getOwnBookListElements(Set<ReleaseInformation> books) {
		int pageNumber = getPageNumber();
		int pageCount = DEFAULT_PAGE_COUNT;
		
		int firstCount = (pageNumber-1)*pageCount;
		int lastCount = pageNumber*pageCount;
		java.util.List<OwnBookListElement> ownBookListElements = new java.util.LinkedList<OwnBookListElement>();
		int i =-1;
		for(ReleaseInformation releaseInformation:books){
			i++;
			if(firstCount>i)
				continue;
			if(lastCount<=i)
				continue;
			ownBookListElements.add(OwnBookListElement.valueOf(releaseInformation));
		}
		java.util.Collections.sort( ownBookListElements , new Comparator<OwnBookListElement>() {

			@Override
			public int compare(OwnBookListElement ownBook1, OwnBookListElement ownBook2) {
				return ownBook1.getBarcode().compareTo(ownBook2.getBarcode());
			}
		});
			
		return ownBookListElements;
	}
	@Override
	public void prepare() throws Exception {
		// ユーザ情報を再取得(DB上のリレーション辿り)
		reloadUser();
		
	}
}
