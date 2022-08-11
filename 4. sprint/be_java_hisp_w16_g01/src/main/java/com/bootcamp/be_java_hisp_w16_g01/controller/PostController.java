package com.bootcamp.be_java_hisp_w16_g01.controller;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.service.IPostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    private IPostService postService;

    @ApiOperation(value = "Post", notes = "Dar de alta una nueva publicación")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @PostMapping("/post")
    public ResponseEntity<MessageDto> createPost(@RequestBody PostDto postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Followed Post Order", notes = "Obtener un listado de las publicaciones realizadas por los vendedores que " +
            "un usuario sigue en las últimas dos semanas " +
            "(para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero)")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDto> getFollowedPostsOrder(@PathVariable int userId, @RequestParam String order) {
        return new ResponseEntity<>(postService.getFollowedPosts(userId, order), HttpStatus.OK);
    }

    @ApiOperation(value = "Promo Post", notes = "Llevar a cabo la publicación de un nuevo producto en promoción")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @PostMapping("/promo-post")
    public ResponseEntity<MessageDto> createPostPromo(@RequestBody PostDto postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Promo Post Count", notes = "Obtener la cantidad de productos en promoción de un determinado vendedor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDto> getCountPromoPost(@RequestParam int userId) {
        return new ResponseEntity<>(postService.getCountPromoPost(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "Promo Post List", notes = "Obtener un listado de todos los productos en promoción de un determinado vendedor")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad request")})
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListDto> findAllPromoProductsBySeller(@RequestParam int userId) {
        return new ResponseEntity<>(postService.findAllPromoProductsBySeller(userId), HttpStatus.OK);
    }
}
