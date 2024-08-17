package com.example.DBD.Repository;

import com.example.DBD.Models.Boleta;

import java.util.Date;
import java.util.List;

public interface Boleta_repository_Interface {
    public List<Boleta> getAllBoletas();
    public List<Boleta> getBoletaByID_Boleta(int ID_Boleta);
    public List<Boleta> getBoletaByFecha(Date Fecha);
    public List<Boleta> getBoletaByPrecio_Total(int Precio_Total);
    public List<Boleta> getBoletaByMetodo_Pago(String Metodo_Pago);
    public List<Boleta> getBoletaByID_Carro_Compra(int ID_Carro_Compra);
    public boolean createBoleta(Boleta boleta);
    public boolean updateBoleta(Boleta boleta);
    public boolean deleteBoleta(int ID_Boleta, int ID_Carro_Compra);
}
