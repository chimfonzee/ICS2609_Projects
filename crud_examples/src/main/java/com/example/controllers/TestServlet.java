package com.example.controllers;

import java.io.IOException;

import com.example.utils.DatabaseManager;
import com.example.utils.PreparedStatementBuilder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        DatabaseManager dbManager = new DatabaseManager("username", "password", "mysql", new PreparedStatementBuilder());
        dbManager.getStudent(0);
    }
}
