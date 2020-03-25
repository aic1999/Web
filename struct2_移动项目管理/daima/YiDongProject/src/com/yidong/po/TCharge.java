package com.yidong.po;

public class TCharge {
    private String CHARGE_CODE;
    private String CHARGE_NAME;
    private double CHARGE;
	public String getCHARGE_CODE() {
		return CHARGE_CODE;
	}
	public void setCHARGE_CODE(String cHARGE_CODE) {
		CHARGE_CODE = cHARGE_CODE;
	}
	public String getCHARGE_NAME() {
		return CHARGE_NAME;
	}
	public void setCHARGE_NAME(String cHARGE_NAME) {
		CHARGE_NAME = cHARGE_NAME;
	}
	public double getCHARGE() {
		return CHARGE;
	}
	public void setCHARGE(double cHARGE) {
		CHARGE = cHARGE;
	}
	@Override
	public String toString() {
		return "TCharge [CHARGE_CODE=" + CHARGE_CODE + ", CHARGE_NAME=" + CHARGE_NAME + ", CHARGE=" + CHARGE + "]";
	}
    
    
}
