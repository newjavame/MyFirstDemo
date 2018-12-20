<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加图书</title>
<style type="text/css">
body{
    background-image: url(../images/addT.jpg);
    background-size: 100%;
    height: auto;
}
</style>
</head>
<body>
<form action="../servlet/DoAddTitle">
	<table align="center" valign="center">	
	<tr>
	<td colspan="2" align="center">添加图书信息</td>
	</tr>
		<tr>
			<td>ISBN</td>
			<td><input type="text" name="isbn" /></td>
		</tr>
		<tr>
			<td>书名</td>
			<td><input type="text" name="title" /></td>
		</tr>
		<tr>
			<td>封面图像文件名称</td>
			<td><input type="text" name="imagefile" /></td>
		</tr>
		<tr>
			<td>版本号</td>
			<td><input type="text" name="editionNumber" /></td>
		</tr>
		<tr>
			<td>出版商</td>
			<td><input type="text" name="publisherId" /></td>
		</tr>
		<tr>
			<td>价格</td>
			<td><input type="text" name="price" /></td>
		</tr>
		<tr>
			<td>版权</td>
			<td><input type="text" name="copyright" /></td>
		</tr>
		<tr>
		
			<td colspan="2" align="center"><input type="submit" value="添加"></td>
		</tr>		
	</table>
</form>
</body>
</html>