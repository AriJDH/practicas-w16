package com.example.ejerciciosiniestros.controller;

import com.example.ejerciciosiniestros.dto.SiniestroDTO;
import com.example.ejerciciosiniestros.model.Siniestro;
import com.example.ejerciciosiniestros.service.ISiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/siniestro")
public class SiniestroController {

    ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Siniestro> getSiniestro(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(siniestroService.findSiniestroById(id));
    }

    @GetMapping
    public ResponseEntity<List<Siniestro>> getSiniestros() {
        return ResponseEntity.status(HttpStatus.OK).body(siniestroService.findAllSiniestros());
    }

    @PostMapping("/new")
    public ResponseEntity<Siniestro> createSiniestro(@RequestBody SiniestroDTO siniestroDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(siniestroService.saveSiniestro(siniestroDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<Siniestro> updateSiniestro(@RequestBody Siniestro siniestro) {
        return ResponseEntity.status(HttpStatus.OK).body(siniestroService.updateSiniestro(siniestro));
    }

    @DeleteMapping("delete/{id}")
    public void deleteSiniestro(@PathVariable long id) {
        siniestroService.deleteSiniestro(id);
    }
}
