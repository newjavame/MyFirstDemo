<%@ page language="java" contentType="text/html; charset=utf-8" import="java.io.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件目录</title>
</head>
<body>
<font size="4" color="red" >已上传的图书封面图像文件</font><br>
<font size="3" color="blue">
	<%
		String path=request.getRealPath("images");
			File fl=new File(path);
			File lst[]=fl.listFiles();
			out.print("服务器上传文件保存路径："+path+"<br><br>");
			out.print("封面图像文件名："+request.getParameter("isbn")+".jpg<br>");
			out.println("<img width='80' height='120' src=images\\"+request.getParameter("isbn")+".jpg<br>");
			
	%>
</font><br>
<a href="listBook.jsp">返回图书编辑页面</a>
</body>
</html>