package com.ejemplo.deportistas.controller;

import com.ejemplo.deportistas.dto.DeporteDTO;
import com.ejemplo.deportistas.dto.DeportistaDTO;
import com.ejemplo.deportistas.service.DeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeportistasController {

    @Autowired
    private DeportistasService deportistasService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        List<DeporteDTO> deportes = deportistasService.findSports();
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{nombreDeporte}")
    public ResponseEntity<String> findSports(@PathVariable String nombreDeporte) {
        DeporteDTO deporte = deportistasService.findSportsWithName(nombreDeporte);

        if (deporte.getNivel() != null) {
            return new ResponseEntity<>(deporte.getNivel().toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Deporte no existe", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findSportsPersonas")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<DeportistaDTO> personaDeporte = deportistasService.findSportsPersona();

        return new ResponseEntity<>(personaDeporte, HttpStatus.OK);

    }

}
