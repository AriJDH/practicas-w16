package com.bootcamp.ejerciciocovid19.controller;

import com.bootcamp.ejerciciocovid19.dto.*;
import com.bootcamp.ejerciciocovid19.service.findService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    findService service;

    @RequestMapping("/findSymphtom")
    public ResponseEntity<ResponseSymphotmsDto> findSymhtoms() {
        return service.getSymphtomsDto();
    }

    @RequestMapping("/findSymphtom/{name}")
    public ResponseEntity<SymphtomDtoMessage> findSymptomByName(@PathVariable String name) {
        return service.getSymphtomsByName(name);
    }

    @RequestMapping("/findRiskPerson")
    public ResponseEntity<ResponseRiskPersonDto> findRiskPerson(){
        return service.getRiskPersons();
    }

}

