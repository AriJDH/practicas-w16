package com.example.be_java_hisp_w16_g09_bariani.controller;

import com.example.be_java_hisp_w16_g09_bariani.dto.*;
import com.example.be_java_hisp_w16_g09_bariani.service.IPostService;
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
    public void createPost(@RequestBody PostDto postDto){
        postService.createPost(postDto);
    }
    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<RecentPostsDTO> getRecentPostsOfSellersFollowedByUserWith(@PathVariable int userId, @RequestParam(required = false) String order){
        if (order != null)
            return new ResponseEntity<>(postService.orderByDate(userId,order),HttpStatus.OK);
        else
            return ResponseEntity.ok(postService.getRecentPostsOfSellersFollowedByUserWith(userId));
    }

    //US 0010 Dar de alta una publicacion promo
    @PostMapping("/products/promo-post")
    public void createPromoPost(@RequestBody PromoPostDto promoPostDto){
        postService.createPromoPost(promoPostDto);
    }

    //US 0011 Obtener cantidad de productos en promo de un seller
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostCountDtoResponse> getPostPromoCount(@RequestParam Integer user_id ){
        return new ResponseEntity<>(postService.countSellerPromoProducts(user_id), HttpStatus.OK);
    }

    //US 0012 Obtener los post promo de un vendedor
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromoPostListDtoResponse> getAllPromoPostOfSeller(@RequestParam Integer user_id, @RequestParam(required = false) String order){
        return new ResponseEntity<>(postService.getAllPromoPostOfSeller(user_id, order), HttpStatus.OK);
    }
}
