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
        <%-- 您好
        <%=username%><BR> --%>
            恭喜您修改成功<br><br>
        <img src="../images/duihao.jpg" style="height:200px;width:250px;"/><br><br>
          <a href="../JSP/login.jsp">现在去登录吧</a>

</body>
</html>