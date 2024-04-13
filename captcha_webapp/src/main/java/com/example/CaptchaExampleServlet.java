package com.example;

import java.io.IOExceptdion;

import com.captcha.botdetect.web.servlet.Captcha;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/example")
public class CaptchaExampleServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Captcha captcha = Captcha.load(req, "captchaCode")
        if(captcha.validate(req.getParameter("captchaCode"))) {
            
        }
    }
}
