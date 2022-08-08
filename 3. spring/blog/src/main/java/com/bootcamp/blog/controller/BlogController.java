package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogEntryDTO;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final IBlogService service;

    @Autowired
    public BlogController(IBlogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BlogEntryDTO> createEntry(@RequestBody BlogEntryDTO be) {
        return new ResponseEntity<>(service.createEntry(be), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogEntryDTO> getEntry(@PathVariable String id) {
        return new ResponseEntity<>(service.getEntry(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BlogEntryDTO>> getEntries() {
        return new ResponseEntity<>(service.getEntries(), HttpStatus.OK);
    }
}
