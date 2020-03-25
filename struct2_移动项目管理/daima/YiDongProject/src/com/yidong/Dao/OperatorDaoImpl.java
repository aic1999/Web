package com.yidong.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.interceptor.SessionAware;
import com.mysql.fabric.xmlrpc.base.Data;
import com.yidong.Mapper.OperatorMapper;
import com.yidong.po.TCharge;
import com.yidong.po.TChargeRule;
import com.yidong.po.TCustomer;
import com.yidong.po.TMobiles;
import com.yidong.po.TOperator;
import com.yidong.po.TUser;

public class OperatorDaoImpl implements OperatorDao{
	InputStream in;
	SqlSession session=null;
	SqlSessionFactory factory = null;
	private Map<String, Object> sess;
	
	public Object getmapper(String resourse,Class<?> c){
		try {
			in = Resources.getResourceAsStream(resourse);
			factory = new SqlSessionFactoryBuilder().build(in);
			session = factory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session.getMapper(c);
	}
	
	
	public List<TOperator> findAllOperator() {
		List<TOperator> operators = null ;
		OperatorMapper mapper = (OperatorMapper)getmapper("mybatis-config.xml", OperatorMapper.class);
		operators = mapper.findAllOperator();
		return operators;
		
	}
   //检查登录 是否是管理员 还是普通操作员
	public boolean checkLogin(String name, String pass) {
		OperatorMapper mapper = (OperatorMapper)getmapper("mybatis-config.xml", OperatorMapper.class);
		TOperator oper = mapper.findOperatorByName(name);
		if(oper!=null&&pass.equals(oper.getOperator_Pwd())){
			return true;
		}else{
			return false;
		}
		
	}

    //资源管理 想数据库中添加从t1到t2的字段 ，以及字段类型
	public boolean addNum(String type, String t1, String t2) {
		TMobiles t= new TMobiles();
		BigDecimal db;
		double tStart = Double.parseDouble(t1);
		double tEnd = Double.parseDouble(t2);
		OperatorMapper mapper = (OperatorMapper)getmapper("mybatis-config.xml", OperatorMapper.class);
		System.out.println(type);
		for(double i=tStart;i<=tEnd;i++){
			db = new BigDecimal(i+"");
			t.setMOBILE_NUMBER(db.toPlainString());
			t.setMOBILE_TYPE(type);
			mapper.insertNumByTtoT(t);
			session.commit();
		}
		session.close();
		return true;
	}

   //收费细项的添加
	public boolean chargeItem(String d1, String t1) {
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		String code = mapper.findChargeCodeByName(d1);
		TCharge tc = new TCharge();
		if(code==null){
			session.close();
			if(d1.equals("开户费")){
				code="A";
			}
			if(d1.equals("漫游费")){
				code="B";
			}
			if(d1.equals("押金")){
				code="C";
			}
			if(d1.equals("入网费")){
				code="D";
			}
			if(d1.equals("选号费")){
				code="E";
			}
			mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
			tc.setCHARGE_CODE(code);
			tc.setCHARGE_NAME(d1);
			tc.setCHARGE(Double.parseDouble(t1));
			mapper.insertChargeItem(tc);
			session.commit();
			session.close();
			return true;
		}else{
			tc.setCHARGE_CODE(code);
			tc.setCHARGE_NAME(d1);
			tc.setCHARGE(Double.parseDouble(t1));
			mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
			mapper.updateChargeByCode(tc);
			session.commit();
			session.close();
			return true;
		}
	}
     
	
	public boolean addChargeRule(String d1,List<String> rule) {
		TChargeRule tcr = new TChargeRule();
		boolean status=false;
				for(String s:rule){
					OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
					if(d1.equals("开户业务")){
						tcr.setFUNC_ID("O");
						tcr.setFUNC_NAME(d1);
					}
					String code = mapper.findChargeCodeByName(s);
					session.close();
					if(code!=null){
						mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
						tcr.setCHARGE_CODE(code);
						mapper.addChargeRule(tcr);
						session.commit();
						session.close();
						status=true;
					}else{
						status=false;
					}
				 }
				return status;
	}
	public boolean updateChargeRule(String d1,List<String> rule){
		List<TChargeRule> list;
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		list = mapper.findAllChargeRule();
		session.close();
		if(list!=null){
			System.out.println("delete..................");
			mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
			mapper.deleteChargeRuleByName(d1);
			session.commit();
			session.close();
			return addChargeRule(d1,rule);
		}else{
			System.out.println("add..............");
			return addChargeRule(d1,rule);
		}
	}
	
	
	
	

	TCustomer mTCustomer;
	public boolean addCustomer(String D1,String T2) {
		TCustomer tt = new TCustomer();
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		mTCustomer = mapper.findCustomerByNum(T2);
		System.out.println(mTCustomer);
		if(mTCustomer!=null&&D1.equals(mTCustomer.getID_TYPE())){
			session.close();
			return true;
		}else{
			mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
			tt.setID_TYPE(D1);
			tt.setID_NUMBER(T2);
			mapper.insertCustomer(tt);
			session.commit();
			if(session!=null){
			    session.close();
			}
			return true;
		}
	}

	public boolean updateCustomer(String T1, String R1, Date T3, String T4,String T2) {
		TCustomer t1 = new TCustomer();
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		t1.setCUSTOMER_BIRTHDAY(T3);
		t1.setCUSTOMER_NAME(T1);
		t1.setCUSTOMER_SEX(R1);
		t1.setCUSTOMER_ADDRESS(T4);
		t1.setID_NUMBER(T2);
		System.out.println(t1.getCUSTOMER_BIRTHDAY());
		mapper.updateCustomer(t1);
		session.commit();
		if(session!=null){
		    session.close();
		}
		return true;
	
	}

    public TCustomer getTCustomer(){
    	return this.mTCustomer;
    }

//根据姓名找是否是管理员还是操作员
	public String getIsadmin(String name) {
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		String isAdmin = mapper.findOperctorAdminByName(name);
		session.close();
		return isAdmin;
	}


	public boolean addOperator(TOperator mToperator) {
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		mapper.addOperator(mToperator);
		session.commit();
		session.close();
		return true;
	}



	public TOperator getOperByName(String name) {
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		TOperator oper = mapper.findOperatorByName(name);
		return oper;
	}


	public boolean updateOper(TOperator mToperator) {
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		mapper.updateOper(mToperator);
		session.commit();
		session.close();
		return true;
	}


	public boolean getNumberisAvailable(String mobilenum) {
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		String isAvailable = mapper.isAvailableNum(mobilenum);
		session.close();
		if(isAvailable!=null&&isAvailable.equals("Y")){
			return true;
		}else{
		return false;
		}
	}



	public boolean addUser(TUser t) {
		OperatorMapper mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		mapper.addUser(t);
		session.commit();
		session.close();
		mapper = (OperatorMapper) getmapper("mybatis-config.xml", OperatorMapper.class);
		mapper.changeAvailableNum(t.getMOBILE_NUMBER());
		session.commit();
		session.close();
		return false;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
