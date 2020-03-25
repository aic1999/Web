package entity;

import java.sql.Date;

public class User {
	private String signtest;
	private String position;
	private String signtime;
	private String sendtime;
	private int id;
	private String name;
	private String psw;
	private int rewards;
	private int wages;
	private float deduct;
	public String getSigntest() {
		return signtest;
	}
	public void setSigntest(String signtest) {
		this.signtest = signtest;
	}
	
	public User(){
		
	}
	public int getId() {
		return id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSigntime() {
		return signtime;
	}
	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public int getRewards() {
		return rewards;
	}
	public void setRewards(int rewards) {
		this.rewards = rewards;
	}
	public int getWages() {
		return wages;
	}
	public void setWages(int wages) {
		this.wages = wages;
	}
	public float getDeduct() {
		return deduct;
	}
	public void setDeduct(float deduct) {
		this.deduct = deduct;
	}
	

}
