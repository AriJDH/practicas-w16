package com.bootcamp.edadPersona.controllers;

import com.bootcamp.edadPersona.dtos.EdadDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalcularEdadController {

  @GetMapping("/calcularGet")
  public ResponseEntity<EdadDto> calcularGet(@RequestParam Integer day, @RequestParam Integer month, @RequestParam Integer year ){
    LocalDate localDate = LocalDate.of(year,month,day);
    Integer years = Period.between(localDate, LocalDate.now()).getYears();
    EdadDto edadDto = new EdadDto(years);
    return new ResponseEntity<>(edadDto, HttpStatus.OK);
  }
}
