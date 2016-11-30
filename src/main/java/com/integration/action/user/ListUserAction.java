package com.integration.action.user;

import com.integration.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class ListUserAction extends ActionSupport {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("list", userService.findAllUsers());
		return SUCCESS;
	}
}
