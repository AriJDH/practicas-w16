package com.bootcamp.youtuber.controller;

import com.bootcamp.youtuber.dto.BlogEntryDto;
import com.bootcamp.youtuber.dto.ResponseApiDto;
import com.bootcamp.youtuber.service.IEntryBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogEntryController {

    private final IEntryBlogService iEntryBlogService;

    public BlogEntryController(IEntryBlogService iEntryBlogService) {
        this.iEntryBlogService = iEntryBlogService;
    }


    @PostMapping("/blog")
    public ResponseEntity<ResponseApiDto> createEntryBlog(@RequestBody BlogEntryDto blogEntryDto){
        return new ResponseEntity<>(iEntryBlogService.createBlog(blogEntryDto), HttpStatus.CREATED);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogEntryDto>> listBlogs(){
        return new ResponseEntity<>(iEntryBlogService.getAllBlogs(), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDto> getBlogById(@PathVariable String id){
        return new ResponseEntity<>(iEntryBlogService.getBlogById(id).get(), HttpStatus.OK);
    }
}
