package com.example.blog.controller;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.service.EntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class EntradaBlogController {

    @Autowired
    EntradaBlogService entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<String> createNewBlog(@RequestBody EntradaBlogDto entradaBlogDto){
        return new ResponseEntity<>(entradaBlogService.createPost(entradaBlogDto),HttpStatus.ACCEPTED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlogDto>> getAll(){
        return new ResponseEntity<>(entradaBlogService.getAllBlogs(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> findById(@PathVariable("id") long id){
        return new ResponseEntity<>(entradaBlogService.findById(id), HttpStatus.ACCEPTED);
    }

}
