<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<CENTER>
<%@ include file="menu.jsp" %>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD height=25>&nbsp;您现在的位置：新增操作员</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
    <form method="POST" action="addOperator">
      <p>登录ID：<input type="text" name="mToperator.Operator_ID" size="20" value="A00000001"></p>
      <p>姓 名：<input type="text" name="mToperator.Operator_Name" size="20" value="张三"></p>
      <p>密码：<input type="password" name="mToperator.Operator_Pwd" size="20" value="******"></p>
      <p>密码确认：<input type="password" name="T4" size="20" value="******"></p>
      <p>是否管理员：<input type="radio" value="Y" checked name="mToperator.Is_Admin">是&nbsp;&nbsp;&nbsp; 
      <input type="radio" name="mToperator.Is_Admin" value="N">否</p>
      <p><input type="submit" value="提交" name="B1"></p>
    </form>
    <s:actionerror/>
    <s:actionmessage/>
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER></BODY></HTML>
