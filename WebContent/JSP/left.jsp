<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>框架左边部分</title>
</head>
<body>
	<font color="blue" size="3">当前用户： <%=application.getAttribute("name")%>
	</font>
	<hr>
	<font color="red" size="4" style="font-family: simhei">前台系统</font>
	<hr>
	<a href=viewBook.jsp target="_blank">浏览图书</a>
	<hr>
	<br>
	<font color="red" size="4" style="font-family: simhei">后台系统</font>
	<hr>
	<a href=listBook.jsp target="_blank">书架维护</a>
	<hr>
	<a href=listTitles.jsp target="_blank">查看图书信息</a>
	<hr>
</body>
</html>