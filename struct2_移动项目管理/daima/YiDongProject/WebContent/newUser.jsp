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
          <TD height=25>&nbsp;您现在的位置：新增用户</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
    
     <form method="POST" action="insertUser">
      <p>手机号码：<input type="text" name="mTuser.MOBILE_NUMBER" size="20"></p>
      <p>漫游状态：<input type="radio" name="mTuser.ROAMING_STATUS" value="省内漫游" checked>省内漫游 <input type="radio" name="mTuser.ROAMING_STATUS" value="国内漫游 ">国内漫游 
      <input type="radio" name="mTuser.ROAMING_STATUS" value="国际漫游">国际漫游</p>
      <p>通话级别：<input type="radio" value="本地通话 " checked name="mTuser.COM_LEVEL">本地通话 
      <input type="radio" name="mTuser.COM_LEVEL" value="国内长途">国内长途 <input type="radio" name="mTuser.COM_LEVEL" value="国际长途">国际长途</p>
      <p>客户ID：<input type="text" name="mTuser.CUSTOMER_ID" size="20" value=<s:property value="#session.mTCutomer.CUSTOMER_ID"/> readonly></p>
      
      <p><input type="submit" value="完成>>" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>
      <s:actionerror/>
    
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER></BODY></HTML>
