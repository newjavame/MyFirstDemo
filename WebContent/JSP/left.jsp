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
<title>框架主页部分</title>
<!--  <style type="text/css">
body {
	background-image: url(../images/mainlog.png);
	background-size: 100%;
	height: auto;
}
</style> -->
</head>
<body>
<img  src="../images/mainlog.png" width="100%" height="auto"></img>
	当前用户：
	<%=application.getAttribute("name")%>
	<font size="4" style="font-family: simhei">前台系统</font>
	<a href=viewBook.jsp target="_blank">浏览图书</a>
	<font size="4" style="font-family: simhei">后台系统</font>
	<a href=listBook.jsp target="_blank">书架维护</a>
	<a href=listTitles.jsp target="_blank">查看图书信息</a>

</body>
</html>