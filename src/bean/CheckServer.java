package bean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckServer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收客户端浏览器提交上来的验证码
		String clientCheckcode = request.getParameter("checkcode");
		// 从服务器端的session中取出验证码
		String serverCheckcode = request.getSession().getAttribute("piccode").toString();
		if (clientCheckcode.equals(serverCheckcode)) {
			// 将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
			System.out.println("验证码验证通过！");
		} else {
			System.out.println("验证码验证失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
