package com.example.bootcamp.covid19.controller;

import com.example.bootcamp.covid19.dto.PersonaDTO;
import com.example.bootcamp.covid19.dto.SintomaDTO;
import com.example.bootcamp.covid19.service.IService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {
    @Autowired
    IService iservice;

    @GetMapping("/findSymptom")
    public List<SintomaDTO> findSymptom(){
        return iservice.getAllSympton();
    }

    @GetMapping("/findSymptom/{nombre}")
    public SintomaDTO findSymptomByName(@PathVariable String nombre){
        return iservice.getSymptonByName(nombre);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findRiskPerson(){
        return iservice.getRisksPersons();
    }


}
