package com.integration.interceptor;

import com.integration.entity.Admin;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class AdminInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
//����Ա��¼������
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext context=invocation.getInvocationContext();
		Map session=context.getSession();
		Admin admin=(Admin) session.get("admin");
		if (admin!=null) {
			return invocation.invoke();
		}
		context.put("message", "�㻹û��¼�����¼ϵͳ");
		return Action.LOGIN;
	}

}
