package com.bootcamp.obras_literarias.controller;

import com.bootcamp.obras_literarias.model.ObrasLiterarias;
import com.bootcamp.obras_literarias.service.IObrasLiterariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obrasLiterarias")
public class ObrasLiterariasController {
    @Autowired
    private IObrasLiterariasService obrasLiterariasService;

    @GetMapping
    public ResponseEntity<List<ObrasLiterarias>> findAll() {
        return new ResponseEntity<>(obrasLiterariasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("autor/{autor}")
    public ResponseEntity<List<ObrasLiterarias>> findByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(obrasLiterariasService.findByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("titulo/{titulo}")
    public ResponseEntity<List<ObrasLiterarias>> findByTitulo(@PathVariable String titulo) {
        return new ResponseEntity<>(obrasLiterariasService.findByTitulo(titulo), HttpStatus.OK);
    }

    @GetMapping("cantidadPaginas/{paginas}")
    public ResponseEntity<List<ObrasLiterarias>> findByCantidadPaginas(@PathVariable Integer paginas) {
        return new ResponseEntity<>(obrasLiterariasService.findByCantidadPaginas(paginas), HttpStatus.OK);
    }

    @GetMapping("publicadosAntes/{anio}")
    public ResponseEntity<List<ObrasLiterarias>> findByAnioPublicacionLessThan(@PathVariable Integer anio) {
        return new ResponseEntity<>(obrasLiterariasService.findByAnioPublicacionLessThan(anio), HttpStatus.OK);
    }

    @GetMapping("publicadosDespues/{anio}")
    public ResponseEntity<List<ObrasLiterarias>> findByAnioPublicacionGreaterThan(@PathVariable Integer anio) {
        return new ResponseEntity<>(obrasLiterariasService.findByAnioPublicacionGreaterThan(anio), HttpStatus.OK);
    }

    @GetMapping("editorial/{editorial}")
    public ResponseEntity<List<ObrasLiterarias>> findByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(obrasLiterariasService.findByEditorial(editorial), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<ObrasLiterarias>> save(@RequestBody List<ObrasLiterarias> obrasLiterarias) {
        return new ResponseEntity<>(obrasLiterariasService.save(obrasLiterarias), HttpStatus.OK);
    }
}
