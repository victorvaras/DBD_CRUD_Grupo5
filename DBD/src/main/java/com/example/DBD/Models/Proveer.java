package com.example.DBD.Models;


public class Proveer {

    private String Rut;
    private int Codigo_Producto;
    private int Unidades;

    public Proveer(String rut, int codigo_Producto, int unidades) {
        Rut = rut;
        Codigo_Producto = codigo_Producto;
        Unidades = unidades;
    }

    //getter
    public String getRut() {
        return Rut;
    }

    public int getCodigo_Producto() {
        return Codigo_Producto;
    }

    public int getUnidades() {
        return Unidades;
    }

    //Setter
    public void setRut(String rut) {
        Rut = rut;
    }

    public void setCodigo_Producto(int codigo_Producto) {
        Codigo_Producto = codigo_Producto;
    }

    public void setUnidades(int unidades) {
        Unidades = unidades;
    }


    @Override
    public String toString() {
        return "Proveer{" +
                "Rut='" + Rut + '\'' +
                ", Codigo_Producto=" + Codigo_Producto +
                ", Unidades=" + Unidades +
                '}';
    }
}
