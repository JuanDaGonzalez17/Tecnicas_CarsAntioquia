/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miguelav.utilidades;

/**
 *
 * @author Paola
 */
public class Cliente {
    
    private String nombre, apellido, tipoDocumento, genero, direccion, ciudadResidencia, celular, celularAlt, licencia;
    private int id, edad;
    
    public Cliente() {
    }
    
    public Cliente(String nombre, String apellido, String tipoDocumento, int id, String genero, int edad, String direccion, String ciudadResidencia, String celular, String celularAlt, String licencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.id = id;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.ciudadResidencia = ciudadResidencia;
        this.celular = celular;
        this.celularAlt = celularAlt;
        this.licencia = licencia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCelularAlt() {
        return celularAlt;
    }

    public void setCelularAlt(String celularAlt) {
        this.celularAlt = celularAlt;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", tipoDocumento=" + tipoDocumento + ", id=" + id + ", genero=" + genero + ", edad=" + edad + ", direccion=" + direccion + ", ciudadResidencia=" + ciudadResidencia + ", celular=" + celular + ", celularAlt=" + celularAlt + ", licencia=" + licencia + '}';
    }
    
}
