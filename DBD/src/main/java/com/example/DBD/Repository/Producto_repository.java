package com.example.DBD.Repository;

import com.example.DBD.Models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Producto_repository implements Producto_repository_Interface{

    private Sql2o sql2o;

    @Autowired
    public Producto_repository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Producto> getAllProductos() {
        String sql = "SELECT * FROM public.\"Producto\"";
        try (var con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Producto.class);
        }
    }


    public List<Producto> getProductosByCodigo_Producto(int Codigo_Producto) {
        String sql = "SELECT * FROM public.\"Producto\" WHERE \"Codigo_Producto\" = :Codigo_Producto";

        try (var con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Codigo_Producto", Codigo_Producto)
                    .executeAndFetch(Producto.class);
        }
    }


    public List<Producto> getProductosByNombre_Producto(String Nombre_Producto) {
        String sql = "SELECT * FROM public.\"Producto\" WHERE \"Nombre_Producto\" = :Nombre_Producto";

        try (var con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Nombre_Producto",Nombre_Producto)
                    .executeAndFetch(Producto.class);
        }
    }


    public List<Producto> getProductosByCategoria(String Categoria) {
        String sql = "SELECT * FROM public.\"Producto\" WHERE \"Categoria\" = :Categoria";

        try (var con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Categoria",Categoria)
                    .executeAndFetch(Producto.class);
        }
    }


    public boolean createProducto(Producto producto) {

        String sql = "INSERT INTO public.\"Producto\"(" +
                "\"Codigo_Producto\", \"Nombre_Producto\", \"Categoria\", \"Stock\", " +
                "\"Precio_Producto\", \"URL_Imagen\") " +
                "VALUES (:Codigo_Producto, :Nombre_Producto, :Categoria, :Stock, " +
                ":Precio_Producto, :URL_Imagen);";



        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Codigo_Producto", producto.getCodigo_Producto())
                    .addParameter("Nombre_Producto", producto.getNombre_Producto())
                    .addParameter("Categoria", producto.getCategoria())
                    .addParameter("Stock", producto.getStock())
                    .addParameter("Precio_Producto", producto.getPrecio_Producto())
                    .addParameter("URL_Imagen", producto.getURL_Imagen())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }


    public boolean updateProducto(Producto producto) {

        String sql = "UPDATE public.\"Producto\" "
                + "SET \"Nombre_Producto\" = :Nombre_Producto, "
                + "\"Categoria\" = :Categoria, "
                + "\"Stock\" = :Stock, "
                + "\"Precio_Producto\" = :Precio_Producto, "
                + "\"URL_Imagen\" = :URL_Imagen "
                + "WHERE \"Codigo_Producto\" = :Codigo_Producto";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Codigo_Producto", producto.getCodigo_Producto())
                    .addParameter("Nombre_Producto", producto.getNombre_Producto())
                    .addParameter("Categoria", producto.getCategoria())
                    .addParameter("Stock", producto.getStock())
                    .addParameter("Precio_Producto", producto.getPrecio_Producto())
                    .addParameter("URL_Imagen", producto.getURL_Imagen())
                    .executeUpdate();

                return true;

        }catch (Exception e){
            return false;
        }

    }

    public boolean deleteProducto(int Codigo_Producto) {
        String sql = "DELETE FROM public.\"Producto\" "
                + "WHERE \"Codigo_Producto\" = :Codigo_Producto";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("Codigo_Producto", Codigo_Producto)
                    .executeUpdate();
                    return true;
        }
        catch (Exception e){
            return false;
        }
    }


}
