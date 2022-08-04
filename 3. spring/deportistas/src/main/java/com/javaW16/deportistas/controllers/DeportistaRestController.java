package com.javaW16.deportistas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class DeportistaRestController {

@PostMapping("/addPerson")

   public <T> ResponseEntity<T> addPerson(
      @RequestParam String name,
      @RequestParam String lastName,
      @RequestParam Integer age
){
   return
   }

}
