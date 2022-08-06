package com.example.ejercicioCovid19.controller;

import com.example.ejercicioCovid19.dto.PersonaDTO;
import com.example.ejercicioCovid19.dto.SintomaDTO;
import com.example.ejercicioCovid19.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class CovidController {

    SintomaService sintomaService = new SintomaService();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> listarSintomas(){
        return new ResponseEntity<>(sintomaService.getSintomas(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> listarSintoma(@PathVariable String name){
        return new ResponseEntity<>(sintomaService.getSintomaName(name),HttpStatus.ACCEPTED);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> listarPersonasSintomas(){
        return new ResponseEntity<>(sintomaService.findSintomaPersona(),HttpStatus.ACCEPTED);
    }

}
