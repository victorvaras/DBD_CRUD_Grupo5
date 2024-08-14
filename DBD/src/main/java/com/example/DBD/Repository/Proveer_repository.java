package com.example.DBD.Repository;

import com.example.DBD.Models.Proveer;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Proveer_repository implements Proveer_repository_Interface{

    private Sql2o sql2o;

    public Proveer_repository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Proveer> getAllProveer(){
        String sql = "SELECT * FROM public.\"Proveer\"";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Proveer.class);
        }
    }

    public List<Proveer> getProveerByRut(String rut){
        String sql = "SELECT * FROM public.\"Proveer\" " +
                "WHERE \"Rut\" = :Rut";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Rut", rut)
                    .executeAndFetch(Proveer.class);
        }
    }

    public List<Proveer> getProveerByCodigo_Producto(int Codigo_Producto){
        String sql = "SELECT * FROM public.\"Proveer\" " +
                "WHERE \"Codigo_Producto\" = :Codigo_Producto";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Codigo_Producto", Codigo_Producto)
                    .executeAndFetch(Proveer.class);
        }
    }

    public boolean createProveer(Proveer proveer){

        String sql = "INSERT INTO public.\"Proveer\"( " +
                "\"Rut\", \"Codigo_Producto\", \"Unidades\")" +
                "VALUES (:Rut, :Codigo_Producto, :Unidades)";

        try (Connection con = sql2o.open()) {
             con.createQuery(sql)
                    .addParameter("Rut", proveer.getRut())
                    .addParameter("Codigo_Producto", proveer.getCodigo_Producto())
                    .addParameter("Unidades", proveer.getUnidades())
                    .executeAndFetch(Proveer.class);
             return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateProveer(Proveer proveer){
        String sql = "UPDATE public.\"Proveer\" " +
                "SET \"Rut\"= :Rut, \"Codigo_Producto\"= :Codigo_Producto, \"Unidades\"= :Unidades";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Rut", proveer.getRut())
                    .addParameter("Codigo_Producto", proveer.getCodigo_Producto())
                    .addParameter("Unidades", proveer.getUnidades())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteProveer(String rut, int codigo_producto){
        String sql = "DELETE FROM public.\"Proveer\" " +
                "WHERE \"Rut\" = :Rut and \"Codigo_Producto\"= :Codigo_Producto";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Rut", rut)
                    .addParameter("Codigo_Producto", codigo_producto)
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


}
