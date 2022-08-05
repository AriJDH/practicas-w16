package com.example.ejercicioblogyoutuber.controller;

import com.example.ejercicioblogyoutuber.dto.BlogEntryDTO;
import com.example.ejercicioblogyoutuber.repository.BlogCreationException;
import com.example.ejercicioblogyoutuber.service.BlogEntryService;
import com.example.ejercicioblogyoutuber.service.BlogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/blog")
public class BlogEntryController {

    private final BlogEntryService blogEntryService;

    @Autowired
    public BlogEntryController(BlogEntryService blogEntryService) {
        this.blogEntryService = blogEntryService;
    }

    @PostMapping
    public ResponseEntity createBlog(@RequestBody BlogEntryDTO aBlog) throws BlogCreationException {
        blogEntryService.create(aBlog);
        return ResponseEntity.ok("Se creo correctamente el blog con ID: " + aBlog.getId());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getBlogById(@PathVariable Long id) throws BlogNotFoundException {
        return ResponseEntity.ok(blogEntryService.getBlogById(id));
    }

    @GetMapping
    public ResponseEntity getBlogs() {
        return ResponseEntity.ok(blogEntryService.getBlogs());
    }

}
