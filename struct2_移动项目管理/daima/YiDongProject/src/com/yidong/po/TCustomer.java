package com.yidong.po;

import java.sql.Date;

public class TCustomer {
	private String CUSTOMER_ID;
	private String ID_TYPE;
	private String ID_NUMBER;
	private String CUSTOMER_NAME;
	private Date CUSTOMER_BIRTHDAY;
	private String CUSTOMER_SEX;
	private String CUSTOMER_ADDRESS;
	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(String cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public String getID_TYPE() {
		return ID_TYPE;
	}
	public void setID_TYPE(String iD_TYPE) {
		ID_TYPE = iD_TYPE;
	}
	public String getID_NUMBER() {
		return ID_NUMBER;
	}
	public void setID_NUMBER(String iD_NUMBER) {
		ID_NUMBER = iD_NUMBER;
	}
	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}
	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}
	public Date getCUSTOMER_BIRTHDAY() {
		return CUSTOMER_BIRTHDAY;
	}
	public void setCUSTOMER_BIRTHDAY(Date cUSTOMER_BIRTHDAY) {
		CUSTOMER_BIRTHDAY = cUSTOMER_BIRTHDAY;
	}
	public String getCUSTOMER_SEX() {
		return CUSTOMER_SEX;
	}
	public void setCUSTOMER_SEX(String cUSTOMER_SEX) {
		CUSTOMER_SEX = cUSTOMER_SEX;
	}
	public String getCUSTOMER_ADDRESS() {
		return CUSTOMER_ADDRESS;
	}
	public void setCUSTOMER_ADDRESS(String cUSTOMER_ADDRESS) {
		CUSTOMER_ADDRESS = cUSTOMER_ADDRESS;
	}
	@Override
	public String toString() {
		return "TCustomer [CUSTOMER_ID=" + CUSTOMER_ID + ", ID_TYPE=" + ID_TYPE + ", ID_NUMBER=" + ID_NUMBER
				+ ", CUSTOMER_NAME=" + CUSTOMER_NAME + ", CUSTOMER_BIRTHDAY=" + CUSTOMER_BIRTHDAY + ", CUSTOMER_SEX="
				+ CUSTOMER_SEX + ", CUSTOMER_ADDRESS=" + CUSTOMER_ADDRESS + "]";
	}
	

}
