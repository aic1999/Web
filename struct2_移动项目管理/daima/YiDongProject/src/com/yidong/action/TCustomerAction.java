package com.yidong.action;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.yidong.po.TCustomer;
import com.yidong.service.OperatorService;
public class TCustomerAction extends ActionSupport implements SessionAware {
	private OperatorService mService = new OperatorService();
	private Map<String, Object> session;
	private String D1;
	private String T2;
	public String getD1() {
		return D1;
	}
	public void setD1(String d1) {
		D1 = d1;
	}
	public String getT2() {
		return T2;
	}
	public void setT2(String t2) {
		T2 = t2;
	}
	
	public String add(){
		if(mService.addCustomer(D1, T2)){
			TCustomer tc = mService.getTCustomer();
			if(tc!=null){
				System.out.println(tc);
				session.put("mTCutomer", tc);
				session.put("type", D1);
				session.put("number", T2);
				return SUCCESS;
			}else{
				System.out.println(T2);
				session.put("type", D1);
				session.put("number", T2);
				return SUCCESS;
			}
		}else{
			return INPUT;
		}
	}
	
	private String T1;
	private String R1;
	private String T3;
	private String T4;
	public String getT1() throws UnsupportedEncodingException {
		return T1;
	}
	public void setT1(String t1) throws UnsupportedEncodingException {
		T1 = t1;
	}
	public String getR1(){
		return R1;
	}
	public void setR1(String r1){
		R1 = r1;
	}
	public String getT3() {
		return T3;
	}
	public void setT3(String t3) {
		T3 = t3;
	}
	public String getT4() {
		return T4;
	}
	public void setT4(String t4) {
		T4 = t4;
	}
	
	public String updateCustomer(){
		
		if(R1.equals("V1")){
			R1 = "男";
		}else{
			R1 = "女";
		}
		System.out.println(R1);
		String T2 = (String) session.get("number");
		//按照"-"的条件进行"切割"
		int year = Integer.parseInt(T3.substring(0, T3.indexOf("-")));
		if(year>1900){
			year=Integer.parseInt(T3.substring(0, T3.indexOf("-")))-1900;
		}
		int month = Integer.parseInt(T3.substring(T3.indexOf("-")+1,T3.lastIndexOf("-")))-1;
		int day = Integer.parseInt( T3.substring(T3.lastIndexOf("-")+1));
		System.out.println(year+"  "+month+"  "+day);
		Date birthday = new Date(year, month, day);
		//将信息进行更新
		if(mService.updateCustomer(T1, R1, birthday, T4,T2)){
			return SUCCESS;
		}else{
			System.out.println("--------------------------------------");
			System.out.println(T2);
			return INPUT;
		}
	}
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session = arg0;
	}
	
	
	

}
