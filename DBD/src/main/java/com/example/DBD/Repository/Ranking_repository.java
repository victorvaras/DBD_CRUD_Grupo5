package com.example.DBD.Repository;

import com.example.DBD.Models.Ranking;
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

    public List<Ranking> getAllRankings() {
        String sql = "SELECT * FROM public.\"Ranking\"";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Ranking.class);
        }
    }

    public List<Ranking> getRankingByID_Ranking(int ID_Ranking) {
        String sql = "SELECT * FROM public.\"Ranking\" WHERE \"ID_Ranking\" = :ID_Ranking";

        try (var con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("ID_Ranking", ID_Ranking)
                    .executeAndFetch(Ranking.class);
        }
    }

    public List<Ranking> getRankingByVentas(int Ventas) {
        String sql = "SELECT * FROM public.\"Ranking\" WHERE \"Ventas\" = :Ventas";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Ventas", Ventas)
                    .executeAndFetch(Ranking.class);
        }
    }

    public boolean createRanking(Ranking ranking) {
        String sql = "INSERT INTO public.\"Ranking\"(" +
                "\"ID_Ranking\", \"Ventas\")" +
                "VALUES (:ID_Ranking, :Ventas);";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Ranking", ranking.getID_Ranking())
                    .addParameter("Ventas", ranking.getVentas())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateRanking(Ranking ranking) {
        String sql = "UPDATE public.\"Ranking\" "
                + "SET \"Ventas\" = :Ventas, "
                + "WHERE \"ID_Ranking\" = :ID_Ranking;";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Ranking", ranking.getID_Ranking())
                    .addParameter("Ventas", ranking.getVentas())
                    .executeUpdate();

            return true;

        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deleteRanking(int ID_Ranking) {
        String sql = "DELETE FROM public.\"Ranking\" "
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
