package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonSportDto;
import com.bootcamp.deportistas.dto.SportDto;
import com.bootcamp.deportistas.repository.SportRepo;
import com.bootcamp.deportistas.services.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class DeportistasController {

    SportService sportService = new SportService();

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> findAllSports(){
        return new ResponseEntity<>( sportService.getAllSports(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<SportDto> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(sportService.getSportByName(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonSportDto>> findSportsPerson(){
        return new ResponseEntity<>(sportService.findPersonSport(), HttpStatus.ACCEPTED);
    }

}
