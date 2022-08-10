package com.bootcamp.be_java_hisp_w16_g7_espitia.controller;

import com.bootcamp.be_java_hisp_w16_g7_espitia.dto.*;
import com.bootcamp.be_java_hisp_w16_g7_espitia.service.IProductService;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService iProductService;


    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }


    @Operation(summary = "Create post to specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post created"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @PostMapping("/post")
    public ResponseEntity<ApiResponseDto> createPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(iProductService.createPost(postDto), HttpStatus.OK);
    }

    @Operation(summary = "Recent posts from followed users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recent Posts found"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Unknown query")})
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<RecentPostsDTO> recentPost(@PathVariable int userId,
                                                     @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iProductService.recentPost(userId, order), HttpStatus.OK);
    }

    @Operation(summary = "Create promo post to specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Promo Post created"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @PostMapping("/promo-post")
    @JsonProperty("user_id")
    public ResponseEntity<ApiResponseDto> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
        return new ResponseEntity<>(iProductService.createPromoPost(promoPostDTO), HttpStatus.OK);
    }

    @Operation(summary = "Count promo post to specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Promo Post count"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/promo-post/count")
    public ResponseEntity<ResponsePromoPostCountDTO> countPromoPost(@RequestParam(name = "user_id") int userId){
        return new ResponseEntity<>(iProductService.countPromoPostByUser(userId),HttpStatus.OK);
    }


}
