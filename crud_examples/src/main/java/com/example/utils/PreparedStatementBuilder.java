package com.example.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class PreparedStatementBuilder implements StatementBuilder {
    
    public HashMap<String, PreparedStatement> buildPreparedStatement(Connection conn) throws SQLException {
        HashMap<String, PreparedStatement> pStatements = new HashMap<>();
        String getStudentSql = "SELECT * from ics2609.student where student_no = ?";
        PreparedStatement getStudent = conn.prepareStatement(getStudentSql);
        pStatements.put("getStudent", getStudent);

        return pStatements;
    }
}
