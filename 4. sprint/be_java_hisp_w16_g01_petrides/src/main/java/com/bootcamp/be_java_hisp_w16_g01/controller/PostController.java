package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.service.IPostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @ApiOperation(value = "Crear publicación", notes = "Dar de alta una nueva publicación")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Publicación creada correctamente"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping("/post")
    public ResponseEntity<MessageDto> createPost(@RequestBody PostDto postDTO) {
        return new ResponseEntity<MessageDto>(postService.createPost(postDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Crear publicación en promoción", notes = "Llevar a cabo la publicación de un nuevo producto en promoción")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Publicación creada correctamente"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @PostMapping("/promo-post")
    public ResponseEntity<MessageDto> createPromoPost(@RequestBody PromoPostDto postDTO) {
        return new ResponseEntity<MessageDto>(postService.createPromoPost(postDTO), HttpStatus.OK);
    }
    @ApiOperation(value = "Ver publicaciones", notes = "Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Publicaciones obtenidas"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDto> getFollowedPostsOrder(@PathVariable int userId, @RequestParam String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    @ApiOperation(value = "Cantidad promociones", notes = "Obtener la cantidad de productos en promoción de un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Publicaciones obtenidas"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> getPromoPostsCount(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromoPostsCount(user_id), HttpStatus.OK);
    }

    @ApiOperation(value = "Ver promociones", notes = "Obtener un listado de todos los productos en promoción de un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Publicaciones obtenidas"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListDto> getPromoPostsList(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromoPostsList(user_id), HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar publicación", notes = "Permite eliminar una publicación")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Publicacion eliminada"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @DeleteMapping("/post")
    public ResponseEntity<MessageDto> deletePost(@RequestParam int postId) {
        return new ResponseEntity<>(postService.deletePost(postId), HttpStatus.OK);
    }
}
