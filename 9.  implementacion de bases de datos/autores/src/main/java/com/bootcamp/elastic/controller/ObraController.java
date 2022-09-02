package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.entity.Obra;
import com.bootcamp.elastic.repository.ObraRepository;
import com.bootcamp.elastic.service.ObraService;
import com.bootcamp.elastic.service.IObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraController {

    ObraRepository obraRepository;

    IObraService obraService;

    public ObraController(ObraRepository obraRepository, ObraService obraService){
        this.obraRepository = obraRepository;
        this.obraService = obraService;
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<?> findByAutor(@PathVariable String autor){
        return new ResponseEntity<>(obraService.findByAutor(autor), HttpStatus.FOUND);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> findByNombreContaining(@PathVariable String nombre){
        return new ResponseEntity<>(obraService.findByNombreContaining(nombre), HttpStatus.FOUND);
    }

    @GetMapping("/cantPaginas/{cantidadPaginas}")
    public ResponseEntity<?> findByCantPaginasGreaterThan(@PathVariable Integer cantidadPaginas){
        return new ResponseEntity<>(obraService.findByCantPaginasGreaterThan(cantidadPaginas), HttpStatus.FOUND);
    }

    @GetMapping("/anioAfter/{fecha}")
    public ResponseEntity<?> findByAnioPublicacionAfter(@PathVariable Integer fecha){
        return new ResponseEntity<>(obraService.findByAnioPublicacionAfter(fecha), HttpStatus.FOUND);
    }

    @GetMapping("/anioBefore/{fecha}")
    public ResponseEntity<?> findByAnioPublicacionBefore(@PathVariable Integer fecha){
        return new ResponseEntity<>(obraService.findByAnioPublicacionBefore(fecha), HttpStatus.FOUND);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> findByAnioPublicacionBefore(@PathVariable String editorial){
        return new ResponseEntity<>(obraService.findByEditorial(editorial), HttpStatus.FOUND);
    }
}
