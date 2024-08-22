package com.example.DBD.Models;


public class Lista_deseos {
    private int ID_Lista_Deseos;
    private int Precio_Total_Lista;

    public Lista_deseos(int ID_Lista_Deseos, int precio_Total_Lista) {
        this.ID_Lista_Deseos = ID_Lista_Deseos;
        Precio_Total_Lista = precio_Total_Lista;
    }

    public int getID_Lista_Deseos() {
        return ID_Lista_Deseos;
    }

    public void setID_Lista_Deseos(int ID_Lista_Deseos) {
        this.ID_Lista_Deseos = ID_Lista_Deseos;
    }

    public int getPrecio_Total_Lista() {
        return Precio_Total_Lista;
    }

    public void setPrecio_Total_Lista(int precio_Total_Lista) {
        Precio_Total_Lista = precio_Total_Lista;
    }

    @Override
    public String toString() {
        return "Lista_Deseos{" +
                "ID_Lista_Deseos=" + ID_Lista_Deseos +
                ", Precio_Total_Lista=" + Precio_Total_Lista +
                '}';
    }
}
