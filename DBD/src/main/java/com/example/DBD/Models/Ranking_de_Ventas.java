package com.example.DBD.Models;

public class Ranking_de_Ventas {
    private int ID_Ranking;
    private int Ventas;
    private int ID_Boleta;

    public Ranking_de_Ventas(int ID_Ranking, int ventas, int ID_Boleta) {
        this.ID_Ranking = ID_Ranking;
        Ventas = ventas;
        this.ID_Boleta = ID_Boleta;
    }

    // GETTERS:
    public int getID_Ranking() {
        return ID_Ranking;
    }

    public int getVentas() {
        return Ventas;
    }

    public int getID_Boleta() {
        return ID_Boleta;
    }

    // SETTERS:
    public void setID_Ranking(int ID_Ranking) {
        this.ID_Ranking = ID_Ranking;
    }

    public void setVentas(int ventas) {
        Ventas = ventas;
    }

    public void setID_Boleta(int ID_Boleta) {
        this.ID_Boleta = ID_Boleta;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "ID_Ranking = " + ID_Ranking +
                "Ventas = " + Ventas + '}';
    }
}
