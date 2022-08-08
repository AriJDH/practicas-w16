package com.blog.blog.controller;
import com.blog.blog.dto.EntradaBlogDto;
import com.blog.blog.model.EntradaBlog;
import com.blog.blog.service.EntradaBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private EntradaBlogService service;
    public BlogController(EntradaBlogService service){
        this.service = service;
    }

    @PostMapping(path = "/blog", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createBlog(@RequestBody EntradaBlog entradaBlog){
        System.out.println("controler: "+ entradaBlog);
        return new ResponseEntity<>(service.createBlog(entradaBlog), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDto> getBlogById(@PathVariable Integer id){
        System.out.println("controler By ID: ");
        return new ResponseEntity<>(service.getBlogById(id), HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<EntradaBlogDto>> getAllBlogs(){
        System.out.println("controler TODOS: ");
        return new ResponseEntity<>(service.getAllBlogs(), HttpStatus.OK);
    }

}
