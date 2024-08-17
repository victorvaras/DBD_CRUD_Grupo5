package com.example.DBD.Repository;

import com.example.DBD.Models.Boleta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;

@Repository
public class Boleta_repository implements Boleta_repository_Interface{

    private Sql2o sql2o;

    @Autowired
    public Boleta_repository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Boleta> getAllBoletas() {
        String sql = "SELECT * FROM public.\"Boleta\"";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Boleta.class);
        }
    }

    public List<Boleta> getBoletaByID_Boleta(int ID_Boleta) {
        String sql = "SELECT * FROM public.\"Boleta\" WHERE \"ID_Boleta\" = :ID_Boleta";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("ID_Boleta", ID_Boleta)
                    .executeAndFetch(Boleta.class);
        }
    }

    public List<Boleta> getBoletaByFecha(Date Fecha) {
        String sql = "SELECT * FROM public.\"Boleta\" WHERE \"Fecha\" = :Fecha";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Fecha", Fecha)
                    .executeAndFetch(Boleta.class);
        }
    }

    public List<Boleta> getBoletaByPrecio_Total(int Precio_Total) {
        String sql = "SELECT * FROM public.\"Boleta\" WHERE \"Precio_Total\" = :Precio_Total";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Precio_Total", Precio_Total)
                    .executeAndFetch(Boleta.class);
        }
    }

    public List<Boleta> getBoletaByMetodo_Pago(String Metodo_Pago) {
        String sql = "SELECT * FROM public.\"Boleta\" WHERE \"Metodo_Pago\" = :Metodo_Pago";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Metodo_Pago", Metodo_Pago)
                    .executeAndFetch(Boleta.class);
        }
    }

    public List<Boleta> getBoletaByID_Carro_Compra(int ID_Carro_Compra) {
        String sql = "SELECT * FROM public.\"Boleta\" " +
                "WHERE \"ID_Carro_Compra\" = :ID_Carro_Compra";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("ID_Carro_Compra", ID_Carro_Compra)
                    .executeAndFetch(Boleta.class);
        }
    }

    public boolean createBoleta(Boleta boleta) {
        String sql = "INSERT INTO public.\"Boleta\"(" +
                "\"ID_Boleta\", \"Fecha\", \"Precio_Total\", \"Metodo_Pago\", \"ID_Carro_Compra\")" +
                "VALUES (:ID_Boleta, :Fecha, :Precio_Total, :Metodo_Pago, :ID_Carro_Compra);";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Boleta", boleta.getID_Boleta())
                    .addParameter("Fecha", boleta.getFecha())
                    .addParameter("Precio_Total", boleta.getPrecio_Total())
                    .addParameter("Metodo_Pago", boleta.getMetodo_Pago())
                    .addParameter("ID_Carro_Compra", boleta.getID_Carro_Compra())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateBoleta(Boleta boleta) {
        String sql = "UPDATE public.\"Boleta\" "
                + "SET \"Fecha\" = :Fecha, "
                + "\"Precio_Total\" = :Precio_Total, "
                + "\"Metodo_Pago\" = :Metodo_Pago , "
                + "WHERE \"ID_Boleta\" = :ID_Boleta and \"ID_Carro_Compra\" = :ID_Carro_Compra";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Boleta", boleta.getID_Boleta())
                    .addParameter("Fecha", boleta.getFecha())
                    .addParameter("Precio_Total", boleta.getPrecio_Total())
                    .addParameter("Metodo_Pago", boleta.getMetodo_Pago())
                    .addParameter("ID_Carro_Compra", boleta.getID_Carro_Compra())
                    .executeUpdate();

            return true;

        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deleteBoleta(int ID_Boleta, int ID_Carro_Compra) {
        String sql = "DELETE FROM public.\"Boleta\" "
                + "WHERE \"ID_Boleta\" = :ID_Boleta and \"ID_Carro_Compra\" = :ID_Carro_Compra";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Boleta", ID_Boleta)
                    .addParameter("ID_Carro_Compra", ID_Carro_Compra)
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
