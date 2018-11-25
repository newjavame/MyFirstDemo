package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartItem;
import bean.Title;

import java.util.*;

public class AddTitlesToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddTitlesToCart() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher;
		// ���session�����ھ���ת�����ͼ��ҳ��;
		if (session == null) {
			dispatcher = request.getRequestDispatcher("/JSP/viewBook.jsp");
			dispatcher.forward(request, response);
		}
		// ��session����ȡ�����ﳵ��cart����Ҫ��ӵ�ͼ�����titles
		Map cart = (Map) session.getAttribute("cart");
		Title titles = (Title) session.getAttribute("titles");
		// ������ﳵ�����ھʹ������ﳵ
		if (cart == null) {
			cart = new HashMap<>();
			// �����ﳵ����session��
			session.setAttribute("cart", cart);
		}
		// �ӹ��ﳵ�����и���ͼ�����ȡ����Ӧ�Ĺ��������
		CartItem cartItem = (CartItem) cart.get(titles.getIsbn());
		if (cartItem != null) {// ������ﳵ�����й�������������ѡ������
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		} else {// ����ʹ���һ���µ���Ŀ��cart��
			CartItem cartItem1 = new CartItem();
			cartItem1.setTitle(titles);
			cartItem.setQuantity(1);
			cart.put(titles.getIsbn(), cartItem1);
		}
		// �ɹ���ӵ����ﳵ��ת��viewCart.jsp��ʾ���ﳵ
		dispatcher = request.getRequestDispatcher("/JSP/viewCart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
