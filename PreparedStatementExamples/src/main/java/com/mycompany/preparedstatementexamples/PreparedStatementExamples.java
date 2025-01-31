/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.preparedstatementexamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Hashtable;

/**
 *
 * @author fonze
 */
public class PreparedStatementExamples {

    private class User {
        String username;
        String password;
        String accessRole;

        public User(String username, String password, String accessRole) {
            this.username = username;
            this.password = password;
            this.accessRole = accessRole;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAccessRole() {
            return accessRole;
        }

        public void setAccessRole(String accessRole) {
            this.accessRole = accessRole;
        }
    }

    private Connection conn;
    private Hashtable<String, PreparedStatement> pStatements;

    public PreparedStatementExamples(String username, String password, String database) {
        String connStr = "jdbc:sqlite:resources:" + database;
        try {
            conn = DriverManager.getConnection(connStr);
            pStatements = new Hashtable<>();
            String getAllStr = "select * from accounts";
            String getUserStr = "select * from accounts a where a.username=?" +
                    "AND a.password=?";
            
            pStatements.put("getAll", conn.prepareStatement(getAllStr));
            pStatements.put("getUser", conn.prepareStatement(getUserStr));
        } catch (SQLException e) {
            System.err.println("Failed to create connection");
            System.err.println(e.toString());
        }
    }

    public ResultSet getAll() throws SQLException {
        return pStatements.get("getAll").executeQuery();
    }

    public User getUser(String username, String password) throws SQLException {
        PreparedStatement getUser = pStatements.get("getUser");
        getUser.setString(1, username);
        getUser.setString(2, password);
        ResultSet rs = getUser.executeQuery();
        if(rs.next())
            return new User(rs.getString("username"), rs.getString("password"),
                rs.getString("access_role"));
        else return null;
    }

    public static void main(String[] args) {
        PreparedStatementExamples jdbc = new PreparedStatementExamples("root", "root", "database.db");
        try {
            ResultSet rs = jdbc.getAll();
            while(rs.next()) {
                System.out.println(rs.getString("username") + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
}
