package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDTO>> findAllBlogs(){
        return new ResponseEntity<>(blogService.listarBlogs(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> findBlogById(@PathVariable int id){
        return new ResponseEntity<>(blogService.buscarBlog(id), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<EntradaBlogDTO> createBlog(@RequestBody EntradaBlogDTO blogDTO){
        return new ResponseEntity<>(blogService.agregar(blogDTO), HttpStatus.OK);
    }
}
