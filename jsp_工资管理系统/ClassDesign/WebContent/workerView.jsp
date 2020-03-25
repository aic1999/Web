<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>员工界面</title>
</head>
<body>
<h1>
<center>
<pre>




${name}的员工信息
----------------
工资:${wages} 

奖金:${rewards} 

提成:${deduct} 

等级:${position} 

最后一次得到工资时间:${sendtime} 
<c:if test="${user=='worker'}">
最后一次签到时间:${signtime} 

<a href="UserServlet?action=sign&id=${id }">签到</a><br>
<a href="adduser.jsp?&action=revise&id=${id }&name=${name }&wages=${wages }&rewards=${rewards }&deduct=${deduct}"onclick="javascript:return confirm('确认修改吗？');">更改密码</a>
</c:if>
-----------------
</pre>
</center>
</h1>
</body>
</html>