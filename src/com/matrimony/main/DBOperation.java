package com.matrimony.main;

import java.util.ArrayList;
import java.util.HashMap;

public class DBOperation {
    static HashMap<String,String> users = new HashMap<>();
    static ArrayList<Person> persons = new ArrayList<>();

    static void loginCheck(String email,String password){
        if (users.containsKey(email)){
            if (users.get(email).equals(password)){
                System.out.println("Login Success!!!");
                System.out.println("------------------------Home Page------------------------");
                Home home = new Home(email);
                home.options();
                new Main().mainOptions();
            }else{
                System.out.println("Hello "+getName(email)+"! Your Password is Wrong!");
                System.out.println("Please try again to Login!");
            }
        }else {
            System.out.println("Email wrong or Not Exists!");
        }
    }
    private static String getName(String email){
        for (int i = 0; i < persons.size();i++){
            if (persons.get(i).getEmail().equals(email)){
                return persons.get(i).getName();
            }
        }
        return "";
    }

    Person getPerson(String email){
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getEmail().equals(email)){
                return persons.get(i);
            }
        }
        return null;
    }
    static boolean createAccount(Person person,String email,String password) {
        if (persons.add(person)){
            users.put(email, password);
            return true;
        }
        return false;
    }


}


