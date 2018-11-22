package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Title;
import bean.TitleDao;
import bean.TitleDaoImpl;

public class DoAddTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoAddTitle() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 获取表单传来的新增的图书属性参数
		String isbn = request.getParameter("isbn");// ISBN
		String booktitle = request.getParameter("title");// 书名
		String copyright = request.getParameter("copyright");// 版权
		String imageFile = request.getParameter("imageFile");// 封面图像文件
/*		PrintWriter out = response.getWriter();
		out.print(isbn+" "+booktitle+" "+copyright);*/
		int editionNumber = Integer.parseInt(request.getParameter("editionNumber"));// 版本号
		int publisherId = Integer.parseInt(request.getParameter("pulisherId"));
		float price = Float.parseFloat(request.getParameter("price"));// 价格
		// 将数据添加进封装类中
		Title titlebean = new Title();
		titlebean.setIsbn(isbn);
		titlebean.setCopyright(copyright);
		titlebean.setEditonNumber(editionNumber);
		// titlebean.setImageFile(imageFile);
		titlebean.setImageFile(isbn + ".jpg");
		titlebean.setPrice(price);
		titlebean.setPublisherId(publisherId);
		titlebean.setTitle(booktitle);
		// 调用数据库操作类执行插入操作
		TitleDao titleDao = new TitleDaoImpl();
		int n = titleDao.add(titlebean);
		if (n > 0)
			response.sendRedirect("../JSP/listBook.jsp");
		else
			response.sendRedirect("../JSP/error.jsp");
	}

}
