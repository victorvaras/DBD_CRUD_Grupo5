package com.example.DBD.Models;

public class Producto_Carro_Compras {
    private int ID_Carro_de_Compras;
    private int Codigo_Producto;
    private int Cantidad_producto;

    public Producto_Carro_Compras(int ID_Carro_de_Compras, int codigo_Producto, int cantidad_Producto) {
        this.ID_Carro_de_Compras = ID_Carro_de_Compras;
        Codigo_Producto = codigo_Producto;
        Cantidad_producto = cantidad_Producto;
    }

    public int getID_Carro_de_Compras() {
        return ID_Carro_de_Compras;
    }

    public void setID_Carro_de_Compras(int ID_Carro_de_Compras) {
        this.ID_Carro_de_Compras = ID_Carro_de_Compras;
    }

    public int getCodigo_Producto() {
        return Codigo_Producto;
    }

    public void setCodigo_Producto(int codigo_Producto) {
        Codigo_Producto = codigo_Producto;
    }

    public int getCantidad_Producto() {
        return Cantidad_producto;
    }

    public void setCantidad_Producto(int cantidad_Producto) {
        Cantidad_producto = cantidad_Producto;
    }

    @Override
    public String toString() {
        return "Producto_Carro_Compras{" +
                "ID_Carro_de_Compras=" + ID_Carro_de_Compras +
                ", Codigo_Producto=" + Codigo_Producto +
                ", Cantidad_Producto=" + Cantidad_producto +
                '}';
    }
}
