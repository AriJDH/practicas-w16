package com.bootcamp.covid19.controllers;

import com.bootcamp.covid19.entities.PersonaDTO;
import com.bootcamp.covid19.entities.SintomaDTO;
import com.bootcamp.covid19.services.PersonaSintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PersonaSintomaController {
  private final PersonaSintomaService personaSintomaService;

  public PersonaSintomaController(PersonaSintomaService personaSintomaService) {
    this.personaSintomaService = personaSintomaService;
  }

  @GetMapping("/findSymptom")
  public ResponseEntity<List<SintomaDTO>> getAllSintomas() {
    return new ResponseEntity<>(personaSintomaService.getAllSintomas(), HttpStatus.OK);
  }

  @GetMapping("/findSymptom/{nombre}")
  public ResponseEntity<?> getRiesgoSintoma(@PathVariable String nombre) {
    try {
      return new ResponseEntity<>(personaSintomaService.getRiesgoSintoma(nombre), HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>("No se pudo encontrar un síntoma con ese nombre", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/findRiskPerson")
  public ResponseEntity<List<PersonaDTO>> getAllGrupoRiesgo() {
    return new ResponseEntity<>(personaSintomaService.getAllGrupoRiesgo(), HttpStatus.OK);
  }
}
