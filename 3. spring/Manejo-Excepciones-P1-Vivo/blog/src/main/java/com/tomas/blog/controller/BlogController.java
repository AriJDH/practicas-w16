package com.tomas.blog.controller;

import com.tomas.blog.dto.BlogCreadoDTO;
import com.tomas.blog.dto.BlogDTO;
import com.tomas.blog.dto.ListaBlogDTO;
import com.tomas.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping ("/blog")
    public ResponseEntity<BlogCreadoDTO> crearEntradaBlog(@RequestBody BlogDTO blogDto) {
        return new ResponseEntity<>(blogService.crearBlog(blogDto), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> obtenerBlog(@PathVariable int id){
        return new ResponseEntity<>(blogService.consultarBlog(id), HttpStatus.FOUND);
    }

    @GetMapping("/blogs")
    public ResponseEntity<ListaBlogDTO> listarTodos(){
        return new ResponseEntity<>(blogService.obtenerBlogs(), HttpStatus.OK);
    }

}
