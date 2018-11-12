package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//封装业务的javabean
public class DBcon {
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/books?useUnicode=true&characterEncoding=UTF-8";
	private static final String user = "root";
	private static final String psw = "mysql";

	// 返回一个连接对象
	public static Connection getConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DRIVER_CLASS);
			dbConnection = DriverManager.getConnection(url, user, psw);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return dbConnection;
	}

	// 关闭连接
	public static void closeConnection(Connection dbConnection) {
		try {
			if (dbConnection != null && (!dbConnection.isClosed())) {
				dbConnection.close();
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 关闭结果集
	public static void closeResultSet(ResultSet res) {
		if (res != null) {
			try {
				res.close();
				res = null;
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
	}

	public static void closeStatement(PreparedStatement pStatement) {
		if (pStatement != null) {
			try {
				pStatement.close();
				pStatement = null;
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
	}
//测试数据库连接

	/*
	 * public static void main(String[] args) { Connection con =
	 * DBcon.getConnection(); if (con != null) { System.out.println("数据库连接正常！"); }
	 * else { System.out.println("数据库连接错误！"); } }
	 */

}
