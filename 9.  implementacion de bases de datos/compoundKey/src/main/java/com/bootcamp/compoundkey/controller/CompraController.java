package com.bootcamp.compoundkey.controller;

import com.bootcamp.compoundkey.DTO.CompraDTO;
import com.bootcamp.compoundkey.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CompraController {

  @Autowired
  ICompraService compraService;

  @PostMapping("/new")
  public ResponseEntity<?> crearCompra(@RequestBody CompraDTO compraDTO){
    return new ResponseEntity<>(compraService.crearCompra(compraDTO), HttpStatus.OK);
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam("id") Integer id, @RequestParam("fecha") String fecha){
    return new ResponseEntity<>(compraService.getById(id, fecha), HttpStatus.OK);
  }
}
