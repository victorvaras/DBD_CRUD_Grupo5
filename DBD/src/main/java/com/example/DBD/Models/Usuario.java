package com.example.DBD.Models;

public class Usuario {
    private String Rut;
    private String Nombre;
    private String Correo;
    private String Contrasena;
    private String Region;
    private String Comuna;
    private String Direccion;
    private int ID_Tipo_Usuario;
    private int ID_Carro_de_Compras;
    private int ID_Lista_Deseos;

    public Usuario(String rut, String nombre, String correo, String contrasena, String region, String comuna, String direccion, int ID_Tipo_Usuario, int ID_Carro_de_Compras, int ID_Lista_Deseos) {
        Rut = rut;
        Nombre = nombre;
        Correo = correo;
        Contrasena = contrasena;
        Region = region;
        Comuna = comuna;
        Direccion = direccion;
        this.ID_Tipo_Usuario = ID_Tipo_Usuario;
        this.ID_Carro_de_Compras = ID_Carro_de_Compras;
        this.ID_Lista_Deseos = ID_Lista_Deseos;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        Rut = rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String comuna) {
        Comuna = comuna;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getID_Tipo_Usuario() {
        return ID_Tipo_Usuario;
    }

    public void setID_Tipo_Usuario(int ID_Tipo_Usuario) {
        this.ID_Tipo_Usuario = ID_Tipo_Usuario;
    }

    public int getID_Carro_de_Compras() {
        return ID_Carro_de_Compras;
    }

    public void setID_Carro_de_Compras(int ID_Carro_de_Compras) {
        this.ID_Carro_de_Compras = ID_Carro_de_Compras;
    }

    public int getID_Lista_Deseos() {
        return ID_Lista_Deseos;
    }

    public void setID_Lista_Deseos(int ID_Lista_Deseos) {
        this.ID_Lista_Deseos = ID_Lista_Deseos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Rut='" + Rut + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Correo='" + Correo + '\'' +
                ", Contrasena='" + Contrasena + '\'' +
                ", Region='" + Region + '\'' +
                ", Comuna='" + Comuna + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", ID_Tipo_Usuario=" + ID_Tipo_Usuario +
                ", ID_Carro_de_Compras=" + ID_Carro_de_Compras +
                ", ID_Lista_Deseos=" + ID_Lista_Deseos +
                '}';
    }
}
