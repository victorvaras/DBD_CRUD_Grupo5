package DBD.borradorMio.Servicies;
import DBD.borradorMio.Models.Producto_Carro_Compras;
import DBD.borradorMio.Repositories.Producto_Carro_ComprasRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Producto_Carro_ComprasService {
    private Producto_Carro_ComprasRepository productoCarroComprasRepository;

    public Producto_Carro_ComprasService(Producto_Carro_ComprasRepository productoCarroComprasRepository) {
        this.productoCarroComprasRepository = productoCarroComprasRepository;
    }

    public List<Producto_Carro_Compras> getAllProductoCarroCompras() {
        return productoCarroComprasRepository.getAllProducto_Carro_Compras();
    }

    public List<Producto_Carro_Compras> getProductoCarroComprasByCarro(int id) {
        return productoCarroComprasRepository.getProductoCarroComprasByCarro(id);
    }

    public List<Producto_Carro_Compras> getProductoCarroComprasByProducto(int id) {
        return productoCarroComprasRepository.getProducto_Carro_ComprasByProducto(id);
    }

    public String crearProductoCarroCompras(Producto_Carro_Compras producto) {
        if(productoCarroComprasRepository.crearProducto_Carro_Compras(producto)){
            return "Relacion producto carro compras creada";
        }else{
            return "Relacion producto carro compras no creada";
        }
    }

    public String updateProductoCarroCompras(Producto_Carro_Compras productoCarroCompras) {
        if(productoCarroComprasRepository.update(productoCarroCompras)){
            return "Relacion producto carro compras modificada";
        }else{
            return "Relacion producto carro compras no modificada";
        }
    }

    public String deleteProductoCarroCompras(int codigo_producto, int id_carro) {
        if(productoCarroComprasRepository.deleteProducto_Carro_Compras(codigo_producto, id_carro)){
            return "Relacion producto carro compras eliminada";

        }else{
            return "Relacion producto carro compras no eliminada";
        }
    }
}
