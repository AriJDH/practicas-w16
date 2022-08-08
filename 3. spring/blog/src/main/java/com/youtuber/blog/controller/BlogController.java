package com.youtuber.blog.controller;

import com.youtuber.blog.dto.BlogDto;
import com.youtuber.blog.dto.ResponseApiDto;
import com.youtuber.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    private final IBlogService blogService;

    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<ResponseApiDto> createEntradaBlog(@RequestBody BlogDto blogDto){
        return new ResponseEntity<>(blogService.createBlog(blogDto), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> listBlogs(){
        return new ResponseEntity<>(blogService.listBlog(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogDto> findBlog(@PathVariable Integer id){
        BlogDto blogResponse = blogService.getBlogById(id);
        return new ResponseEntity<>(blogResponse, HttpStatus.OK);
    }
}
