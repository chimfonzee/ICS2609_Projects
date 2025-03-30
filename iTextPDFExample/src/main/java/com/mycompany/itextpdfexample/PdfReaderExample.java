/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itextpdfexample;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author fonze
 */
public class PdfReaderExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        PdfReader reader = new PdfReader(new FileInputStream("./font_target.pdf"));
        
        // PDFDocument can be instantiated with a reader
        // Another PDFDcoument instantiation includes both reader and writer if
        //      you require both reader and writer functionalities.
        PdfDocument pdf = new PdfDocument(reader);
        
        // PDFReader is only limited to some details like the file length
        // Most important is the information regarding getting the page
        // As you recall, iText is structured like AWT. Getting the page, lets
        //      you get certain elements which has more code later.
        System.out.println("PDF Version: " + pdf.getPdfVersion());
        System.out.println("Number of Pages: " + pdf.getNumberOfPages());
        System.out.println("File length: " + reader.getFileLength());
        System.out.println("Is it encrypted: " + reader.isEncrypted());
        System.out.println("Width of Page 1: " + pdf.getPage(1).getPageSize().getWidth());
        System.out.println("Height of Page 1: " + pdf.getPage(1).getPageSize().getHeight());
        System.out.println("Rotation of Page 1: " + pdf.getPage(1).getRotation());
    }
}
