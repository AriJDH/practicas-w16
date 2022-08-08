package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.RequestBlogDto;
import com.bootcamp.blog.dto.ResponseBlogDto;
import com.bootcamp.blog.dto.ResponseBlogListDto;
import com.bootcamp.blog.dto.ResponseFullBlogDto;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogEntryController {
    @Autowired
    IBlogService service;

@PostMapping("/blog")
    public ResponseEntity<ResponseBlogDto> createNewBlogEntry(@RequestBody RequestBlogDto requestBlogDto){

    return new ResponseEntity<>(service.createBlogEntry(requestBlogDto), HttpStatus.OK);
}

@GetMapping("/blog/{id}")
    public ResponseEntity<ResponseFullBlogDto>getBlogById(@PathVariable Integer id){
    return new ResponseEntity<>(service.getBlogById(id),HttpStatus.OK);
}

@GetMapping("/blogs")
    public ResponseEntity<ResponseBlogListDto> getAllBlogs(){
    return new ResponseEntity<>(service.getAllBlogs(),HttpStatus.OK);
}
}
