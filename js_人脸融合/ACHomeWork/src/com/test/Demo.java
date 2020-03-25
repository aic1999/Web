package com.test;


import org.json.JSONObject;
import com.youtu.*;

public class Demo {
	private String path="";	//"D:\\hh\\left.jpg"
	private String errorid="";
	private String pic1="",pic2="",pic3="",pic4="",pic5="";
	
	//配置信息
	public static final String APP_ID = "10116240";
	public static final String SECRET_ID = "AKIDFNGtJTRyKQHsCFdaqqZ4KNAhy2sVZ55v";
	public static final String SECRET_KEY = "kHafW9YjhRxFKAmAKGySikYQ4UgdMsAD";
	public static final String USER_ID = "850161565";
	//public static void main(String[] args) {
	public String main() {
		try {
		
			//官方代码
			Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_MY_END_POINT,USER_ID);
			JSONObject respose;
			respose = faceYoutu.FaceFuse(getPath(),"cf_wzry_libai");	//李白
			pic1=(String) respose.get("img_url");
			respose = faceYoutu.FaceFuse(getPath(),"cf_wzry_zhenjiImage");	//甄姬 
			pic2=(String) respose.get("img_url");
			respose = faceYoutu.FaceFuse(getPath(),"hezuo_junzhuangzhao_1948m_20170919140951");	 //军装
			pic3=(String) respose.get("img_url");
			respose = faceYoutu.FaceFuse(getPath(),"cf_xianjian_linger");	 //赵灵儿
			pic4=(String) respose.get("img_url");
			respose = faceYoutu.FaceFuse(getPath(),"cf_wzry_wangzhaojun");	 //王昭君
			pic5=(String) respose.get("img_url");
			errorid=(String)respose.get("ret");
			//System.out.println(path+"    "+pic2);
			System.out.println(respose );
			return "success";
		} catch( Exception e) {
			
			e.printStackTrace();
		}
		//System.out.println(getIpath()+"  -0-0-0-0-0    "+getPath()+"     0-0-0-0-");
		
		return "input";
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic3() {
		return pic3;
	}
	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public String getPic4() {
		return pic4;
	}
	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}
	public String getPic5() {
		return pic5;
	}
	public void setPic5(String pic5) {
		this.pic5 = pic5;
	} 
	public String getErrorid() {
		return errorid;
	}
	public void setErrorid(String errorid) {
		this.errorid = errorid;
	}
}
