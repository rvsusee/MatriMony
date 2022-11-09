package com.matrimony.main;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    static HashMap<String,String> users = new HashMap<>();
    static ArrayList<Person> persons = new ArrayList<>();

    Database(){
        persons.add(new Person("AAA","20","Male","9654238743","111111","Fat","Mom","chennai","iT","20000","chennai","BE"));
        persons.add(new Person("BBB","20","Female","9874667428","def@gmail.com","Fat","Mom","chennai","iT","20000","chennai","BE"));
        persons.add(new Person("CCC","20","Female","9087667545","ghi@gmail.com","Fat","Mom","chennai","iT","20000","chennai","BE"));
        persons.add(new Person("DDD","20","Male","7435632464","jkl@gmail.com","Fat","Mom","chennai","iT","20000","chennai","BE"));
        persons.add(new Person("EEE","20","Female","9634453634","mno@gmail.com","Fat","Mom","chennai","iT","20000","chennai","BE"));

        users.put("abc@gmail.com","111111");
        users.put("def@gmail.com","09876");
        users.put("ghi@gmail.com","54688");
        users.put("jkl@gmail.com","3468348");
        users.put("mno@gmail.com","mno123");
    }


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
            System.out.println("Email: "+email+" Password: "+password);
            users.put(email, password);
            return true;
        }
        return false;
    }


}


