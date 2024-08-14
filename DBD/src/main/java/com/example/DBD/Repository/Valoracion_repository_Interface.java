package com.example.DBD.Repository;

import com.example.DBD.Models.Valoracion;
import org.sql2o.Sql2o;

import java.util.List;

public interface Valoracion_repository_Interface {

    public List<Valoracion> getAllValoracion();
    public List<Valoracion> getValoracionByRut(String Rut);
    public List<Valoracion> getValoracionByCodigo_Producto(int Codigo_Producto);
    public boolean createValoracion(Valoracion valoracion);
    public boolean updateValoracion(Valoracion valoracion);
    public boolean deleteValoracion(String rut, int codigo_producto);
}
