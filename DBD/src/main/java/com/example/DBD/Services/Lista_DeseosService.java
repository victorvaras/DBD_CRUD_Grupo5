package com.example.DBD.Services;

import com.example.DBD.Models.Lista_deseos;
import com.example.DBD.Repository.Lista_DeseosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Lista_DeseosService {
    private Lista_DeseosRepository listaDeseosRepository;

    Lista_DeseosService(Lista_DeseosRepository listaDeseosRepository) {
        this.listaDeseosRepository = listaDeseosRepository;
    }

    public List<Lista_deseos> getAllListaDeseos() {
        return listaDeseosRepository.getAllListaDeseos();
    }

    public List<Lista_deseos> getListaDeseosByID(int id) {
        return listaDeseosRepository.getListaDeseosbyID(id);
    }

    public String createListaDeseo(Lista_deseos listaDeseo) {
        if(listaDeseosRepository.crearListaDeseos(listaDeseo)){
            return "Lista de deseos creada";
        }else{
            return "Lista de deseos no creada";
        }
    }

    public String updateListaDeseo(Lista_deseos listaDeseo) {
        if(listaDeseosRepository.updateListaDeseos(listaDeseo)){
            return "Lista de deseos atualizada";
        }else{
            return "Lista de deseos no modificada";
        }
    }

    public String deleteListaDeseo(int id) {
        if(listaDeseosRepository.deleteListaDeseos(id)){
            return "Lista de deseos eliminada";
        }else{
            return "Lista de deseos no eliminada";
        }
    }
}
