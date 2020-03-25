<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报错啦</title>
</head>
<body>
	出现了一些错误！错误码为${returnPath}!
	5秒后跳转至官网查询错误信息！
	<%
		response.setHeader("refresh","5;url=https://cloud.tencent.com/document/product/670/14357");
	%>
</body>
</html>