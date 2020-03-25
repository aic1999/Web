package com.yidong.po;

	public class TMobiles {
	   private String MOBILE_NUMBER;
	   private String MOBILE_TYPE;
	   private String CARD_NUMBER;
	   private String IS_AVAILABLE;
	public String getMOBILE_NUMBER() {
		return MOBILE_NUMBER;
	}
	public void setMOBILE_NUMBER(String mOBILE_NUMBER) {
		MOBILE_NUMBER = mOBILE_NUMBER;
	}
	public String getMOBILE_TYPE() {
		return MOBILE_TYPE;
	}
	public void setMOBILE_TYPE(String mOBILE_TYPE) {
		MOBILE_TYPE = mOBILE_TYPE;
	}
	public String getCARD_NUMBER() {
		return CARD_NUMBER;
	}
	public void setCARD_NUMBER(String cARD_NUMBER) {
		CARD_NUMBER = cARD_NUMBER;
	}
	public String getIS_AVAILABLE() {
		return IS_AVAILABLE;
	}
	public void setIS_AVAILABLE(String iS_AVAILABLE) {
		IS_AVAILABLE = iS_AVAILABLE;
	}
	@Override
	public String toString() {
		//为了方便调试，后台打印出来
		return "TMobiles [MOBILE_NUMBER=" + MOBILE_NUMBER + ", MOBILE_TYPE=" + MOBILE_TYPE + ", CARD_NUMBER=" + CARD_NUMBER
				+ ", IS_AVAILABLE=" + IS_AVAILABLE + "]";
	}
	   
   
}
