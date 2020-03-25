<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>

<TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
  <TBODY>
  
  <TR>
    <TD width=173><A href="http://www.chinamobile.com/index.asp"><IMG 
      height=74 src="images/logo.gif" width=173 border=0></A></TD>
    <TD vAlign=top align=right>
      </TD></TR>
        
        
  <TR>
    <TD height="12" colSpan=2 align=right bgColor=#d4dced>
     

      <img src="images/spacer.gif" width="1" height="1">
       
 
    </TD></TR>
  <TR>
  <TD colSpan=2><IMG height=2 src="images\blank(1).gif" width=1></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
  <TBODY>
  <TR vAlign=top>
    <TD width=173 bgColor=#c9d3e9 rowSpan=2>
      <TABLE cellSpacing=0 cellPadding=0 width=173 border=0>
        <TBODY>
        <s:if test="#session.isAdmin=='Y'.toString()">
        <TR>
          <TD width=11 height="29" bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="newOperator.jsp">新增操作员</A></TD>
        </TR>
        <TR>
<!--           <TD bgColor=#ffffff colSpan=2><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0></TD></TR> -->
<!--         <TR> -->
<!--           <TD width=11 bgColor=#2650a6><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD> -->
<!--           <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A  -->
<!--             class=nav  -->
<!--             href="modifyOperator.htm">修改操作员</A></TD> -->
<!--         </TR> -->
<!--         <TR> -->
<!--           <TD bgColor=#ffffff colSpan=2><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0></TD> -->
<!--         </TR> -->
          </s:if>
        <TR>
          
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <TR>
          <TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav href="resource.jsp">资源管理</A></TD>
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <TR>
          <TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="charge.jsp">配置业务费用</A></TD>
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
<!--         <TR> -->
<!--           <TD width=11 bgColor=#2650a6><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD> -->
<!--           <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A  -->
<!--             class=nav  -->
<!--             href="#"></A></TD> -->
<!--         </TR> -->
<!--         <TR> -->
<!--           <TD bgColor=#ffffff colSpan=2><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0></TD></TR> -->
<!--         <TR> -->
          <TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="newCustomer.jsp">开户</A></TD>
        </TR>
<%--         <s:if test="#session.isAdmin=='Y'"> --%>
<!--         <TR> -->
<!--           <TD bgColor=#ffffff colSpan=2><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0></TD></TR> -->
            
<!--         <TR> -->
<!--           <TD width=11 bgColor=#2650a6><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD> -->
<!--           <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A  -->
<!--             class=nav  -->
<!--             href="newUser.htm">录入用户信息</A></TD> -->
<!--         </TR> -->
<!--         <TR> -->
<!--           <TD bgColor=#ffffff colSpan=2><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0></TD></TR> -->
<!--         <TR> -->
<!--           <TD width=11 bgColor=#2650a6><IMG height=1  -->
<!--             src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD> -->
<!--           <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A  -->
<!--             class=nav  -->
<!--             href="newAccount.htm">录入账户信息</A></TD> -->
<!--         </TR> -->
<%--             </s:if> --%>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD>
        </TR>
        <TR>
        
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <TR>
          <TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="LogoutAction">退出</A></TD>
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>

        <TR align=middle>
          <TD colSpan=2 height=160>&nbsp;</TD></TR>
        <TR>
          <TD colSpan=2><IMG height=1 src="images/blank.gif" 
        width=1></TD></TR></TBODY></TABLE></TD>
    <TD width=2 rowSpan=3><IMG height=1 src="images\blank(1).gif" width=2></TD>
    <TD width="2">
      
<BR></CENTER></BODY></HTML>