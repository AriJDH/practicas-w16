package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.service.IPostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "US 05 - Alta de publicacion", notes = "Da de alta una nueva publicación.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping("/post")
    public ResponseEntity<MessageDto> createPost(
            @RequestBody @ApiParam(value = "Datos de la publicacion y del producto a publicar por el vendedor") PostDto postDTO) {
        return new ResponseEntity<MessageDto>(postService.createPost(postDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "US 06 - Listado de publicaciones de los vendedores seguidos",
            notes = "Obtiene un listado de las publicaciones realizadas por los vendedores que el usuario sigue en las últimas dos semanas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDto> getFollowedPostsOrder(
            @PathVariable @ApiParam(value = "Usuario que sigue a los vendedores de los que se devolveran las publicaciones") int userId,
            @RequestParam(required = false) @ApiParam(value = "Orden de la lista (valores aceptados: date_desc, date_asc)") String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    @ApiOperation(value = "US 0010: Nueva publicación en promoción",
            notes = "Llevar a cabo la publicación de un nuevo producto en promoción")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @PostMapping("/promo-post")
    public ResponseEntity<MessageDto> createPromoPost(@RequestBody PromoPostDto postDTO) {
        return new ResponseEntity<MessageDto>(postService.createPromoPost(postDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "US 0011: Cantidad de promociones", notes = "Obtener la cantidad de productos en promoción de un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> getPromoPostsCount(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromoPostsCount(user_id), HttpStatus.OK);
    }

    @ApiOperation(value = "US 0012 :Ver promociones", notes = "Obtener un listado de todos los productos en promoción de un determinado vendedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListDto> getPromoPostsList(@RequestParam int user_id) {
        return new ResponseEntity<>(postService.getPromoPostsList(user_id), HttpStatus.OK);
    }

    @ApiOperation(value = "US 0013 :Eliminar publicación", notes = "Permite eliminar una publicación")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST")
    })
    @DeleteMapping("/post")
    public ResponseEntity<MessageDto> deletePost(@RequestParam int postId) {
        return new ResponseEntity<>(postService.deletePost(postId), HttpStatus.OK);
    }
}
