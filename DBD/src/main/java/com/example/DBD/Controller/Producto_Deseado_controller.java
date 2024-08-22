package com.example.DBD.Controller;

import com.example.DBD.Models.Producto_Deseado;
import com.example.DBD.Services.Producto_Deseado_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto_deseado")
@CrossOrigin
public class Producto_Deseado_controller {

    Producto_Deseado_services producto_deseado_services;

    @Autowired
    public Producto_Deseado_controller(Producto_Deseado_services producto_deseado_services) {
        this.producto_deseado_services = producto_deseado_services;
    }

    @GetMapping
    public List<Producto_Deseado> getAllProducto_Deseado() {
        return producto_deseado_services.getAllProducto_Deseado();
    }

    @GetMapping("/buscar_id_lista_deseos/{id_lista_deseos}")
    public List<Producto_Deseado> getProducto_DeseadoById_Lista_Deseos(@PathVariable int id_lista_deseos) {
        return producto_deseado_services.getProducto_DeseadoById_Lista_Deseos(id_lista_deseos);
    }

    @GetMapping("/buscar_codigo_producto/{codigo_producto}")
    public List<Producto_Deseado> getProducto_DeseadoByCodigo_Producto(@PathVariable int codigo_producto) {
        return producto_deseado_services.getProducto_DeseadoByCodigo_Producto(codigo_producto);
    }

    @PostMapping("/crear")
    public String crearProducto_Deseado(@RequestBody Producto_Deseado producto_deseado) {
        return producto_deseado_services.crearProducto_Deseado(producto_deseado);
    }

    @PutMapping("/uptade")
    public String uptateProducto_Deseado(@RequestBody Producto_Deseado producto_deseado) {
        return producto_deseado_services.updateProducto_Deseado(producto_deseado);
    }

    @DeleteMapping("/delete/{id_lista_deseos}/{codigo_producto}")
    public String deleteProducto_Deseado(@PathVariable int id_lista_deseos, @PathVariable int codigo_producto) {
        return producto_deseado_services.deleteProducto_Deseado(id_lista_deseos, codigo_producto);
    }
}
