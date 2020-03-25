package com.yidong.po;

public class TUser {
     private String MOBILE_NUMBER;   //电话号
     private int CUSTOMER_ID;        //客户ID
     private String ROAMING_STATUS;   //漫游状态
     private String COM_LEVEL;       //通话级别
	public String getMOBILE_NUMBER() {
		return MOBILE_NUMBER;
	}
	public void setMOBILE_NUMBER(String mOBILE_NUMBER) {
		MOBILE_NUMBER = mOBILE_NUMBER;
	}
	public int getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(int cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public String getROAMING_STATUS() {
		return ROAMING_STATUS;
	}
	public void setROAMING_STATUS(String rOAMING_STATUS) {
		ROAMING_STATUS = rOAMING_STATUS;
	}
	public String getCOM_LEVEL() {
		return COM_LEVEL;
	}
	public void setCOM_LEVEL(String cOM_LEVEL) {
		COM_LEVEL = cOM_LEVEL;
	}
	@Override
	public String toString() {
		return "TUser [MOBILE_NUMBER=" + MOBILE_NUMBER + ", CUSTOMER_ID=" + CUSTOMER_ID + ", ROAMING_STATUS="
				+ ROAMING_STATUS + ", COM_LEVEL=" + COM_LEVEL + "]";
	}
     
	
}
