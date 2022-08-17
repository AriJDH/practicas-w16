package com.javaw16.blog.controllers;

import com.javaw16.blog.dtos.request.ReqBlogEntryDTO;
import com.javaw16.blog.dtos.response.ResBlogEntryDTO;
import com.javaw16.blog.services.IBlogEntryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping()
public class BlogEntryController {
    @Autowired
    private IBlogEntryService blogService;

    public BlogEntryController(IBlogEntryService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<ResBlogEntryDTO> getEntry(@PathVariable Integer id) {
        return new ResponseEntity<>(this.blogService.getEntryByID(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<ResBlogEntryDTO>> getEntries() {
        return new ResponseEntity<>(this.blogService.getEntries(), HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity postEntry(@RequestBody ReqBlogEntryDTO reqBlogEntryDTO){
        this.blogService.postEntry(reqBlogEntryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
