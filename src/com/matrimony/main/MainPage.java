package com.matrimony.main;

import java.util.Scanner;

public class MainPage {
	static Scanner sc;
	static DataBase db;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println(" \t\tWelcome to MatriMony \t\t");

		while (true) {
			System.out.print("1.Already Have an Account\n2.Create new Account\n Enter Option:");
			try {
				switch (sc.nextInt()) {
				case 1:
					signIn();

				case 2:
				case 3:
				default:
					throw new Exception();
				}

			} catch (Exception e) {
				System.err.println("Enter Valid Input");
			}

		}
	}

	static void signIn() {

		String email = "";
		String password= "";
		
		while(true) {
			System.err.println("\t\tLogin Page\t\t");
			System.out.println("Enter Email:");
			email = sc.next();
			System.out.println("Enter Password:");
			password= sc.next();
			switch(db.signIn(email, password)) {
			case 1:
				System.out.println("Email and ");
			case 2:
			case 3:
			}
		}
	}
}
