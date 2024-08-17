package com.example.DBD.Controller;

import com.example.DBD.Models.Ranking;
import com.example.DBD.Services.Ranking_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ranking")
@CrossOrigin

public class Ranking_controller {
    Ranking_services ranking_services;

    @Autowired
    public Ranking_controller(Ranking_services ranking_services) {
        this.ranking_services = ranking_services;
    }

    @GetMapping
    public List<Ranking> getAllRankings() {
        return ranking_services.getAllRankings();
    }

    @GetMapping("/buscar_ID_Ranking/{ID_Ranking}")
    public List<Ranking> getRankingByID_Ranking(@PathVariable int ID_Ranking) {
        return ranking_services.getRankingByID_Ranking(ID_Ranking);
    }

    @GetMapping("/buscar_Ventas/{Ventas}")
    public List<Ranking> getRankingByVentas(@PathVariable int Ventas) {
        return ranking_services.getRankingByVentas(Ventas);
    }

    @PostMapping("/create")
    public String createRanking(@RequestBody Ranking ranking) {
        return ranking_services.createRanking(ranking);
    }

    @PutMapping("/update")
    public String updateRanking(@RequestBody Ranking ranking) {
        return ranking_services.updateRanking(ranking);
    }

    @DeleteMapping("/delete/{ID_Ranking}")
    public String deleteRanking(@PathVariable int ID_Ranking) {
        return ranking_services.deleteRanking(ID_Ranking);
    }
}
