<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.sql.*" pageEncoding="utf-8"%>
<jsp:useBean id="db" class="bean.DBcon" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>检查用户名和密码</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("loginName");
		String password = request.getParameter("password");
	%>

	<%
		Connection conn = db.getConnection();
		Statement st = conn.createStatement();
		String sql = "select * from userinfo";
		ResultSet rs = st.executeQuery(sql);
		//检查用户名和密码合法化
		while (rs.next()) {
			if (name.equals(rs.getString("loginname")) && password.equals(rs.getString("password"))) {
				application.setAttribute("name", name);
				response.sendRedirect("main.jsp");
			}
		}
		out.println("无此用户或密码错误，登录失败！<br><br>");
		out.println("<a href='../HTML/index.html'>重新登录");
		//</a>或<a href='../JSP/Reg.jsp'>注册</a>
	%>
</body>
</html>