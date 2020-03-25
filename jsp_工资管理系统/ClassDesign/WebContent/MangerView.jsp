<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="util.ConnDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 使用jstl必不可少要这个 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>管理员界面</title>
</head>
<body>
<center>
<%	 
	List<User> users =(List<User>) request.getAttribute("users");
    int temp=(int)request.getAttribute("totalCount");
%>
<br>
当前可用资金为:
<%
int count=0;
float totalnum=0;
//float absence=0;
int absence=0;
ConnDB connDB=new ConnDB();
PreparedStatement preparedStatement;
Connection connection=null;
Statement statement=null;
ResultSet rs=null;
SimpleDateFormat df ;
int[] aid=new int[temp];
df = new SimpleDateFormat("yyyy-MM-dd");  
connection=connDB.getConnection();
 	String sql="select money from info";
	statement=connection.createStatement();
	ResultSet rSet = statement.executeQuery(sql);
	if(rSet.next()){
		out.print(rSet.getInt(1));
	}
	sql="select signtime,id from worker";
	statement=connection.createStatement();
	rSet = statement.executeQuery(sql);
	while(rSet.next()){
		totalnum++;
		String str=rSet.getString(1);
		if(str!=null){//否则会空指针异常,无数据的不算
			String strr[]=str.split(" ");
			if(!df.format(System.currentTimeMillis()).equals(strr[0])){
				absence++;//需要保存id么？保存到list，然后点击“查看”,在跳转列出
				aid[count++]=rSet.getInt(2);
			}
		}else{
			absence++;
			aid[count++]=rSet.getInt(2);
		}
	}
%>
<br>
<form action='UserServlet' method="post">
id或名字查询: 
<input type="text" name="nd" >
<select name="action"  ><br>
<option>id</option><br>
<option>name</option><br>
</select>
<input type="submit"  >

</form>
<br>
<a href="adduser.jsp?action=adduser">新增员工</a>
<a href="UserServlet?action=send">一键发送所有员工工资</a>
今日缺勤数：
<%
out.print(absence);
//out.print(100*(absence/totalnum));
%>
 <%
session.setAttribute("aid",aid);
 /* for(int i:aid)
	 System.out.print(i+","); */
%>    
<%-- (<a href="UserServlet?action=absent&aid=<%=aid %>">考勤详情</a>)
 传值有问题，getParameter传不了数组，int string都行。。
 而且传到usersevrlet然后再request分发会报错:IllegalStateException: Cannot forward after response has been committed
 这么麻烦经手中间人java，是不是相当于"响应"了?所以报错了？所以直接给jsp就不报错？
 --%>
 
 (<a href="absdetail.jsp">考勤详情</a>)
 
 <br><br>
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
    for(User user:users){
    	%>
    	<tr><td><%=user.getId()%></td>
    	<td><%=user.getName() %></td>
    	<td><%=user.getWages() %></td>
    	<td><%=user.getRewards() %></td>
    	<td><%=user.getDeduct() %></td>
    	<td><%=user.getPosition() %></td>
    	<td><%=user.getSigntime() %></td>
    	<td><%=user.getSendtime() %></td>
        <td><a href="UserServlet?action=del&id=<%=user.getId()%>"onclick="javascript:return confirm('确认删除吗？');">
    	删除</a></td>
    	<td><a href="adduser.jsp?psw=<%=user.getPsw()%>&position=<%=user.getPosition()%>&action=revise&id=<%=user.getId()%>&name=<%=user.getName()%>&wages=<%=user.getWages()%>&rewards=<%=user.getRewards()%>&deduct=<%=user.getDeduct() %>"onclick="javascript:return confirm('确认修改吗？');">
    	修改</a></td>
    	</tr>
    	<%
    }
%> 
</table>
<br>
	共${totalPage}页,当前${pageNum }页.
		每页${pageSize }条记录。<br>
		<br>
	<a href="userList?pageNum=1">首页</a>	
	<c:if test="${pageNum!=1}">
		<a href='userList?pageNum=${pageNum-1}'>上一页</a>
	</c:if>
	<c:if test="${pageNum!=totalPage}">
		<a href='userList?pageNum=${pageNum+1}'>下一页</a>	
	</c:if> 
		<a href='userList?pageNum=${totalPage}'>尾页</a>
</center>
</body>
</html>