/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itextpdfexample;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfButtonFormField;
import com.itextpdf.forms.fields.PdfFormCreator;
import com.itextpdf.forms.fields.PdfTextFormField;
import com.itextpdf.forms.fields.PushButtonFormFieldBuilder;
import com.itextpdf.forms.fields.TextFormFieldBuilder;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.renderer.DrawContext;
import com.itextpdf.layout.renderer.IRenderer;
import com.itextpdf.layout.renderer.TextRenderer;

import java.io.IOException;

/**
 *
 * @author fonze
 */
public class FormExample {
    public static void main(String args[]) throws IOException {
        new FormExample().manipulatePdf("./form_edit.pdf");
    }
    
    protected void manipulatePdf(String dest) throws IOException {
        PdfWriter writer = new PdfWriter("./form_edit.pdf");

        PdfDocument pdf = new PdfDocument(writer);
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
        
        Rectangle rect = new Rectangle(36, 780, 108, 26);
        PdfButtonFormField pushButton = new PushButtonFormFieldBuilder(pdf, "button")
                .setWidgetRectangle(rect).setCaption("Hello!").createPushButton();
        pushButton.setFontSize(12f);
        form.addField(pushButton);
        
        Paragraph p = new Paragraph();
        p.add("My Name is ");
        
        Text name = new Text(" ");
        name.setNextRenderer(new FieldTextRenderer(name, "name"));
        pdf.close();
    }
    
    private class FieldTextRenderer extends TextRenderer {
        protected String fieldName;
        
        public FieldTextRenderer(Text textElement, String fieldName) {
            super(textElement);
            this.fieldName = fieldName;
        }
        
        @Override
        public IRenderer getNextRenderer() {
            return new FieldTextRenderer((Text) modelElement, fieldName);
        }
        
        @Override
        public void draw(DrawContext drawContext) {
            PdfTextFormField field = new TextFormFieldBuilder(drawContext.getDocument(), fieldName)
                    .setWidgetRectangle(getOccupiedAreaBBox()).createText();
            PdfFormCreator.getAcroForm(drawContext.getDocument(), true)
                    .addField(field);
        }
    }
}
