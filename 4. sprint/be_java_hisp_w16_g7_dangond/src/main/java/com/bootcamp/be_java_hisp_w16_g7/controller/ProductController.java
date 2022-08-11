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
    public ResponseEntity<ApiResponseDTO> createPost(@RequestBody PostDTO postDto) {
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

    @Operation(summary = "Create post of a new product with discount")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "User not found")})

    @PostMapping("/promo-post")
    public ResponseEntity<ApiResponseDTO> postOfProductWithDiscount(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(iProductService.postOfProductWithDiscount(postDto), HttpStatus.OK);
    }

    @Operation(summary = "Get the amount of products with discount of a specific seller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Object given"),
            @ApiResponse(responseCode = "400", description = "User is not a seller"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> getCountProductsWithDiscount(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(iProductService.getCountProductsWithDiscount(userId), HttpStatus.OK);
    }

    @Operation(summary = "Get a list of all products with discount of a specific seller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List given"),
            @ApiResponse(responseCode = "400", description = "User is not a seller"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/promo-post/list")
    public ResponseEntity<List<ProductDTO>> getListProductsWithDiscount(@RequestParam("user_id") int userId) {
        return new ResponseEntity<>(iProductService.getListProductsWithDiscount(userId), HttpStatus.OK);
    }
}
