package com.example.DBD.Repository;

import com.example.DBD.Models.Ranking;

import java.util.List;

public interface Ranking_repository_Interface {
    public List<Ranking> getAllRankings();
    public List<Ranking> getRankingByID_Ranking(int ID_Ranking);
    public List<Ranking> getRankingByVentas(int Ventas);
    public boolean createRanking(Ranking ranking);
    public boolean updateRanking(Ranking ranking);
    public boolean deleteRanking(int ID_Ranking);
}
