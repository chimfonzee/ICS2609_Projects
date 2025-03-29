/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itextpdfexample;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

/**
 *
 * @author fonze
 */
public class FontsExample {
    public static void main(String args[]) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter("./font_target.pdf"));
        Document doc = new Document(pdf);
        
        PdfFont fontTimes = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
        
        Text title = new Text("Example Title with Bold Face").setFont(fontBold);
        Text text = new Text("Now this is a text a set font").setFont(fontTimes);
        
        Paragraph p = new Paragraph().add(title).add("\n").add(text);
        doc.add(p);
        doc.close();
    }
}
