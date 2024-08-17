package com.example.DBD.Models;

public class Ranking {
    private int ID_Ranking;
    private int Ventas;

    public Ranking(int ID_Ranking, int ventas) {
        this.ID_Ranking = ID_Ranking;
        Ventas = ventas;
    }

    // GETTERS:
    public int getID_Ranking() {
        return ID_Ranking;
    }

    public int getVentas() {
        return Ventas;
    }

    // SETTERS:
    public void setID_Ranking(int ID_Ranking) {
        this.ID_Ranking = ID_Ranking;
    }

    public void setVentas(int ventas) {
        Ventas = ventas;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "ID_Ranking = " + ID_Ranking +
                "Ventas = " + Ventas + '}';
    }
}
