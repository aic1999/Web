package com.yidong.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yidong.po.TMobiles;
import com.yidong.service.OperatorService;

public class Mobiles extends ActionSupport{
	//TMobiles mTmobiles = null;
	private OperatorService mService = new OperatorService();
    private String MType;
    private String T1;
    private String T2;
	public String getMType() {
		return MType;
	}
	public void setMType(String mType) {
		MType = mType;
	}
	public String getT1() {
		return T1;
	}
	public void setT1(String t1) {
		T1 = t1;
	}
	public String getT2() {
		return T2;
	}
	public void setT2(String t2) {
		T2 = t2;
	}
	
	public String add(){
		System.out.println(MType+".....................");
		System.out.println(T1+""+T2);
		if(mService.addNum(MType, T1, T2)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	 
}
