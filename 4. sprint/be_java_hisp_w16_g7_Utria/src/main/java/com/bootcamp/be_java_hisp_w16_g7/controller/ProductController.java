package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.PromotionProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
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
            @ApiResponse(responseCode = "200", description = "Recent Posts found"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Unknown query")})
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<RecentPostsDTO> recentPost(@PathVariable int userId,
                                                     @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iProductService.recentPost(userId, order), HttpStatus.OK);
    }

    //Individual
    @Operation(summary = "Create a promotion post to specific user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post created"),
            @ApiResponse(responseCode = "400", description = "User not found")})
    @PostMapping("/promo-post")
    public ResponseEntity<ApiResponseDto> createPromotionPost(@RequestBody PostDTO postDto) {
        return new ResponseEntity<>(iProductService.createPromotionPost(postDto), HttpStatus.OK);
    }
    @Operation(summary = "Get total products with promotion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400", description = "User isn't a seller", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)})
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromotionProductDTO> getPromotionProducts(@RequestParam int userId){
        return new ResponseEntity<>(iProductService.getPromotionProducts(userId), HttpStatus.OK);
    }
}
