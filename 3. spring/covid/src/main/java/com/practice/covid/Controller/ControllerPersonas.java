package com.practice.covid.Controller;

import com.practice.covid.DTO.PersonasConRiesgoDTO;
import com.practice.covid.Service.ServicePersonas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerPersonas {

    @Autowired
    ServicePersonas servicePersonas;

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonasConRiesgoDTO>> findSymptom() {
        List<PersonasConRiesgoDTO> result = servicePersonas.findRiskPerson();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
