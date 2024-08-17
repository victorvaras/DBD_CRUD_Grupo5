package com.example.DBD.Services;

import com.example.DBD.Models.Boleta;
import com.example.DBD.Repository.Boleta_repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Boleta_services {
    Boleta_repository boleta_repository;

    public Boleta_services(Boleta_repository boleta_repository) {
        this.boleta_repository = boleta_repository;
    }

    public List<Boleta> getAllBoletas() {
        return boleta_repository.getAllBoletas();
    }

    public List<Boleta> getBoletaByID_Boleta(int ID_Boleta) {
        return boleta_repository.getBoletaByID_Boleta(ID_Boleta);
    }

    public List<Boleta> getBoletaByFecha(Date Fecha) {
        return boleta_repository.getBoletaByFecha(Fecha);
    }

    public List<Boleta> getBoletaByPrecio_Total(int Precio_Total) {
        return boleta_repository.getBoletaByPrecio_Total(Precio_Total);
    }

    public List<Boleta> getBoletaByMetodo_Pago(String Metodo_Pago) {
        return boleta_repository.getBoletaByMetodo_Pago(Metodo_Pago);
    }

    public List<Boleta> getBoletaByID_Carro_Compra(int ID_Carro_Compra) {
        return boleta_repository.getBoletaByID_Carro_Compra(ID_Carro_Compra);
    }

    public String createBoleta(Boleta boleta){

        if (boleta_repository.createBoleta(boleta)){
            return "La boleta ha sido creada exitosamente";
        }
        else{
            return "La boleta no se ha podido crear";
        }
    }

    public String updateBoleta(Boleta boleta){

        if(boleta_repository.updateBoleta(boleta)){
            return "La boleta ha sido actualizada";
        }
        else{
            return "La boleta no se ha podido actualizar";
        }
    }

    public String deleteBoleta(int ID_Boleta, int ID_Carro_Compra){

        if(boleta_repository.deleteBoleta(ID_Boleta, ID_Carro_Compra)){
            return "La boleta ha sido eliminada exitosamente";
        }
        else {
            return "La boleta no se ha podido eliminar";
        }
    }

}
