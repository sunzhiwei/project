package com.gome.sermanage.interceptor;


import com.gome.sermanage.entity.SerManage_User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class checkSecurityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// 获取当前用户
		SerManage_User user = (SerManage_User) ActionContext.getContext().getSession().get("user");
		
		// 获取当前访问的URL，并去掉当前应用程序的前缀（也就是 namespaceName + actionName ）
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		String privilegeUrl = null;
		if (namespace.endsWith("/")) {
			privilegeUrl = namespace + actionName;
		} else {
			privilegeUrl = namespace + "/" + actionName;
		}

		// 要去掉开头的'/'
		if (privilegeUrl.startsWith("/")) {
			privilegeUrl = privilegeUrl.substring(1);
		}

		// 如果未登录用户, 如果成功，则调用invocation.invoke()将逻辑交给Action，否则退出并返回一个全局的Login结果。
		if (user == null) {
			if (privilegeUrl.startsWith("homeAction_index") || privilegeUrl.startsWith("userAction_login")) { 
				// 如果是正在使用登录功能，就放行
				return invocation.invoke(); // 直接跳转到相应的action的对应方法
			} else {
				// 如果不是去登录，就转到登录页面
				return "tologin";
			}
		}
		// 如果已登录用户
		else
			return invocation.invoke();
	}
}
