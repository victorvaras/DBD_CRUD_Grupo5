package com.example.DBD.Services;

import org.springframework.web.bind.annotation.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import com.example.DBD.Models.Producto;
import com.example.DBD.Repository.Producto_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producto_services {

    private Producto_repository producto_repository;

    Producto_services(Producto_repository producto_repository){
        this.producto_repository = producto_repository;
    }


    public List<Producto> getAllProductos(){
        return producto_repository.getAllProductos();
    }


    public List<Producto> getProductoByCodigo_Producto(int Codigo_Producto){
        return producto_repository.getProductosByCodigo_Producto(Codigo_Producto);
    }

    public List<Producto> getProductoByNombre_Producto(String Nombre_Producto){
        return producto_repository.getProductosByNombre_Producto(Nombre_Producto);
    }

    public List<Producto> getProductoByCategoria( String Categoria){
        return producto_repository.getProductosByCategoria(Categoria);
    }

    public String crearProducto(Producto producto){

        if(producto_repository.createProducto(producto)){
            return "Producto creada correctamente";
        }
        else
            return "Error al crear el producto";
    }

    public String updateProducto(Producto producto){
        if(producto_repository.updateProducto(producto)){
            return "Producto modificada correctamente";
        }
        else
            return "Error al modificar el producto";
    }


    public String deleteProducto(int Codigo_Producto){

        if(producto_repository.deleteProducto(Codigo_Producto)){
            return "Producto eliminado correctamente";
        }
        else
            return "Error al eliminar el producto";
    }
}
