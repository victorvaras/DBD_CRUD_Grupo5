package com.example.DBD.Controller;

import com.example.DBD.Models.Valoracion;
import com.example.DBD.Services.Valoracion_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valoracion")
@CrossOrigin
public class Valoracion_controller {


    Valoracion_services valoracion_services;

    @Autowired
    public Valoracion_controller(Valoracion_services valoracion_services) {
        this.valoracion_services = valoracion_services;
    }

    @GetMapping
    public List<Valoracion> getAllValoracion(){
        return valoracion_services.getAllValoracion();
    }

    @GetMapping("/buscar_rut/{rut}")
    public List<Valoracion> getValoracionByRut(@PathVariable String rut){
        return valoracion_services.getValoracionByRut(rut);
    }

    @GetMapping ("/buscar_codigo_producto/{codigo_producto}")
    List<Valoracion> getValoracionByCodigo_Producto(@PathVariable int codigo_producto){
        return valoracion_services.getValoracionByCodigo_Producto(codigo_producto);
    }

    @PostMapping("/crear")
    public String createValoracion(@RequestBody Valoracion valoracion){
        return valoracion_services.createValoracion(valoracion);
    }

    @PostMapping("/update")
    public String updateValoracion(@RequestBody Valoracion valoracion){
        return valoracion_services.updateValoracion(valoracion);
    }

    @DeleteMapping("/delete/{rut}/{codigo_producto}")
    public String deleteValoracion(@PathVariable String rut, @PathVariable int codigo_producto){
        return valoracion_services.deleteValoracion(rut, codigo_producto);
    }
}
