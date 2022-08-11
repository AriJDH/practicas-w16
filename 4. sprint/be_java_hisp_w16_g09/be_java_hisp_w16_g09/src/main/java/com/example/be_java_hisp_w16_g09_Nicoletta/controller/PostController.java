package com.example.be_java_hisp_w16_g09_Nicoletta.controller;

import com.example.be_java_hisp_w16_g09_Nicoletta.dto.PostDto;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.RecentPostsDTO;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.*;
import com.example.be_java_hisp_w16_g09_Nicoletta.service.IPostService;
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
    @PostMapping("/products/promo-post")
    public ResponseEntity<MessageDto> US010(@RequestBody PostPromoDto postDto){
        postService.createPostPromo(postDto);
        return new ResponseEntity<>(new MessageDto("Promo add"), HttpStatus.OK);
   }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PostPromoResponseDTO> US0011(@RequestParam int user_id){
        return new ResponseEntity<>(postService.calculatePromoCount(user_id),HttpStatus.OK);
    }
    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PostPromoListDTO> US0012(@RequestParam int user_id){
        return new ResponseEntity<>(postService.getPromoOfSeller(user_id),HttpStatus.OK);
    }

}
