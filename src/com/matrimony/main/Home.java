package com.matrimony.main;

import java.util.Scanner;

public class Home {
    Person user;
    DBOperationSSSS db = new DBOperationSSSS();
    Home(String email){
        user = db.getPerson(email);
    }

    void options(){
        display();
        while (true){
            System.out.println("1. View Persons Detail ");
            System.out.println("2. Your Account Details ");
            System.out.println("3. Logout");
            System.out.print("Enter Your Option: ");
            int option = new Scanner(System.in).nextInt();
            if (option == 1){
                display();
                while (true){
                    System.out.print("Enter Roll No: ");
                    int rno = new Scanner(System.in).nextInt();
                    if (rno < db.persons.size()) {
                        displayFullDetail(db.persons.get(rno));
                        break;
                    }else{
                        System.out.println("Reg no not Found");
                    }
                }
            }else if (option == 2){
                displayFullDetail(user);
            }else if (option == 3){
                System.out.println("------------------------Logout Successfully------------------------");
                break;
            }else{
                System.out.println("Enter Valid Option: ");
            }
        }
    }



    public void display() {
        DBOperationSSSS db = new DBOperationSSSS();
        System.out.println("Rno\tName\tAge\t\tLocation\tJob\t\tSalary\t\tEducation");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < db.persons.size(); i++) {
            Person person = db.persons.get(i);
            if (!person.getGender().equals(user.getGender())){
                if (!person.getEmail().equals(user.getEmail())){
                    System.out.print(i+"\t");
                    displayPerson(person);
                }
            }
        }
        System.out.println("--------------------------------------------------------");
    }
    private void displayPerson(Person person) {
        System.out.print(person.getName()+"\t\t"+person.getAge()+"\t\t"+person.getHomeLocation()+"\t\t"+person.getJobType()+"\t\t"+person.getSalary()+"\t\t"+person.getEducation());
        System.out.println();
    }
    void displayFullDetail(Person person){
        System.out.println("--------------------------------------------------------");
        System.out.println("Name\t\t\t:"+person.getName());
        System.out.println("Age\t\t\t\t:"+person.getAge());
        System.out.println("Gender\t\t\t:"+person.getGender());
        System.out.println("Education\t\t:"+person.getEducation());
        System.out.println("Father Name\t\t:"+person.getEmail());
        System.out.println("Mother Name\t\t:"+person.getEmail());
        System.out.println("Mobile No\t\t:"+person.getMobileNo());
        System.out.println("Email\t\t\t:"+person.getEmail());
        System.out.println("Job Type\t\t:"+person.getJobType());
        System.out.println("Salary\t\t\t:"+person.getSalary());
        System.out.println("Work Location\t:"+person.getWorkLocation());
        System.out.println("--------------------------------------------------------");
    }



}
