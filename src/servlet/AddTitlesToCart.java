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
		// 如果session不存在就跳转到浏览图书页面;
		if (session == null) {
			dispatcher = request.getRequestDispatcher("/JSP/viewBook.jsp");
			dispatcher.forward(request, response);
		}
		// 从session中提取出购物车（cart）和要添加的图书对象titles
		Map cart = (Map) session.getAttribute("cart");
		Title titles = (Title) session.getAttribute("titles");
		// 如果购物车不存在就创建购物车
		if (cart == null) {
			cart = new HashMap<>();
			// 将购物车存入session中
			session.setAttribute("cart", cart);
		}
		// 从购物车对象中根据图书书号取出相应的购书项对象
		CartItem cartItem = (CartItem) cart.get(titles.getIsbn());
		if (cartItem != null) {// 如果购物车中已有购书项对象，则更新选购数量
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		} else {// 否则就创建一个新的条目到cart中
			CartItem cartItem1 = new CartItem();
			cartItem1.setTitle(titles);
			cartItem.setQuantity(1);
			cart.put(titles.getIsbn(), cartItem1);
		}
		// 成功添加到购物车后转向viewCart.jsp显示购物车
		dispatcher = request.getRequestDispatcher("/JSP/viewCart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
