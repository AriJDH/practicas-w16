package com.example.ejercicio2.controller;

import com.example.ejercicio2.dto.EntradaBlogDTO;
import com.example.ejercicio2.model.EntradaBlog;
import com.example.ejercicio2.repository.IBlogRepository;
import com.example.ejercicio2.service.BlogService;
import com.example.ejercicio2.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<Integer> postBlog(@RequestBody EntradaBlog body){
        System.out.println(body);
        return new ResponseEntity<>(blogService.cargaData(body), HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getBlog(@PathVariable Integer id){
        return new ResponseEntity<>(blogService.getData(id),HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<EntradaBlogDTO>> getBlogs(){
        return new ResponseEntity<>(blogService.muestraData(),HttpStatus.OK);
    }

}
