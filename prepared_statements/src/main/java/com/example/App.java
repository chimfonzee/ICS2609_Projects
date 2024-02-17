package com.example; //comment out if default package

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

        username = "Renzo";
        User user = getUser(username);
        System.out.println(user.getName());
        System.out.println(user.getAddress());
    }

    public static boolean login(String username, String password) {
        boolean result = dbManager.dbLogin(username, password);
        // do stuff here
        return result;
    }

    public static User getUser(String username) {
        User user = dbManager.getUser(username);
        // do stuff here
        return user;
    }
}
