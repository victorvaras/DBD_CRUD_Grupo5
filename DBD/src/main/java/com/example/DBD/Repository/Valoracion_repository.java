package com.example.DBD.Repository;

import com.example.DBD.Models.Producto;
import com.example.DBD.Models.Valoracion;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;

import java.util.List;


@Repository
public class Valoracion_repository implements Valoracion_repository_Interface {

    private Sql2o sql2o;

    public Valoracion_repository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Valoracion> getAllValoracion() {
        String sql = "SELECT * FROM \"Valoracion\"";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Valoracion.class);
        }
    }

    public List<Valoracion> getValoracionByRut(String Rut) {
        String sql = "SELECT * FROM \"Valoracion\" WHERE \"Rut\" = :Rut";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).addParameter("Rut", Rut).executeAndFetch(Valoracion.class);
        }
    }

    public List<Valoracion> getValoracionByCodigo_Producto(int Codigo_Producto) {
        String sql = "SELECT * FROM \"Valoracion\" WHERE \"Codigo_Producto\" = :Codigo_Producto";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).addParameter("Codigo_Producto", Codigo_Producto).executeAndFetch(Valoracion.class);
        }
    }

    public boolean createValoracion(Valoracion valoracion) {

        String sql = "INSERT INTO public.\"Valoracion\"( " +
                "\"Rut\", \"Codigo_Producto\", \"Valoracion\")"
                + " VALUES (:Rut, :Codigo_Producto, :Valoracion)";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Rut", valoracion.getRut())
                    .addParameter("Codigo_Producto", valoracion.getCodigo_Producto())
                    .addParameter("Valoracion", valoracion.getValoracion())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateValoracion(Valoracion valoracion) {
        String sql = "UPDATE public.\"Valoracion\" " +
                "SET  \"Valoracion\"= :Valoracion " +
                "WHERE \"Rut\"= :Rut and \"Codigo_Producto\"= :Codigo_Producto";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Rut", valoracion.getRut())
                    .addParameter("Codigo_Producto", valoracion.getCodigo_Producto())
                    .addParameter("Valoracion", valoracion.getValoracion())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean deleteValoracion(String rut, int codigo_producto) {
        String sql = "DELETE FROM \"Valoracion\" " +
                "WHERE \"Rut\" = :Rut and \"Codigo_Producto\"= :Codigo_Producto";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Rut", rut)
                    .addParameter("Codigo_Producto",codigo_producto)
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }



}

