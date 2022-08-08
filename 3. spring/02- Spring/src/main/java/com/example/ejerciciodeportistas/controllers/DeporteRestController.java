package com.example.ejerciciodeportistas.controllers;


import com.example.ejerciciodeportistas.dto.deporte.DeporteDto;
import com.example.ejerciciodeportistas.dto.deporte.DeporteNivelDto;
import com.example.ejerciciodeportistas.dto.deporte.PersonaDto;
import com.example.ejerciciodeportistas.service.DeporteSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteRestController {

    @Autowired
    DeporteSvc deporteSvc = new DeporteSvc();

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> listarDeportes(){

        return new ResponseEntity<>(deporteSvc.listarDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteNivelDto>  buscarDeporte(@PathVariable String name){
        if(deporteSvc.buscarDeporte(name) == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(deporteSvc.buscarDeporte(name), HttpStatus.OK);
        }
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDto>>  listarPersonas(){
        return new ResponseEntity<>(deporteSvc.listarPersonas(),HttpStatus.OK);
    }

}
