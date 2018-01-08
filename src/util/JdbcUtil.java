package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletContext;

public class JdbcUtil {
	private static String driverClass;
	private static String url;
	private static String userName;
	private static String password;
	/*private static String driverClass ="com.mysql.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost:3306/studentsystem?useUnicode=true&characterEncoding=UTF-8";
	private static String userName = "root";
	private static String password = "root";*/
	
	public static void init(ServletContext servletContext) {
		InputStream inputStream = null;
		try {
			inputStream = servletContext.getResourceAsStream("/WEB-INF/classes/db");
			//inputStream = new FileInputStream("db");
			Properties properties = new Properties();
			properties.load(inputStream);
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	static{
		
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, userName, password);
	}
	
	public static void close(Connection connection,Statement statement,ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
}
