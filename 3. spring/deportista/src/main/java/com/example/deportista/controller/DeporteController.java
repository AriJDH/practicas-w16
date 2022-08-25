package com.example.deportista.controller;

import com.example.deportista.dto.DeporteDTO;
import com.example.deportista.dto.PersonaDTO;
import com.example.deportista.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    DeporteService deporteService = new DeporteService();

    @GetMapping("/findSport")
    public ResponseEntity<List<DeporteDTO>> getAll(){
        return new ResponseEntity<>(deporteService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> getDeporte(@PathVariable String name){
        return new ResponseEntity<>(deporteService.getByName(name),HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSportPerson")
    public ResponseEntity<List<PersonaDTO>> getAllPersona(){
        return new ResponseEntity<>(deporteService.getPersonas(),HttpStatus.ACCEPTED);
    }
}
