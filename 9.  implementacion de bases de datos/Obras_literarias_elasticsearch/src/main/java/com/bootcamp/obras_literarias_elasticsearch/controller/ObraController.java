package com.bootcamp.obras_literarias_elasticsearch.controller;

import com.bootcamp.obras_literarias_elasticsearch.dto.ObraDto;
import com.bootcamp.obras_literarias_elasticsearch.service.IObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObraController {

    private final IObraService iObraService;

    public ObraController(IObraService iObraService) {
        this.iObraService = iObraService;
    }

    @PostMapping("/obra")
    public ResponseEntity<?> createObra(@RequestBody ObraDto obraDto){
        return new ResponseEntity<>(iObraService.createObra(obraDto), HttpStatus.OK);
    }

    @GetMapping("/obra/{autor}")
    public ResponseEntity<?> getObrasByAutor(@PathVariable String autor){
        return new ResponseEntity<>(iObraService.getObrasByAuthor(autor), HttpStatus.OK);
    }

    @GetMapping("/obra/titulo/{nombreObra}")
    public ResponseEntity<?> getObrasByNombreObra(@PathVariable String nombreObra){
        return new ResponseEntity<>(iObraService.findByNombreObra(nombreObra), HttpStatus.OK);
    }

    @GetMapping("/obra/paginas/{cantidadPaginas}")
    public ResponseEntity<?> getObrasByCantidadPaginas(@PathVariable Integer cantidadPaginas){
        return new ResponseEntity<>(iObraService.getByCantidadPaginas(cantidadPaginas), HttpStatus.OK);
    }

    @GetMapping("/obra/publicacionAntes/{anioPrimeraPublicacion}")
    public ResponseEntity<?> getObrasByAnioPublicacionAntes(@PathVariable Integer anioPrimeraPublicacion){
        return new ResponseEntity<>(iObraService.getByAnioPublicacionLessThan(anioPrimeraPublicacion), HttpStatus.OK);
    }

    @GetMapping("/obra/publicacionDespues/{anioPrimeraPublicacion}")
    public ResponseEntity<?> getObrasByAnioPublicacionDespues(@PathVariable Integer anioPrimeraPublicacion){
        return new ResponseEntity<>(iObraService.getByAnioPublicacionGreaterThan(anioPrimeraPublicacion), HttpStatus.OK);
    }

}
