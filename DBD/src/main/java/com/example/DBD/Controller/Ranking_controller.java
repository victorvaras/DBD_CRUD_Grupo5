package com.example.DBD.Controller;

import com.example.DBD.Models.Ranking_de_Ventas;
import com.example.DBD.Services.Ranking_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
@CrossOrigin

public class Ranking_controller {
    Ranking_services ranking_services;

    @Autowired
    public Ranking_controller(Ranking_services ranking_services) {
        this.ranking_services = ranking_services;
    }

    @GetMapping
    public List<Ranking_de_Ventas> getAllRankings() {
        return ranking_services.getAllRankings();
    }

    @GetMapping("/buscar_ID_Ranking/{ID_Ranking}")
    public List<Ranking_de_Ventas> getRankingByID_Ranking(@PathVariable int ID_Ranking) {
        return ranking_services.getRankingByID_Ranking(ID_Ranking);
    }

    @GetMapping("/buscar_Ventas/{Ventas}")
    public List<Ranking_de_Ventas> getRankingByVentas(@PathVariable int Ventas) {
        return ranking_services.getRankingByVentas(Ventas);
    }

    @PostMapping("/create")
    public String createRanking(@RequestBody Ranking_de_Ventas rankingDeVentas) {
        return ranking_services.createRanking(rankingDeVentas);
    }

    @PutMapping("/update")
    public String updateRanking(@RequestBody Ranking_de_Ventas rankingDeVentas) {
        return ranking_services.updateRanking(rankingDeVentas);
    }

    @DeleteMapping("/delete/{ID_Ranking}")
    public String deleteRanking(@PathVariable int ID_Ranking) {
        return ranking_services.deleteRanking(ID_Ranking);
    }
}
