package com.example.DBD.Models;

import java.util.Date;

public class Carro_Compra {
    private int ID_Carro_Compra;
    private Date Fecha;
    private String Metodo_Pago;
    private int Precio_Total_Carro;

    public Carro_Compra(int ID_Carro_Compra, Date fecha, String metodo_Pago, int precio_Total_Carro) {
        this.ID_Carro_Compra = ID_Carro_Compra;
        Fecha = fecha;
        Metodo_Pago = metodo_Pago;
        Precio_Total_Carro = precio_Total_Carro;
    }

    // GETTERS:
    public int getID_Carro_Compra() {
        return ID_Carro_Compra;
    }

    public Date getFecha() {
        return Fecha;
    }

    public String getMetodo_Pago() {
        return Metodo_Pago;
    }

    public int getPrecio_Total_Carro() {
        return Precio_Total_Carro;
    }

    // SETTERS:
    public void setID_Carro_Compra(int ID_Carro_Compra) {
        this.ID_Carro_Compra = ID_Carro_Compra;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setMetodo_Pago(String metodo_Pago) {
        Metodo_Pago = metodo_Pago;
    }

    public void setPrecio_Total_Carro(int precio_Total_Carro) {
        Precio_Total_Carro = precio_Total_Carro;
    }

    @Override
    public String toString() {
        return "Carro_Compra{" +
                ", ID_Carro_Compra = " + ID_Carro_Compra +
                ", Fecha = " + Fecha +
                ", Metodo_Pago = " + Metodo_Pago +
                ", Precio_Total_Carro = " + Precio_Total_Carro + '}';
    }
}
