package com.spring.blog.controller;

import com.spring.blog.dto.EntradaBlogDTO;
import com.spring.blog.entity.EntradaBlog;
import com.spring.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @PostMapping("/blog")
    public ResponseEntity<Integer> add(@RequestBody EntradaBlogDTO b){
        return new ResponseEntity<>(iBlogService.add(b), HttpStatus.OK);
    }

}
