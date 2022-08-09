package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.request.QueryDeporteDTO;
import com.bootcamp.deportistas.dto.response.DeporteDTO;
import com.bootcamp.deportistas.dto.response.PersonaDTO;
import com.bootcamp.deportistas.service.ServiceDeporte;
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
    ServiceDeporte serviceDeporte;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> getDeportes() {
        return new ResponseEntity<> (serviceDeporte.getAllDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findDeporte(@PathVariable QueryDeporteDTO name) {
        return new ResponseEntity<>(serviceDeporte.getDeporte(name.getName()), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>>  getPersonasDeporte() {
        return  new ResponseEntity<>((serviceDeporte.getPersonas()), HttpStatus.OK);
    }
}
