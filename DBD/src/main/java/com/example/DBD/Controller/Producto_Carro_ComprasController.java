package com.example.DBD.Controller;

import com.example.DBD.Models.Producto_Carro_Compras;
import com.example.DBD.Services.Producto_Carro_ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productoCarroCompras")
@CrossOrigin
public class Producto_Carro_ComprasController {

    Producto_Carro_ComprasService productoCarroComprasService;

    @Autowired
    public Producto_Carro_ComprasController(Producto_Carro_ComprasService productoCarroComprasService) {
        this.productoCarroComprasService = productoCarroComprasService;
    }

    @GetMapping
    public List<Producto_Carro_Compras> getAllProductoCarroCompras(){
        return productoCarroComprasService.getAllProductoCarroCompras();
    }

    //get by codigo y id carro
    @GetMapping("/buscarproducto/{Codigo_Producto}")
    public List<Producto_Carro_Compras> getProductoCarroComprasByCodigoProducto(@PathVariable int Codigo_Producto){
        return productoCarroComprasService.getProductoCarroComprasByProducto(Codigo_Producto);
    }

    @GetMapping("/buscarcarro/{ID_Carro_de_Compras}")
    public List<Producto_Carro_Compras> getProductoCarroComprasByCarro(@PathVariable int ID_Carro_de_Compras){
        return productoCarroComprasService.getProductoCarroComprasByCarro(ID_Carro_de_Compras);
    }

    @PostMapping("/nuevo")
    public String crearProductoCarroCompras(@RequestBody Producto_Carro_Compras productoCarroCompras){
        return productoCarroComprasService.crearProductoCarroCompras(productoCarroCompras);
    }

    @PutMapping("/update")
    public String updateProductoCarroCompras(@RequestBody Producto_Carro_Compras productoCarroCompras){
        return productoCarroComprasService.updateProductoCarroCompras(productoCarroCompras);
    }

    @DeleteMapping("/delete/{Codigo_Producto}/{ID_Carro_de_Compras}")
    public String deleteProductoCarroCompras(@PathVariable int Codigo_Producto, @PathVariable int ID_Carro_de_Compras){
        return productoCarroComprasService.deleteProductoCarroCompras(Codigo_Producto, ID_Carro_de_Compras);
    }
}
