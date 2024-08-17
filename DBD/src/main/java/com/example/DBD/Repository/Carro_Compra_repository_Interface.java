package com.example.DBD.Repository;

import com.example.DBD.Models.Carro_Compra;

import java.util.Date;
import java.util.List;

public interface Carro_Compra_repository_Interface {
    public List<Carro_Compra> getAllCarros();
    public List<Carro_Compra> getCarrosByID_Carro_Compra(int ID_Carro_Compra);
    public List<Carro_Compra> getCarrosByFecha(Date Fecha);
    public List<Carro_Compra> getCarrosByMetodo_Pago(String Metodo_Pago);
    public List<Carro_Compra> getCarrosByPrecio_Total_Carro(int Precio_Total_Carro);
    public boolean createCarro_Compra(Carro_Compra carro_Compra);
    public boolean updateCarro_Compra(Carro_Compra carro_Compra);
    public boolean deleteCarro_Compra(int ID_Carro_Compra);
}
