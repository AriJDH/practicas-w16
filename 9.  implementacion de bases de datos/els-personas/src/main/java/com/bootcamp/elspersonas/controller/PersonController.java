package com.bootcamp.elspersonas.controller;

import com.bootcamp.elspersonas.model.Person;
import com.bootcamp.elspersonas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        personService.createPerson(person);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<?> deletePersonById(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping (path = "/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id) {
        return new ResponseEntity(personService.getPersonById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllPersons() {
        return new ResponseEntity(personService.getPersons(),HttpStatus.OK);
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<?> updatePerson(@RequestBody Person updatedPerson, @PathVariable Long id) {
        personService.updatePerson(id, updatedPerson);
        return new ResponseEntity(HttpStatus.OK);
    }

}