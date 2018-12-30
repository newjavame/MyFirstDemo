<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/login.css'/>">
<script type="text/javascript"
	src="<c:url value='/css/js/jquery-1.5.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/css/js/login.js'/>"></script>
<script src="<c:url value='/css/js/common.js'/>"></script>

<script type="text/javascript">
	$(function() {/*Map<String(Cookie名称),Cookie(Cookie本身)>*/
		// 获取cookie中的用户名
		var loginname = window.decodeURI("${cookie.loginname.value}");
		if ("${requestScope.user.loginname}") {
			loginname = "${requestScope.user.loginname}";
		}
		$("#loginname").val(loginname);
	});
</script>
</head>
<body>
	<div class="main">
		<div>
			<img src="<c:url value='/images/books.jpg'/>"
				style="width: 100px; height: 100px" />
		</div>
		<div>
			<div class="imageDiv">
				<img class="img" src="<c:url value='/images/zj.png'/>" />
			</div>
			<div class="login1">
				<div class="login2">
					<div class="loginTopDiv">
						<span class="loginTop">用户登录</span>
					</div>
					<div>
						<form method="post" name="Register" action="checkUser.jsp"
							target="_self">
							<table>
								<tr>
									<td width="50"></td>
									<td></td>
								</tr>
								<tr>
									<td width="50">用户名</td>

									<td><input class="input" type="text" name="loginname"
										id="loginname" /></td>
								</tr>
								<tr>
									<td height="20">&nbsp;</td>
									<td><label id="loginnameError" class="error"></label></td>
								</tr>
								<tr>
									<td>密 码</td>

									<td><input class="input" type="password" name="password" /></td>
								</tr>
								<tr>
									<td height="20">&nbsp;</td>
									<td><label id="loginpassError" class="error"></label></td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<td align="left"><input type="image" id="submit"
										src="<c:url value='/images/login1.jpg'/>" /> <a
										href="regist.jsp">立即注册</a></td>
									<td></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>