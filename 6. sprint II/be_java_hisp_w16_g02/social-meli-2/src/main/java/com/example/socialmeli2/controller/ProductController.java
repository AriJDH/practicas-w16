package com.example.socialmeli2.controller;

import com.example.socialmeli2.dto.PostDto;
import com.example.socialmeli2.dto.PostListLastTwoWeeksDto;
import com.example.socialmeli2.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<Void> addPost(@Valid @RequestBody PostDto post){
        postService.addPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListLastTwoWeeksDto> getFollowedPostLastTwoWeeks(@PathVariable int userId, @RequestParam Optional<String> order){
        return new ResponseEntity<>(postService.getFollowedPostListLastTwoWeeks(userId, order), HttpStatus.OK);
    }
}
