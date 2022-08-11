package com.grodriguez.blog.controller;

import com.grodriguez.blog.dto.BlogEntryDTO;
import com.grodriguez.blog.dto.MessageDTO;
import com.grodriguez.blog.service.BlogEntryService;
import com.grodriguez.blog.service.IBlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogEntryController {

    @Autowired
    private IBlogEntryService blogEntryService;

    @PostMapping("/blog")
    public ResponseEntity<MessageDTO> createBlogEntry(@RequestBody BlogEntryDTO blogEntry){
        return new ResponseEntity<>(blogEntryService.createBlogEntry(blogEntry), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDTO> getBlogEntry(@PathVariable int id){
        return new ResponseEntity<>(blogEntryService.getBlogEntry(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogEntryDTO>> getAllBlogEntries(){
        return new ResponseEntity<>(blogEntryService.getAll(), HttpStatus.OK);
    }

}
