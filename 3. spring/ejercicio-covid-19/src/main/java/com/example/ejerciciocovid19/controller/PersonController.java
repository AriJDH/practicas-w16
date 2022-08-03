package com.example.ejerciciocovid19.controller;

import com.example.ejerciciocovid19.dto.RiskPersonDTO;
import com.example.ejerciciocovid19.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping (path = "/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> riskPersons() {
        var people = personService.getRiskPersons().stream().map(person -> new RiskPersonDTO(person.getName(), person.getSurname())).collect(Collectors.toList());
        return ResponseEntity.ok(people);
    }


}
