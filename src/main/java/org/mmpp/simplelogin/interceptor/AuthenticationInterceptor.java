package org.mmpp.simplelogin.interceptor;

import org.mmpp.simplelogin.action.UserAware;
import org.mmpp.simplelogin.model.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 認証サービスインタセプタクラス
 * @author kou
 * 参考 Struts2InAction (isbn ; 978-1933988078 ) p 95
 */
public class AuthenticationInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	public void init() {
		
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		java.util.Map<String,Object> session = actionInvocation.getInvocationContext().getSession();
		User user  = (User)session.get("USER");
		if(user==null)
			return Action.LOGIN;
		Action action = (Action)actionInvocation.getAction();
		if(action instanceof UserAware){
			((UserAware)action).setUser(user);
		}
		return actionInvocation.invoke();
	}

}
