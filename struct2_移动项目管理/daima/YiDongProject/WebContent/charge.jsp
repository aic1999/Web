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
          <TD height=25>&nbsp;您现在的位置：配置业务费用</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
 


<h2>收费细项</h2>
    <form method="POST" action="chargeItem">
      <p>收费项目：<select size="1" name="D1">
        <option>开户费</option>
        <option>漫游费</option>
        <option>押金</option>
        <option>入网费</option>
        <option>选号费</option>
      </select></p>
      <p>收费金额：<input type="text" name="T1" size="20" value="10"></p>
      <p><input type="submit" value="提交" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>
    <hr>
    
    
    <h2>业务收费</h2>
    <form method="POST" action="chargeRule">
      <p>业务：<select size="1" name="D1">
        <option>开户业务</option>
      </select></p>
      <p>收费项目：
      <input type="checkbox" name="C1" value="开户费 " checked>开户费 
      <input type="checkbox" name="C2" value="漫游费">漫游费 
      <input type="checkbox" name="C3" value="押金 ">押金 
      <input type="checkbox" name="C4" value="入网费" checked>入网费 
      <input type="checkbox" name="C5" value="选号费" checked>选号费</p>
      <p><input type="submit" value="提交" name="B1">
      <input type="reset" value="全部重写" name="B2"></p>
    </form>   
    <s:actionerror/>
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER></BODY></HTML>