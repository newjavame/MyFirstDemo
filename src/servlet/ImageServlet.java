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
		// ���������������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// ��ȡ���ύ�Ĳ���ֵ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("inputcheckcode");
		// ����һ��session���󣬴�jsp�е�session��ȡֵ
		HttpSession session = request.getSession();
		String piccode = (String) session.getAttribute("piccode");
		PrintWriter out = response.getWriter();
		if (checkcode.equals(piccode)) {
			out.println("��֤��ȷ��");
		} else {
			out.println("��֤����" + piccode);
		}
	}

	/*
	 * Connection conn = DBcon.getConnection(); Statement stmt; try { stmt =
	 * conn.createStatement(); String sql = "select * from userinfo"; ResultSet rs =
	 * stmt.executeQuery(sql);
	 * 
	 * while (checkcode.equals(piccode) && rs.next()) {
	 * request.getSession().setAttribute("username", username);// ���û������浽session��
	 * out.println("��ϲ����֤ͨ��!"); // out.println("<a href='main.jsp'>ת����ҳ</a>");
	 * request.getRequestDispatcher("main.jsp").forward(request, response); }
	 * out.println("��֤����"); // out.println("<a href='login.jsp'>���µ�¼</a>");
	 * request.getRequestDispatcher("login.jsp").forward(request, response); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
