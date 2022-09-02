package com.bootcamp.ejerciciovehiculossiniestros.controller;

import com.bootcamp.ejerciciovehiculossiniestros.dto.SiniestroDto;
import com.bootcamp.ejerciciovehiculossiniestros.service.ServiceSiniestro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SiniestroController {
    @Autowired
    ServiceSiniestro serviceSiniestro;

    @PostMapping("/reportarsiniestro")
    public ResponseEntity<?> reportarSiniestro(@RequestBody SiniestroDto siniestroDto) {
        serviceSiniestro.reportarSiniestro(siniestroDto);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/obtenersiniestro/{id}")
    public ResponseEntity<SiniestroDto> obtenerSiniestro(@PathVariable Long id) {
        return new ResponseEntity<>(serviceSiniestro.obtenerSiniestro(id), HttpStatus.OK);
    }

    @GetMapping("/obt")
    public ResponseEntity<?> obtenerMarcaModeloYPatenteByPerdida(){
        return new ResponseEntity<>(serviceSiniestro.obtenerMarcaModeloYPatenteByPerdida(),HttpStatus.OK);
    }

    @GetMapping("/obten")
    public ResponseEntity<?> obtenerMarcaModeloYPatenteTotalPerdida(){
        return new ResponseEntity<>(serviceSiniestro.obtenerMarcaModeloYPatenteTotalPerdida(),HttpStatus.OK);
    }

}
