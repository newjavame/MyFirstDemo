<%@ page language="java" contentType="text/html; charset=utf-8"
	import="bean.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改图书页面</title>
</head>
<body>
	<%
		//从request对象中取出属性title的值
		Title title = (Title) request.getAttribute("title");
	request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
	%>
	<h1>修改图书</h1>
	<form action="../servlet/DoSaveEditTitle" method="post">
		<table>
			<tr>
				<td>ISBN</td>
				<td><input type="text" name="isbn" readonly="true"
					value="<%=title.getIsbn()%>" /></td>
			</tr>
			<tr>
				<td>书名</td>
				<td><input type="text" name="title"
					value="<%=title.getTitle()%>" /></td>
			</tr>
			<tr>
				<td>封面图像文件名称</td>
				<td><input type="text" name="imageFile"
					value="<%=title.getImageFile()%>" /></td>
			</tr>
			<tr>
				<td>版本号</td>
				<td><input type="text" name="editionNumber"
					value="<%=title.getEditonNumber()%>" /></td>
			</tr>
			<tr>
				<td>出版商ID</td>
				<td><input type="text" name="pulisherId" readonly="true"
					value="<%=title.getPublisherId()%>" /></td>
			</tr>
			<tr>
				<td>价格</td>
				<td><input type="text" name="price"
					value="<%=title.getPrice()%>" /></td>
			</tr>
			<tr>
				<td>版权</td>
				<td><input type="text" name="copyright"
					value="<%=title.getCopyright()%>" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
	<br>
	<%-- <a href="uploadfile.jsp?isbn=<%=title.getIsbn()%>">上传图书封面图像文件</a>

	<a href="uploadfile_show.jsp">查看图书封面图像文件</a> --%>
</body>

</html>