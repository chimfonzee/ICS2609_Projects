/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itextpdfexample;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.ITextExtractionStrategy;
import com.itextpdf.kernel.pdf.canvas.parser.listener.SimpleTextExtractionStrategy;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author fonze
 */
public class SimpleTextExtractionExample {
    public static void main(String args[]) throws IOException {
        StringBuilder builder = new StringBuilder();
        PdfReader reader = new PdfReader("./target.pdf");
        PdfDocument doc = new PdfDocument(reader);
        
        for (int p = 1; p <= doc.getNumberOfPages(); p++) {
            ITextExtractionStrategy strat = new SimpleTextExtractionStrategy();
            String current = PdfTextExtractor.getTextFromPage(doc.getPage(p), strat);
            builder.append(current);
//            current = StandardCharsets.UTF_8.decode(StandardCharsets.US_ASCII.encode(current));
        }
        doc.close();
        System.out.println(builder.toString());
    }
}
