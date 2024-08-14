package com.example.DBD.Services;

import com.example.DBD.Models.Valoracion;
import com.example.DBD.Repository.Valoracion_repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Valoracion_services {

    private Valoracion_repository valoracion_repository;

    public Valoracion_services(Valoracion_repository valoracion_repository) {
        this.valoracion_repository = valoracion_repository;
    }

    public List<Valoracion> getAllValoracion() {
        return valoracion_repository.getAllValoracion();
    }

    public List<Valoracion> getValoracionByRut(String rut) {
        return valoracion_repository.getValoracionByRut(rut);
    }

    public List<Valoracion> getValoracionByCodigo_Producto(int codigo_producto) {
        return valoracion_repository.getValoracionByCodigo_Producto(codigo_producto);
    }


    public String createValoracion(Valoracion valoracion) {

        if(valoracion_repository.createValoracion(valoracion)){
            return "Valoracion creada";
        }
        else{
            return "Valoracion no Creada";
        }
    }

    public String updateValoracion(Valoracion valoracion) {
        if(valoracion_repository.updateValoracion(valoracion)){
            return "Valoracion modificada";
        }
        else {
            return "Valoracion no Modificada";
        }
    }

    public String deleteValoracion(String rut, int codigo_producto) {
        if(valoracion_repository.deleteValoracion(rut, codigo_producto)){
            return "Valoracion eliminada";
        }
        else{
            return "Valoracion no Eliminada";
        }
    }


}
