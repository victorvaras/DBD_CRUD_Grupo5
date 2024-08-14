package com.example.DBD.Services;

import com.example.DBD.Models.Proveer;
import com.example.DBD.Repository.Proveer_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Proveer_services {

    Proveer_repository proveer_repository;

    private Proveer_services(Proveer_repository proveer_Repository) {
        this.proveer_repository = proveer_Repository;
    }

    public List<Proveer> getAllProveer() {
        return proveer_repository.getAllProveer();
    }

    public List<Proveer> getProveerByRut(String rut) {
        return proveer_repository.getProveerByRut(rut);
    }

    public List<Proveer> getProveerByCodigo_Producto(int codigo_producto) {
        return proveer_repository.getProveerByCodigo_Producto(codigo_producto);
    }

    public String createProveer(Proveer proveer) {

        if(proveer_repository.createProveer(proveer)) {
            return "Proveer creado";
        }
        else{
            return "Proveer no creado";
        }
    }

    public String updateProveer(Proveer proveer) {
        if(proveer_repository.updateProveer(proveer)) {
            return "Proveer actualizado";
        }
        else{
            return "Proveer no actualizado";
        }
    }

    public String deleteProveer(String rut, int codigo_producto) {
        if(proveer_repository.deleteProveer(rut, codigo_producto)) {
            return "Proveer eliminado";
        }
        else{
            return "Proveer no eliminado";
        }
    }


}
