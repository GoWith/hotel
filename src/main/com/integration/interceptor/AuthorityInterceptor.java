package com.integration.interceptor;

import com.integration.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	//��¼������
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext context=invocation.getInvocationContext();
		Map session=context.getSession();
		User user=(User) session.get("user");
		if (user!=null) {
			return invocation.invoke();
		}
		context.put("message", "����û�е�¼�����¼ϵͳ��");
		return Action.LOGIN;
	}

}
