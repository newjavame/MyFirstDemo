package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//从数据库得到用户名和密码
public class GetUserInfo {
	static String loginname;
	static String password;

	public static void main(String[] args) {
		Connection conn = DBcon.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "select * from userinfo";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {				
				loginname=rs.getString("loginname");
				password=rs.getString("password");

			}			
			rs.close();
			st.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
