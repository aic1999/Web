<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.User"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<title>员工缺勤记录</title>
</head>
<body>
<center>
<h1>员工缺勤记录</h1>>
<%
ConnDB connDB=new ConnDB();
PreparedStatement preparedStatement;
Connection connection=null;
Statement statement=null;
ResultSet rs=null;
List<User> list = new ArrayList<User>();
connection=connDB.getConnection();
int[] aid=(int[])session.getAttribute("aid");
if(aid!=null)
for(int i=0;aid[i]!=0;i++){ //id=0说明已经遍历完迟到的人了
	//如果是全部没有....那就会报错索引越界异常我的天
	     System.out.println(aid[i]);
	 String sql="select * from worker where id = "+aid[i];
    
			statement=connection.createStatement();
			rs = statement.executeQuery(sql);
			if(rs.next()){
				User user=new User();
				user.setSendtime(rs.getString(2));
				user.setSigntime(rs.getString(1));
				user.setPosition(rs.getString(9));
				user.setId(rs.getInt(8));
				user.setName(rs.getString(7));
				user.setDeduct(rs.getFloat(4));
				user.setWages(rs.getInt(6));
				user.setRewards(rs.getInt(5));
				list.add(user);				
			}
			//request.setAttribute("users", list);
			//response.sendRedirect("absdetail.jsp");
 }

%>
<%	  
//out.println(request.getAttribute("hh"));
	 //List<User> users =(List<User>) request.getAttribute("users");
%>

 <table border="1">
    	<tr>
    		<th>编号</th>
    		<th>用户名</th>
    		<th>工资</th>
    		<th>奖金</th>
    		<th>提成</th>
    		<th>职位</th>
    		<th>最近一次签到</th>
    		<th>最后一次发工资时间</th>
    	</tr>
 <%
    for(User user:list){
    	%>
    	<tr><td><%=user.getId()%></td>
    	<td><%=user.getName() %></td>
    	<td><%=user.getWages() %></td>
    	<td><%=user.getRewards() %></td>
    	<td><%=user.getDeduct() %></td>
    	<td><%=user.getPosition() %></td>
    	<td><%=user.getSigntime() %></td>
    	<td><%=user.getSendtime() %></td>
    	</tr>
    	<%
    }
%> 
</table> 
</center> 
</body>
</html>