package com.example.DBD.Repository;

import com.example.DBD.Models.Producto;

import java.util.List;

public interface Producto_repository_Interface {

    public List<Producto> getAllProductos();
    public List<Producto> getProductosByCodigo_Producto(int Codigo_Producto);
    public List<Producto> getProductosByNombre_Producto(String Nombre_Producto);
    public List<Producto> getProductosByCategoria(String Categoria);
    public boolean createProducto(Producto producto);
    public boolean updateProducto(Producto producto);
    public boolean deleteProducto(int Codigo_Producto);

}
