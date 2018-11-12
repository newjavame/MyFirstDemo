<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.sql.*,java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="db" class="bean.DBcon" />
<html>
<head>
<meta charset="utf-8">
<title>查看图书信息</title>
</head>
<body>
	<table bgcolor="lightgrey">
		<tr>
			<td>ISBN</td>
			<td>书名</td>
			<td>版本</td>
			<td>出版时间</td>
			<td>价格</td>
		</tr>
		<%
			Connection conn = db.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from titles";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
		%>
		<tr bgcolor="cyan">
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt("editionNumber")%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getDouble("price")%></td>
		</tr>
		<%
			}
			rs.close();
			st.close();
			conn.close();
		%>

	</table>
</body>
</html>