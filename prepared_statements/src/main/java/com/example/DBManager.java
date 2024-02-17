package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class DBManager {
    private String mySQLHost = "192.168.144.1"; //localhost
    private String mySQLPort = "3306";
    private Connection conn = null;
    private HashMap<String, PreparedStatement> preStmts = new HashMap<String, PreparedStatement>();

    public DBManager(String username, String password) {
        try {
            String url = String.format("jdbc:mysql://%s:%s", mySQLHost, mySQLPort);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Completed connection.");
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        } catch (Exception e) {
            System.err.println(String.format("Fatal Error: %s", e.getMessage()));
        }

        try {
            String loginSql =
                "select count(username) " +
                "from ics2609.users " +
                "where username = ? and password = ?";
            PreparedStatement login = conn.prepareStatement(loginSql);
            preStmts.put("login", login);

            String createUserSql = 
                "insert into ics2609.users " +
                "values(?, ?, ?)";
            PreparedStatement createUser = conn.prepareStatement(createUserSql);
            preStmts.put("createUser", createUser);

            String getUserSql =
                "select * " +
                "from ics2609.users " +
                "where username = ?";
            PreparedStatement getUser = conn.prepareStatement(getUserSql);
            preStmts.put("getUser", getUser);

            String deleteUserSql =
                "delete from ics2609.users " +
                "where username = ?";
            PreparedStatement deleteUser = conn.prepareStatement(deleteUserSql);
            preStmts.put("deleteUser", deleteUser);
        } catch (SQLException sqlException) {
            // do exception handling here
        } catch (Exception e) {
            // do exception handling here
        }
    }

    public boolean close() {
        if (conn == null) return true;
        try {
            conn.close();
            conn = null;
            System.out.println("Connection closed.");
            return true;
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        } catch (Exception e) {
            System.err.println(String.format("Fatal Error: %s", e.getMessage()));
        }
        return false;
    }

    public boolean dbLogin(String username, String password) {
        PreparedStatement login = preStmts.get("login");
        int count = 0;

        try {
            login.setString(1, username);
            login.setString(2, password);
            ResultSet rs = login.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            System.out.println("Test here");
        } catch (Exception e) {
            System.out.println("Test here");
        }
        try {
            login.clearParameters();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return count == 1;
    }

    public boolean createUser(String username, String address, String password) {
        PreparedStatement createUser = preStmts.get("createUser");
        int inserted = 0;

        try {            
            createUser.setString(1, username);
            createUser.setString(2, address);
            createUser.setString(3, password);

            inserted = createUser.executeUpdate();
        } catch (SQLException sqlException) {
            // do exception handling here
        } catch (Exception e) {
            // do exception handling here
        }
        try {
            createUser.clearParameters();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return inserted > 0;
    }

    public User getUser(String username) {
        PreparedStatement getUser = preStmts.get("getUser");
        User retrievedUser = null;

        try {
            getUser.setString(1, username);
            ResultSet rs = getUser.executeQuery();
            if (rs.next()) {
                retrievedUser = new User(rs.getString("username"), rs.getString("address"));
            }
        } catch (SQLException sqlException) {
            // do exception handling here
        } catch (Exception e) {
            // do exception handling here
        }
        try {
            getUser.clearParameters();
        } catch (SQLException sqlException) {
            // do exception handling here
        }

        return retrievedUser;
    }

    public boolean deleteUser(String username) {
        PreparedStatement deleteUser = preStmts.get("deleteUser");
        boolean isDeleted = false;

        try {
            deleteUser.setString(1, username);
            int removed = deleteUser.executeUpdate();
            isDeleted = removed == 1;
        } catch (SQLException sqlException) {
            // do handling here
        } catch (Exception exception) {
            // do handling here
        }
        
        try {
            deleteUser.clearParameters();
        } catch (SQLException sqlException) {
            // do handling here
        }

        return isDeleted;
    }
}
