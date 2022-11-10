package com.matrimony.main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {

	private final String USERNAME = "sa1";
	private final String PASSWORD = "P@ssw0rd";
	private final String URL = "jdbc:sqlserver://192.168.168.12:1433;databaseName=";
	private final String DATABASE_NAME = "New_joinee_2022";

	private Connection conn;
	private Statement stmt;
	private PreparedStatement statement;
	private String Query;

	DataBase() {
		try {
			conn = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
			stmt = conn.createStatement();

		} catch (SQLException e) {
			System.out.println("Unable to Connect Database!");
			System.out.println(e);
			e.printStackTrace();
			System.exit(0);
		}
	}

	void uploadData(User user, UserDetails details) {
		String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, "bill");
			statement.setString(2, "secretpass");
			statement.setString(3, "Bill Gates");
			statement.setString(4, "bill.gates@microsoft.com");

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
		} catch (SQLException e) {
			System.out.println("");
			e.printStackTrace();
		}
	}

	void updateData() {

	}

}
