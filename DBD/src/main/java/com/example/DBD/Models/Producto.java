package com.example.DBD.Models;

public class Producto {
    private int Codigo_Producto;
    private String Nombre_Producto;
    private String Categoria;
    private int Stock;
    private int Precio_Producto;
    private String URL_Imagen;

    public Producto(String nombre_Producto, int codigo_Producto, String categoria, int stock, int precio_Producto, String URL_Imagen) {
        Nombre_Producto = nombre_Producto;
        Codigo_Producto = codigo_Producto;
        Categoria = categoria;
        Stock = stock;
        Precio_Producto = precio_Producto;
        this.URL_Imagen = URL_Imagen;
    }

    //Getter
    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public int getCodigo_Producto() {
        return Codigo_Producto;
    }

    public String getCategoria() {
        return Categoria;
    }

    public int getStock() {
        return Stock;
    }

    public int getPrecio_Producto() {
        return Precio_Producto;
    }

    public String getURL_Imagen() {
        return URL_Imagen;
    }

    //Setter
    public void setCodigo_Producto(int codigo_Producto) {
        Codigo_Producto = codigo_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        Nombre_Producto = nombre_Producto;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public void setPrecio_Producto(int precio_Producto) {
        Precio_Producto = precio_Producto;
    }

    public void setURL_Imagen(String URL_Imagen) {
        this.URL_Imagen = URL_Imagen;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Codigo_Producto=" + Codigo_Producto +
                ", Nombre_Producto='" + Nombre_Producto + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Stock=" + Stock +
                ", Precio_Producto=" + Precio_Producto +
                ", URL_Imagen='" + URL_Imagen + '\'' +
                '}';
    }
}
