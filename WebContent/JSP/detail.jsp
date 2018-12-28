<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@ page import="java.util.*,bean.*" session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>图书信息</title>
<link rel="stylesheet" type="text/css" href="../css/logreg.css" />
</head>
<body class="body1">

	<%
		//从session中获取titles值，
		Title titles = (Title) session.getAttribute("titles");
	%>
	<table style="TEXT-ALIGN: center" cellSpacing="0" cellPadding="0"
		width="590" border="0">
		 <tr height="100">
			<td colspan="3"><h2><%=titles.getTitle()%></h2></td>
		</tr>
		<tr>
			 <td rowspan="5"><img style="border: thin solid black" width="80"
				height="120" alt="<%=titles.getTitle()%>:<%=titles.getIsbn()%>.jpg"
				src="images/<%=titles.getIsbn()%>.jpg"></td> 
			<td class="bold" align="left">图书编号:</td>
			<td align="left"><%=titles.getIsbn()%></td>
		</tr>
		<tr align="left">
			<td class="bold" align="left">价格：</td>
			<td align="left"><%=titles.getPrice()%></td>
		</tr>
		<tr align="left">
			<td class="bold" align="left">版本号：</td>
			<td align="left"><%=titles.getEditonNumber()%></td>
		</tr>
		<tr align="left">
			<td class="bold" align="left">版权：</td>
			<td align="left"><%=titles.getCopyright()%></td>
		</tr>
		<tr align="left">
			<td><form method="post" action="../servlet/AddTitlesToCart">
					<input type="submit" value="放入购物车" />
				</form></td>
			<td><form method="post" action="../JSP/viewCart.jsp">
					<input type="submit" value="查看购物车" />
				</form></td>
		</tr>
	</table>
</body>
</html>