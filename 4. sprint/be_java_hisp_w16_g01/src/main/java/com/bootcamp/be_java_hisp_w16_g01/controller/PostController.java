package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.service.IPostService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;

    @ApiOperation(value = "US 05 - Alta de publicacion",
            notes = "Da de alta una nueva publicación.")
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
            @RequestParam @ApiParam(value = "Orden de la lista (valores aceptados: date_desc, date_asc)") String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    @ApiOperation(value = "US 10 - Publicacion de un nuevo producto en promocion")
    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(
            @RequestBody @ApiParam(value = "Datos de la publicacion y del producto en promocion a publicar por el vendedor") PromoPostDTO promoPostDTO) {
        return ResponseEntity.ok(postService.createPost(promoPostDTO));
    }

    @ApiOperation(value = "US 11 - Cantidad de productos en promocion publicados por un determinado vendedor")
    @GetMapping("promo-post/count")
    public ResponseEntity<ResponsePromoPostQtyDTO> getPromoPostQty(
            @RequestParam("user_id") @ApiParam(value = "Id del vendedor para filtrar la cantidad de productos en promocion")  int userId) {
        return ResponseEntity.ok(postService.getPromoPostsQty(userId));
    }

    @ApiOperation(value = "US 12 - Listado de todos los productos en promocion publicados por un determinado vendedor")
    @GetMapping("promo-post/list")
    public ResponseEntity<ResponsePromoPostsDTO> getPromoPosts(
            @RequestParam("user_id") @ApiParam("Id del vendedor para filtrar la lista de productos en promocion") int userId) {
        return ResponseEntity.ok(postService.getPromoPostsDto(userId));
    }
}
