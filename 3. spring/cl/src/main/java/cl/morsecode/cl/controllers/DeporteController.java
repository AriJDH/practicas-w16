package cl.morsecode.cl.controllers;

import cl.morsecode.cl.dto.Persona_Deporte_DTO;
import cl.morsecode.cl.entities.deportista.Deporte;
import cl.morsecode.cl.entities.deportista.Persona;
import cl.morsecode.cl.services.deportes.DeportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deporte")
public class DeporteController {

    @Autowired
    private DeportesService deportesService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getDeportes(){
        return new ResponseEntity<>(deportesService.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> getDeporte(@PathVariable String name){
        return new ResponseEntity<>(deportesService.findDeporte(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Deporte> addDeporte(@RequestBody Deporte deporte){
        return new ResponseEntity<>(deportesService.addDeporte(deporte),HttpStatus.OK);
    }

    @PostMapping("/persona")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona) {
        return new ResponseEntity<>(deportesService.addPersona(persona), HttpStatus.OK);
    }

    @PostMapping("/deportista")
    public ResponseEntity<Persona_Deporte_DTO> addDeportista(@RequestBody Persona_Deporte_DTO deportista){
        return new ResponseEntity<>(deportesService.addDeportista(deportista), HttpStatus.OK);
    }

    @GetMapping("/deportistas")
    public ResponseEntity<List<Persona_Deporte_DTO>> getDeportistas(){
        return new ResponseEntity<>(deportesService.getDeportistas(), HttpStatus.OK);
    }
}
