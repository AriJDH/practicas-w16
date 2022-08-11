package com.bootcamp.be_java_hisp_w16_g01_Morales.controller;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.MessageDto;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.PostDto;
import com.bootcamp.be_java_hisp_w16_g01_Morales.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<MessageDto> createPost(@RequestBody PostDto postDTO) {
        return new ResponseEntity<MessageDto>(postService.createPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDto> getFollowedPostsOrder(@PathVariable int userId, @RequestParam String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }



}
