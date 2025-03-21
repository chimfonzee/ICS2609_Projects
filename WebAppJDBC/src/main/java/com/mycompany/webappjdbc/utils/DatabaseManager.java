/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webappjdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import java.util.HashMap;

/**
 *
 * @author fonze
 */
public class DatabaseManager {
    private Connection conn;
    private HashMap<String, PreparedStatement> pStatements;
    
    public DatabaseManager(ServletContext context) throws SQLException, ClassNotFoundException {
        pStatements = new HashMap<>();
        
        Class.forName("org.mariadb.jdbc.Driver");
        String url = (String)context.getInitParameter("url");
        conn = DriverManager.getConnection(url, "root", "root");
        HashMap<String, String> sqlStmts =  DatabaseConstants.STATEMENTS;
        
        for (String key : sqlStmts.keySet()) {
            System.out.println(key);
            PreparedStatement pStatement = conn.prepareStatement(sqlStmts.get(key));
            pStatements.put(key, pStatement);
        }
    }
    
    public String getUser(String uName) throws SQLException {
        String user = "";
        PreparedStatement pStatement = pStatements.get("getUser");
        pStatement.setString(1, uName);
        ResultSet rs = pStatement.executeQuery();
        
        if (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String role = rs.getString("role");
            user = "%1s %2s %3s";
            
            user = String.format(user, username, password, role);
        }
        
        return user;
    }
}
