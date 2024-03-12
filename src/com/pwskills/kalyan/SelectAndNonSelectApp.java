package com.pwskills.kalyan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.utility.DBUtil;

public class SelectAndNonSelectApp {

	// private static final String SQLINSERT_QUERY = "INSERT INTO student
	// values(97,'george',58,'uk')";
	public static void main(String[] args) {

		// Resources used
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int rowCount = 0;

		boolean flag = false;
		try {
			connection = DBUtil.getDBConnection();

			if (connection != null) {
				statement = connection.createStatement();

			}
			Scanner scanner = new Scanner(System.in);
//			System.out.print("Enter the sid :: ");
//			int sid = scanner.nextInt();

			String sqlQuery = null;
			
			if(scanner!=null) {
				System.out.println("Enter the query :: ");
				sqlQuery = scanner.nextLine();
				scanner.close();
			}
			if (statement != null) {
				
				flag = statement.execute(sqlQuery);
				
				
			}
			if (flag) {
				//Display resultSet
				resultSet = statement.getResultSet();
				
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" +resultSet.getString(4) );
				}
			} else {
				rowCount = statement.getUpdateCount();
				if(rowCount == 0) {
					System.out.println("No records got modified");
				}else {
					System.out.println("Records modified");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.cleanUpResources(null, statement, connection);
		}

	}

}
