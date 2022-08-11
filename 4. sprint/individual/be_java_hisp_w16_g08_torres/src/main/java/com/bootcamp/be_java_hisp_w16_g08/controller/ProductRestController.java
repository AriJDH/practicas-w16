package com.bootcamp.be_java_hisp_w16_g08.controller;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.PromoPostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserPromoCountDto;
import com.bootcamp.be_java_hisp_w16_g08.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    final
    IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products/post")
    public void publishPost(@RequestBody PostDto post){
        productService.publishPost(post);
    }

    @PostMapping("/products/promo-post")
    public void publishPromoPost(@RequestBody PromoPostDto promoPostDto){
        productService.publishPromoPost(promoPostDto);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<UserPromoCountDto> getUserPromoCount(@RequestParam("user_id") int userId) {
        return ResponseEntity.ok(productService.getUserPromoCount(userId));
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<List<PromoPostDto>> getPromoPostByUserId(@RequestParam("user_id") int userId){
        return ResponseEntity.ok(productService.getPromoPostByUserId(userId));
    }


}
