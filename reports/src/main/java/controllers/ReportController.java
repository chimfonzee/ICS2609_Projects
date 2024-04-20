package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/report")
public class ReportController extends HttpServlet {
    private final int ARBITRARY_SIZE = 1024;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletContext().getRealPath("/");

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd");
        String filename = df.format(date) + ".pdf";

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + filename));
            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("This is added content!", font);
            document.add(chunk);

            // Path path = Paths.get(ClassLoader.getSystemResource("java.jpg").toURI());
            Image img = Image.getInstance(String.format("%s/java.png", path));
            document.add(img);

            PdfPTable table = new PdfPTable(3);
            
            for (int i = 0; i < 3; i++) {
                PdfPCell header = new PdfPCell();
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(String.format("Column Header %s", i)));
                table.addCell(header);
            }

            for (int i = 0; i < 3; i++)
                table.addCell(String.format("Sample Row 1 Column %s", i));

            document.add(table);
            document.close();

            PdfReader pdfReader = new PdfReader(path + filename);
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(String.format("%sencrypted_%s", path, filename)));
            pdfStamper.setEncryption("userpass".getBytes(), "password".getBytes(), 0, PdfWriter.ENCRYPTION_AES_256);
            pdfStamper.close();

            resp.setContentType("application/pdf");
            ServletOutputStream out = resp.getOutputStream();
            FileInputStream in = new FileInputStream(String.format("%sencrypted_%s", path, filename));
            
            byte[] buffer = new byte[ARBITRARY_SIZE];
            int numBytesRead;

            while((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
            out.flush();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
