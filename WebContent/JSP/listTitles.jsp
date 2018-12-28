<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.sql.*,java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="db" class="bean.DBcon" />
<html>
<head>
<meta charset="utf-8">
<title>查看图书信息</title>
<link rel="stylesheet" type="text/css" href="../css/logreg.css" />
</head>
<body class="body1" >
<%
  int i=0;
%>
	<table align="center" valign="center">
	   <tr>
	   <td colspan="5" align="center">书库图书信息 </td>
	   </tr>
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
		<tr >
			<td><%=rs.getString("isbn")%></td>
			<td><%=rs.getString("title")%></td>
			<td><%=rs.getInt("editionNumber")%></td>
			<td><%=rs.getString("copyright")%></td>
			<td><%=rs.getDouble("price")%></td>
		</tr>
		<%
		++i;
			}
			rs.close();
			st.close();
			conn.close();
		%>
        <tr>
            <td colspan="4" align="right">总计</td>
            <td><font color="red"><%=i %></font>条图书信息 </td>
        </tr>
	</table>

</body>
</html>