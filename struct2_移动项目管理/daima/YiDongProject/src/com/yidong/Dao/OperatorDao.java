package com.yidong.Dao;

import java.sql.Date;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Data;
import com.yidong.po.TCustomer;
import com.yidong.po.TOperator;
import com.yidong.po.TUser;

public interface OperatorDao {

	public abstract List<TOperator> findAllOperator();
	
	public abstract boolean checkLogin(String name,String pass);
    
	public abstract boolean addNum(String type,String t1,String t2);

	public abstract boolean chargeItem(String d1, String t1);
	
	public abstract boolean addCustomer(String D1,String T2);
	
	public abstract boolean updateCustomer(String T1,String R1,Date T3,String T4,String T2);

	public abstract TCustomer getTCustomer();

	public abstract String getIsadmin(String name);

	public abstract boolean addOperator(TOperator mToperator);

	public abstract TOperator getOperByName(String name);

	public abstract boolean updateOper(TOperator mToperator);

	public abstract boolean getNumberisAvailable(String mobilenum);

	public abstract boolean addUser(TUser t);

	public abstract boolean updateChargeRule(String d1,List<String> rule);
	
	
}
