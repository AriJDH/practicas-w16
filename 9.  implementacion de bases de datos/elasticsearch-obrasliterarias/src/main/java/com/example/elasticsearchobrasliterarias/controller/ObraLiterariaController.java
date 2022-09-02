package com.example.elasticsearchobrasliterarias.controller;

import com.example.elasticsearchobrasliterarias.model.ObraLiteraria;
import com.example.elasticsearchobrasliterarias.repository.IObraLiterariaRepository;
import com.example.elasticsearchobrasliterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obraliteraria")
public class ObraLiterariaController {
    @Autowired
    private IObraLiterariaService obraLiterariaService;
    @Autowired
    private IObraLiterariaRepository obraLiterariaRepository;

    @PostMapping("/create")
    public ResponseEntity<ObraLiteraria> create(@RequestBody ObraLiteraria obraLiteraria) {
        return new ResponseEntity<>(this.obraLiterariaService.create(obraLiteraria), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<Iterable<ObraLiteraria>> getAll() {
        return new ResponseEntity<>(this.obraLiterariaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/byautor")
    public ResponseEntity<Iterable<ObraLiteraria>> getAllByAutor(@RequestParam String autor) {
        return new ResponseEntity<>(this.obraLiterariaRepository.findObraLiterariaByAutorEqualsIgnoreCase(autor), HttpStatus.OK);
    }

    @GetMapping("/byword")
    public ResponseEntity<Iterable<ObraLiteraria>> getAllByWord(@RequestParam String word) {
        return new ResponseEntity<>(this.obraLiterariaRepository.findObraLiterariaByObraContains(word), HttpStatus.OK);
    }

    @GetMapping("/quantitypages")
    public ResponseEntity<Iterable<ObraLiteraria>> getAllByQuantityPages(@RequestParam Integer quantityPage) {
        return new ResponseEntity<>(this.obraLiterariaRepository.findObraLiterariaByCantidadPaginasGreaterThan(quantityPage), HttpStatus.OK);
    }

    @GetMapping("/beforeyear")
    public ResponseEntity<Iterable<ObraLiteraria>> getAllByBeforeYear(@RequestParam Integer beforeYear) {
        return new ResponseEntity<>(this.obraLiterariaRepository.findObraLiterariaByAnioPrimeraPublicacionBefore(beforeYear), HttpStatus.OK);
    }

    @GetMapping("/afteryear")
    public ResponseEntity<Iterable<ObraLiteraria>> getAllByAfterYear(@RequestParam Integer afterYear) {
        return new ResponseEntity<>(this.obraLiterariaRepository.findObraLiterariaByAnioPrimeraPublicacionAfter(afterYear), HttpStatus.OK);
    }

    @GetMapping("/byeditorial")
    public ResponseEntity<Iterable<ObraLiteraria>> getAllByEditorial(@RequestParam String editorial) {
        return new ResponseEntity<>(this.obraLiterariaRepository.findObraLiterariaByEditorialEqualsIgnoreCase(editorial), HttpStatus.OK);
    }
}
