package com.example.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public interface StatementBuilder {

    public abstract HashMap<String, PreparedStatement> buildPreparedStatement(Connection conn) throws SQLException;
}
