package com.example.covid.controller;

import com.example.covid.dto.PersonaDto;
import com.example.covid.dto.SintomaDto;
import com.example.covid.service.ServicioPersonasSintomas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("covid")
public class CovidContoller {

    ServicioPersonasSintomas service = new ServicioPersonasSintomas();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDto>> obtenerSintomas(){
        return new ResponseEntity<>(service.obtenerSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDto> obtenerSintomaNombre(@PathVariable String nombre){
        return new ResponseEntity<>(service.obtenerSintomaNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDto>> obtenerPersonaSeveridad(){
        return new ResponseEntity<>(service.obtenerPersonaSeveridad(), HttpStatus.OK);
    }

}
