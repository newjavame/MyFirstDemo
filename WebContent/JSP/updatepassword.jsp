<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value='../css/pwd.css'/>">
<script type="text/javascript"
	src="<c:url value='../css/js/jquery-1.5.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='../css/js/pwd.js'/>"></script>
<script src="<c:url value='/js/common.js'/>"></script>
<title>修改密码</title>
</head>
<body>
	<div class="div1">
		<div class="div0">修改密码</div>
		<form action="../servlet/UpDatePassword" method="post"
			target="_top">
			<table align="center" valign="center">
			     <tr>
			         <td align="right">用户名:</td>
                    <td><input class="input" type="text" name="username"/></td>
                </tr>
                    <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
				<tr>
					<td align="right">原密码:</td>
					<td><input class="input" type="password" name="oldpass" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="right">新密码:</td>
					<td><input class="input" type="password" name="newpass"
						<%-- id="newpass" value="${user.newpass }" " --%>/></td>
					<td><!-- <label id="newpassError" class="error"></label> --></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="right">确认密码:</td>
                    <td><input class="input" type="password" name="confirmpass"
					<%-- 	id="reloginpass" value="${user.reloginpass }" " --%>/></td>
					<td><label id="mima" ></label></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input id="submit"
						type="submit" value="修改密码" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>