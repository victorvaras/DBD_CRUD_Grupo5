package com.example.DBD.Models;

public class Valoracion {

    private String Rut;
    private int Codigo_Producto;
    private int Valoracion;

    public Valoracion(String rut, int codigo_Producto, int valoracion) {
        Rut = rut;
        Codigo_Producto = codigo_Producto;
        Valoracion = valoracion;
    }

    //Getter

    public String getRut() {
        return Rut;
    }

    public int getCodigo_Producto() {
        return Codigo_Producto;
    }

    public int getValoracion() {
        return Valoracion;
    }


    //Setter
    public void setRut(String rut) {
        Rut = rut;
    }

    public void setCodigo_Producto(int codigo_Producto) {
        Codigo_Producto = codigo_Producto;
    }

    public void setValoracion(int valoracion) {
        Valoracion = valoracion;
    }


    @Override
    public String toString() {
        return "Valoracion{" +
                "Rut='" + Rut + '\'' +
                ", Codigo_Producto=" + Codigo_Producto +
                ", Valoracion=" + Valoracion +
                '}';
    }
}
