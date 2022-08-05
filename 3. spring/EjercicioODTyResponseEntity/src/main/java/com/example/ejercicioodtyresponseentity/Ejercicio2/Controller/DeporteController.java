package com.example.ejercicioodtyresponseentity.Ejercicio2.Controller;

import com.example.ejercicioodtyresponseentity.Ejercicio2.Entity.Deporte;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Service.DeporteService;
import com.example.ejercicioodtyresponseentity.Ejercicio2.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class DeporteController {
    @Autowired
    private DeporteService deporteService;
    private PersonaService personaService;
    @GetMapping(path = "/Deporte/{nombreDeporte}/{nivelDeporte}")
    public ResponseEntity<List> addDeporte(@PathVariable String nombreDeporte, @PathVariable String nivelDeporte ){
        return new ResponseEntity<>(this.deporteService.addDeporte(nombreDeporte,nivelDeporte), HttpStatus.OK);

    }



}
