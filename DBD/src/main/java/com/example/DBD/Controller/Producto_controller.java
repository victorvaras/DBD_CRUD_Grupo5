package com.example.DBD.Controller;

import com.example.DBD.Models.Producto;
import com.example.DBD.Services.Producto_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class Producto_controller {

    Producto_services producto_services;

    @Autowired
    public Producto_controller(Producto_services producto_services) {
        this.producto_services = producto_services;
    }

    @GetMapping
    public List<Producto> getAllProductos(){
        return producto_services.getAllProductos();
    }

    @GetMapping("/buscar_codigo_producto/{Codigo_Producto}")
    public List<Producto> getProductoByCodigo_Producto(@PathVariable int Codigo_Producto){
        return producto_services.getProductoByCodigo_Producto(Codigo_Producto);
    }

    @GetMapping("/buscar_nombre_producto/{Nombre_Producto}")
    public List<Producto> getProductoByNombre_Producto(@PathVariable String Nombre_Producto){
        return producto_services.getProductoByNombre_Producto(Nombre_Producto);
    }


    @GetMapping("/buscar_categoria/{Categoria}")
    public List<Producto> getProductoByCategoria(@PathVariable String Categoria){
        return producto_services.getProductoByCategoria(Categoria);
    }

    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto producto){
        return producto_services.crearProducto(producto);
    }

    @PutMapping("/update")
    public String updateProducto(@RequestBody Producto producto){
        return producto_services.updateProducto(producto);
    }

    @DeleteMapping("/delete/{Codigo_Producto}")
    public String deleteProducto(@PathVariable int Codigo_Producto){
        return producto_services.deleteProducto(Codigo_Producto);
    }

}
