package com.mercadolibre.bootcamp.controllers;

import com.mercadolibre.bootcamp.dtos.BlogEntryDto;
import com.mercadolibre.bootcamp.models.BlogEntry;
import com.mercadolibre.bootcamp.services.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDto> searchEntryById(@PathVariable int id){
        BlogEntryDto blogEntry = blogService.searchEntryById(id);
        return new ResponseEntity<>(blogEntry, HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<String> createEntry(@RequestBody BlogEntry body){
        blogService.createEntry(body);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<BlogEntryDto>> getAllEntries(){
        List<BlogEntryDto> all = blogService.getAllEntries();
        return new ResponseEntity<>(all,HttpStatus.CREATED);
    }
}
