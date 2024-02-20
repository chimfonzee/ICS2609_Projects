package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

            String updateUserSql =
                "update ics2609.users " +
                "set ? " +
                "where username = ?";
            PreparedStatement updateUser = conn.prepareStatement(updateUserSql);
            preStmts.put("updateUser", updateUser);

            String updatePasswordSql =
                "update ics2609.users " +
                "set password = ? " +
                "where username = ?";
            PreparedStatement updatePassword = conn.prepareStatement(updatePasswordSql);
            preStmts.put("updatePassword", updatePassword);

            String selectEmptySql =
                "select * " +
                "from ics2609.users " +
                "where username is ? or address is ?";
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

    public boolean createUser(User user, String password) {
        PreparedStatement createUser = preStmts.get("createUser");
        int inserted = 0;

        try {            
            createUser.setString(1, user.getName());
            createUser.setString(2, user.getAddress());
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

    public boolean updateUser(User user, String username) {
        PreparedStatement updateUser = preStmts.get("updateUser");
        String setClause = "";
        int updates = 0;

        try {
            if (user.getName() != null && !user.getName().equals(""))
                setClause = String.format("username = %s", user.getName());
            if (user.getAddress() != null && !user.getAddress().equals(""))
                if (setClause.equals(""))
                    setClause = String.format("address = %s", user.getAddress());
                else
                    setClause = String.format("%s, address = %s", setClause, user.getAddress());
            
            updateUser.setString(1, setClause);
            updateUser.setString(2, username);
            updates = updateUser.executeUpdate();
        } catch (SQLException sqlException) {

        } catch (Exception exception) {

        }
        try {
            updateUser.clearParameters();
        } catch (SQLException sqlException) {

        }

        return updates > 0;
    }

    public boolean updatePassword(String username, String password) {
        PreparedStatement updatePassword = preStmts.get("updatePassword");
        int updates = 0;

        try {
            updatePassword.setString(1, password);
            updatePassword.setString(2, username);
            updates = updatePassword.executeUpdate();
        } catch (SQLException sqlException) {

        } catch (Exception exception) {

        }
        try {
            updatePassword.clearParameters();
        } catch (SQLException sqlException) {

        }

        return updates > 0;
    }

    public ArrayList<User> selectEmtpy() {
        PreparedStatement selectEmpty = preStmts.get("selectEmpty");
        ArrayList<User> emptyUsers = new ArrayList<User>();

        try {
            selectEmpty.setNull(1, java.sql.Types.VARCHAR);
            selectEmpty.setNull(2, java.sql.Types.VARCHAR);
            ResultSet rs = selectEmpty.executeQuery();

            while (rs.next()) {
                User emptyUser = new User(rs.getString("username"), rs.getString("address"));
                emptyUsers.add(emptyUser);
            }
        } catch (SQLException sqlException) {

        } catch (Exception exception) {

        }
        try {
            selectEmpty.clearParameters();
        } catch (SQLException sqlException) {

        }
        
        return emptyUsers;
    }


}
