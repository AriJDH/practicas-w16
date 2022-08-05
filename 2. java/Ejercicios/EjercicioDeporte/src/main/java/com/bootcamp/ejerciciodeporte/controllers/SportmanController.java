package com.bootcamp.ejerciciodeporte.controllers;

import com.bootcamp.ejerciciodeporte.dtos.PersonDto;
import com.bootcamp.ejerciciodeporte.dtos.SportDto;
import com.bootcamp.ejerciciodeporte.entities.Person;
import com.bootcamp.ejerciciodeporte.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SportmanController {

    @Autowired
    Services service;

    @GetMapping("/findSports")
    public ResponseEntity<SportDto> getSports() {
        SportDto sportDto = new SportDto();
        sportDto.setSports(service.getSports());
        return new ResponseEntity<>(sportDto, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getSportByName(@PathVariable String name){
        return new ResponseEntity<>(service.getLevelByName(name),HttpStatus.OK);
    }
@GetMapping("/findSportsPersons")
public ResponseEntity<List<PersonDto>> getSportsMan(){
//        List<PersonDto> personDtoList= new ArrayList<>();
//        for(Person person : service.getPersons()){
//            personDtoList.add(new PersonDto(person.getName(),person.getSubName(),person.getSport().getName()));
//        }
    List<PersonDto> personDtoList1= service.getPersons().stream()
            .map(person -> new PersonDto(person.getName(),person.getSubName(),person.getSport().getName())).collect(Collectors.toList());


return new ResponseEntity<>(personDtoList1,HttpStatus.OK);

}

}
