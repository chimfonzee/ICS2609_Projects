package com.example;

import java.sql.SQLException;

import com.example.utils.DatabaseManager;
import com.example.utils.PreparedStatementBuilder;

public class App {
    public static void main(String[] args) {
        try {
            DatabaseManager dbManager = new DatabaseManager(null, null, null, new PreparedStatementBuilder());
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
}
