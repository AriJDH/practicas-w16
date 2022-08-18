package com.example.sports.controller;

import com.example.sports.dto.response.PersonWithSportDTO;
import com.example.sports.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonWithSportDTO>> findSportsPersons() {
        return new ResponseEntity<>(this.personService.findSportsPersons(), HttpStatus.OK);
    }
}
