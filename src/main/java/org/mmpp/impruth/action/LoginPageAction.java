package org.mmpp.impruth.action;

import org.apache.struts2.interceptor.SessionAware;
import org.mmpp.impruth.action.models.LoginUserForm;
import org.mmpp.impruth.service.UserService;

/**
 * ログインページ
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 */
public class LoginPageAction extends com.opensymphony.xwork2.ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ユーザ情報サービス
	 */
	private UserService _userService;

	/**
	 * 入力メールアドレス
	 */
	private LoginUserForm _user= new LoginUserForm();
	/**
	 * セッション情報格納変数
	 */
	private java.util.Map<String, Object> _session;

	/**
	 * 入力フォームのユーザ情報を格納します
	 * @param user 入力フォームのユーザ情報
	 */
	public void setUser(LoginUserForm user){
		_user= user;
	}
	/**
	 * 入力フォームのユーザ情報を取得します
	 * @return 入力フォームのユーザ情報
	 */
	public LoginUserForm getUser(){
		return _user;
	}
	/**
	 * 実行メソッド
	 */
	public String execute() throws Exception{
		if(!authenticate())
			return INPUT;
		return SUCCESS;
	}
	/**
	 * ユーザ認証を行います
	 * @return 認証結果
	 * @throws Exception
	 */
	private boolean authenticate() throws Exception{
	
		if(_user.getEmailAddress()==null){
			return false;
		}
		org.mmpp.impruth.model.User user = getUserService().find(_user.getEmailAddress());
		if(user==null){
			throw new Exception("DBにユーザが存在しません");
		}
		if(user.getEmailAddress()==null){
			throw new Exception("DBにユーザが存在しません（メールアドレス）");
		}
		if(user.getFirstName()==null){
			throw new Exception("DBにユーザが存在しません（名前）");
		}
		// パスワード認証
		if(!user.getPassword().equals(_user.getPassword())){
			throw new Exception("パスワードが違います");
		}

		_session.put("USERID", user.getEmailAddress());
		setUser(LoginUserForm.valueOf(user));
		return true;
	}
	/**
	 *  ユーザ情報サービスを格納する
	 * @param userService ユーザ情報サービス
	 */
	public void setUserService(UserService userService){
		_userService = userService;
	}
	/**
	 * ユーザ情報サービスを取得します
	 * @return ユーザ情報サービス
	 */
	public UserService getUserService(){
		return _userService;
	}

	@Override
	public void setSession(java.util.Map<String, Object> session){
		_session = session;
	}
}
