package com.yidong.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yidong.po.TUser;
import com.yidong.service.OperatorService;

public class TUserAction extends ActionSupport {
	private OperatorService mService = new OperatorService();
	private TUser mTuser;

	public TUser getmTuser() {
		return mTuser;
	}

	public void setmTuser(TUser mTuser) {
		this.mTuser = mTuser;
	}
	
	
	public String addUser(){
		//判断号码是否可用
		if(mService.getNumisAvailable(mTuser.getMOBILE_NUMBER())){
			
			mService.addUser(mTuser);
			return SUCCESS;
		}else{
			addActionError("号码不可用");
			return INPUT;
		}
		
		
	}
}
