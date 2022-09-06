package com.bootcamp.literarias.controller;

import com.bootcamp.literarias.dto.ObraDto;
import com.bootcamp.literarias.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ObraController {

    @Autowired
    IObraService obraService;

    @PostMapping("")
    public ResponseEntity<ObraDto> create(@RequestBody ObraDto obraDto) {
        return new ResponseEntity<>(obraService.create(obraDto), HttpStatus.OK);
    }

    @GetMapping("/autor")
    public ResponseEntity<List<ObraDto>> getNombreAutor(@RequestParam("nombre") String nombre) {
        return new ResponseEntity<>(obraService.findByAutor(nombre), HttpStatus.OK);
    }

    @GetMapping("/obra")
    public ResponseEntity<List<ObraDto>> getNombreObraContaining(@RequestParam("nombre") String nombre) {
        return new ResponseEntity<>(obraService.findByObraContaining(nombre), HttpStatus.OK);
    }

    @GetMapping("/cantidad-pag")
    public ResponseEntity<List<ObraDto>> getCantidadPaginasGreaterThan(@RequestParam("pag") Integer pag) {
        return new ResponseEntity<>(obraService.findByCantidadPaginasGreaterThan(pag), HttpStatus.OK);
    }

    @GetMapping("/obra-anio-before")
    public ResponseEntity<List<ObraDto>> getAnioPublicacionBefore(@RequestParam("anio") Integer anio) {
        return new ResponseEntity<>(obraService.findByAnioPublicacionLessThanEqual(anio), HttpStatus.OK);
    }

    @GetMapping("/obra-anio-after")
    public ResponseEntity<List<ObraDto>> getAnioPublicacionAfter(@RequestParam("anio") Integer anio) {
        return new ResponseEntity<>(obraService.findByAnioPublicacionGreaterThanEqual(anio), HttpStatus.OK);
    }

    @GetMapping("/editorial")
    public ResponseEntity<List<ObraDto>> getEditorial(@RequestParam("editorial") String editorial) {
        return new ResponseEntity<>(obraService.findByEditorial(editorial), HttpStatus.OK);
    }
}
