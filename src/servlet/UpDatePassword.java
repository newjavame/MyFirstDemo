package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DBcon;
import bean.user;

public class UpDatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpDatePassword() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		/*PrintWriter out = response.getWriter();
		out.print(username);*/
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String confirmpass = request.getParameter("confirmpass");
		user yh = new user();
		yh.setLoginname(username);
		yh.setPassword(oldpass);
		Connection conn = DBcon.getConnection();
		PreparedStatement st;
		try {

			String sql = "update userinfo set password=?"+"where loginname="+username;
			st = conn.prepareStatement(sql);
			st.setString(2, yh.getPassword());
			st.setString(2, yh.getPassword());
			int resultSet = st.executeUpdate();
			request.getRequestDispatcher("/JSP/ok1.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
