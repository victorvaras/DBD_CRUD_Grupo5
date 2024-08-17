package com.example.DBD.Repository;

import com.example.DBD.Models.Carro_Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;

@Repository
public class Carro_Compra_repository implements Carro_Compra_repository_Interface{

    private Sql2o sql2o;

    @Autowired
    public Carro_Compra_repository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public List<Carro_Compra> getAllCarros() {
        String sql = "SELECT * FROM public.\"Carro_Compra\"";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Carro_Compra.class);
        }
    }

    public List<Carro_Compra> getCarrosByID_Carro_Compra(int ID_Carro_Compra) {
        String sql = "SELECT * FROM public.\"Carro_Compra\" WHERE \"ID_Carro_Compra\" = :ID_Carro_Compra";

        try (var con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("ID_Carro_Compra", ID_Carro_Compra)
                    .executeAndFetch(Carro_Compra.class);
        }
    }

    public List<Carro_Compra> getCarrosByFecha(Date Fecha) {
        String sql = "SELECT * FROM public.\"Carro_Compra\" WHERE \"Fecha\" = :Fecha";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Fecha", Fecha)
                    .executeAndFetch(Carro_Compra.class);
        }
    }

    public List<Carro_Compra> getCarrosByMetodo_Pago(String Metodo_Pago) {
        String sql = "SELECT * FROM public.\"Carro_Compra\" WHERE \"Metodo_Pago\" = :Metodo_Pago";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Metodo_Pago", Metodo_Pago)
                    .executeAndFetch(Carro_Compra.class);
        }
    }

    public List<Carro_Compra> getCarrosByPrecio_Total_Carro(int Precio_Total_Carro) {
        String sql = "SELECT * FROM public.\"Carro_Compra\" WHERE \"Precio_Total_Carro\" = :Precio_Total_Carro";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("Precio_Total_Carro", Precio_Total_Carro)
                    .executeAndFetch(Carro_Compra.class);
        }
    }

    public boolean createCarro_Compra(Carro_Compra carro_Compra) {
        String sql = "INSERT INTO public.\"Carro_Compra\"(" +
                "\"ID_Carro_Compra\", \"Fecha\", \"Metodo_Pago\", \"Precio_Total_Carro\")" +
                "VALUES (:ID_Carro_Compra, :Fecha, :Metodo_Pago, :Precio_Total_Carro);";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Carro_Compra", carro_Compra.getID_Carro_Compra())
                    .addParameter("Fecha", carro_Compra.getFecha())
                    .addParameter("Metodo_Pago", carro_Compra.getMetodo_Pago())
                    .addParameter("Precio_Total_Carro", carro_Compra.getPrecio_Total_Carro())
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateCarro_Compra(Carro_Compra carro_Compra) {

        String sql = "UPDATE public.\"Carro_Compra\" "
                + "SET \"Fecha\" = :Fecha, "
                + "\"Metodo_Pago\" = :Metodo_Pago, "
                + "\"Precio_Total_Carro\" = :Precio_Total_Carro,"
                + "WHERE \"ID_Carro_Compra\" = :ID_Carro_Compra;";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Carro_Compra", carro_Compra.getID_Carro_Compra())
                    .addParameter("Fecha", carro_Compra.getFecha())
                    .addParameter("Metodo_Pago", carro_Compra.getMetodo_Pago())
                    .addParameter("Precio_Total_Carro", carro_Compra.getPrecio_Total_Carro())
                    .executeUpdate();

            return true;

        }
        catch (Exception e){
            return false;
        }
    }

    public boolean deleteCarro_Compra(int ID_Carro_Compra) {
        String sql = "DELETE FROM public.\"Carro_Compra\" "
                + "WHERE \"ID_Carro_Compra\" = :ID_Carro_Compra;";

        try (var con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("ID_Carro_Compra", ID_Carro_Compra)
                    .executeUpdate();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
