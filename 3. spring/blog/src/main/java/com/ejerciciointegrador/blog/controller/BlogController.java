package com.ejerciciointegrador.blog.controller;

import com.ejerciciointegrador.blog.dto.EntradaBlogDTO;

import com.ejerciciointegrador.blog.entity.EntradaBlog;
import com.ejerciciointegrador.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@Controller
public class BlogController {

    /*nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su
    “Id”. (URI: /blog).
    En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y
     devolver un mensaje indicando dicha situación.*/
    @Autowired
    private IBlogService iBlogService;

    @PostMapping( "/blog")
    public ResponseEntity<EntradaBlogDTO> crearEntrada(@RequestBody EntradaBlogDTO entradaBlogDTO) {
        iBlogService.save(entradaBlogDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping( "/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> findById(@PathVariable long id) {
        return new ResponseEntity<>(iBlogService.find(id), HttpStatus.OK);
    }

    @GetMapping( "/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> findAll() {
        return new ResponseEntity<>(iBlogService.findAll(), HttpStatus.OK);
    }
}
