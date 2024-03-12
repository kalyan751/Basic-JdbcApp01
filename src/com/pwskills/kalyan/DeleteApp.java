package com.pwskills.kalyan;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.pwskills.utility.DBUtil;

public class DeleteApp {

	// private static final String SQLINSERT_QUERY = "INSERT INTO student
	// values(97,'george',58,'uk')";
	public static void main(String[] args) {

		// Resources used
		Connection connection = null;
		Statement statement = null;
		int rowCount = 0;

		try {
			connection = DBUtil.getDBConnection();

			if (connection != null) {
				statement = connection.createStatement();

			}
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the sid :: ");
			int sid = scanner.nextInt();

			String SqlDeleteQuery = "DELETE FROM student where sid = " + sid + "";
			System.out.println(SqlDeleteQuery);

			scanner.close();
			if (statement != null) {
				rowCount = statement.executeUpdate(SqlDeleteQuery);
			}
			if (rowCount == 0) {
				System.out.println("Failure in updation...");
			} else {
				System.out.println("Record is updated successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.cleanUpResources(null, statement, connection);
		}

	}

}
