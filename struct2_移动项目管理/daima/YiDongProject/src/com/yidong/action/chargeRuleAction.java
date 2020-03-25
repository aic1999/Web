package com.yidong.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.yidong.service.OperatorService;

public class chargeRuleAction extends ActionSupport {
	private OperatorService mService = new OperatorService();
	private String D1;
    private String C1;
    private String C2;
    private String C3;
    private String C4;
    private String C5;
    
	public String getD1() {
		return D1;
	}
	public void setD1(String d1) {
		D1 = d1;
	}
	public String getC1() {
		return C1;
	}
	public void setC1(String c1) {
		C1 = c1;
	}
	public String getC2() {
		return C2;
	}
	public void setC2(String c2) {
		C2 = c2;
	}
	public String getC3() {
		return C3;
	}
	public void setC3(String c3) {
		C3 = c3;
	}
	public String getC4() {
		return C4;
	}
	public void setC4(String c4) {
		C4 = c4;
	}
	public String getC5() {
		return C5;
	}
	public void setC5(String c5) {
		C5 = c5;
	}
	
	private List<String> rule = new ArrayList<String>();
	public String addChargeRule(){
		rule = init();
		if(mService.addChargeRule(D1, rule)){
			return SUCCESS;
		}else{
			addActionError("添加失败");
			return INPUT;
		}
		
	}
	
	public List<String> init(){
		//判断收费细项是否为空 不为空则添加进去
		List<String> rule = new ArrayList<String>();
		if(C1!=null){
			System.out.println(C1+"................");
			rule.add(C1);
		}
		if(C2!=null){
			System.out.println(C2+"................");
			rule.add(C2);
		}
		if(C3!=null){
			System.out.println(C3+"................");
			rule.add(C3);
		}
		if(C4!=null){
			System.out.println(C4+"................");
			rule.add(C4);
		}
		if(C5!=null){
			System.out.println(C5+"................");
			rule.add(C5);
		}
		
		return rule;
	}
	
} 
