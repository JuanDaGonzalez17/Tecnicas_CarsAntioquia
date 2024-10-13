/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miguelav.utilidades;

/**
 *
 * @author Paola
 */
public class Vehiculo {
    private String referencia, marca, color, placa, modelo;
    private double precio, kilometraje;

    public Vehiculo() {
    }

    public Vehiculo(String referencia, String marca, String color, String placa, String modelo, double precio, double kilometraje) {
        this.referencia = referencia;
        this.marca = marca;
        this.color = color;
        this.placa = placa;
        this.modelo = modelo;
        this.precio = precio;
        this.kilometraje = kilometraje;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "referencia=" + referencia + ", marca=" + marca + ", color=" + color + ", placa=" + placa + ", modelo=" + modelo + ", precio=" + precio + ", kilometraje=" + kilometraje + '}';
    }
}
