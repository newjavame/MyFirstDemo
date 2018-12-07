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

public class ToEditTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ToEditTitle() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String isbn = request.getParameter("isbn");	
		TitleDao titleDao = new TitleDaoImpl();
		Title title = titleDao.findByIsbn(isbn);
		// 将图书信息保存到request对象中，转发到编辑页面
		request.setAttribute("title", title);
		request.getRequestDispatcher("/JSP/editTitle.jsp").forward(request, response);
	
	}

}
