<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="bean.*,java.util.*"%>
<jsp:useBean id="dao" class="bean.TitleDaoImpl" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>浏览图书页面</title>
<link rel="stylesheet" type="text/css" href="../css/logreg.css" />
</head>
<body class="body1">
	<h1 align="center">浏览图书</h1>
	<table align="center">
		<tr>
			<td>ISBN</td>
			<td>书名</td>
			<td>版本号</td>
			<td>出版商ID</td>
			<td>价格</td>
			<td>图书图像</td>
			<td>版权</td>
		</tr>
		<%
			List<Title> list = dao.getTitles();//得到图书列表
			Title titles = null;
			for (int i = 0; i < list.size(); i++) {
				titles = (Title) list.get(i);

		%>
		<tr >
			<td><a href="../servlet/ToViewTitle?isbn=<%=titles.getIsbn()%>"
				title="图书详情"> <%=titles.getIsbn()%></a></td>
			<td><%=titles.getTitle()%></td>
			<td><%=titles.getEditonNumber()%></td>
			<td><%=titles.getCopyright()%></td>
			<td><%=titles.getPrice()%></td>
			<td><%=titles.getImageFile() %>
			<td><%=titles.getPublisherId() %>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>