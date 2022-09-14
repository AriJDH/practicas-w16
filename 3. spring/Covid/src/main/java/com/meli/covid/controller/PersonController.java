package com.meli.covid.controller;

import com.meli.covid.dto.PersonDto;
import com.meli.covid.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDto>> findRiskPerson() {
        return new ResponseEntity<>(personService.findRiskPerson(), HttpStatus.OK);
    }
}
