package bean;
//���Ը���ͼ��ISBN���ͼ����Ϣ
public class TitleTest {

	public static void main(String[] args) {
		Title book=new Title();
		TitleDao titleDao=new TitleDaoImpl();
		book=titleDao.findByIsbn("456");
		System.out.println(book.getIsbn());

	}

}
