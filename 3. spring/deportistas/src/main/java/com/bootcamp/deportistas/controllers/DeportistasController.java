package com.bootcamp.deportistas.controllers;

import com.bootcamp.deportistas.dtos.AtheltePersonDTO;
import com.bootcamp.deportistas.dtos.SportDTO;
import com.bootcamp.deportistas.entities.Sport;
import com.bootcamp.deportistas.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistasController {

    private final SportService service;

    public DeportistasController(SportService service) {
        this.service = service;
    }

    @GetMapping("/sports")
    public ResponseEntity<List<SportDTO>> findSports() {
        try {
            return new ResponseEntity<>(service.getAllSports(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/sports/{name}")
    public ResponseEntity<SportDTO> findSport(@PathVariable String name) {
        try {
            return new ResponseEntity<>(service.getSport(name), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sportsPeople")
    public ResponseEntity<List<AtheltePersonDTO>> findSportsPeople() {
        try {
            return new ResponseEntity<>(service.findSportsPeople(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
