package com.example.ejercicioyoutuber.controller;

import com.example.ejercicioyoutuber.dto.BlogEntryDto;
import com.example.ejercicioyoutuber.repository.IBlogRepository;
import com.example.ejercicioyoutuber.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<Integer> inserBlogEntry(@RequestBody BlogEntryDto blogEntry){
        int result = blogService.insertBlog(blogEntry);
        return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDto> getBlogEntryById(@PathVariable int id ){
        BlogEntryDto responseBlogEntry = blogService.getBlogById(id);
        return new ResponseEntity<>(responseBlogEntry,HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogEntryDto>> getBlogEntryById(){
        List<BlogEntryDto> responseBlogEntries = blogService.getAllBlogs();
        return new ResponseEntity<>(responseBlogEntries,HttpStatus.OK);
    }

}
