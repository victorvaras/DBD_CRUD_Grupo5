package com.example.DBD.Models;

import java.util.Date;

public class Boleta {
    private int ID_Boleta;
    private Date Fecha;
    private int Precio_Total;
    private String Metodo_Pago;
    private int ID_Carro_de_Compras;

    public Boleta(int ID_Boleta, Date fecha, int precio_Total, String metodo_Pago, int ID_Carro_Compra) {
        this.ID_Boleta = ID_Boleta;
        Fecha = fecha;
        Precio_Total = precio_Total;
        Metodo_Pago = metodo_Pago;
        this.ID_Carro_de_Compras = ID_Carro_Compra;
    }

    // GETTERS:
    public int getID_Boleta() {
        return ID_Boleta;
    }

    public Date getFecha() {
        return Fecha;
    }

    public int getPrecio_Total() {
        return Precio_Total;
    }

    public String getMetodo_Pago() {
        return Metodo_Pago;
    }

    public int getID_Carro_de_Compras() {
        return ID_Carro_de_Compras;
    }

    // SETTERS:
    public void setID_Boleta(int ID_Boleta) {
        this.ID_Boleta = ID_Boleta;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setPrecio_Total(int precio_Total) {
        Precio_Total = precio_Total;
    }

    public void setMetodo_Pago(String metodo_Pago) {
        Metodo_Pago = metodo_Pago;
    }

    public void setID_Carro_de_Compras(int ID_Carro_de_Compras) {
        this.ID_Carro_de_Compras = ID_Carro_de_Compras;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                ", ID_Boleta = " + ID_Boleta +
                ", Fecha = " + Fecha +
                ", Precio_Total = " + Precio_Total +
                ", Metodo_Pago = " + Metodo_Pago + '}' +
                ", ID_Carro_Compra = " + ID_Carro_de_Compras + '}';
    }
}
