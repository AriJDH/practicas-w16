package com.bootcamp.sport.controllers;

import com.bootcamp.sport.entity.PersonDTO;
import com.bootcamp.sport.entity.SportsDTO;
import com.bootcamp.sport.services.SportPersonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportPersonController {
    private final SportPersonService sportPersonService;

    public SportPersonController(SportPersonService sportPersonService) {
        this.sportPersonService = sportPersonService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<SportsDTO> findAllSports(){
        return new ResponseEntity<>(sportPersonService.findAllSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name){
        try {
            return new ResponseEntity<>(sportPersonService.findSport(name), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("No existe el deporte ingresado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> findAllPersons(){
        return new ResponseEntity<>(sportPersonService.findAllPersons(), HttpStatus.OK);
    }
}
