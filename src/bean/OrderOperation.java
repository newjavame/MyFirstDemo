package bean;
//���������࣬���ڽ��������浽���ݿ�

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderOperation {
	private Connection conn;
	private PreparedStatement pstmt;
	public void saveOrder(BookOrder bookOrder) {
		conn=DBcon.getConnection();
		String sql="insert into bookorder(username,zipcode,phone,creditcard,total)"
				+ "values(?,?,?,?,?)";
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, bookOrder.getUserName());
			pstmt.setString(2, bookOrder.getZipcode());
			pstmt.setString(3, bookOrder.getPhone());
			pstmt.setString(4, bookOrder.getCreditcard());
			pstmt.setDouble(5, bookOrder.getTotal());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBcon.closeStatement(pstmt);
			DBcon.closeConnection(conn);
		}
		
	}
}
