package co.edu.post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static final String url = "jdbc:oracle:thin:@javadb_high?TNS_ADMIN=/Users/tessa/Wallet_javadb";
	static final String userid = "post";
	static final String pwd = "NewProject3019";

	public static Connection connection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		return con;
	}

}
