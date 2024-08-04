package com.example.DBD.Services;

import org.springframework.web.bind.annotation.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import com.example.DBD.Models.Producto;
import com.example.DBD.Repository.Producto_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@CrossOrigin
@RestController
public class Producto_services {

    private Producto_repository producto_repository;

    Producto_services(Producto_repository producto_repository){
        this.producto_repository = producto_repository;
    }

    @GetMapping("/producto")
    public List<Producto> getAllProductos(){
        return producto_repository.getAllProductos();
    }

    @GetMapping("/producto/buscar_codigo_producto/{Codigo_Producto}")
    public List<Producto> getProductoByCodigo_Producto(@PathVariable int Codigo_Producto){
        return producto_repository.getProductosByCodigo_Producto(Codigo_Producto);
    }

    @GetMapping("/producto/buscar_nombre_producto/{Nombre_Producto}")
    public List<Producto> getProductoByNombre_Producto(@PathVariable String Nombre_Producto){
        return producto_repository.getProductosByNombre_Producto(Nombre_Producto);
    }

    @GetMapping("producto/buscar_categoria/{Categoria}")
    public List<Producto> getProductoByCategoria(@PathVariable String Categoria){
        return producto_repository.getProductosByCategoria(Categoria);
    }

    @PostMapping("/producto/crear")
    public String crearProducto(@RequestBody Producto producto){

        if(producto_repository.createProducto(producto)){
            return "Producto creada correctamente";
        }
        else
            return "Error al crear el producto";
    }

    @PutMapping("/producto/update")
    public String updateProducto(@RequestBody Producto producto){
        if(producto_repository.updateProducto(producto)){
            return "Producto modificada correctamente";
        }
        else
            return "Error al modificar el producto";
    }


    @DeleteMapping("producto/delete/{Codigo_Producto}")
    public String deleteProducto(@RequestBody Producto producto, @PathVariable int Codigo_Producto){

            if(producto_repository.deleteProducto(producto,Codigo_Producto)){
            return "Producto eliminado correctamente";
        }
        else
            return "Error al eliminar el producto";
    }
}
