package com.bootcamp.elastic.controller;

import java.util.List;

import com.bootcamp.elastic.entity.Obra;
import com.bootcamp.elastic.service.IObraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ObraController
 */
@RestController
@RequestMapping("/obra")

public class ObraController {
   
   @Autowired
   IObraService service;

   @PostMapping("")   
   public ResponseEntity<List<Obra>> createObras (@RequestBody List<Obra> listObras) {
      return new ResponseEntity<>(service.createObras(listObras),HttpStatus.CREATED);   
   }

   @GetMapping("")
   public ResponseEntity<Iterable<Obra>> listObras () {
      return new ResponseEntity<>(service.listObras(),HttpStatus.OK);   
   }

   @GetMapping("/{nombre}")
   public ResponseEntity<Iterable<Obra>> findByNombreAutor (@PathVariable String nombre){
      return new ResponseEntity<>(service.findByNombreAutor(nombre),HttpStatus.OK);   
   }

   @GetMapping("/obrabynombre")
   public ResponseEntity<Iterable<Obra>> findByNombreObraLike (@RequestParam String nombre){
      return new ResponseEntity<>(service.findByNombreObraLike(nombre),HttpStatus.OK);   
   }

   @GetMapping("/obrasbycantidadpaginas")
   public ResponseEntity <Iterable<Obra>> findByCantidadDePaginasGreaterThan(@RequestParam Integer pages){
      return new ResponseEntity<>(service.findByCantidadDePaginasGreaterThan(pages),HttpStatus.OK);   
   }

   @GetMapping("/afterfecha")
   public ResponseEntity <Iterable<Obra>> findByAnioPublicacionAfter(@RequestParam String fecha) {
      return new ResponseEntity<>(service.findByAnioPublicacionAfter(fecha),HttpStatus.OK);   
   }

}
