<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加图书</title>
<style type="text/css">
<!--
body {
	background-image: url(../images/addT.jpg);
	background-size: 100%;
	height: auto;
}
</style>
-->
<link rel="stylesheet" type="text/css" href="../css/logreg.css" />
</head>
<body class="body1">
	<form action="../servlet/DoAddTitle">
		<table align="center" valign="center">
			<tr>
				<td colspan="2" align="center"
					style="font-family: YouYuan; font-size: 42px;">添加图书信息</td>

			</tr>
			<tr>
				<td style="font-family: FangSong; font-size: 30px;">ISBN</td>
				<td><input type="text" name="isbn"
					style="width: 330px; height: 30px;" /></td>
			</tr>
			<tr>
				<td style="font-family: FangSong; font-size: 30px;">书名</td>
				<td><input type="text" name="title"
					style="width: 330px; height: 30px;" /></td>
			</tr>
			<tr>
				<td style="font-family: FangSong; font-size: 30px;">封面图像文件名称</td>
				<td><input type="text" name="imagefile"
					style="width: 330px; height: 30px;" /></td>
			</tr>
			<tr>
				<td style="font-family: FangSong; font-size: 30px;">版本号</td>
				<td><input type="text" name="editionNumber"
					style="width: 330px; height: 30px;" /></td>
			</tr>
			<tr>
				<td style="font-family: FangSong; font-size: 30px;">出版商</td>
				<td><input type="text" name="publisherId"
					style="width: 330px; height: 30px;" /></td>
			</tr>
			<tr>
				<td style="font-family: FangSong; font-size: 30px;">价 格</td>
				<td><input type="text" name="price"
					style="width: 330px; height: 30px;" /></td>
			</tr>
			<tr>
				<td style="font-family: FangSong; font-size: 30px;">版权</td>
				<td><input type="text" name="copyright"
					style="width: 330px; height: 30px;" /></td>
			</tr>
			<tr>

				<td colspan="2" align="center"><input type="submit" value="添加"
					style="width: 150px; height: 32px; font-family: FangSong; font-size: 20px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>