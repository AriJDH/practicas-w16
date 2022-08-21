package com.example.springblog.controller;

import com.example.springblog.dto.EntradaBlogDTO;
import com.example.springblog.dto.IdBlogDTO;
import com.example.springblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Ejercicio > Modulo 8: Spring > ManejoDeExcepciones-P1-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<IdBlogDTO> createBlogEntry(@RequestBody EntradaBlogDTO body) {
        return new ResponseEntity<>(blogService.cargar(body), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getBlogEntry(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> getAllBlogEntries() {
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK);
    }
}
