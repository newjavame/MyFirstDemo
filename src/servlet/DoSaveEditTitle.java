package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Title;
import bean.TitleDao;
import bean.TitleDaoImpl;


public class DoSaveEditTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DoSaveEditTitle() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		//��ȡ��������ͼ��༭��Ϣ
		String isbn=request.getParameter("isbn");//ISBN
		String title=request.getParameter("title");//����
		String copyright=request.getParameter("copyright");//��Ȩ
		String imageFile=request.getParameter("imageFile");//����ͼ���ļ�
		int editionNumber=Integer.parseInt(request.getParameter("editionNumber"));//�汾��
		int publisherId=Integer.parseInt(request.getParameter("publisherId"));
		float price=Float.parseFloat(request.getParameter("price"));//�۸�
		//��������ӽ���װ����
		Title titlebean=new Title();
		titlebean.setIsbn(isbn);
		titlebean.setCopyright(copyright);
		titlebean.setEditonNumber(editionNumber);
		titlebean.setImageFile(imageFile);
		titlebean.setPrice(price);
		titlebean.setPublisherId(publisherId);
		titlebean.setTitle(title);
		//�������ݿ������ִ�и��²���
		TitleDao titleDao=new TitleDaoImpl();
		int n=titleDao.update(titlebean);
		if(n>0)
		  response.sendRedirect("listBook.jsp");
		else
		   response.sendRedirect("error.jsp"); 		
	}

}
