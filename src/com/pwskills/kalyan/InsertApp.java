package com.pwskills.kalyan;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.utility.DBUtil;

public class InsertApp {

	//private static final String SQLINSERT_QUERY = "INSERT INTO student values(97,'george',58,'uk')";

	public static void main(String[] args) {
		
		//Resources used 
		Connection connection = null;
		Statement statement = null;
		int rowCount = 0;
		
		 try {
			connection = DBUtil.getDBConnection();
			
			if(connection != null) {
				statement = connection.createStatement();

			}
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the sid :: ");
			int sid = scanner.nextInt();
			
			System.out.print("Enter the sname :: ");
			String  sname = scanner.next();
			
			System.out.print("Enter the sage :: ");
			int sage = scanner.nextInt();
			
			System.out.print("Enter the sname :: ");
			String  saddress = scanner.next();
			String SqlInsertQuery = "insert into student values(" + sid + ",'"+sname+"',"+sage+",'"+saddress+"'"+")";
			System.out.println(SqlInsertQuery);
			if(statement != null) {
				
				rowCount = 	statement.executeUpdate(SqlInsertQuery);
				
			}
			if(rowCount == 0) {
				System.out.println("Failure in insertion...");
			}else {
				System.out.println("Record is inserted successfully");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.cleanUpResources(null, statement, connection);
		}

	}

}
