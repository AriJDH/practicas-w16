package com.example.elastic.controller;

import com.example.elastic.entity.ObrasLiterarias;
import com.example.elastic.service.ObrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObrasController {

    @Autowired
    ObrasService obrasService;

    @PostMapping("/")
    public ResponseEntity<?> createObras(@RequestBody ObrasLiterarias obras){
        return new ResponseEntity<>(obrasService.creaObras(obras), HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<?> listarObras(){
        return new ResponseEntity<>(obrasService.listarObras(), HttpStatus.OK);

    }
    @GetMapping("/{name}")
    public ResponseEntity<?> listarObrasPorAutor(@PathVariable String name){
        return new ResponseEntity<>(obrasService.buscarPorAutor(name), HttpStatus.OK);

    }

    @GetMapping("/pepe/{title}")
    public ResponseEntity<?> libroPorTitulo(@PathVariable String title){
        return new ResponseEntity<>(obrasService.buscaPorTitle(title), HttpStatus.OK);

    }

    @GetMapping("/pe/{paginas}")
    public ResponseEntity<?> libroPorTitulo(@PathVariable Integer paginas){
        return new ResponseEntity<>(obrasService.buscarMayoresPaginas(paginas), HttpStatus.OK);

    }
    @GetMapping("/fecha")
    public ResponseEntity<?> buscarEntreFechas(@RequestParam Integer desde,@RequestParam Integer hasta ){
        return new ResponseEntity<>(obrasService.buscarEntreFechas(desde,hasta), HttpStatus.OK);
    }
    @GetMapping("/fechaMenor")
    public ResponseEntity<?> buscarMenorFecha(@RequestParam Integer d ){
        return new ResponseEntity<>(obrasService.buscarMenoresAFecha(d), HttpStatus.OK);
    }

    @GetMapping("/fechaMayor")
    public ResponseEntity<?> buscarMayorFecha(@RequestParam Integer d ){
        return new ResponseEntity<>(obrasService.buscarMayoresAFecha(d), HttpStatus.OK);
    }
}
