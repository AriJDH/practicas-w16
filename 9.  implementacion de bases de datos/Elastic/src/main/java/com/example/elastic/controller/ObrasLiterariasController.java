package com.example.elastic.controller;

import com.example.elastic.model.ObrasLiterarias;
import com.example.elastic.service.IObrasLiterariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obrasLiterarias")
public class ObrasLiterariasController {

    @Autowired
    IObrasLiterariasService service;


    @GetMapping("/{autor}")
    public ResponseEntity<List<ObrasLiterarias>> findByAutor(@PathVariable String autor)
    {
        return  new ResponseEntity<>(service.findByAutor(autor), HttpStatus.OK);
    }

    @PostMapping("/save")
    public  ResponseEntity<List<ObrasLiterarias>> save(@RequestBody List<ObrasLiterarias> literarias)
    {
        return new ResponseEntity<>(service.save(literarias),HttpStatus.OK);
    }

}
