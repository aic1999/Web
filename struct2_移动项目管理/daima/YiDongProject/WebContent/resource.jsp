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
          <TD height=25>&nbsp;您现在的位置：资源管理</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
 

    <form method="POST" action="addNum">
    <p>号码类型：<input type="Radio" name="MType" value="SIM" checked>SIM &nbsp;&nbsp;<input type="Radio" name="MType" value="UIM">UIM</p>
    <p>指定号段：从<input type="text" name="T1" size="20" value="13910000000">到<input type="text" name="T2" size="20" value="13912345678"><input type="submit" value="提交" name="B1">
    <input type="reset" value="全部重写" name="B2"></p>
    </form>
    <hr>
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER></BODY></HTML>