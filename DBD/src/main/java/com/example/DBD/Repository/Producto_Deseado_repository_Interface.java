package com.example.DBD.Repository;

import com.example.DBD.Models.Producto_Deseado;

import java.util.List;

public interface Producto_Deseado_repository_Interface {

    public List<Producto_Deseado> getAllProducto_Deseado();
    public List<Producto_Deseado> getProducto_DeseadoById_Lista_Deseos(int Id_Lista_Deseos);
    public List<Producto_Deseado> getProducto_DeseadoByCodigo_Producto(int Codigo_Producto);
    public boolean crearProducto_Deseado(Producto_Deseado producto_deseado);
    public boolean updateProducto_Deseado(Producto_Deseado producto_deseado);
    public boolean deleteProducto_Deseado(int ID_Lista_Deseos, int Codigo_Producto);
}
