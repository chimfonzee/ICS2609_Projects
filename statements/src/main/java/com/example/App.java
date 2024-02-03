package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static String mySQLHost = "192.168.144.1"; //localhost
    public static String mySQLPort = "3306";
    public static Connection conn = null;

    public static Connection connect(String username, String password) {
        if (conn == null) {
            try {
                String url = String.format("jdbc:mysql://%s:%s", mySQLHost, mySQLPort);
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Completed connection.");
            } catch (SQLException sqlException) {
                System.err.println(sqlException.getMessage());
            } catch (Exception e) {
                System.err.println(String.format("Fatal Error: %s", e.getMessage()));
            }
        }
        return conn;
    }

    public static boolean close() {
        if (conn == null) return true;

        try {
            conn.close();
            System.out.println("Connection closed.");
            return true;
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        } catch (Exception e) {
            System.err.println(String.format("Fatal Error: %s", e.getMessage()));
        }
        return false;
    }

    public static void main(String[] args) {
        Connection conn = connect("admin", new Secret().getPassword());

        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        String sql = String.format(
            "select * from ics2609.example\n" +
            "where id = %s;", id
        );

        // String condition = sc.nextLine();
        // sql = String.format(
        //     "select * from ics2609.example " +
        //     "where %s", condition
        // );
        System.out.println(sql);

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String name = rs.getString("name");
                String university = rs.getString("university");

                System.out.println(String.format("name: %s | university: %s", name, university));
            }

            while (rs.next() || rs.first()) {
                String name = rs.getString("name");
                System.out.println(String.format("name: %s", name));
            }

            rs = stmt.getResultSet();

            while (rs.next() || rs.first()) {
                String name = rs.getString("name");
                System.out.println(String.format("name: %s", name));
            }

            stmt.close();
            rs = stmt.getResultSet();

            System.out.println(rs);

            close();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        } finally {
            sc.close();
        }
    }
}
