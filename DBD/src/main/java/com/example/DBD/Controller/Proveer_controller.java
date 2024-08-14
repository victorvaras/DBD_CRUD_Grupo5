package com.example.DBD.Controller;

import com.example.DBD.Models.Proveer;
import com.example.DBD.Services.Proveer_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proveer")
@CrossOrigin
public class Proveer_controller {

    Proveer_services proveer_services;

    @Autowired
    public Proveer_controller(Proveer_services proveer_services) {
        this.proveer_services = proveer_services;
    }

    @GetMapping
    public List<Proveer> getAllProveer() {
        return proveer_services.getAllProveer();
    }

    @GetMapping("/buscar_rut/{rut}")
    public List<Proveer> getProveerByRut(@PathVariable String rut) {
        return proveer_services.getProveerByRut(rut);
    }

    @GetMapping("/buscar_codigo_producto/{codigo_producto}")
    public List<Proveer> getProveerByCodigoProducto(@PathVariable int codigo_producto) {
        return proveer_services.getProveerByCodigo_Producto(codigo_producto);
    }

    @PostMapping("/crear")
    public String createProveer(@RequestBody Proveer proveer) {
        return proveer_services.createProveer(proveer);
    }

    @PostMapping("/update")
    public String updateProveer(@RequestBody Proveer proveer) {
        return proveer_services.updateProveer(proveer);
    }

    @DeleteMapping("/delete/{rut}/{codigo_producto}")
    public String deleteProveer(@PathVariable String rut, @PathVariable int codigo_producto) {
        return proveer_services.deleteProveer(rut, codigo_producto);
    }
}
