package com.bootcamp.be_java_hisp_w16_g01_rodriguez.controller;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.*;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.service.IPostService;
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
    public ResponseEntity<MessageDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<MessageDTO>(postService.createPost(postDTO), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<MessageDTO> createPost(@RequestBody PromoPostDTO postDTO) {
        return new ResponseEntity<MessageDTO>(postService.createPromoPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDTO> getFollowedPostsOrder(@PathVariable int userId, @RequestParam String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCount(@RequestParam int user_Id) {
        return new ResponseEntity<>(postService.getPromoPostCount(user_Id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<UserPromoPostsDTO> getUserPromoPostsDto(@RequestParam int user_Id){
        return new ResponseEntity<>(postService.getUserPromoPosts(user_Id), HttpStatus.OK);
    }
}
