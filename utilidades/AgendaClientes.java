
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
public class AgendaClientes implements ReporteI<Cliente>{
    List<Cliente> listaClientes = new ArrayList<>();
    List<Cliente> listaRecuperada = new ArrayList<>();
    
    @Override
    public void adicionarObjeto(Cliente objA){
        listaClientes.add(objA); 
        try {
            guardarFichero();
        } catch (IOException ex) {
            Logger.getLogger(AgendaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int obtenerIndice(String Id){
        for(Cliente cliente : listaRecuperada) {
            if(String.valueOf(Id).equals(String.valueOf(cliente.getId()))){
                return listaRecuperada.indexOf(cliente);
            }
        }
        return -1;
    }
    
    @Override
    public String listarObjetos(){
        String lista ="";
        if(!listaRecuperada.isEmpty()){
            for(Cliente cliente : listaRecuperada) {
                lista = lista + cliente.getNombre()+ "\t" + cliente.getApellido() + "\t" + cliente.getTipoDocumento() + 
                    "\t" + cliente.getId() + "\t" + cliente.getGenero() + "\t" + cliente.getEdad() + "\t" + cliente.getDireccion() + 
                    "\t" + cliente.getCiudadResidencia() + "\t" + cliente.getCelular() + "\t" + cliente.getCelularAlt() + 
                    "\t\t" + cliente.getLicencia() + "\n";
            }
        }
        return lista;
    }
    
    @Override
    public Cliente buscarPorID(int indice){
        Cliente encontrado = listaRecuperada.get(indice);
        return encontrado;
    }
    
    @Override
    public void actualizarObjeto(Cliente obj){
        for (Cliente cliente : listaRecuperada){
            if(String.valueOf(obj.getId()).equals(String.valueOf(cliente.getId()))){
                cliente.setNombre(obj.getNombre());
                cliente.setApellido(obj.getApellido());
                cliente.setTipoDocumento(obj.getTipoDocumento());
                cliente.setId(obj.getId());
                cliente.setGenero(obj.getGenero());
                cliente.setEdad(obj.getEdad());
                cliente.setDireccion(obj.getDireccion());
                cliente.setCiudadResidencia(obj.getCiudadResidencia());
                cliente.setCelular(obj.getCelular());
                cliente.setCelularAlt(obj.getCelularAlt());
                cliente.setLicencia(obj.getLicencia());
            }
            try {
                actualizarFichero(listaRecuperada);
            } catch (IOException ex) {
                Logger.getLogger(AgendaClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void eliminarObjeto(int indice){
        listaRecuperada.remove(indice);
        try {
            actualizarFichero(listaRecuperada);
        } catch (IOException ex) {
            Logger.getLogger(AgendaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int numClientes(){
        int numClientes = listaRecuperada.size();
        return numClientes;
    }
    
    @Override
    public  void guardarFichero() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("infoClientes.csv"))) {
            for (Cliente obj : listaClientes) {
                StringJoiner joiner = new StringJoiner(",");
                joiner.add(obj.getNombre())
                      .add(obj.getApellido())
                      .add(obj.getTipoDocumento())
                      .add(String.valueOf(obj.getId()))
                      .add(obj.getGenero())
                      .add(String.valueOf(obj.getEdad()))
                      .add(obj.getDireccion())
                      .add(obj.getCiudadResidencia())
                      .add(obj.getCelular())
                      .add(obj.getCelularAlt())
                      .add(obj.getLicencia());
                bw.write(joiner.toString());
                bw.newLine();
            }
        }
    }
    
    @Override
    public void leerFichero() throws IOException, ClassNotFoundException {
        listaRecuperada.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("infoClientes.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Cliente cliente = new Cliente(values[0], values[1], values[2], Integer.parseInt(values[3]), values[4], Integer.parseInt(values[5]), values[6], values[7], values[8], values[9], values[10]);
                listaRecuperada.add(cliente);
            }
        }
    }
    
    @Override
    public void actualizarFichero(List<Cliente> lista)throws IOException{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("infoClientes.csv"))) {
            for (Cliente obj : listaClientes) {
                StringJoiner joiner = new StringJoiner(",");
                joiner.add(obj.getNombre())
                      .add(obj.getApellido())
                      .add(obj.getTipoDocumento())
                      .add(String.valueOf(obj.getId()))
                      .add(obj.getGenero())
                      .add(String.valueOf(obj.getEdad()))
                      .add(obj.getDireccion())
                      .add(obj.getCiudadResidencia())
                      .add(obj.getCelular())
                      .add(obj.getCelularAlt())
                      .add(obj.getLicencia());
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
            
            PdfWriter.getInstance(doc, new FileOutputStream("Lista_de_Clientes.pdf"));  //lo asociamos como archivo y colocarle nombre
            doc.open();
            Paragraph titulo = new Paragraph("Lista de clientes", tipo2);
            doc.add(titulo);
            for (Cliente cliente : listaRecuperada){
                Paragraph txNom = new Paragraph("Nombre: " + cliente.getNombre(), tipo1);
                Paragraph txApe = new Paragraph("Apellido: " + cliente.getApellido(), tipo1);
                Paragraph txTD = new Paragraph("Tipo de Documento: " + cliente.getTipoDocumento(), tipo1);
                Paragraph txId = new Paragraph("ID: " + cliente.getId(), tipo1);
                Paragraph txGen = new Paragraph("Genero: "+ cliente.getGenero(), tipo1);
                Paragraph txEda = new Paragraph("Edad: " + cliente.getEdad(), tipo1);
                Paragraph txDir = new Paragraph("Direccion: "+ cliente.getDireccion(), tipo1);
                Paragraph txCiu = new Paragraph("Ciudad de Residencia: "+ cliente.getCiudadResidencia(), tipo1);
                Paragraph txCel = new Paragraph("Celular: "+ cliente.getCelular(), tipo1);
                Paragraph txCelA = new Paragraph("Celular Alternativo: "+ cliente.getCelularAlt(), tipo1);
                Paragraph txLic = new Paragraph("Licencia: "+ cliente.getLicencia(), tipo1);
                Paragraph txLinea = new Paragraph("------------------------------------------------------", tipo1);
                
                doc.add(txNom);
                doc.add(txApe);
                doc.add(txTD);
                doc.add(txId);
                doc.add(txGen);
                doc.add(txEda);
                doc.add(txDir);
                doc.add(txCiu);
                doc.add(txCel);
                doc.add(txCelA);
                doc.add(txLic);
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

 
