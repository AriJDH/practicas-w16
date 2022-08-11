package com.bootcamp.entradasblog.controller;

import com.bootcamp.entradasblog.dto.BlogDto;
import com.bootcamp.entradasblog.dto.ResponseDto;
import com.bootcamp.entradasblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogsController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<ResponseDto> addBlog(@RequestBody BlogDto blog){
        return new ResponseEntity<>(blogService.addBlog(blog), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable int id){
        return new ResponseEntity<>(blogService.getBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getBlogs(){
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }
}
