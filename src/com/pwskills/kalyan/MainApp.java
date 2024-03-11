package com.pwskills.kalyan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MainApp {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		FileInputStream fis = null;
		
		
		try {
			 fis = new FileInputStream("D:\\Java Programming files for eclipse\\practice-advance-java\\JdbcApp01\\src\\com\\pwskills\\properties\\database.properties");
			Properties properties = new Properties();
			properties.load(fis);
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			
			// 1 Establishing the connection
			connection = DriverManager.getConnection(url,user,password );
			System.out.println("Connection established for :: " + url);
			 
			//2 creating the statement object
			
			statement = connection.createStatement();
			System.out.println("Statement object created");
			
			//3 send and execute query
			String selectQuery = "select * from student";
			resultSet = statement.executeQuery(selectQuery);
			
			System.out.println("\nCollected the result in the resultset ");
			
			
			
			//4 processing the result
			System.out.println("SID\tSNAME\tSAGE\tsSADDRESS");
			System.out.println("**************************************");
			while(resultSet.next()) {
				int sid = resultSet.getInt(1);
				String sname = resultSet.getString(2);
				int sage = resultSet.getInt(3);
				String saddress = resultSet.getString(4);
				
				System.out.println(sid + "\t" + sname + "\t" + sage + "\t" + saddress);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5 close the resources
			//closing the resultSet
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//closing the statement 
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//closing the connection
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//closing the fileInputStream resource
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
