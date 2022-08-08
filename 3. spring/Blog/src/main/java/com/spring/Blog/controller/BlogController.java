package com.spring.Blog.controller;

import com.spring.Blog.dto.BlogDTO;
import com.spring.Blog.dto.ResponseDTO;
import com.spring.Blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @PostMapping("/blog")
    public ResponseEntity<ResponseDTO> addBlog(@RequestBody BlogDTO blogDTO){
        return new ResponseEntity<>(iBlogService.addBlog(blogDTO), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable int id){
        return new ResponseEntity<>(iBlogService.getBlog(id),HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDTO>> allBlogs(){
        return new ResponseEntity<>(iBlogService.getAllBlogs(),HttpStatus.OK);
    }
}
