package com.example.DBD.Repository;

import com.example.DBD.Models.Proveer;

import java.util.List;

public interface Proveer_repository_Interface {

    public List<Proveer> getAllProveer();
    public List<Proveer> getProveerByRut(String rut);
    public List<Proveer> getProveerByCodigo_Producto(int Codigo_Producto);
    public boolean createProveer(Proveer proveer);
    public boolean updateProveer(Proveer proveer);
    public boolean deleteProveer(String rut, int codigo_producto);
}
