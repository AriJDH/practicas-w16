package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogEntryDTO;
import com.bootcamp.blog.dto.BlogEntryIdDTO;
import com.bootcamp.blog.service.IBlogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class BlogEntryController {
    @Autowired
    IBlogEntryService blogEntryService;

    @PostMapping("/blog")
    public ResponseEntity<BlogEntryIdDTO> createBlogEntry(@RequestBody BlogEntryDTO blogEntryDTO){
        return new ResponseEntity<>(blogEntryService.createBlogEntry(blogEntryDTO), HttpStatus.CREATED);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDTO> getBlogEntry(@PathVariable int id){
        return new ResponseEntity<BlogEntryDTO>(blogEntryService.getBlogEntry(id), HttpStatus.OK);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogEntryDTO>> getBlogsEntries(){
        return new ResponseEntity<List<BlogEntryDTO>>(blogEntryService.getBlogsEntries(), HttpStatus.OK);
    }

}
