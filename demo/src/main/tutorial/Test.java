package main.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static String mySQLHost = "localhost";
    public static String mySQLPort = "3306";

    public static Connection connect(String username, String password) {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://" + mySQLHost + ":" + mySQLPort;
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Currently Connecting...");
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        } catch (Exception e) {
            System.err.println("Fatal Error");
        }

        return conn;
    }

    public static void close(Connection conn) {
        try {
            conn.close();
            System.out.println("Connection Closed");
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        } catch (Exception e) {
            System.err.println("Closing Failed");
        }
    }

    public static void main(String[] args) {
        Connection conn = connect("<created user>", "<created password>");
        
        String sql0 = "create database sample";
        String sql0_1 = "use sample";
        String sql1 = "drop table if exists student";
        String sql2 =
        "create table student (" +
            "student_id varchar(15) primary key," +
            "student_fname varchar(30)," +
            "student_lname varchar(30)" +
        ")";

        try {
            Statement stmt0 = conn.createStatement();
            Statement stmt0_1 = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();

            stmt0.execute(sql0); //first ResultSet here
            stmt0_1.execute(sql0_1); //first ResultSet here
            stmt1.execute(sql1); //first ResultSet here
            stmt2.execute(sql2); //second ResultSet here
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
            // conn.rollback();
        }

        close(conn);
    }
}