package com.matrimony.main;

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        while(main.mainOptions());
        System.out.println("----------------------------------------------------------");
    }
    boolean mainOptions() {

        while(true) {
            System.out.println("------------------------Login Page------------------------");
            System.out.println("1.Already Have an Account  \n2.Create New Account \n3.Exit");
            System.out.print("Enter Your Option:");
            int option = sc.nextInt();
            System.out.println("--------------------------------------------------------");
            if (option == 1){
                signIn();
            }else if (option == 2){
                signUp();
            }else if (option == 3){
                return false;
            }else{
                System.out.println("Please Choose Valid Option: ");
            }
        }
    }

    private void signUp() {
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
            if (email.length()>5&& password.length()>5){
                break;
            }else{
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

        if (DBOperationSSSS.createAccount(new Person(name,age,gender,mobNo,email,fName,mName,homeLoc,jobType,salary,workLoc,edu),email,password)){
            System.out.println("-------------Account Created Successfully-------------");
        }else{
            System.out.println("Something went Wrong Please try again");
        }

    }

    private void signIn() {
        while (true) {
            System.out.print("Email :");
            String username = sc.next();
            System.out.print("Password:");
            String password = sc.next();
            DBOperationSSSS.loginCheck(username,password);
        }
    }
}