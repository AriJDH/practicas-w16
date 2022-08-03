package com.example.ejcovid19.controllers;

import com.example.ejcovid19.entities.Persona;
import com.example.ejcovid19.entities.Sintoma;
import com.example.ejcovid19.services.PersonaService;
import com.example.ejcovid19.services.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class Controller {

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> getAll(){
        SintomaService sintomaService = new SintomaService();
        return new ResponseEntity<>(sintomaService.getSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSympton(@PathVariable String name){
        SintomaService sintomaService = new SintomaService();

        var res = sintomaService.getSintoma(name);

        if (res == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(res.getNivel_de_gravedad(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<Stream<String>> getAllRiskPerson(){
        PersonaService personaService = new PersonaService();

        var res = personaService.getPersonasEnRiesgo().stream().map(p -> {
            var xd =  p.getPersona().getNombre() + " " + p.getPersona().getApellido();
            return xd;
        });

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
