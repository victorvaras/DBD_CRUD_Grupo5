package com.example.DBD.Controller;

import com.example.DBD.Models.Usuario;
import com.example.DBD.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {

    UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // get R
    @GetMapping()
    public List<Usuario> getAllUsuario(){
        return usuarioService.getAllUsuario();
    }

    //get by
    @GetMapping("/porTipo/{ID_Tipo_Usuario}")
    public List<Usuario> getUsuarioByTipo(@PathVariable int ID_Tipo_Usuario){
        return usuarioService.getUsuarioByTipo(ID_Tipo_Usuario);
    }

    @GetMapping("/porNombre/{nombre}")
    public List<Usuario> getUsuarioByNombre(@PathVariable String nombre){
        return usuarioService.getUsuarioByNombre(nombre);
    }

    @GetMapping("/porRut/{rut}")
    public List<Usuario> getUsuarioByRut(@PathVariable String rut){
        return usuarioService.getUsuarioByRut(rut);
    }


    // crear C
    @PostMapping("/nuevo")
    public String crearUsuario(@RequestBody Usuario usuario){
       return usuarioService.crearUsuario(usuario);
    }


    // actualizar U
    @PutMapping("/update")
    public String updateUsuario(@RequestBody Usuario Usuario){
        String retorno = usuarioService.updateUsuario(Usuario);
        return retorno;
    }

    // borrar D
    @DeleteMapping("/delete/{Rut}")
    public String borrarUsuario(@PathVariable String Rut){
        String retorno = usuarioService.deleteUsuario(Rut);
        return retorno;
    }

    //iniciar sesión
    @GetMapping("/login/{Correo}/{Contraseña}")
    public String login(@PathVariable String Correo, @PathVariable String Contraseña){
        return usuarioService.loginUsuario(Correo,Contraseña);
    }
}
