package com.bootcamp.practico.controller;

import com.bootcamp.practico.dto.BlogDto;
import com.bootcamp.practico.dto.ResponseMessageDto;
import com.bootcamp.practico.service.BlogAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    BlogAction service;



    @PostMapping("/add/blog")
    public ResponseEntity<ResponseMessageDto> addBlog(@RequestBody BlogDto body) {

        return new ResponseEntity<>(service.addBlog(body), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getBlogById(@PathVariable int id){

        return new ResponseEntity<>(service.getBlogById(id), HttpStatus.OK);
    }
}
