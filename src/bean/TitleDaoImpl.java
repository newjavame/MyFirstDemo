package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



//ͼ��ӿڵ�ʵ����
public class TitleDaoImpl implements TitleDao {
	private Connection connection;// ���Ӷ���
	private PreparedStatement titleQuery;// ����SQL������
	private ResultSet results;// ������������

	// ��ȡͼ�������ͼ��
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
			// TODO �Զ����ɵ� catch ��
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
//����ͼ��ISBNɾ��ͼ��	
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
//����ͼ��bean����ͼ���¼��titles�е�ͼ���¼	
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

//����ISBN����ͼ�飬�����ҵ���ͼ��bean
	@Override
	public Title findByIsbn(String isbn) {
		Title book = null;
		connection = DBcon.getConnection();
		String sql = "Select * from titles where isbn='" + isbn + "'";
		try {
			results = titleQuery.executeQuery();
			if (results.next()) {
				book = new Title();// ÿ�δ���һ����װ���ʵ��
				// �����ݱ��е�һ����¼��ӵ���װ����
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
