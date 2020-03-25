package com.yidong.action;

import org.omg.PortableInterceptor.SUCCESSFUL;

import com.opensymphony.xwork2.ActionSupport;
import com.yidong.po.TOperator;
import com.yidong.service.OperatorService;

public class OperatorAction extends ActionSupport{
	private OperatorService mOperService = new OperatorService();
     private TOperator mToperator;
     //二次输入
     private String T4;
	public TOperator getmToperator() {
		return mToperator;
	}
	public void setmToperator(TOperator mToperator) {
		this.mToperator = mToperator;
	}
	public String getT4() {
		return T4;
	}
	public void setT4(String t4) {
		T4 = t4;
	}
     
	
	public String addOperator(){
		//如果都不为空
		if(mToperator.getOperator_ID()!=null&&mToperator.getOperator_ID()!=""&&
				mToperator.getOperator_Name()!=null&&mToperator.getOperator_Name()!=""&&
				mToperator.getOperator_Pwd().equals(T4)){
			//查找数据库有没有此人
			TOperator toper = mOperService.getOperatorByName(mToperator.getOperator_Name());
			System.out.println(toper);
			if(toper!=null){
				if(mToperator.getOperator_Name().equals(toper.getOperator_Name())){
					//有此人 更新此人
					if(mOperService.updateOper(mToperator)){
						addActionMessage("更新成功");
						return SUCCESS;
					}else{
						return INPUT;
					}
					//无此人添加此人
					}else if(mOperService.addOperator(mToperator)){
						addActionMessage("添加成功");
						return SUCCESS;
					}else{
						return INPUT;
					}
			}else{
				addActionError("信息不能为空");
				return INPUT;
			}
		}else{
			addActionError("请正确填写信息");
			return INPUT;
		}
		
		
	}
	
	
	
	
	
}
