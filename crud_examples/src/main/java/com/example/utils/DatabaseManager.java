package com.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.models.Student;

public class DatabaseManager {
    private String mySQLHost = "192.168.144.1"; //localhost
    private String mySQLPort = "3306";
    private Connection conn = null;
    private HashMap<String, PreparedStatement> pStatements;

    public DatabaseManager(String username, String password, String vendor, StatementBuilder builder) throws SQLException {
        String url = String.format("jdbc:%s://%s:%s", vendor, mySQLHost, mySQLPort);
        conn = DriverManager.getConnection(url, username, password);

        this.pStatements = builder.buildPreparedStatement(conn);
    }

    public Student getStudent(long studentNo) throws SQLException {
        Student student = null;
        PreparedStatement getStudent = pStatements.get("getStudent");
        getStudent.setLong(1, studentNo);
        ResultSet rs = getStudent.executeQuery();
        if(rs.next()) {
            student = new Student(rs.getLong("student_no"), rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"), rs.getInt("year_enrolled"), rs.getString("degree"));
        }
        return student;
    }

    public Student getStudents(String className) throws SQLException {
        ArrayList<Student> students = new ArrayList();
        PreparedStatement getStudents;

        if (className != null && className.equals("")) {
            getStudents = pStatements.get("getStudentsWithoutClass");
        } else {
            getStudents = pStatements.get("getStudents");
        }
        Student student = null;
        PreparedStatement getStudent = pStatements.get("getStudent");
        ResultSet rs = getStudent.executeQuery();
        if(rs.next()) {
            student = new Student(rs.getLong("student_no"), rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"), rs.getInt("year_enrolled"), rs.getString("degree"));
        }
        return student;
    }
}
