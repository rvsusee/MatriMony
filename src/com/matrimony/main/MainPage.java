package com.matrimony.main;

import java.util.Scanner;

public class MainPage {
	static Scanner sc;
	static DataBase db;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println(" \t\tWelcome to MatriMony \t\t");

		while (true) {
			System.out.print("1.Already Have an Account\n2.Create new Account\n3.Exit Enter Option:");
			try {
				switch (sc.nextInt()) {
				case 1:
					signIn();

				case 2:
					signUp();
				case 3:
					System.out.println("-------------------------------------------------------------------");
					System.out.println("Program Ended");
					System.exit(1);
				default:
					throw new Exception();
				}

			} catch (Exception e) {
				System.err.println("Enter Valid Input");
			}

		}
	}

	static void signIn() {

		String email = null;
		String password = null;

		int chances = 0;
		while (true) {
			System.err.println("\t\tLogin Page\t\t");
			System.out.println("Enter Email:");
			email = sc.next();
			System.out.println("Enter Password:");
			password = sc.next();
			if (email.length() > 5 && password.length() > 5) {
				switch (db.signIn(email, password)) {
				case 1:
					System.out.println("Email and Password Wrong");
					chances++;
				case 2:
					System.out.println("Password Wrong");
					chances++;
				case 3:
					System.err.println("Unable to reach DataBase...\n Check Internet Connection! and try later!");
					System.exit(1);
				}
				if (chances == 3) {
					System.out.println("You tried more times! pls try later or create new Account");
					return;
				}
			} else {
				System.out.println("Enter Vaild Email and Password");
			}
		}
	}

	private static void signUp() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Name:");
			String name = sc.nextLine();
			System.out.print("Enter Age:");
			String age = sc.nextLine();
			System.out.print("Enter Gender:");
			String gender = sc.nextLine();
			System.out.print("Enter Father Name:");
			String fName = sc.nextLine();
			System.out.print("Enter Mother Name:");
			String mName = sc.nextLine();
			System.out.print("Enter Home Location:");
			String homeLoc = sc.nextLine();
			System.out.print("Enter Mobile No:");
			String mobNo = sc.nextLine();
			String email;
			String password;
			while (true) {
				System.out.print("Enter Email:");
				email = sc.nextLine();
				System.out.print("Enter Password: ");
				password = sc.nextLine();
				if (email.length() > 5 && password.length() > 5) {
					break;
				} else {
					System.out.print("Enter valid email and Password:");
				}
			}
			System.out.print("Enter Education:");
			String edu = sc.nextLine();
			System.out.print("Enter Job Type:");
			String jobType = sc.nextLine();
			System.out.print("Enter Salary:");
			String salary = sc.nextLine();
			System.out.print("Enter Work Location:");
			String workLoc = sc.nextLine();
			if (DBOperationSSSS.createAccount(
					new Person(name, age, gender, mobNo, email, fName, mName, homeLoc, jobType, salary, workLoc, edu),
					email, password)) {
				System.out.println("-------------Account Created Successfully-------------");
			} else {
				System.out.println("Something went Wrong Please try again");
			}
		} catch (Exception e) {
			System.err.println("Enter Valid Input!!");
			signUp();
		}
	}

}
