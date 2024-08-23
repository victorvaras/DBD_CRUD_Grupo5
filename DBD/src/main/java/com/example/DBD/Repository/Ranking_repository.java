package com.example.DBD.Repository;

import com.example.DBD.Models.Ranking_de_Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Ranking_repository implements Ranking_repository_Interface {
    private Sql2o sql2o;

    @Autowired
    public Ranking_repository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Ranking_de_Ventas> getAllRankings() {
        String sql = "SELECT * FROM public.\"Ranking_de_Ventas\"";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Ranking_de_Ventas.class);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<Ranking_de_Ventas> getRankingByID_Ranking(int ID_Ranking) {
        String sql = "SELECT * FROM public.\"Ranking_de_Ventas\" WHERE \"ID_Ranking\" = :ID_Ranking";

        try (var con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("ID_Ranking", ID_Ranking)
                    .executeAndFetch(Ranking_de_Ventas.class);
        }
    }

    public List<Ranking_de_Ventas> getRankingByVentas(int Ventas) {
        String sql = "SELECT * FROM public.\"Ranking_de_Ventas\" WHERE \"Ventas\" = :Ventas";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Ventas", Ventas)
                    .executeAndFetch(Ranking_de_Ventas.class);
        }
    }

    public boolean createRanking(Ranking_de_Ventas rankingDeVentas) {
        String sql = "INSERT INTO public.\"Ranking_de_Ventas\"(" +
                "\"ID_Ranking\", \"Ventas\", \"ID_Boleta\")" +
                "VALUES (:ID_Ranking, :Ventas, :ID_Boleta);";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Ranking", rankingDeVentas.getID_Ranking())
                    .addParameter("Ventas", rankingDeVentas.getVentas())
                    .addParameter("ID_Boleta", rankingDeVentas.getID_Boleta())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateRanking(Ranking_de_Ventas rankingDeVentas) {
        String sql = "UPDATE public.\"Ranking_de_Ventas\" "
                + "SET \"Ventas\" = :Ventas "
                + "WHERE \"ID_Ranking\" = :ID_Ranking and \"ID_Boleta\" = :ID_Boleta";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Ranking", rankingDeVentas.getID_Ranking())
                    .addParameter("Ventas", rankingDeVentas.getVentas())
                    .addParameter("ID_Boleta", rankingDeVentas.getID_Boleta())
                    .executeUpdate();

            return true;

        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deleteRanking(int ID_Ranking) {
        String sql = "DELETE FROM public.\"Ranking_de_Ventas\" "
                + "WHERE \"ID_Ranking\" = :ID_Ranking;";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Ranking", ID_Ranking)
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
