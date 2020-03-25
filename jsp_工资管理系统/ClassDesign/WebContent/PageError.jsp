<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnDB"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import='util.RandomChinese'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="msapplication-task" content="name=切换地区;action-uri=http://ele.me/home;icon-uri=http://static11.elemecdn.com/apple-touch-icon.png?v=2" />
<title>Insert title here</title>
</head>
<body>
<pre>
<center>
<h1>






签到成功！3秒后返回页面！
</h1>
<%
response.setHeader("refresh","3;url=workerView.jsp");
%>
</center>
</pre>
<!-- <a href="usee.txt">下载test</a> -->
<%-- <%
		
		ConnDB connDB=new ConnDB();
		PreparedStatement preparedStatement;
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		String position="E",wages="100";
		String sql="insert into worker(name,psw,deduct,rewards,wages,position)values(?,?,?,?,?,?)";
		connection=connDB.getConnection();
		preparedStatement = connection.prepareStatement(sql);
		for(int i=0;i<50;i++){
			
			if(i<10) {position="A"; wages="500";}
			else if(i<20) {position="B"; wages="400";}
			else if(i<30) {position="C"; wages="300";}
			else if(i<40) {position="D"; wages="200";}
			else if(i<50) {position="E"; wages="100";}

				
			preparedStatement.setString(1, RandomChinese.getName());
			preparedStatement.setString(2, "1234");
			preparedStatement.setString(3, "0");
			preparedStatement.setString(4, "0");
			preparedStatement.setString(5, wages);
			preparedStatement.setString(6, position);
			int j=preparedStatement.executeUpdate();
			if(j>0){
				System.out.print("input ok");
			}else{
				System.out.print("input error");
			}
		}
%> --%>
</body>
</html>