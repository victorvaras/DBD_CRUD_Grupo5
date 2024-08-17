package DBD.borradorMio.Servicies;
import DBD.borradorMio.Models.Tipo_Usuario;
import DBD.borradorMio.Repositories.Tipo_UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class Tipo_UsuarioService {

    private Tipo_UsuarioRepository tipo_usuarioRepository;

    public Tipo_UsuarioService(Tipo_UsuarioRepository tipo_usuarioRepository) {
        this.tipo_usuarioRepository = tipo_usuarioRepository;
    }

    public List<Tipo_Usuario> getAllTipoUsuario() {
        return tipo_usuarioRepository.getAllTipoUsuario();
    }

    public  List<Tipo_Usuario> getTipoUsuarioById(int id) {
        return tipo_usuarioRepository.getTipoUsuarioById(id);
    }

    public List<Tipo_Usuario>getTipoUsuarioByNombre(String Tipo) {
        return tipo_usuarioRepository.getTipoUsuarioByNombre(Tipo);
    }

    public String crearTipoUsuario(Tipo_Usuario tipo_usuario) {
        if(tipo_usuarioRepository.crearTipoUsuario(tipo_usuario)){
            return "Tipo Usuario Creado Exitosamente";
        }else{
            return "Tipo Usuario No Creado";
        }
    }

    public String updateTipoUsuario(Tipo_Usuario tipo_usuario) {
        if(tipo_usuarioRepository.updateTipoUsuario(tipo_usuario)){
            return "Tipo Usuario Actualizado Exitosamente";
        }else{
            return "Tipo Usuario No Actualizado";
        }
    }

    public String deleteTipoUsuario(int id) {
        if(tipo_usuarioRepository.deleteTipoUsuario(id)){
            return "Tipo Usuario Eliminado Exitosamente";
        }else{
            return "Tipo Usuario No Eliminado";
        }
    }
}
