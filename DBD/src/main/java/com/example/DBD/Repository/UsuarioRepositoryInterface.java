package com.example.DBD.Repository;

import com.example.DBD.Models.Usuario;

import java.util.List;

public interface UsuarioRepositoryInterface {
    List<Usuario> getAllUsuario();

    //get by rut, nombre y id tipo usuario
    List<Usuario> getUsuarioByRut(String Rut);

    List<Usuario> getUsuarioByNombre(String Nombre);

    List<Usuario> getUsuarioByTipo(int ID_Tipo_Usuario);

    boolean crearUsuario(Usuario usuario);

    boolean updateUsuario(Usuario usuario);

    boolean deleteUsuario(String Rut);
}
