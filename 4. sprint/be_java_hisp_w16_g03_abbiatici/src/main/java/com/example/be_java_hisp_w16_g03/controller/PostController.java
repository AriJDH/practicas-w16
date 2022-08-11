package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.dto.*;
import com.example.be_java_hisp_w16_g03.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    IPostService service;

    @PostMapping("/products/post")
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO request) {
        service.addPost(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostsDTO> getLatestPostsOrderedByUserId(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(service.getLatestPostsOrderedByUserId(userId, order), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<PromoPostDTO> addPromoPost(@RequestBody PromoPostDTO request){
        service.addPromoPost(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCount(@RequestParam Integer user_id){
        return new ResponseEntity<>(service.getPromoPostCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromoPostsDTO> getPromoPosts(@RequestParam Integer user_id, @RequestParam(required = false) String order){
        return new ResponseEntity<>(service.getPromoPostsOrderedByUserId(user_id, order), HttpStatus.OK);
    }

}
