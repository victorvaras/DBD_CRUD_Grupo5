package com.example.DBD.Services;
import com.example.DBD.Models.Usuario;
import com.example.DBD.Repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuario(){
        return usuarioRepository.getAllUsuario();
    }

    public List<Usuario> getUsuarioByNombre(String nombre){
        return usuarioRepository.getUsuarioByNombre(nombre);
    }
    public List<Usuario> getUsuarioByRut(String rut){
        return usuarioRepository.getUsuarioByRut(rut);
    }

    public List<Usuario> getUsuarioByTipo(int tipo){
        return usuarioRepository.getUsuarioByTipo(tipo);
    }

    public String crearUsuario(Usuario usuario){
        if(usuarioRepository.crearUsuario(usuario)){
            return "Usuario creado";
        }else{
            return "Usuario no creado";
        }
    }

    public String updateUsuario(Usuario usuario){
        if(usuarioRepository.updateUsuario(usuario)){
            return "Usuario actualizado";
        }else{
            return "Usuario no actualizado";
        }
    }

    public String deleteUsuario(String rut){
        if(usuarioRepository.deleteUsuario(rut)){
            return "Usuario eliminado";
        }else{
            return "Usuario no eliminado";
        }
    }

    public String loginUsuario(String correo, String contrasena){

        if(usuarioRepository.loginUsuario(correo,contrasena) == null){
            return "Usuario no encontrado";
        }
        else {
            return "Usuario encontrado";
        }

       //return usuarioRepository.loginUsuario(correo, contrasena);
    }
}
