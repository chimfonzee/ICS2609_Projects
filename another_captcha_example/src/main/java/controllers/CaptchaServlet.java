package controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.logicsquad.nanocaptcha.image.ImageCaptcha;
import java.awt.image.BufferedImage;

@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        ServletOutputStream out = resp.getOutputStream();

        ImageCaptcha imageCaptcha = ImageCaptcha.create();
        req.getSession().setAttribute("captcha", imageCaptcha);

        BufferedImage image = imageCaptcha.getImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        baos.flush();
        byte[] imageBytes = baos.toByteArray();
        baos.close();

        out.write(imageBytes);
        out.close();
    }
}
