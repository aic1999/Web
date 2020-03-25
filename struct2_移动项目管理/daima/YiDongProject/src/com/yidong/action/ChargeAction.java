package com.yidong.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yidong.service.OperatorService;

public class ChargeAction extends ActionSupport {
	private OperatorService mService = new OperatorService();
    private String D1;
    private String T1;
	public String getD1() {
		return D1;
	}
	public void setD1(String d1) {
		D1 = d1;
	}
	public String getT1() {
		return T1;
	}
	public void setT1(String t1) {
		T1 = t1;
	}
    
	//收费细项
	public String chargeItem(){
		if(mService.chargeItem(D1,T1)){
			return SUCCESS;
		}else{
			addActionMessage("业务配置成功");
			return INPUT;
		}
		
	}
}
