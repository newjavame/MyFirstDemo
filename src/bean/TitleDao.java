package bean;

import java.util.List;

//操作图书表的接口
public interface TitleDao {
	public List<Title> getTitles();//获得图书列表
	public int add(Title titlebean);//添加图书
	public int delete(String isbn);//删除图书
	public int update(Title titlebean);//更新修改图书
	public Title findByIsbn(String isbn);//查询图书
	
	

}
