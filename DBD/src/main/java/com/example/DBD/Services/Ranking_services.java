package com.example.DBD.Services;

import com.example.DBD.Models.Ranking;
import com.example.DBD.Repository.Ranking_repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ranking_services {
    Ranking_repository ranking_repository;

    public Ranking_services(Ranking_repository ranking_repository) {
        this.ranking_repository = ranking_repository;
    }

    public List<Ranking> getAllRankings() {
        return ranking_repository.getAllRankings();
    }

    public List<Ranking> getRankingByID_Ranking(int ID_Ranking) {
        return ranking_repository.getRankingByID_Ranking(ID_Ranking);
    }

    public List<Ranking> getRankingByVentas(int Ventas) {
        return ranking_repository.getRankingByVentas(Ventas);
    }

    public String createRanking(Ranking ranking){

        if (ranking_repository.createRanking(ranking)){
            return "El ranking ha sido creado exitosamente";
        }
        else{
            return "El ranking no se ha podido crear";
        }
    }

    public String updateRanking(Ranking ranking){

        if(ranking_repository.updateRanking(ranking)){
            return "El ranking ha sido actualizado";
        }
        else{
            return "El ranking no se ha podido actualizar";
        }
    }

    public String deleteRanking(int ID_Ranking){

        if(ranking_repository.deleteRanking(ID_Ranking)){
            return "El ranking ha sido eliminado exitosamente";
        }
        else {
            return "El ranking no se ha podido eliminar";
        }
    }
}
