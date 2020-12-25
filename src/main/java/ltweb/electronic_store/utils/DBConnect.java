package ltweb.electronic_store.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private final String dbName = "webdt";
	private final String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
	private final String dbUsn = "nsqa";
	private final String dbPw = "123456";
	private Connection conn;

	public DBConnect() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUsn, dbPw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

}
