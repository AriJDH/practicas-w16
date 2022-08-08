package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

  @Autowired
  IBlogService findService;

  @GetMapping("/blogs")
  public ResponseEntity<List<EntradaBlogDTO>> getAllBlogs(){
    return findService.getAllSports();
  }

  @GetMapping("/blog/{id}")
  public ResponseEntity<EntradaBlogDTO> getBlog(@PathVariable Integer id){
    return findService.getBlog(id);
  }
}
