package com.pwskills.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
	// making the constructor private because I dont want user to create the object
	// of the class DBUtil
	// because creation of a object is a costly event
	private DBUtil() {

	}

	static Properties properties = null;

	// using static block to create the stream for the .properties file when the
	// .class file loads
	static {
		FileInputStream fis = null;
		String fileInfo = "D:\\Java Programming files for eclipse\\practice-advance-java\\JdbcApp01\\src\\com\\pwskills\\properties\\database.properties";
		try {
			fis = new FileInputStream(fileInfo);
			properties = new Properties();
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getDBConnection() throws Exception {

		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		return DriverManager.getConnection(url, user, password);

	}

	public static void cleanUpResources(ResultSet resultSet, Statement statement, Connection connection) {
		// 5 close the resources
		// closing the resultSet
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// closing statement
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// closing connection
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
