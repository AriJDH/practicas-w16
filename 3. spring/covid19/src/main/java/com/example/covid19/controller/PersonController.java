package com.example.covid19.controller;

import com.example.covid19.dto.request.PersonReqDTO;
import com.example.covid19.dto.response.FindRiskPersonDTO;
import com.example.covid19.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @GetMapping("/{name}")
    public ResponseEntity<List<FindRiskPersonDTO>> findRiskPerson() {
        return new ResponseEntity<>(this.personService.findRiskPerson(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity add(@RequestBody PersonReqDTO person) {
        this.personService.add(person);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/{personId}/symthomp/{symthompId}")
    public ResponseEntity addSymthomp(@PathVariable Integer personId, @PathVariable Integer symthompId) {
        this.personService.addSymthomp(personId, symthompId);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
