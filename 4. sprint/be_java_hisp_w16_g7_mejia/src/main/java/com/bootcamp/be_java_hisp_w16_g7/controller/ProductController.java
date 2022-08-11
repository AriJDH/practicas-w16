package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.dto.*;
import com.bootcamp.be_java_hisp_w16_g7.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "(Individual) Create promo post to specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Promo Post created"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @PostMapping("/promo-post")
    public ResponseEntity<ApiResponseDto> createPromoPost(@RequestBody PostPromoDto promoDto) {
        return new ResponseEntity<>(iProductService.createPostPromo(promoDto), HttpStatus.OK);
    }

    @Operation(summary = "(Individual) Count promo post to specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Count of promo post"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "User is not seller")})
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> countPromoPost(@RequestParam() int user_id) {
        return new ResponseEntity<>(iProductService.countPostPromo(user_id), HttpStatus.OK);
    }


    @Operation(summary = "(Bonus) List all posts with specific type of product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lists all post with specific type of product"),
            @ApiResponse(responseCode = "404", description = "No post with this type"),})
    @GetMapping("/post/list/{type}")
    public ResponseEntity<List<PromoPostListDto>> listPostsByProductType(@PathVariable String type) {
        return new ResponseEntity<>(iProductService.getAllPostByProductType(type), HttpStatus.OK);
    }

    @Operation(summary = "(Bonus) List all promo posts of specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lists promo posts of user"),
            @ApiResponse(responseCode = "404", description = "User not found / Seller has no promo posts"),
            @ApiResponse(responseCode = "400", description = "User is not seller")})
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostListDto> listPromoPost(@RequestParam() int user_id) {
        return new ResponseEntity<>(iProductService.getPromoPostList(user_id), HttpStatus.OK);
    }


}
