package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookOrder;
import bean.OrderOperation;

public class DoOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoOrder() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookOrder bookorderbean=new BookOrder();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		bookorderbean.setUserName(request.getParameter("username"));
		bookorderbean.setZipcode(request.getParameter("zipcode"));
		bookorderbean.setCreditcard(request.getParameter("creditcard"));
		bookorderbean.setPhone(request.getParameter("phone"));
		bookorderbean.setTotal(((Double)session.getAttribute("total")).doubleValue());
		session.setAttribute("order",bookorderbean);//��������Ϣ����session�й�byeҳ�����
		OrderOperation op=new OrderOperation();
		op.saveOrder(bookorderbean);//���������浽���ݿ�
		request.getRequestDispatcher("bye.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
