<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
<%-- <%
/* 网站域名或ip后面的部分,即项目上下文路径 */
      String path=request.getContextPath();
/* //访问基准路径,该页面上的相对路径需要扣上的前缀 */
        String basePath = request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path+"/";

   %> --%>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<%-- <base href="<%=basePath%>"> --%>
</head>
<script type="text/javascript">
	function reloadImage(t) {
		t.src = "../bean/ImageServlet?flag=" + Math.random();
	}
</script>
<body>
	<form action="../bean/CheckServer">
		<table>
			<tr>
				<td colspan="2" align="center">用户登录</td>
			</tr>
			<tr>
				<td>登录名：</td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" name="checkcode"> <img
					src="../bean/ImageServlet" align="middle" alt="看不清，点击这里"
					onclick="reloadImage(this)"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="登录">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>