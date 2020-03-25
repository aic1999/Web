<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登陆界面</title>
</head>
<body>
<center>
<pre>
<h1>



<form action="LoginServlet" method="post">
用户名    <input name="username"><br>
密   码   <input name="pwd" type="password"><br>
权   限           <select name="user"  ><br>
<option>worker</option><br>
<option>manager</option><br>
</select>

<input type="submit" value="登陆">
</form>
</h1>
</pre>
<%
String ifError=(String)session.getAttribute("loginError");
if(ifError!=null&&ifError.equals("1")){
	out.print("账号或密码错误");
} 
%>
<h1>
信息通知：
<%
ConnDB connDB=new ConnDB();
PreparedStatement preparedStatement;
Connection connection=null;
Statement statement=null;
ResultSet rs=null;
connection=connDB.getConnection();
 	String sql="select text from info";
	statement=connection.createStatement();
	ResultSet rSet = statement.executeQuery(sql);
	if(rSet.next()){
		out.print(rSet.getString(1));
	}
%>
</h1>

</center>
</body>
</html>