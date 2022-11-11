package com.matrimony.main;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase {

	private final String USERNAME = "sa1";
	private final String PASSWORD = "P@ssw0rd";
	private final String URL = "jdbc:sqlserver://192.168.168.12:1433;databaseName=";
	private final String DATABASE_NAME = "New_joinee_2022";

	private Connection conn;
	private Statement stmt;
	private PreparedStatement prepstmt;
	private String query;
	private ResultSet resultSet;

	DataBase() {
		try {
			conn = DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
			stmt = conn.createStatement();

		} catch (SQLException e) {
			System.err.println("Unable to reach DataBase...\n Check Internet Connection! and try later!");
			System.exit(1);
			System.out.println(e);
			e.printStackTrace();
			System.exit(0);
		}
	}

	void addNewUser(User user, UserDetails details) {
		query = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

		try {
			prepstmt = conn.prepareStatement(query);
			prepstmt.setString(1, "bill");
			prepstmt.setString(2, "secretpass");
			prepstmt.setString(3, "Bill Gates");
			prepstmt.setString(4, "bill.gates@microsoft.com");

			int rowsInserted = prepstmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
		} catch (SQLException e) {
			System.out.println("");
			e.printStackTrace();
		}
	}

	int signIn(String username, String password) {
		query = "SELECT * FROM SUSEENDHIRAN_USERS WHERE username = ? and password = ?;";
		try {
			prepstmt = conn.prepareStatement(query);
			prepstmt.setString(1, username);
			prepstmt.setString(1, password);

			System.out.println(query);
			resultSet = prepstmt.executeQuery();
			if (resultSet.next()) {
				User user = new User(111,"dasf","fdsfs");
				
				if (user.getUsername().equals(username)) {
					if (user.getPassword().equals(password)) {
//						new HomePage(resultSet.getString(0));
						new HomePage(user.getUserID(),user.getUsername());
					}else {
						return 2;
					}
				}else {
					return 1;
				}
			}else {
				throw new Exception();
			}
			return 3;
		} catch (Exception e) {
			System.out.println("Database Error");
			return 3;
		}
	}

	List<UserDetails> getPersonDetails() {
		List<UserDetails> persons = new ArrayList<>();

		return null;
	}

	UserDetails getPersonDetails(int id) {
// 		get single user details
		return null;
	}

	void updateData() {
//		add in future
	}
}
