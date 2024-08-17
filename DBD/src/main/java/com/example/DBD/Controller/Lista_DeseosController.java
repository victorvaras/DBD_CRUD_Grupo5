package DBD.borradorMio.Controllers;

import DBD.borradorMio.Models.Lista_deseos;
import DBD.borradorMio.Servicies.Lista_DeseosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ListaDeseos")
@CrossOrigin
public class Lista_DeseosController {

    Lista_DeseosService listaDeseosService;

    @Autowired
    public Lista_DeseosController(Lista_DeseosService listaDeseosService) {
        this.listaDeseosService = listaDeseosService;
    }

    @GetMapping
    public List<Lista_deseos> getAllListaDeseos() {
        return listaDeseosService.getAllListaDeseos();
    }

    //get by's
    @GetMapping("/buscarPorID/{ID_Lista_Deseos}")
    public List<Lista_deseos> getListaDeseosByID(@PathVariable int ID_Lista_Deseos) {
        return listaDeseosService.getListaDeseosByID(ID_Lista_Deseos);
    }

    @PostMapping("/nueva")
    public String crearListaDeseos(@RequestBody Lista_deseos lista_deseos) {
        return listaDeseosService.createListaDeseo(lista_deseos);
    }

    @PutMapping("/update")
    public String updateListaDeseos(@RequestBody Lista_deseos listaDeseos) {
        return listaDeseosService.updateListaDeseo(listaDeseos);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteListaDeseos(@PathVariable int id) {
        return listaDeseosService.deleteListaDeseo(id);
    }




}
