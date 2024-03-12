package com.pwskills.kalyan;

//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Properties;

import com.pwskills.utility.DBUtil;

public class MainApp {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// FileInputStream fis = null;

		try {

			// 1 Establishing the connection
			connection = DBUtil.getDBConnection();
			System.out.println("Connection established ");

			// 2 creating the statement object

			statement = connection.createStatement();
			System.out.println("Statement object created");

			// 3 send and execute query
			String selectQuery = "select * from student";
			resultSet = statement.executeQuery(selectQuery);

			System.out.println("Collected the result in the resultset\n");

			// 4 processing the result
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			System.out.println("**************************************");
			while (resultSet.next()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
