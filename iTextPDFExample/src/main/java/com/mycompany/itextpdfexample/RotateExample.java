/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itextpdfexample;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.IOException;

/**
 *
 * @author fonze
 */
public class RotateExample {
    public static void main(String args[]) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter("./rotateTarget.pdf"));
        
        // Document PageSize can be rotated around for a landscape orientation.
        // You can try different page sizes for different cases.
        //      PageSize is a static class with multiple static members.
        //      A4 is one of those static members.
        Document doc = new Document(pdf, PageSize.A4.rotate());
        
        String[] paragraphs = {"\tThis is an example paragraph.\n" +
                "This is how it looks like.",
            "\tAnother paragraph right here!"};
        
        for (String paragraph : paragraphs) {
            Paragraph par = new Paragraph();
            par.add(paragraph);
            doc.add(par);
        }
        doc.close();
    }
}
