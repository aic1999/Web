package com.yidong.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yidong.service.OperatorService;

public class MainAction extends ActionSupport implements SessionAware{
	private OperatorService mService = new OperatorService();
	private Map<String, Object> session;
    private String loginname;
    private String passwords;
    
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String login() throws Exception {
		//判断是否登录成功
		if(mService.checkLogin(loginname, passwords)){
			//将用户存入(操作员或者管理员)
			session.put("isAdmin", mService.getIs_admin(loginname));
			return SUCCESS;
		}else{
			addActionMessage("登陆失败:用户名或密码不正确");
			return INPUT;
		}
		
		
	}
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	
}
