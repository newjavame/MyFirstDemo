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
		// 文件上传，使用时要导入相应的文件包
		String isbn = request.getParameter("isbn");
		String path = request.getContextPath();
		// 封面图像文件保存在web——info中的images文件夹中
		String realpath = request.getRealPath("images");
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		System.out.println("path=" + path);
		System.out.println("request.getRealPath('images')=" + realpath);
		System.out.println("basepath=" + basePath);
		System.out.println("isbn=" + isbn);

		/*// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 3、判断提交上来的数据是否是上传表单的数据
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 按照传统方式获取数据
			return;
		}*/

		DiskFileUpload fu = new DiskFileUpload();
		fu.setSizeMax(1024 * 1024);// 设置允许用户上传文件的大小，单位为字节
		fu.setRepositoryPath(realpath);
		/*
		 * 以下接收request对象从浏览器中传来封面图像文件，重新以书号命名 保存到"\images"文件夹中
		 */
		try {
			List fileItems = fu.parseRequest(request);
			Iterator iter = fileItems.iterator();
			while (iter.hasNext()) {// 依次处理每个上传的文件
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {// 忽略其他不是文件域的所有表单信息
					/* 以下为文件名处理，上传的图书封面文件名与书号相同，保存在images文件夹中 */
					File savedFile = new File(realpath, isbn + ".jpg");
					item.write(savedFile);
				}
			}
		} catch (Exception e) {
			response.sendRedirect("uploadfile_show.jsp?isbn=" + isbn);
		}

	}

}
