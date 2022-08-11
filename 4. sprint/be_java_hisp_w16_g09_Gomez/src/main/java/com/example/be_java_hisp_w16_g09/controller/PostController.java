package com.example.be_java_hisp_w16_g09.controller;

import com.example.be_java_hisp_w16_g09.dto.*;
import com.example.be_java_hisp_w16_g09.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    IPostService postService;

    //US 0005: Dar de alta una nueva publicación
    @PostMapping("/products/post")
    public void createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<RecentPostsDTO> getRecentPostsOfSellersFollowedByUserWith(@PathVariable int userId, @RequestParam(required = false) String order) {
        if (order != null) return new ResponseEntity<>(postService.orderByDate(userId, order), HttpStatus.OK);
        else return ResponseEntity.ok(postService.getRecentPostsOfSellersFollowedByUserWith(userId));
    }

    @PostMapping("/products/promo-post")
    public void createPromoPost(@RequestBody PromoPostDto promoPost) {
        postService.createPromoPost(promoPost);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostCounterDto> getPromoPostcounter(@RequestParam int user_id) {
        PromoPostCounterDto count = postService.countPromoPosts(user_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @DeleteMapping("products/post/{postId}")
    public ResponseEntity<MessageDto> removePost(@PathVariable int postId) {
        postService.removePost(postId);
        return new ResponseEntity<>(new MessageDto("Post " + postId + " deleted succesfully"), HttpStatus.OK);

    }
}
