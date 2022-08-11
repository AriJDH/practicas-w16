package com.example.be_java_hisp_w16_g03.controller;

import com.example.be_java_hisp_w16_g03.dto.*;
import com.example.be_java_hisp_w16_g03.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    IPostService service;

    @PostMapping("/post")
    public ResponseEntity<PostDTO> addPost(@RequestBody PostDTO request) {
        service.addPost(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsDTO> getLatestPostsOrderedByUserId(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(service.getLatestPostsOrderedByUserId(userId, order), HttpStatus.OK);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++ Métodos Individuales ++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @PostMapping("/promo-post")
    public ResponseEntity<PromoPostDTO> addPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
        service.addPromoPost(promoPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<ProductCountDTO> getProductCountByUserId(@RequestParam Integer user_id) {
        return new ResponseEntity<>(service.getProductCountByUserId(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostsDTO> getProductsPromoByUserId(@RequestParam Integer user_id) {
        return new ResponseEntity<>(service.getProductsPromoByUserId(user_id), HttpStatus.OK);
    }

    @GetMapping("/biggest-discount")
    public ResponseEntity<PromoPostDTO> getBiggestDiscountByUserId(@RequestParam Integer user_id) {
        return new ResponseEntity<>(service.getBiggestDiscountByUserId(user_id), HttpStatus.OK);
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++ Fin de Métodos Individuales +++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

}
