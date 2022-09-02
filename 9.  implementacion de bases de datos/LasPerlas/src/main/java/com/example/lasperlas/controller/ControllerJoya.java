package com.example.lasperlas.controller;

import com.example.lasperlas.model.Joya;
import com.example.lasperlas.service.IServiceJoya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerJoya {
    @Autowired
    private IServiceJoya servisJoya;

    @PostMapping("/create")
    public ResponseEntity<String> createJoya(@RequestBody Joya joya){
        servisJoya.saveJoya(joya);
        return new ResponseEntity<>("Has creado una joya",HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Joya>> getAll(){
        return new ResponseEntity<>(servisJoya.getJoya(),HttpStatus.OK);
    }

}
