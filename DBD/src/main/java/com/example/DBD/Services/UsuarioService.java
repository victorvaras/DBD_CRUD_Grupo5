package DBD.borradorMio.Servicies;
import DBD.borradorMio.Models.Usuario;
import DBD.borradorMio.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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
}
