package com.example; //comment out if default package

import java.sql.SQLException;

public class App {
    public static DBManager dbManager = new DBManager("admin", new Secret().getPassword());

    public static void main(String[] args) {
        String username = "Alfonzo";
        String password = "example123";

        if (login(username, password)) {
            System.out.println("Login successful with:" + username + " " + password);
        } else {
            System.out.println("Username does not exist");
        }
    }

    public static boolean login(String username, String password) {
        try {
            boolean result = dbManager.dbLogin(username, password);
            // do stuff here
            return result;
        } catch (SQLException sqlException) {

        }
        return false;
    }
}
