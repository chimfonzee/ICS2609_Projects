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
public class ParagraphExample {
    public static void main(String args[]) throws IOException {
        // Document is a wrapper for any document found in iText.
        // If we want to write with a PDF, use a PDFWriter with the target
        //      path as an argument.
        PdfDocument pdf = new PdfDocument(new PdfWriter("./target.pdf"));
        
        // Document constructor has multiple constructor.
        // PageSize is an optional parameter
        // A third parameter requires Boolean if an immediate flush is required
        //      which is for non-laxy writing.
        Document doc = new Document(pdf, PageSize.A4);
        
        // Just like AWT for Java, we add elements in the document in a left-to-
        //      right fashion. There are multiple elements that are in other
        //      examples. For now, we can do a simple paragraph for a report.
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
