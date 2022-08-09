package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogPostDTO;
import com.bootcamp.blog.dto.BlogResponseDTO;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @PostMapping("/blog")
    public ResponseEntity<BlogResponseDTO> newBlog(@RequestBody BlogPostDTO blogPostDTO){
        return new ResponseEntity<>(iBlogService.newBlogService(blogPostDTO), HttpStatus.CREATED);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogPostDTO>> allBlogs(){
        return new ResponseEntity<>(iBlogService.allBlogsService(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogPostDTO> findBlog(@PathVariable Integer id) {
        return new ResponseEntity<>(iBlogService.findBlogService(id), HttpStatus.OK);
    }

}
