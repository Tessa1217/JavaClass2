package co.edu.prj.database.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource { // Singleton
	private static DataSource dataSource = new DataSource();

	private DataSource() {
	};

	public static DataSource getInstance() {
		return dataSource;
	}

	private Connection conn;
	private String driver;
	private String url;
	private String id;
	private String pwd;

	public Connection connection() {
		try {
			configuration();
			Class.forName(driver);
			// System.out.println("드라이버 연결에 성공하셨습니다.");
			conn = DriverManager.getConnection(url, id, pwd);
			// System.out.println("DB 연결에 성공하셨습니다.");

		} catch (ClassNotFoundException | SQLException e) {
			// System.out.println("DB 연결에 실패하였습니다.");
			e.printStackTrace();
		}
		return conn;
	}

	// 하드코딩된 url, id, pwd말고 리소스 파일 읽어드리기

	public void configuration() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			id = properties.getProperty("id");
			pwd = properties.getProperty("pwd");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
