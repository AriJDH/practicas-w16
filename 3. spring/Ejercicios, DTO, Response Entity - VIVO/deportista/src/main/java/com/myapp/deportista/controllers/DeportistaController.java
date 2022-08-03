package com.myapp.deportista.controllers;


import com.myapp.deportista.dtos.AthleteDTO;
import com.myapp.deportista.dtos.SportDTO;
import com.myapp.deportista.services.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class DeportistaController {

    private SportService sportService = new SportService();
    public DeportistaController(SportService sportService){
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> findSports(){

        try {
            return new ResponseEntity<>(sportService.getAllSports(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<SportDTO> findSport(@PathVariable String name) {
        try {
            return new ResponseEntity<>(sportService.getSport(name), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<AthleteDTO>> findSportsPerson() {
        try {
            return new ResponseEntity<>(sportService.findAthlete(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
