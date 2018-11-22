package servlet;
//显示图书详细信息
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Title;
import bean.TitleDao;
import bean.TitleDaoImpl;

public class ToViewTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;     
 
    public ToViewTitle() {
        super();      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String isbn=request.getParameter("isbn");
		/*PrintWriter out = response.getWriter();
		out.println(isbn);*/
		TitleDao titleDao=new TitleDaoImpl();
		Title titles=titleDao.findByIsbn(isbn);
		HttpSession session=request.getSession();
		session.setAttribute("titles", titles);//将图书tiltes保存在session中
		//用服务器内部转发至图书详情页面
		request.getRequestDispatcher("/JSP/detail.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
