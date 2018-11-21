<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="bean.*,java.util.*,java.sql.*"%>
<jsp:useBean id="dao" class="bean.TitleDaoImpl" scope="request" />
<jsp:useBean id="db" class="bean.DBcon" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>书架维护</title>
</head>
<body>
	<h1 algin="center">书架维护</h1>
	<table bgcolor="lightgrey">
		<tr>
			<td>ISBN</td>
			<td>书名</td>
			<td>版本</td>
			<td>发布时间</td>
			<td>价格</td>
		</tr>
		 <%-- <%
		 	List list=dao.getTitles();//添加图书列表至list中
		 	Title titles = null;
		 	for (int i = 0; i < list.size(); i++) {
		 		titles = (Title) list.get(i);
		 %>
	<tr bgcolor=cyan>
		<td><a href="../servlet/ToEditTitle?isbn=<%=titles.getIsbn()%>" title="单击进行编辑">
		<%=titles.getIsbn() %></a></td>
		<td><%=titles.getTitle() %></td>
		<td><%=titles.getEditonNumber() %></td>
		<td><%=titles.getCopyright() %></td>
		<td><%=titles.getPrice() %></td>
		<td> <a href="../servlet/DoDeleteTitle?isbn=<%=titles.getIsbn() %>">删除</a></td>		
<%
	}	
%>  --%>
		 <%
			Connection conn = db.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from titles";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
		%>
		<tr bgcolor="cyan">
			<td><a href="../servlet/ToEditTitle?isbn=<%=rs.getInt("isbn")%>"
				title="单击进行图书修改"><%=rs.getString(1)%></a></td>
			 <%
			request.setAttribute("isbn",rs.getInt("isbn"));
			%> 
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt("editionNumber")%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getDouble("price")%></td>
			<td><a
				href="../servlet/DoDeleteTitle?isbn=<%=rs.getInt("isbn")%>">删除</a></td>
		</tr>
		<%
			}
			rs.close();
			st.close();
			conn.close();
		%>
	</table> 
	<br>
	<a href="addTitle.jsp">添加图书</a>
</body>
</html>