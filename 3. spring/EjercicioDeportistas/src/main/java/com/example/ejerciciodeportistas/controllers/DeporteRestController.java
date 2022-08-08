package com.example.ejerciciodeportistas.controllers;


import com.example.ejerciciodeportistas.dtos.DeporteDto;
import com.example.ejerciciodeportistas.dtos.DeporteNivelDto;
import com.example.ejerciciodeportistas.dtos.PersonaDto;
import com.example.ejerciciodeportistas.enitty.Deporte;
import com.example.ejerciciodeportistas.service.DeporteSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
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
        DeporteNivelDto retorno = deporteSvc.buscarDeporte(name);
        if(retorno == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        }
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<PersonaDto>>  listarPersonas(){
        return new ResponseEntity<>(deporteSvc.listarPersonas(),HttpStatus.OK);
    }

}
