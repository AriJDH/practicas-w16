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
    public void createPost(@RequestBody PostDto postDto){
        postService.createPost(postDto);
    }
    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<RecentPostsDto> getRecentPostsOfSellersFollowedByUserWith(@PathVariable int userId, @RequestParam(required = false) String order){
        if (order != null)
            return new ResponseEntity<>(postService.orderByDate(userId,order),HttpStatus.OK);
        else
            return ResponseEntity.ok(postService.getRecentPostsOfSellersFollowedByUserWith(userId));
    }

    //US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
    @PostMapping("/products/promo-post")
    public void createPostPromo(@RequestBody PromoPostDto promoPostDto){
        postService.createPostWithPromo(promoPostDto);
    }
    //US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostCountDto> getPostPromoCount(@RequestParam int userId ){
        return new ResponseEntity<>(postService.countPromoBySeller(userId), HttpStatus.OK);
    }

    //US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostsUserDto> getPromoPostsByUser(@RequestParam int userId) {
        return new ResponseEntity<>(postService.getPromoPostsOfUser(userId), HttpStatus.OK);
    }

}
