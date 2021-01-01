package ltweb.electronic_store.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static DBConnect dbConnect;
	private final String dbName = "webdt";
	private final String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
	private final String dbUsn = "root";
	private final String dbPw = "123456789";
	private Connection conn;

	private DBConnect() {
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

	public static DBConnect getInstance() {
		if (dbConnect == null) {
			dbConnect = new DBConnect();
		}
		return dbConnect;
	}

	public Connection getConnection() {
		return conn;
	}

}
