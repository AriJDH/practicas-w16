package com.example.ejerciciocovid_19.controllers;

import com.example.ejerciciocovid_19.dtos.PersonaConSintomasDto;
import com.example.ejerciciocovid_19.dtos.SintomaDto;
import com.example.ejerciciocovid_19.dtos.SintomaGravedadDto;
import com.example.ejerciciocovid_19.service.CovidService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid19RestController {
    @Autowired
    CovidService covidService = new CovidService();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDto>> obtenerListaSintomasCargados(){
        return new ResponseEntity<>(covidService.obtenerListaSintomasCargados(), HttpStatus.OK);
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaGravedadDto> buscarSintoma(@PathVariable String name){
        SintomaGravedadDto retorno = covidService.buscarSintoma(name);
        if(retorno == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(retorno,HttpStatus.OK);
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaConSintomasDto>> buscarPersonasDeRiesgo(){
        return new ResponseEntity<>(covidService.buscarPersonasDeRiesgo(),HttpStatus.OK);
    }

}
