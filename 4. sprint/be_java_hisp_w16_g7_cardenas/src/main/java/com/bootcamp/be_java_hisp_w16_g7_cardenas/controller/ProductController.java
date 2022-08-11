package com.bootcamp.be_java_hisp_w16_g7_cardenas.controller;

import com.bootcamp.be_java_hisp_w16_g7_cardenas.dto.*;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
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
            @ApiResponse(responseCode = "201", description = "Recent Posts found"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Unknown query")})
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<RecentPostsDTO> recentPost(@PathVariable int userId,
                                                     @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iProductService.recentPost(userId, order), HttpStatus.CREATED);
    }

    @Operation(summary = "Create post to specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post created"),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "bad discount", content = @Content)
    })
    @PostMapping("/promo-post")
    public ResponseEntity<ApiResponseDto> createPostWithDiscount(@RequestBody PostDiscountDTO postDto) {
        return new ResponseEntity<>(iProductService.createPostWithDiscount(postDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Count products with discount for given seller")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post created"),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "User is not seller", content = @Content),
    })
    @GetMapping("/promo-post/count")
    public ResponseEntity<DiscountCountDTO> getDiscountCount(
            @Parameter(description = "User id") @RequestParam("user_id") int userId) {
        return new ResponseEntity<>(iProductService.getDiscountCount(userId), HttpStatus.OK);
    }
}
