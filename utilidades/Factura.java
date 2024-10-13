package com.miguelav.utilidades;

import com.mycompany.mavenproject1.Cliente;
import com.mycompany.mavenproject1.Vehiculo;
import java.util.Date;


public class Factura {
    private String Fecha;
    private Vehiculo vehiculo; 
    private Cliente cliente; 
    private Vehiculo placa;
    private Vehiculo precio;
    private Cliente Id;
    private String metodoDePago;
    private String financiacion;
    private int cuotas;
    
    
    public Factura(String Fecha, Vehiculo vehiculo, Vehiculo placa, Cliente cliente, String metodoDePago, String financiacion, int cuotas) {
        this.Fecha = Fecha;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.placa = placa;
        this.precio = precio;
        this.Id = Id;
        this.metodoDePago = metodoDePago;
        this.financiacion = financiacion;
        this.cuotas = cuotas;
    }
    

    public String getFecha() {
        return Fecha;
    }

    public Vehiculo getPlaca() {
        return placa;
    }

    public Vehiculo getPrecio() {
        return precio;
    }

    public Cliente getId() {
        return Id;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setPlaca(Vehiculo placa) {
        this.placa = placa;
    }

    public void setPrecio(Vehiculo precio) {
        this.precio = precio;
    }

    public void setId(Cliente Id) {
        this.Id = Id;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getFinanciacion() {
        return financiacion;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setFinanciacion(String financiacion) {
        this.financiacion = financiacion;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" + "Fecha=" + Fecha + ", vehiculo=" + vehiculo + ", cliente=" + cliente + ", placa=" + placa + ", precio=" + precio + ", Id=" + Id + ", metodoDePago=" + metodoDePago + ", financiacion=" + financiacion + ", cuotas=" + cuotas + '}';
    }

    
}

