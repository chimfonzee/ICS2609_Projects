package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.logicsquad.nanocaptcha.image.ImageCaptcha;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String captchaCode = req.getParameter("captchaCode");
        
        ImageCaptcha imageCaptcha = (ImageCaptcha) req.getSession().getAttribute("captcha");
        out.write("<html>");
        out.write(String.format("%s", imageCaptcha.isCorrect(captchaCode)));
        out.write("</html>");
    }
}
