<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<CENTER>
	<%@ include file="menu.jsp" %>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD height=25>&nbsp;您现在的位置：新增客户>第二步</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
    <form action="inserttwo">
      <p>证件类型：${type}</p>
      <p>证件号码：${number }</p>
      <p>姓名：<input type="text" name="T1" size="20" value=<s:property value="#session.mTCutomer.CUSTOMER_NAME"/>></p>
      <p>性别：<input type="radio" value="V1" checked name="R1">男&nbsp;&nbsp; <input type="radio" name="R1" value="V2">女</p>
      <p>生日：<input type="text" name="T3" size="20" value=<s:property value="#session.mTCutomer.CUSTOMER_BIRTHDAY"/>></p>
      <p>联系地址：<input type="text" name="T4" size="20" value=<s:property value="#session.mTCutomer.CUSTOMER_ADDRESS"/>></p>
      <p>　</p>
      <p><input type="submit" value="下一步>>" name="B1">
      <input type="reset" value="全部重写" name="B2"></p>
    </form>
    
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER></BODY></HTML>
