<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件上传</title>
</head>
<body bgcolor="#FFFFFF" text="#000000" leftmargin="0" topmargin="40"
	marginheight="0" marginwidth="0">
	<center>
		<h1>文件上传</h1>
		<form name="uploadform" method="post"
			action="../servlet/SaveUploadFile?isbn=<%=request.getParameter("isbn")%>"
			enctype="multipart/form-data">
			书号：<%=request.getAttribute("isbn")%>
			<table border="3" width="450" cellpadding="4" cellspacing="2"
				bordercolor="#9bd7ff">
				<tr>
					<td width="40%">封面图像文件</td>
					<td><input type="file" size="30" name="file1"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit"
						name="submit" value="上传"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>