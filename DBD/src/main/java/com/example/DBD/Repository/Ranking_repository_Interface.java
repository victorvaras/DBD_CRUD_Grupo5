package com.example.DBD.Repository;

import com.example.DBD.Models.Ranking_de_Ventas;

import java.util.List;

public interface Ranking_repository_Interface {
    public List<Ranking_de_Ventas> getAllRankings();
    public List<Ranking_de_Ventas> getRankingByID_Ranking(int ID_Ranking);
    public List<Ranking_de_Ventas> getRankingByVentas(int Ventas);
    public boolean createRanking(Ranking_de_Ventas rankingDeVentas);
    public boolean updateRanking(Ranking_de_Ventas rankingDeVentas);
    public boolean deleteRanking(int ID_Ranking);
}
