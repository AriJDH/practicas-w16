package com.bootcamp.covid19.controller;


import com.bootcamp.covid19.dto.PersonDto;
import com.bootcamp.covid19.dto.SymptonDto;
import com.bootcamp.covid19.service.SymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomController {

    SymptomService service = new SymptomService();


    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptonDto>> findSymptoms(){

        return new ResponseEntity<>(service.findSysptomsDto(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptonDto> findSymptom(@PathVariable String name){

        return new ResponseEntity<>(service.findSystomDto(name), HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<List<PersonDto>> findSymptomPerson(){

        return new ResponseEntity<>(service.findPersonSymptom(), HttpStatus.OK);
    }


}
