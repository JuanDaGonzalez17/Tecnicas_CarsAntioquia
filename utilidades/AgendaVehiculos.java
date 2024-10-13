
package com.miguelav.utilidades;

import java.util.ArrayList;
import java.util.List;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.*;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duvan Ruiz
 */
public class AgendaVehiculos implements ReporteI<Vehiculo>{
    List<Vehiculo> listaVehiculos = new ArrayList<>();
    List<Vehiculo> listaRecuperadaV = new ArrayList<>();
    
    @Override
    public void adicionarObjeto(Vehiculo objA){
        listaVehiculos.add(objA); 
        try {
            guardarFichero();
        } catch (IOException ex) {
            Logger.getLogger(AgendaVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int obtenerIndice(String Placa){
        for(Vehiculo automovil : listaRecuperadaV) {
            if(automovil.getPlaca().equals(Placa)){
                return listaRecuperadaV.indexOf(automovil);
            }
        }
        return -1;
    }
    
    @Override
    public String listarObjetos(){
        String lista ="";
        if(!listaRecuperadaV.isEmpty()){
            for(Vehiculo automovil : listaRecuperadaV) {
                lista = lista + automovil.getReferencia()+ "\t" + automovil.getMarca() + "\t" + automovil.getColor() +  
                    "\t" + automovil.getModelo() + "\t" + automovil.getPrecio() + "\t" + automovil.getKilometraje() + "\t\t" + automovil.getPlaca() + "\n";
            }
        }
        return lista;
    }
    
    @Override
    public Vehiculo buscarPorID(int indice){
        Vehiculo encontrado = listaRecuperadaV.get(indice);
        return encontrado;
    }
    
    @Override
    public void actualizarObjeto(Vehiculo obj){ // Cambiar aqui tambien
        for (Vehiculo vehiculo : listaRecuperadaV){
            if(obj.getPlaca().equals(vehiculo.getPlaca())){
                vehiculo.setReferencia(obj.getReferencia());
                vehiculo.setMarca(obj.getMarca());
                vehiculo.setColor(obj.getColor());
                vehiculo.setPlaca(obj.getPlaca());
                vehiculo.setModelo(obj.getModelo());
                vehiculo.setPrecio(obj.getPrecio());
                vehiculo.setKilometraje(obj.getKilometraje());
            }
            try {
                actualizarFichero(listaRecuperadaV);
            } catch (IOException ex) {
                Logger.getLogger(AgendaVehiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void eliminarObjeto(int indice){
        listaRecuperadaV.remove(indice);
        try {
            actualizarFichero(listaRecuperadaV);
        } catch (IOException ex) {
            Logger.getLogger(AgendaVehiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int numClientes(){
        int numVehiculos = listaRecuperadaV.size();
        return numVehiculos;
    }
    
    @Override
    public  void guardarFichero() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("infoVehiculos.csv"))) {
            for (Vehiculo obj : listaVehiculos) {
                StringJoiner joiner = new StringJoiner(",");
                joiner.add(obj.getReferencia())
                      .add(obj.getMarca())
                      .add(obj.getColor())
                      .add(obj.getPlaca())
                      .add(obj.getModelo())
                      .add(String.valueOf(obj.getPrecio()))
                      .add(String.valueOf(obj.getKilometraje()));
                bw.write(joiner.toString());
                bw.newLine();
            }
        }
    }
    
    @Override
    public void leerFichero() throws IOException, ClassNotFoundException {
        listaRecuperadaV.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("infoVehiculos.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Vehiculo vehiculo = new Vehiculo(values[0], values[1], values[2], values[3], values[4], Double.parseDouble(values[5]), Double.parseDouble(values[6]));
                listaRecuperadaV.add(vehiculo);
            }
        }
    }
    
    @Override
    public void actualizarFichero(List<Vehiculo> lista)throws IOException{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("infoVehiculos.csv"))) {
            for (Vehiculo obj : lista) {
                StringJoiner joiner = new StringJoiner(",");
                joiner.add(obj.getReferencia())
                      .add(obj.getMarca())
                      .add(obj.getColor())
                      .add(obj.getPlaca())
                      .add(obj.getModelo())
                      .add(String.valueOf(obj.getPrecio()))
                      .add(String.valueOf(obj.getKilometraje()));
                bw.write(joiner.toString());
                bw.newLine();
            }
        }
    }
    
    @Override
    public void crearPDF() {
        try {
            Document doc = new Document();  //Creamos un objeto tipo documento
            
            Font tipo1 = FontFactory.getFont(BaseFont.TIMES_ROMAN, 12, BaseColor.BLACK);
            Font tipo2 = FontFactory.getFont(BaseFont.TIMES_BOLD, 20, BaseColor.GREEN);
            
            PdfWriter.getInstance(doc, new FileOutputStream("Lista_de_Vehiculos.pdf"));  //lo asociamos como archivo y colocarle nombre
            doc.open();
            Paragraph titulo = new Paragraph("Lista de Vehiculos", tipo2);
            doc.add(titulo);
            for (Vehiculo automovil : listaRecuperadaV){
                Paragraph txRef = new Paragraph("Referencia: " + automovil.getReferencia(), tipo1); // Cambiar aqui tambien
                Paragraph txMarc = new Paragraph("Marca: " + automovil.getMarca(), tipo1);
                Paragraph txCol = new Paragraph("Color: "+ automovil.getColor(), tipo1);
                Paragraph txPla = new Paragraph("Placa: "+ automovil.getPlaca(), tipo1);
                Paragraph txMod = new Paragraph("Modelo: "+ automovil.getModelo(), tipo1);
                Paragraph txKil = new Paragraph("Kilometraje: "+ automovil.getKilometraje(), tipo1);
                Paragraph txPre = new Paragraph("Precio: "+ automovil.getPrecio(), tipo1);
                Paragraph txLinea = new Paragraph("------------------------------------------------------", tipo1);
                
                doc.add(txRef);
                doc.add(txMarc);
                doc.add(txCol);
                doc.add(txPla);
                doc.add(txMod);
                doc.add(txKil);
                doc.add(txPre);
                doc.add(txLinea);
            }
            doc.addAuthor("Juan Andres Posada, Juan David González, Alejandro Munera, Miguel Angel Avila");
            doc.close(); 
        }catch(DocumentException | java.io.FileNotFoundException e){
            System.out.println("Error del archivo");
            e.printStackTrace();
        }
    }
}


 
