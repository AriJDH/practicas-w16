package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.dto.PromoPostCountDTO;
import com.example.be_java_hisp_w16_g03.dto.PromoPostDTO;
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
        service.addPost(request, false, 0d);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<PromoPostDTO> addPromoPost(@RequestBody PromoPostDTO promoPost) {
        service.addPromoPost(promoPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostsDTO> getLatestPostsOrderedByUserId(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(service.getLatestPostsOrderedByUserId(userId, order), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostCountDTO> getPromoPostCountByUserId(@RequestParam Integer userId) {
        return new ResponseEntity<>(service.getPromoPostCountByUserId(userId), HttpStatus.OK);
    }

}
