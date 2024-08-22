package com.example.DBD.Controller;

import com.example.DBD.Models.Tipo_Usuario;
import com.example.DBD.Services.Tipo_UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_usuario")
@CrossOrigin
public class Tipo_UsuarioController {

    Tipo_UsuarioService tipo_usuarioService;

    @Autowired
    public Tipo_UsuarioController(Tipo_UsuarioService tipo_usuarioService) {
        this.tipo_usuarioService = tipo_usuarioService;
    }

    @GetMapping
    public List<Tipo_Usuario> getAllTipoUsuario() {
        return tipo_usuarioService.getAllTipoUsuario();
    }

    //get by
    @GetMapping("/buscarTipo/{ID_Tipo_Usuario}")
    public List<Tipo_Usuario> getTipoUsuarioById(@PathVariable int ID_Tipo_Usuario){
        return tipo_usuarioService.getTipoUsuarioById(ID_Tipo_Usuario);
    }

    @GetMapping("/buscarId/{Tipo}")
    public List<Tipo_Usuario> getTipoUsuarioByNombre(@PathVariable String Tipo){
        return tipo_usuarioService.getTipoUsuarioByNombre(Tipo);
    }

    @PostMapping("/nuevo")
    public String crearTipoUsuario(@RequestBody Tipo_Usuario tipo_usuario){
        return tipo_usuarioService.crearTipoUsuario(tipo_usuario);
    }

    @PutMapping("/update")
    public String updateTipo_Usuario(@RequestBody Tipo_Usuario tipo_usuario){
        return tipo_usuarioService.updateTipoUsuario(tipo_usuario);
    }

    // borrar D
    @DeleteMapping("/delete/{ID_Tipo_Usuario}")
    public String deleteTipo_Usuario(@PathVariable int ID_Tipo_Usuario){
        return tipo_usuarioService.deleteTipoUsuario(ID_Tipo_Usuario);
    }

}
