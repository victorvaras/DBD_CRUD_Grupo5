package DBD.borradorMio.Repositories;

import DBD.borradorMio.Models.Producto_Carro_Compras;

import java.util.List;

public interface Producto_Carro_ComprasRepositoryInterface {
    List<Producto_Carro_Compras> getAllProducto_Carro_Compras();

    List<Producto_Carro_Compras> getProducto_Carro_ComprasByProducto(int Codigo_Producto);

    List<Producto_Carro_Compras> getProductoCarroComprasByCarro(int ID_Carro_de_Compras);

    boolean crearProducto_Carro_Compras(Producto_Carro_Compras producto_Carro_Compras);

    boolean update(Producto_Carro_Compras producto_carro_compras);

    boolean deleteProducto_Carro_Compras(int Codigo_Producto, int ID_Carro_de_Compras);
}
