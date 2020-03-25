<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
<pre>





<center>
<form action='UserServlet' method="post">
员工名 <input name="name" value=${param.name }  ><br>
<c:if test="${user=='manager' }">
提成   <input name="deduct" value=${param.deduct }  ><br>
工资   <input name="wages" value=${param.wages } ><br>
奖金   <input name="rewards" value=${param.rewards }><br>
职位   <input name="position"  value=${param.position }><br>
</c:if>
密码   <input name="psw" value=${param.psw } ><br> 
<input type='hidden' name="id" value=${param.id }>
<input type="submit" name="action" value=${param.action }>
</form>
</center>
</pre>
</body>
</html>