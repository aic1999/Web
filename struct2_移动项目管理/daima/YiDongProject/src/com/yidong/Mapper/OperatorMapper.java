package com.yidong.Mapper;

import java.util.List;

import com.yidong.po.TCharge;
import com.yidong.po.TChargeRule;
import com.yidong.po.TCustomer;
import com.yidong.po.TMobiles;
import com.yidong.po.TOperator;
import com.yidong.po.TUser;
public interface OperatorMapper {
   //查找所有管理员
   public abstract List<TOperator> findAllOperator();
   //通过名字找管理员
   public abstract TOperator findOperatorByName(String name);
   //添加操作员
   public abstract void addOperator(TOperator tOperator);
   //添加号码字段
   public abstract void insertNumByTtoT(TMobiles t);
   //添加收费细项
   public abstract void insertChargeItem(TCharge tc);
   //查找所收费细项
   public abstract List<String> findAllChargeCode();
   //增加开户用户TCustomer表的信息
   public abstract void insertCustomer(TCustomer tt);
   
   public abstract void updateCustomer(TCustomer t1);
  
   public abstract TCustomer findCustomerByNum(String num);
   
   public abstract String findOperctorAdminByName(String name);
   
   public abstract void updateOper(TOperator t);
   
   public abstract String isAvailableNum(String num);
   
   public abstract void addUser(TUser tuser);
   
   public abstract void changeAvailableNum(String num);
   
   public abstract void addChargeRule(TChargeRule tcr);
   
   public abstract String findChargeCodeByName(String name);
   
   public abstract void updateChargeByCode(TCharge tc);
   
   public abstract void deleteChargeRuleByName(String name);
   
   public abstract List<TChargeRule> findAllChargeRule();
   
   
   
   
   
   
   
}
