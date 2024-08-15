package com.example.DBD.Services;

import com.example.DBD.Models.Producto_Deseado;
import com.example.DBD.Repository.Producto_Deseado_repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producto_Deseado_services {

    Producto_Deseado_repository producto_deseado_repository;

    public Producto_Deseado_services(Producto_Deseado_repository producto_deseado_repository) {
        this.producto_deseado_repository = producto_deseado_repository;
    }

    public List<Producto_Deseado> getAllProducto_Deseado() {
        return producto_deseado_repository.getAllProducto_Deseado();
    }

    public List<Producto_Deseado> getProducto_DeseadoById_Lista_Deseos(int Id_Lista_Deseos){
        return producto_deseado_repository.getProducto_DeseadoById_Lista_Deseos( Id_Lista_Deseos);
    }

    public List<Producto_Deseado> getProducto_DeseadoByCodigo_Producto(int Codigo_Producto){
        return producto_deseado_repository.getProducto_DeseadoByCodigo_Producto(Codigo_Producto);
    }

    public String crearProducto_Deseado(Producto_Deseado producto_deseado){

        if (producto_deseado_repository.crearProducto_Deseado(producto_deseado)){
            return "Se ha agregado el Producto deseado";
        }
        else{
            return "No se ha agregado el Producto deseado";
        }
    }

    public String updateProducto_Deseado(Producto_Deseado producto_deseado){

        if(producto_deseado_repository.updateProducto_Deseado(producto_deseado)){
            return "Se ha actualizado el Producto deseado";
        }
        else{
            return "No se ha actualizado el Producto deseado";
        }
    }

    public String deleteProducto_Deseado(int ID_Lista_Deseos, int Codigo_Producto){

        if(producto_deseado_repository.deleteProducto_Deseado(ID_Lista_Deseos, Codigo_Producto)){
            return "Se ha eliminado el Producto deseado";
        }
        else {
            return "No se ha eliminado el Producto deseado";
        }
    }

}
