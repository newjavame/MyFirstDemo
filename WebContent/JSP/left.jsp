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
</head>
<body>
	当前用户：
	<%=application.getAttribute("name")%>
	<table>
		<tr>
			<td><font size="4" style="font-family: simhei">前台系统</font></td>
		</tr>
		<tr>
			<td><a href=viewBook.jsp target="_blank">浏览图书</a></td>
		</tr>
		<tr>
			<td><font size="4" style="font-family: simhei">后台系统</font></td>
		</tr>
		<tr>
			<td><a href=listBook.jsp target="_blank">书架维护</a></td>
		</tr>
		<tr>
			<td><a href=listTitles.jsp target="_blank">查看图书信息</a></td>
		</tr>
	</table>
</body>
</html>