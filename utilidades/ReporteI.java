/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miguelav.utilidades;

import java.io.IOException;
import java.util.List;


/**
 *
 * @author Juan David
 */
public interface ReporteI <T>{
    public void adicionarObjeto(T objA);
    public int obtenerIndice(String Id);
    public String listarObjetos();
    public T buscarPorID(int indice);
    public void actualizarObjeto(T obj);
    public void eliminarObjeto(int indice);
    public int numClientes();
    public void guardarFichero() throws IOException ;
    public void leerFichero() throws IOException, ClassNotFoundException;
    public void actualizarFichero(List<T> lista)throws IOException;
    public void crearPDF();
}
