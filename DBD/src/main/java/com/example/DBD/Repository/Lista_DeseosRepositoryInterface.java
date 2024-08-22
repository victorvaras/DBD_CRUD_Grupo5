package com.example.DBD.Repository;

import com.example.DBD.Models.Lista_deseos;

import java.util.List;

public interface Lista_DeseosRepositoryInterface {
    List<Lista_deseos> getAllListaDeseos();

    //leer
    List<Lista_deseos> getListaDeseosbyID(int ID_Lista_Deseos);

    boolean crearListaDeseos(Lista_deseos lista_deseos);

    boolean updateListaDeseos(Lista_deseos lista_deseos);

    //eliminar
    boolean deleteListaDeseos(int ID_Lista_Deseos);
}
