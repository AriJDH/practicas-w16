package com.bootcamp.ejercicioDeportistas.controllers;

import com.bootcamp.ejercicioDeportistas.dtos.SportDto;
import com.bootcamp.ejercicioDeportistas.services.ServiceSport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {
  private ServiceSport serviceSport;
  @GetMapping("/findSports")
  public ResponseEntity<List<SportDto>> getAllSports(){
    return new ResponseEntity<>(serviceSport.getAllSports(), HttpStatus.OK);
  }
}
