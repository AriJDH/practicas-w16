package com.bootcamp.deportes.controller;


import com.bootcamp.deportes.dto.DeporteDTO;
import com.bootcamp.deportes.models.Deporte;
import com.bootcamp.deportes.dto.SportPersonDTO;
import com.bootcamp.deportes.services.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        return new ResponseEntity<>(deporteService.findSports(), HttpStatus.OK);
    }
    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> findSportsByName(@PathVariable String name){
        return new ResponseEntity<>(deporteService.findSportByName(name), HttpStatus.OK);
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> findSportsPerson(){
        return new ResponseEntity<>(deporteService.findSportPerson(), HttpStatus.OK);
    }
}
