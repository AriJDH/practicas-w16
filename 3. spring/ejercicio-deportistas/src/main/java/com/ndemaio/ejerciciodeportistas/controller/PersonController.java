package com.ndemaio.ejerciciodeportistas.controller;

import com.ndemaio.ejerciciodeportistas.dto.PersonDTO;
import com.ndemaio.ejerciciodeportistas.service.PersonService;
import lombok.Getter;
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

    @GetMapping (path = "/findSportsPeople")
    public ResponseEntity<List<PersonDTO>> getSportsPeople() {
        var people = personService.getSportsPeople().stream().map(person -> new PersonDTO(person)).collect(Collectors.toList());
        return ResponseEntity.ok(people);
    }

}
