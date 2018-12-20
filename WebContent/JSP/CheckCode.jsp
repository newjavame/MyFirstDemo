<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@ page
	import="java.awt.image.BufferedImage,javax.imageio.ImageIO,java.awt.Graphics,
java.util.Random,java.awt.Color,java.awt.Font"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>生成验证码</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int width = 78;
		int heiht = 20;
		// 创建对象
		BufferedImage bim = new BufferedImage(68, 20, BufferedImage.TYPE_INT_RGB);
		// 获取图片对象的上下文对象g
		Graphics g = bim.getGraphics();
		Random rm = new Random();
		g.setColor(new Color(rm.nextInt(100), 205, rm.nextInt(100)));
		g.fillRect(0, 0, width, heiht);
		String sRand = "";
		// 输出数字
		for (int i = 0; i < 4; i++) {
			g.setColor(Color.black);
			g.setFont(new Font("华文隶书", Font.BOLD | Font.ITALIC, 22));
			int n = rm.nextInt(10);
			//char ctmp = (char) n;
			sRand += String.valueOf(n);
			g.drawString("" + n, i * 15 + 5, 18);
		}
		//将验证码保存到session中
		session.setAttribute("piccode", sRand);			
		//out.print(session.getAttribute("piccode"));
		/* // 禁止缓存
		response.setHeader("Prama", "no-cache");
		response.setHeader("Coche-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg"); */
		// 将bim图片以jpg格式返回给浏览器		
		ImageIO.write(bim, "JPG", response.getOutputStream());	
		/* session.setAttribute("hello", "world!");
		out.print(session.getAttribute("hello")); */
		
		//解决项目访问时getOutStream()hasrecalled的异常
	/* 	out.clear();
		out = pageContext.pushBody();
		response.getOutputStream().close(); */
	%>
</body>
</html>