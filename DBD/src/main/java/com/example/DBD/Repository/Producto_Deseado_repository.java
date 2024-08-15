package com.example.DBD.Repository;

import com.example.DBD.Models.Producto_Deseado;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class Producto_Deseado_repository implements Producto_Deseado_repository_Interface {

    private Sql2o sql2o;

    public Producto_Deseado_repository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Producto_Deseado> getAllProducto_Deseado() {
        String sql = "SELECT * FROM public.\"Producto_Deseado\"";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Producto_Deseado.class);
        }
    }

    public List<Producto_Deseado> getProducto_DeseadoById_Lista_Deseos(int Id_Lista_Deseos) {
        String sql = "SELECT * FROM public.\"Producto_Deseado\" " +
                "WHERE \"ID_Lista_Deseos\" = :id_Lista_Deseos";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id_Lista_Deseos", Id_Lista_Deseos)
                    .executeAndFetch(Producto_Deseado.class);
        }
    }

    public List<Producto_Deseado> getProducto_DeseadoByCodigo_Producto(int Codigo_Producto){
        String sql = "SELECT * FROM public.\"Producto_Deseado\" " +
                "WHERE \"Codigo_Producto\" = :codigo_Producto";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("codigo_Producto", Codigo_Producto)
                    .executeAndFetch(Producto_Deseado.class);
        }
    }


    public boolean crearProducto_Deseado(Producto_Deseado producto_deseado) {
        String sql = "INSERT INTO public.\"Producto_Deseado\"( " +
                "\"ID_Lista_Deseos\", \"Codigo_Producto\", \"Cantidad_Producto_Deseada\") " +
                "VALUES( :ID_Lista_Deseos, :Codigo_Producto, :Cantidad_Producto_Deseada)";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Lista_Deseos", producto_deseado.getID_Lista_Deseos())
                    .addParameter("Codigo_Producto", producto_deseado.getCodigo_Producto())
                    .addParameter("Cantidad_Producto_Deseada", producto_deseado.getCantidad_Producto_Deseada())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateProducto_Deseado(Producto_Deseado producto_deseado) {
        String sql = "UPDATE public.\"Producto_Deseado\" " +
                "SET \"Cantidad_Producto_Deseada\" = :Cantidad_Producto_Deseada " +
                "WHERE \"ID_Lista_Deseos\" = :ID_Lista_Deseos  and \"Codigo_Producto\" = :Codigo_Producto";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Lista_Deseos", producto_deseado.getID_Lista_Deseos())
                    .addParameter("Codigo_Producto", producto_deseado.getCodigo_Producto())
                    .addParameter("Cantidad_Producto_Deseada", producto_deseado.getCantidad_Producto_Deseada())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteProducto_Deseado(int ID_Lista_Deseos, int Codigo_Producto) {
        String sql = "DELETE FROM public.\"Producto_Deseado\" " +
                "WHERE \"ID_Lista_Deseos\" = :id_Lista_Deseos  and \"Codigo_Producto\" = :Codigo_Producto";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id_Lista_Deseos", ID_Lista_Deseos)
                    .addParameter("Codigo_Producto", Codigo_Producto)
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

}
