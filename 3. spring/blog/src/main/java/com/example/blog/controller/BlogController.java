package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.dto.ResponseDTO;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService service;

    @PostMapping("/blog")
    public ResponseEntity<ResponseDTO> saveEntradaBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){
        return new ResponseEntity<>(service.saveEntradaBlog(entradaBlogDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> listBlogs(){
        return new ResponseEntity<>(service.getAllBlog(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> findBlogById(@PathVariable Integer id){
        //Devolver error, consultar.
        EntradaBlogDTO response = service.getBlogById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
