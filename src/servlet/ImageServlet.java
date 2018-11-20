package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DBcon;

public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// 获取表单提交的参数值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("inputcheckcode");
		// 生成一个session对象，从jsp中的session中取值
		HttpSession session = request.getSession();
		String piccode = (String) session.getAttribute("piccode");
		PrintWriter out = response.getWriter();
		if (checkcode.equals(piccode)) {
			out.println("验证正确！");
		} else {
			out.println("验证错误！" + piccode);
		}
	}

	/*
	 * Connection conn = DBcon.getConnection(); Statement stmt; try { stmt =
	 * conn.createStatement(); String sql = "select * from userinfo"; ResultSet rs =
	 * stmt.executeQuery(sql);
	 * 
	 * while (checkcode.equals(piccode) && rs.next()) {
	 * request.getSession().setAttribute("username", username);// 将用户名保存到session中
	 * out.println("恭喜你验证通过!"); // out.println("<a href='main.jsp'>转向主页</a>");
	 * request.getRequestDispatcher("main.jsp").forward(request, response); }
	 * out.println("验证错误！"); // out.println("<a href='login.jsp'>重新登录</a>");
	 * request.getRequestDispatcher("login.jsp").forward(request, response); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
