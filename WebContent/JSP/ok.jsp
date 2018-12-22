<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册成功提示页面</title>
<link rel="stylesheet" type="text/css" href="../css/logreg.css" />
</head>
<body class="body1">
	<%
		String username = (String) request.getAttribute("username");
	%>
	<div
		style="text-align: center; font-family: YouYuan; font-size: 42px; margin-top: 150px;">
		您好
		<%=username%><BR>
		<BR> 恭喜您注册成功！<br><br>
		  <a href="../HTML/index.html">现在去登录吧</a>
	</div>

</body>
</html>