package com.grupodeportista.personasdeportes.controller;

import com.grupodeportista.personasdeportes.dto.DeporteDto;
import com.grupodeportista.personasdeportes.dto.PersonaDto;
import com.grupodeportista.personasdeportes.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
public class DeporteController {

    DeporteService deporteService = new DeporteService();


    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> findAllSports(){

        return new ResponseEntity<>(deporteService.getAllDeporteDto(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDto> findSport(@PathVariable String name){

        return new ResponseEntity<>(deporteService.getDeporteDto(name), HttpStatus.OK);
    }


    @GetMapping("/findSportsPersons")
    public  ResponseEntity<List<PersonaDto>> findPerson(){
        return new ResponseEntity<>(deporteService.getAllPerson(), HttpStatus.OK);
    }


}
