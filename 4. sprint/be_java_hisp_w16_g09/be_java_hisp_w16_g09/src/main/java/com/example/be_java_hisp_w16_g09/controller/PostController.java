package com.example.be_java_hisp_w16_g09.controller;

import com.example.be_java_hisp_w16_g09.dto.NewPostDto;
import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.service.IPostService;
import com.example.be_java_hisp_w16_g09.service.PostService;
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
    public void createPost(@RequestBody NewPostDto postDto){
        postService.createPost(postDto);
    }
    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
    // últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity getRecentPostsOfSellersFollowedByUserWith(@PathVariable int userId){
        return ResponseEntity.ok(postService.getRecentPostsOfSellersFollowedByUserWith(userId));
    }
    //US 0009: Ordenamiento por fecha ascendente y descendente
    //     products/followed/{userId}/list?order=date_asc
    //     products/followed/{userId}/list?order=date_desc
    //  *Nota: Este ordenamiento aplica solo para la US-006
    @GetMapping("US009") //Cambiar Endpoint
    public void US009(){
    }
}
