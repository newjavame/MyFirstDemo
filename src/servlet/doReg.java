package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DBcon;

public class doReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public doReg() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");// 处理输出中文乱码
		request.setCharacterEncoding("UTF-8");// 处理接收的中文乱码
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		
		try {
			Connection conn = DBcon.getConnection();
			String sql = "insert into userinfo(loginname,password) values(?,?)";
			PreparedStatement st= conn.prepareStatement(sql);			
			st.setString(1, username);
			st.setString(2, password);				
			st.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/JSP/ok.jsp").forward(request, response);

	}

}
