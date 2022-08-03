package com.spring.Covid19.controller;

import com.spring.Covid19.DTO.PersonaSintomaDTO;
import com.spring.Covid19.DTO.SintomaDTO;
import com.spring.Covid19.services.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    Services service = new Services();
    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> buscarSintomas(){
        return new ResponseEntity<>(service.listarSintomas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<SintomaDTO> buscarSintomaPorNombre(@PathVariable String nombre){
        return new ResponseEntity<>(service.buscarPorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaSintomaDTO>> listarPersonaSintoma(){
        return new ResponseEntity<>(service.listarPersonas(), HttpStatus.ACCEPTED);
    }

}
