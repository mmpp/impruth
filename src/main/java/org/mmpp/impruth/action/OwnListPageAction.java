package org.mmpp.impruth.action;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.mmpp.impruth.action.models.OwnBookListElement;
import org.mmpp.impruth.action.models.OwnListPageType;
import org.mmpp.impruth.action.service.LoginAccessable;
import org.mmpp.impruth.model.OwnBook;
import org.mmpp.impruth.model.ReleaseInformation;
import org.mmpp.impruth.model.User;
import org.mmpp.impruth.service.OwnBookService;
import org.mmpp.impruth.service.ReleaseService;
import org.mmpp.impruth.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 蔵書ページアクション
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class OwnListPageAction extends ActionSupport implements LoginAccessable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 画像表示時の一行に表示する書籍数
	 */
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
	 * 画像一覧ページで表示します
	 */
	private final String SUCCESS_IMAGE_LIST = "imagelist";
	/**
	 * 蔵書情報サービス格納変数
	 */
	private OwnBookService _ownBookService;

	/**
	 * ユーザ情報サービス格納変数
	 */
	private UserService _userService;

	/**
	 * ページの表示タイプ
	 */
	private OwnListPageType _showType=OwnListPageType.LIST;
	/**
	 * 総蔵書件数
	 */
	private int _totalBookCount=-1;
	/**
	 * 最大表示ページ数
	 */
	private int _pageMaxNumber=-1;

	/**
	 * ログインユーザID格納変数
	 */
	private String _userid;

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
	
	@Override
	public String execute() throws Exception{
		return executeNext();
	}
	/**
	 * 次のページを取得します
	 * @return 次のページ名
	 */
	public String executeNext(){
		if(isShowImageList())
			return SUCCESS_IMAGE_LIST;
		return SUCCESS;
	}
	/**
	 * 画像一覧表示モードであるかの判断
	 * @return 画像表示モード (true)
	 */
	public boolean isShowImageList(){
		return (getShowType()==OwnListPageType.IMAGE);
	}

	/**
	 * ログインユーザ格納変数
	 */
	private User _user=null;

	/**
	 * ログインユーザ情報を取得します
	 * @return ログインユーザ情報
	 */
	public User getUser( ) {
		if(_user==null){
			_user = getUserService().find(getUserID());
		}
		return _user;
	}

	/**
	 * 表示蔵書情報一覧を取得します
	 * @return 表示蔵書情報一覧
	 */
	public java.util.List<OwnBookListElement> getOwnBooks(){
		java.util.List<OwnBookListElement> results = new java.util.LinkedList<OwnBookListElement>();
		for(OwnBook ownBook : getOwnBookService().findOwnBooksByUser(getUser(), getPageCount(), getPageNumber())){
			results.add(OwnBookListElement.valueOf(ownBook));
		}
		return results;
	}
	/**
	 * 蔵書情報サービスを取得します
	 * @return 蔵書情報サービス
	 */
	private OwnBookService getOwnBookService() {
		return _ownBookService;
	}
	
	/**
	 * 蔵書情報サービスを取得します
	 * @param ownBookService 蔵書情報サービス
	 */
	public void setOwnBookService(OwnBookService ownBookService) {
		_ownBookService = ownBookService;
	}
	/**
	 * ユーザ情報サービスを格納します
	 * @param userService ユーザ情報サービス
	 */
	public void setUserService(UserService userService){
		_userService = userService;
	}
	/**
	 * ユーザ情報サービスを取得します
	 * @return ユーザ情報サービス
	 */
	private UserService getUserService(){
		return _userService;
	}

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
	 * @param ownBook 編集書籍情報
	 */
	public void setOwnBook(OwnBookListElement ownBook){
		_ownBook = ownBook;
	}
	/**
	 * [メニュー]-[新規登録]ボタン処理
	 * @return 次画面
	 */
	public String onClickAddOwnBook(){
		_ownBook = new OwnBookListElement();
		return INPUT;
	}
	/**
	 * 新規登録ボタン処理
	 * @return 次画面
	 */
	public String onClickRegist(){
		// 新規登録処理
		getOwnBookService().registOwnBook(getUser(),getOwnBook().getBarcode());
		return executeNext();
	}
	/**
	 * [メニュー]-[画像一覧]ボタン処理
	 * @return 次画面
	 */
	public String onClickChangeImageList(){
		setShowType(OwnListPageType.IMAGE);
		return executeNext();
	}

	/**
	 * [メニュー]-[表一覧]ボタン処理
	 * @return 次画面
	 */
	public String onClickChangeList(){
		setShowType(OwnListPageType.LIST);
		return executeNext();
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
	 * @return 次画面
	 */
	public String onClickPrePage(){
		if(_pageNumber>0)
			_pageNumber--;
		return executeNext();
	}
	/**
	 * ページ送りボタンクリック処理
	 * @return 次画面
	 */
	public String onClickNextPage(){
		if(_pageNumber<=getPageMaxNumber())
			_pageNumber++;
		return executeNext();
	}
	
	@Override
	public void setUserID(String userid) {
		_userid = userid;
	}
	private String getUserID(){
		return _userid;
	}
}
