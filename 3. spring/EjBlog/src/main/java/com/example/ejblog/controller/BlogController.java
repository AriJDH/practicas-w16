package com.example.ejblog.controller;

import com.example.ejblog.dto.EntradaBlogDto;
import com.example.ejblog.exception.BlogExisteException;
import com.example.ejblog.exception.BlogNotFoundException;
import com.example.ejblog.model.EntradaBlog;
import com.example.ejblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping ("/blog")
    public ResponseEntity<String> nuevaEntrada(@RequestBody EntradaBlog entrada){

        var res = blogService.save(entrada);
        return new ResponseEntity<>("Blog creado exitosamente, id: " + res.getId(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getBlog(@PathVariable int id) throws BlogNotFoundException {
        return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> getBlogs(){
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }
}
