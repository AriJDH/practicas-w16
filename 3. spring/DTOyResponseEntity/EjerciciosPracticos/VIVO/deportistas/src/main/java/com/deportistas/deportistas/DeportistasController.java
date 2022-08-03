package com.deportistas.deportistas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deportistas.service.SportService;

import com.deportistas.dto.Deporte;
import com.deportistas.dto.DeportistaDTO;

@RestController
public class DeportistasController {

    SportService deportistaService;

    public DeportistasController() {
        this.deportistaService = new SportService();
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        List<Deporte> sports = deportistaService.findAll();

        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> findSport(@PathVariable String name) {
        Deporte sport = deportistaService.findByName(name);
        
        if(sport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(sport, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        List<DeportistaDTO> sportsPersons = deportistaService.findSportsPersons();

        return new ResponseEntity<>(sportsPersons, HttpStatus.OK);
    }
}
