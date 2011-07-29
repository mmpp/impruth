package org.mmpp.simplelogin.action;

import org.apache.struts2.interceptor.SessionAware;
import org.mmpp.simplelogin.action.models.User;
import org.mmpp.simplelogin.service.LoginService;

/**
 * ログインページ
 * @author mmpp kou
 *
 */
public class LoginPageAction extends com.opensymphony.xwork2.ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ログインアクションサービス
	 */
	private LoginService _loginService;

	/**
	 * 入力メールアドレス
	 */
	private User _user= new User();
	public void setUser(User user){
		_user= user;
	}
	public User getUser( ){
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
		if(getLoginService()==null){
			return false;
		}
	
		if(_user.getEmailAddress()==null){
			return false;
		}
		org.mmpp.simplelogin.model.User user = getLoginService().findUserByEmailAddress(_user.getEmailAddress());
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

		_session.put("USER", user);
		setUser(User.valueOf(user));
		return true;
	}
	/**
	 *  ログインアクションサービスを格納する
	 * @param loginService ログインアクションサービス
	 */
	public void setLoginService(LoginService loginService){
		_loginService = loginService;
	}
	public LoginService getLoginService(){
		return _loginService;
	}
	
	private java.util.Map<String, Object> _session;
	public void setSession(java.util.Map<String, Object> session){
		_session = session;
	}
}
