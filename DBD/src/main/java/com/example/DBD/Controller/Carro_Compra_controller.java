package com.example.DBD.Controller;

import com.example.DBD.Models.Carro_Compra;
import com.example.DBD.Services.Carro_Compra_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Carro_Compra")
@CrossOrigin

public class Carro_Compra_controller {
    Carro_Compra_services carro_compra_services;

    @Autowired
    public Carro_Compra_controller(Carro_Compra_services carro_compra_services) {
        this.carro_compra_services = carro_compra_services;
    }

    @GetMapping
    public List<Carro_Compra> getAllCarros() {
        return carro_compra_services.getAllCarros();
    }

    @GetMapping("/buscar_ID_Carro_Compra/{ID_Carro_Compra}")
    public List<Carro_Compra> getCarrosByID_Carro_Compra(@PathVariable int ID_Carro_Compra) {
        return carro_compra_services.getCarrosByID_Carro_Compra(ID_Carro_Compra);
    }

    @GetMapping("/buscar_Fecha/{Fecha}")
    public List<Carro_Compra> getCarrosByFecha(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date Fecha) {
        return carro_compra_services.getCarrosByFecha(Fecha);
    }

    @GetMapping("/buscar_Metodo_Pago/{Metodo_Pago}")
    public List<Carro_Compra> getCarrosByMetodo_Pago(@PathVariable String Metodo_Pago) {
        return carro_compra_services.getCarrosByMetodo_Pago(Metodo_Pago);
    }

    @GetMapping("/buscar_Precio_Total_Carro/{Precio_Total_Carro}")
    public List<Carro_Compra> getCarrosByPrecio_Total_Carro(@PathVariable int Precio_Total_Carro) {
        return carro_compra_services.getCarrosByPrecio_Total_Carro(Precio_Total_Carro);
    }

    @PostMapping("/create")
    public String createCarro_Compra(@RequestBody Carro_Compra carro_compra) {
        return carro_compra_services.createCarro_Compra(carro_compra);
    }

    @PutMapping("/update")
    public String updateCarro_Compra(@RequestBody Carro_Compra carro_compra) {
        return carro_compra_services.updateCarro_Compra(carro_compra);
    }

    @DeleteMapping("/delete/{ID_Carro_Compra}")
    public String deleteCarro_Compra(@PathVariable int ID_Carro_Compra) {
        return carro_compra_services.deleteCarro_Compra(ID_Carro_Compra);
    }


}
