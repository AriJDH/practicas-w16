package com.example.be_java_hisp_w16_g09_Nicoletta.controller;

import com.example.be_java_hisp_w16_g09_Nicoletta.dto.PostDto;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.RecentPostsDTO;
import com.example.be_java_hisp_w16_g09_Nicoletta.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PostController {

    @Autowired
    IPostService postService;
    //US 0005: Dar de alta una nueva publicación
    @PostMapping("/products/post")
    public void createPost(@RequestBody @Valid PostDto postDto){
        postService.createPost(postDto);
    }
    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<RecentPostsDTO> getRecentPostsOfSellersFollowedByUserWith(@PathVariable int userId, @RequestParam(required = false) String order){
        return ResponseEntity.ok(postService.getRecentPostsOfSellersFollowedByUserWith(userId, order));
    }
}
