/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itextpdfexample;

import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.ReaderProperties;
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
        ReaderProperties prop = reader.getPropertiesCopy();
    }
}
