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
		// ���տͻ���������ύ��������֤��
		String clientCheckcode = request.getParameter("checkcode");
		// �ӷ������˵�session��ȡ����֤��
		String serverCheckcode = request.getSession().getAttribute("piccode").toString();
		if (clientCheckcode.equals(serverCheckcode)) {
			// ���ͻ�����֤��ͷ���������֤�Ƚϣ������ȣ����ʾ��֤ͨ��
			System.out.println("��֤����֤ͨ����");
		} else {
			System.out.println("��֤����֤ʧ�ܣ�");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
