package bean;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImageServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		int width = 78;
		int heiht = 20;
		// ��������
		BufferedImage bim = new BufferedImage(68, 20, BufferedImage.TYPE_INT_RGB);
		// ��ȡͼƬ����������Ķ���g
		Graphics g = bim.getGraphics();
		Random rm = new Random();
		g.setColor(new Color(rm.nextInt(100), 205, rm.nextInt(100)));
		g.fillRect(0, 0, width, heiht);
		//StringBuffer sbf = new StringBuffer();
		 String sRand="";
		// �������
		for (int i = 0; i < 4; i++) {
			g.setColor(Color.black);
			g.setFont(new Font("��������", Font.BOLD | Font.ITALIC, 22));
			int n = rm.nextInt(10);
			 char ctmp = (char)n; 
			 sRand += String.valueOf(ctmp); 
			g.drawString("" + n, i * 15 + 5, 18);
		}       
		  
		// ���ɵ���֤�뱣�浽session��
		HttpSession session = request.getSession(true);
		session.setAttribute("piccode", sRand);

		// ��ֹ����
		response.setHeader("Prama", "no-cache");
		response.setHeader("Coche-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		// ��bimͼƬ��jpg��ʽ���ظ������
		ImageIO.write(bim, "JPG", response.getOutputStream());
		response.getOutputStream().close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}


