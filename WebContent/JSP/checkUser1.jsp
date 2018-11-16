<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<jsp:useBean id="db" class="bean.DBcon" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>验证登录验证码</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String checkcode=request.getParameter("inputcheckcode");
 	String piccode=(String)session.getAttribute("piccode"); 	
%>
	你输入的验证码是：<%=checkcode %><br>
	 由servlet生成的验证码是：<%=piccode %><br> 
	你输入的用户名：<%=username %><br>
	你输入的密码：<%=password %><br>
<%
	 Connection conn=db.getConnection();
	Statement stmt = conn.createStatement();	
	String sql = "select * from userinfo";
	ResultSet rs=stmt.executeQuery(sql);
	while(checkcode.equals(piccode) && rs.next()){
		session.setAttribute("username",username);//将用户名保存到session中
		out.println("恭喜你验证通过!");
		out.println("<a href='main.jsp'>转向主页</a>");
	}
		out.println("验证错误！");
		out.println("<a href='login.jsp'>重新登录</a>");			
%>
</body>
</html>