package com.example.DBD.Models;

public class Producto_Deseado {

    private int ID_Lista_Deseos;
    private int Codigo_Producto;
    private int Cantidad_Producto_Deseada;

    public Producto_Deseado(int ID_Lista_Deseos, int codigo_Producto, int cantidad_Producto_Deseada) {
        this.ID_Lista_Deseos = ID_Lista_Deseos;
        Codigo_Producto = codigo_Producto;
        Cantidad_Producto_Deseada = cantidad_Producto_Deseada;
    }

    //Getter
    public int getID_Lista_Deseos() {
        return ID_Lista_Deseos;
    }

    public int getCodigo_Producto() {
        return Codigo_Producto;
    }

    public int getCantidad_Producto_Deseada() {
        return Cantidad_Producto_Deseada;
    }


    //Setter
    public void setID_Lista_Deseos(int ID_Lista_Deseos) {
        this.ID_Lista_Deseos = ID_Lista_Deseos;
    }

    public void setCodigo_Producto(int codigo_Producto) {
        Codigo_Producto = codigo_Producto;
    }

    public void setCantidad_Producto_Deseada(int cantidad_Producto_Deseada) {
        Cantidad_Producto_Deseada = cantidad_Producto_Deseada;
    }
}
