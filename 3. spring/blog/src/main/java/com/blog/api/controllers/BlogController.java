package com.blog.api.controllers;

import com.blog.api.dto.BlogDTO;
import com.blog.api.entity.EntradaBlog;
import com.blog.api.exceptions.BlogExisteException;
import com.blog.api.exceptions.BlogNotFoundException;
import com.blog.api.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> saveBlog(@RequestBody EntradaBlog blog) throws BlogExisteException {

        HashMap<String,Long> response = new HashMap<>();
        BlogDTO blogDTO =  blogService.save(blog);

        response.put("Blog creado con exito, con id",blogDTO.getId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable Long id) throws BlogNotFoundException {

        return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);

    }

    @GetMapping("/blog")
    public ResponseEntity<List<BlogDTO>> getBlogs()  {

        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }
}
