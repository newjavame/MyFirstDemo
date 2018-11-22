package bean;
//测试根据图书ISBN输出图书信息
public class TitleTest {

	public static void main(String[] args) {
		Title book=new Title();
		TitleDao titleDao=new TitleDaoImpl();
		book=titleDao.findByIsbn("456");
		System.out.println(book.getIsbn());

	}

}
