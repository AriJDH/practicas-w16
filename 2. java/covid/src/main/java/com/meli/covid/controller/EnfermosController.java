package com.meli.covid.controller;

import com.meli.covid.dtos.Pasientedtos;
import com.meli.covid.entity.Persona;
import com.meli.covid.entity.Sintoma;
import com.meli.covid.service.PersonaService;
import com.meli.covid.service.SymptomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnfermosController {

    SymptomService serviceSintoma = new SymptomService();
    PersonaService personaService =new PersonaService();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> getSintomas()
    {

        return ResponseEntity.ok(serviceSintoma.getSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> getSintoma(@PathVariable String name){
        return ResponseEntity.ok(serviceSintoma.getSintomas().stream().filter(x-> x.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null));
    }


    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Pasientedtos>> getRiskPersons()
    {

        return ResponseEntity.ok(personaService.getRiskPerson());
    }


}
