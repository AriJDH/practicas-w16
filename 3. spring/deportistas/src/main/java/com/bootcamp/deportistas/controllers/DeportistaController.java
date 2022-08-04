package com.bootcamp.deportistas.controllers;

import com.bootcamp.deportistas.dtos.AthleticPersonDto;
import com.bootcamp.deportistas.dtos.SportDTO;
import com.bootcamp.deportistas.services.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistaController {

    @Autowired
    private SportService service;



    @GetMapping("/sports")
    public ResponseEntity<List<SportDTO>> findSports() {
            return new ResponseEntity<>(service.getAllSports(), HttpStatus.OK);
    }

    @GetMapping("/sports/{name}")
    public ResponseEntity<SportDTO> findSport(@PathVariable String name) {
            return new ResponseEntity<>(service.getSport(name), HttpStatus.OK);
    }

    @GetMapping("/sportsPeople")
    public ResponseEntity<List<AthleticPersonDto>> findSportsPeople() {
            return new ResponseEntity<>(service.findSportsPeople(), HttpStatus.OK);

    }
}
