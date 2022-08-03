package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonDTO;
import com.bootcamp.deportistas.dto.SportDTO;
import com.bootcamp.deportistas.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {

    @Autowired
    SportService sportService = new SportService();

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> getSports(){
        return new ResponseEntity<>(sportService.getAllSports(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSport/{sportName}")
    public ResponseEntity<SportDTO> getSportByName(@PathVariable  String sportName){
        return new ResponseEntity<>(sportService.getSport(sportName), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> getSportsPersons(){
        return new ResponseEntity<>(sportService.getPersons(), HttpStatus.ACCEPTED);
    }
}
