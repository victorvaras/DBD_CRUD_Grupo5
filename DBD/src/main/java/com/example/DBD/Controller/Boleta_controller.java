package com.example.DBD.Controller;

import com.example.DBD.Models.Boleta;
import com.example.DBD.Services.Boleta_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Boleta")
@CrossOrigin

public class Boleta_controller {
    Boleta_services boleta_services;

    @Autowired
    public Boleta_controller(Boleta_services boleta_services) {
        this.boleta_services = boleta_services;
    }

    @GetMapping
    public List<Boleta> getAllBoletas() {
        return boleta_services.getAllBoletas();
    }

    @GetMapping("/buscar_ID_Boleta/{ID_Boleta}")
    public List<Boleta> getBoletaByID_Boleta(@PathVariable int ID_Boleta) {
        return boleta_services.getBoletaByID_Boleta(ID_Boleta);
    }

    @GetMapping("/buscar_Fecha/{Fecha}")
    public List<Boleta> getBoletaByFecha(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date Fecha) {
        return boleta_services.getBoletaByFecha(Fecha);
    }

    @GetMapping("/buscar_Precio_Total/{Precio_Total}")
    public List<Boleta> getBoletaByPrecio_Total(@PathVariable int Precio_Total) {
        return boleta_services.getBoletaByPrecio_Total(Precio_Total);
    }

    @GetMapping("/buscar_Metodo_Pago/{Metodo_Pago}")
    public List<Boleta> getBoletaByMetodo_Pago(@PathVariable String Metodo_Pago) {
        return boleta_services.getBoletaByMetodo_Pago(Metodo_Pago);
    }

    @GetMapping("/buscar_ID_Carro_Compra/{ID_Carro_Compra}")
    public List<Boleta> getBoletaByID_Carro_Compra(@PathVariable int ID_Carro_Compra) {
        return boleta_services.getBoletaByID_Carro_Compra(ID_Carro_Compra);
    }

    @PostMapping("/create")
    public String createBoleta(@RequestBody Boleta boleta) {
        return boleta_services.createBoleta(boleta);
    }

    @PutMapping("/update")
    public String updateBoleta(@RequestBody Boleta boleta) {
        return boleta_services.updateBoleta(boleta);
    }

    @DeleteMapping("/delete/{ID_Boleta}/{ID_Carro_Compra}")
    public String deleteBoleta(@PathVariable int ID_Boleta, @PathVariable int ID_Carro_Compra) {
        return boleta_services.deleteBoleta(ID_Boleta, ID_Carro_Compra);
    }

}
