<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%
    String path = request.getContextPath(); //上下文路径
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/regist.css'/>">
	<script type="text/javascript" src="<c:url value='/css/js/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/css/js/regist.js'/>"></script>
  </head>

  <body>
<div id="divMain">
  <div id="divTitle">
    <span id="spanTitle">新用户注册</span>
  </div>
  <div id="divBody">
<form method="post" action="<%=path%>/servlet/doReg" name="register">
	<input type="hidden" name="method" value="regist"/>
    <table id="tableForm">
      <tr>
        <td class="tdText">用户名：</td>
        <td class="tdInput">
          <input class="inputClass" type="text" name="username"  />
        </td>
      </tr>
      <tr>
        <td class="tdText">登录密码：</td>
        <td>
          <input class="inputClass" type="password" name="userpass"  />
        </td>
      </tr>
      <tr>
        <td class="tdText">确认密码：</td>
        <td>
          <input class="inputClass" type="password" name="reloginpass"  />
        </td>
      </tr>
      <tr>

       <td> &nbsp;</td>
        <td align="left" colspan="3">
          <input type="image" src="<c:url value='/images/regist1.jpg'/>" id="submitBtn" />
        </td>
      </tr>
    </table>
</form>
  </div>
</div>
  </body>
</html>
