package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TitleDao;
import bean.TitleDaoImpl;

public class DoDeleteTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DoDeleteTitle() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		String isbn=request.getParameter("isbn");//根据isbn来进行删除图书信息
		TitleDao titleDao=new TitleDaoImpl();
		int n=titleDao.delete(isbn);
		if(n>0)
		  response.sendRedirect("listBook.jsp");
		else
		   response.sendRedirect("error.jsp");
		  
		/*PrintWriter out = response.getWriter();
		out.println(isbn);*/
	
	}

}
