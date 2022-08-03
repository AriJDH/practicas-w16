package com.bootcamp.ejercicioDeportistas.controllers;

import com.bootcamp.ejercicioDeportistas.dtos.SportDto;
import com.bootcamp.ejercicioDeportistas.dtos.SportPersonsDto;
import com.bootcamp.ejercicioDeportistas.services.ServiceSport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {
  @Autowired
  private ServiceSport serviceSport;

  @GetMapping("/findSports")
  public ResponseEntity<List<SportDto>> getAllSports() {
    return new ResponseEntity<>(serviceSport.getAllSports(), HttpStatus.OK);
  }

  @GetMapping("/findSport/{name}")
  public ResponseEntity<SportDto> getSport(@PathVariable String name){
    return new ResponseEntity<>(serviceSport.getSport(name), HttpStatus.OK);
  }

  @GetMapping("/findSportsPersons")
  public ResponseEntity<SportPersonsDto> findSportsPersons(@RequestParam String name){
    return new ResponseEntity<>(serviceSport.getSportPersons(name), HttpStatus.OK);
  }
}
