package com.javaW16.startWars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.javaW16.startWars.dto.RequestPersonajeDTO;
import com.javaW16.startWars.dto.ResponsePersonajeDto;
import com.javaW16.startWars.service.Service;

@RestController
public class Controller {

   @Autowired
   private Service service;

   @PostMapping("/carga")
   public ResponseEntity<String> cargaPersonaje(@RequestBody List<RequestPersonajeDTO> body) {

      service.cargaPersonajes(body);
      return new ResponseEntity<>("carga ok", HttpStatus.OK);

   }

   @GetMapping("/getName/{name}")
   public ResponseEntity<List<ResponsePersonajeDto>> getName(@PathVariable String name) {

      return new ResponseEntity<>(service.getPersonaje(name), HttpStatus.OK);
   }

}
