<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页面</title>
<link rel="stylesheet" type="text/css" href="../css/logreg.css" />
</head>
<body class="body1">
当前用户：
    <%=application.getAttribute("name")%>
	<div style="text-align:center;font-family:YouYuan;font-size:42px;margin-top:50px;">

        <big>欢迎使用网上书店</big>
    </div>
	<div
		style="position: absolute; top: 250px; left: 650px; font-family: FangSong; font-size: 30px;">
		<a href=viewBook.jsp target="_blank">1.购买书籍</a> <br>
		<a href=listBook.jsp target="_blank">2.修改图书信息</a><br>
		<a href=listTitles.jsp target="_blank">3.查看图书信息</a><br>
		<a href=updatepassword.jsp target="_blank">4.修改登录信息</a>
	</div>
</body>
</html>