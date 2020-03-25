package com.yidong.service;

import java.sql.Date;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Data;
import com.yidong.Dao.OperatorDao;
import com.yidong.Dao.OperatorDaoImpl;
import com.yidong.po.TCustomer;
import com.yidong.po.TOperator;
import com.yidong.po.TUser;

public class OperatorService {
     static OperatorDao operDao = new OperatorDaoImpl();
	 
     public Boolean checkLogin(String name,String password){
    	if(operDao.checkLogin(name, password)){
    		return true;
    	}else{
    		return false;
    	}
     }
     
     public Boolean addNum(String type,String t1,String t2){
    	 
    	 return operDao.addNum(type, t1, t2);
     }

    
	public TOperator getOperatorByName(String name) {
         return operDao.getOperByName(name);
	}
     
	public boolean chargeItem(String d1, String t1) {
		 return operDao.chargeItem(d1,t1);
	}
	public  boolean addCustomer(String D1,String T2){
		return operDao.addCustomer(D1,T2);
	}
	public  boolean updateCustomer(String T1,String R1,Date T3,String T4,String T2){
		
		return operDao.updateCustomer(T1,R1,T3,T4,T2);
	}
	
	public TCustomer getTCustomer(){
		return operDao.getTCustomer();
	}
	
	public String getIs_admin(String name){
		return operDao.getIsadmin(name);
	}

	public boolean addOperator(TOperator mToperator) {
		return operDao.addOperator(mToperator);
	}

	public boolean updateOper(TOperator mToperator) {
		return operDao.updateOper(mToperator);
	}

	public boolean getNumisAvailable(String mobilenum) {
		
		return operDao.getNumberisAvailable(mobilenum);
	}

	public boolean addUser(TUser t) {
		return operDao.addUser(t);
	}

	public boolean addChargeRule(String D1,List<String> rule) {
		
		return operDao.updateChargeRule(D1,rule);
	}

}
