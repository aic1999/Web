package com.yidong.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	public String execute(){
		HttpSession session =  ServletActionContext.getRequest().getSession();
		//将session里面的数据清除
		session.removeAttribute("isAdmin");
		return SUCCESS;
	}

}
