package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



//图书接口的实现类
public class TitleDaoImpl implements TitleDao {
	private Connection connection;// 连接对象
	private PreparedStatement titleQuery;// 处理SQL语句对象
	private ResultSet results;// 处理结果集对象

	// 获取图书表所有图书
	public List<Title> getTitles() {
		List<Title> titlesList = new ArrayList<Title>();
		connection = DBcon.getConnection();
		try {
			titleQuery = connection.prepareStatement("Select isbn,title,editionNumber,copyright,"
					+ "publisherID,imageFile,price" + "From titles order by title");
			results = titleQuery.executeQuery();
			while (results.next()) {
				Title book = new Title();
				book.setIsbn(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditonNumber(results.getInt("editionNumber"));
				book.setCopyright(results.getString("copyright"));
				book.setPublisherId(results.getInt("publisherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getFloat("price"));
				titlesList.add(book);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titleQuery);
			DBcon.closeConnection(connection);			
		}
		return titlesList;
		

	}

	@Override
	public int add(Title titlebean) {
		int result = 0;
		connection = DBcon.getConnection();
		String sql = "insert into titles(isbn,title,editionNumber,";
		sql += "copyright,publisherID,imageFile,price) values(?,?,?,?,?,?,?)";
		try {
			titleQuery = connection.prepareStatement(sql);
			titleQuery.setString(1, titlebean.getIsbn());
			titleQuery.setString(2, titlebean.getTitle());
			titleQuery.setInt(3, titlebean.getEditonNumber());
			titleQuery.setString(4, titlebean.getCopyright());
			titleQuery.setInt(5, titlebean.getPublisherId());
			titleQuery.setString(6, titlebean.getImageFile());
			titleQuery.setFloat(7, titlebean.getPrice());
			result = titleQuery.executeUpdate();
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titleQuery);
			DBcon.closeConnection(connection);
		}
		return result;

	}
//根据图书ISBN删除图书	
	@Override
	public int delete(String isbn) {
		int result=0;
		connection=DBcon.getConnection();
		String sql="delete from titles where isbn='"+isbn+"'";
		try {
			titleQuery=connection.prepareStatement(sql);
			result=titleQuery.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titleQuery);
			DBcon.closeConnection(connection);
		}
		return result;
	
	}
//根据图书bean更新图书记录表titles中的图书记录	
	@Override
	public int update(Title titlebean) {
		int result=0;
		connection=DBcon.getConnection();
		String sql="update titles set title=?,editionNumber=?,";
		sql+="copyright=?,publisherID=?,imageFile=?,price=? where isbn=?";
		try {
			titleQuery=connection.prepareStatement(sql);
			titleQuery.setString(1,titlebean.getTitle());
			titleQuery.setInt(2, titlebean.getEditonNumber());
			titleQuery.setString(3, titlebean.getCopyright());
			titleQuery.setInt(4, titlebean.getPublisherId());
			titleQuery.setString(5, titlebean.getImageFile());
			titleQuery.setFloat(6, titlebean.getPrice());
			titleQuery.setString(7, titlebean.getIsbn());
			result=titleQuery.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titleQuery);
			DBcon.closeConnection(connection);
		}
		return result;
		
	}

//根据ISBN查找图书，返回找到的图书bean
	@Override
	public Title findByIsbn(String isbn) {
		Title book = null;
		connection = DBcon.getConnection();
		String sql = "Select * from titles where isbn='" + isbn + "'";
		try {
			results = titleQuery.executeQuery();
			if (results.next()) {
				book = new Title();// 每次创建一个封装类的实例
				// 将数据表中的一条记录添加到封装类中
				book.setIsbn(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditonNumber(results.getInt("editionNumber"));
				book.setCopyright(results.getString("copyright"));
				book.setPublisherId(results.getInt("publisherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getFloat("price"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titleQuery);
			DBcon.closeConnection(connection);

		}
		return book;
		
	}

}
