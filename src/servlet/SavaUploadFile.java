package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class SavaUploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SavaUploadFile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �ļ��ϴ���ʹ��ʱҪ������Ӧ���ļ���
		String isbn = request.getParameter("isbn");
		String path = request.getContextPath();
		// ����ͼ���ļ�������web����info�е�images�ļ�����
		String realpath = request.getRealPath("images");
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		System.out.println("path=" + path);
		System.out.println("request.getRealPath('images')=" + realpath);
		System.out.println("basepath=" + basePath);
		System.out.println("isbn=" + isbn);

		/*// 1������һ��DiskFileItemFactory����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2������һ���ļ��ϴ�������
		ServletFileUpload upload = new ServletFileUpload(factory);
		// ����ϴ��ļ�������������
		upload.setHeaderEncoding("UTF-8");
		// 3���ж��ύ�����������Ƿ����ϴ���������
		if (!ServletFileUpload.isMultipartContent(request)) {
			// ���մ�ͳ��ʽ��ȡ����
			return;
		}*/

		DiskFileUpload fu = new DiskFileUpload();
		fu.setSizeMax(1024 * 1024);// ���������û��ϴ��ļ��Ĵ�С����λΪ�ֽ�
		fu.setRepositoryPath(realpath);
		/*
		 * ���½���request�����������д�������ͼ���ļ���������������� ���浽"\images"�ļ�����
		 */
		try {
			List fileItems = fu.parseRequest(request);
			Iterator iter = fileItems.iterator();
			while (iter.hasNext()) {// ���δ���ÿ���ϴ����ļ�
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {// �������������ļ�������б���Ϣ
					/* ����Ϊ�ļ��������ϴ���ͼ������ļ����������ͬ��������images�ļ����� */
					File savedFile = new File(realpath, isbn + ".jpg");
					item.write(savedFile);
				}
			}
		} catch (Exception e) {
			response.sendRedirect("uploadfile_show.jsp?isbn=" + isbn);
		}

	}

}
