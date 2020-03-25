package com.yidong.po;

public class TChargeRule {
   private String FUNC_ID;
   private String CHARGE_CODE;
   private String FUNC_NAME;
	public String getFUNC_ID() {
		return FUNC_ID;
	}
	public void setFUNC_ID(String fUNC_ID) {
		FUNC_ID = fUNC_ID;
	}
	public String getCHARGE_CODE() {
		return CHARGE_CODE;
	}
	public void setCHARGE_CODE(String cHARGE_CODE) {
		CHARGE_CODE = cHARGE_CODE;
	}
	public String getFUNC_NAME() {
		return FUNC_NAME;
	}
	public void setFUNC_NAME(String fUNC_NAME) {
		FUNC_NAME = fUNC_NAME;
	}
	@Override
	public String toString() {
		return "chargeRule [FUNC_ID=" + FUNC_ID + ", CHARGE_CODE=" + CHARGE_CODE + ", FUNC_NAME=" + FUNC_NAME + "]";
	}
	   

}
