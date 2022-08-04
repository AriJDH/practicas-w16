package com.bootcamp.covid19.controlador;

import com.bootcamp.covid19.dtos.NivelDeGavedadSintomaDTO;
import com.bootcamp.covid19.dtos.PersonasDeRiesgoDTO;
import com.bootcamp.covid19.dtos.SintomasDTO;
import com.bootcamp.covid19.service.CovidSVC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid19Controller {

    @Autowired
    private CovidSVC service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomasDTO>> allSymptom(){

        return new ResponseEntity<>(service.findAllSymptoms(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<NivelDeGavedadSintomaDTO> findSymptomByName(@PathVariable String name){

        if(service.findSymptom(name) == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(service.findSymptom(name), HttpStatus.OK);
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonasDeRiesgoDTO>> findRiskPerson(){

        return new ResponseEntity<>(service.personasDeRiesgo(),HttpStatus.OK);
    }


}
