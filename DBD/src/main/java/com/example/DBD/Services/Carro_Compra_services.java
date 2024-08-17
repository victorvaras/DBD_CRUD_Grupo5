package com.example.DBD.Services;

import com.example.DBD.Models.Carro_Compra;
import com.example.DBD.Repository.Carro_Compra_repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Carro_Compra_services {
    Carro_Compra_repository carro_compra_repository;

    public Carro_Compra_services(Carro_Compra_repository carro_compra_repository) {
        this.carro_compra_repository = carro_compra_repository;
    }

    public List<Carro_Compra> getAllCarros() {
        return carro_compra_repository.getAllCarros();
    }

    public List<Carro_Compra> getCarrosByID_Carro_Compra(int ID_Carro_Compra) {
        return carro_compra_repository.getCarrosByID_Carro_Compra(ID_Carro_Compra);
    }

    public List<Carro_Compra> getCarrosByFecha(Date Fecha) {
        return carro_compra_repository.getCarrosByFecha(Fecha);
    }

    public List<Carro_Compra> getCarrosByMetodo_Pago(String Metodo_Pago) {
        return carro_compra_repository.getCarrosByMetodo_Pago(Metodo_Pago);
    }

    public List<Carro_Compra> getCarrosByPrecio_Total_Carro(int Precio_Total_Carro) {
        return carro_compra_repository.getCarrosByPrecio_Total_Carro(Precio_Total_Carro);
    }

    public String createCarro_Compra(Carro_Compra carro_Compra) {
        if (carro_compra_repository.createCarro_Compra(carro_Compra)){
            return "El carro de compras se ha creado con exito";
        }
        else{
            return "No ha sido posible crear el carro de compras";
        }
    }

    public String updateCarro_Compra(Carro_Compra carro_Compra) {
        if(carro_compra_repository.updateCarro_Compra(carro_Compra)){
            return "El carro de compras ha sido actualizado";
        }
        else{
            return "El carro de compras no se ha podido actualizar";
        }
    }

    public String deleteCarro_Compra(int ID_Carro_Compra) {
        if(carro_compra_repository.deleteCarro_Compra(ID_Carro_Compra)){
            return "El carro de compras ha sido eliminado exitosamente";
        }
        else {
            return "El carro de compras no se ha podido eliminar";
        }
    }
}
