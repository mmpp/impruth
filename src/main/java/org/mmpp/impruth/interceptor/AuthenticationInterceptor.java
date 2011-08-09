package org.mmpp.impruth.interceptor;

import org.mmpp.impruth.action.service.LoginAccessable;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 認証サービスインタセプタクラス
 * @author mmpp wataru
 * @since 0.0.3-SNAPSHOT
 * 参考 Struts2InAction (isbn ; 978-1933988078 ) p 95
 */
public class AuthenticationInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		String userid = getUserFromSession(actionInvocation);
		if(userid==null){
			return Action.LOGIN;
		}
		Action action = (Action)actionInvocation.getAction();
		if(action instanceof LoginAccessable){
			((LoginAccessable)action).setUserID(userid);
		}
		return actionInvocation.invoke();
	}
	/**
	 * セッションからログインユーザ情報を取得します
	 * @param actionInvocation 
	 * @return ログインユーザ情報
	 */
	private String getUserFromSession(ActionInvocation actionInvocation){
		java.util.Map<String,Object> session = actionInvocation.getInvocationContext().getSession();
		String userid  = (String)session.get("USERID");

		return userid;
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

}
