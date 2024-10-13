package com.mycompany.mavenproject1;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import javax.swing.JFileChooser;


public class FacturaPDF {

    public static void generarPDF(Factura factura) {
    Document document = new Document();
    try {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Guardar Factura como PDF");
    fileChooser.setSelectedFile(new File("factura.pdf")); 

    int userSelection = fileChooser.showSaveDialog(null);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        
        PdfWriter.getInstance(document, new FileOutputStream(fileToSave));
        document.open();
        
        document.add(new Paragraph(" FACTURA "));
        document.add(new Paragraph(" ")); 
       
        document.add(new Paragraph("Fecha: " + factura.getFecha()));
        document.add(new Paragraph("Cliente ID: " + factura.getCliente().getId())); 
        document.add(new Paragraph("Método de Pago: " + factura.getMetodoDePago())); 
        document.add(new Paragraph("Financiación: " + factura.getFinanciacion()));
        document.add(new Paragraph("Cuotas: " + factura.getCuotas())); 
        document.add(new Paragraph(" ")); 
        document.add(new Paragraph("Detalles del Vehículo"));
        document.add(new Paragraph("Placa: " + factura.getVehiculo().getPlaca())); 
        document.add(new Paragraph("Precio: $" + factura.getVehiculo().getPrecio()));      
        document.add(new Paragraph(" ")); 

        document.close();
        System.out.println("PDF generado exitosamente en: " + fileToSave.getAbsolutePath());
    }

    } catch (FileNotFoundException | DocumentException e) {
    e.printStackTrace();
    }   
    }
}
