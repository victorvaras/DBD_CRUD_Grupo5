package com.example.DBD.Repository;

import com.example.DBD.Models.Tipo_Usuario;
import java.util.List;

public interface Tipo_UsuarioRepositoryInterface {

    List<Tipo_Usuario> getAllTipoUsuario();

    List<Tipo_Usuario> getTipoUsuarioById(int ID_Tipo_Usuario);

    List<Tipo_Usuario> getTipoUsuarioByNombre(String Tipo);

    boolean crearTipoUsuario(Tipo_Usuario tipo_usuario);

    boolean updateTipoUsuario(Tipo_Usuario tipo_usuario);

    boolean deleteTipoUsuario(int ID_Tipo_Usuario);
}
