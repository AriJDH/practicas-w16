package com.bootcamp.be_java_hisp_w16_g08_diaz.controller;

import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.request.PromoPostDto;
import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.response.ResponsePromoCounter;
import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.response.ResponsePromoPostFromUserDto;
import com.bootcamp.be_java_hisp_w16_g08_diaz.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void publishPromoPost (@RequestBody PromoPostDto promoPost){productService.publishPromoPost(promoPost);}


    @GetMapping("/products/promo-post/count")
    public ResponseEntity<ResponsePromoCounter> countPromoPost (@RequestParam("user_id") int userId){
        return new ResponseEntity<>(productService.countPromoPost(userId), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<ResponsePromoPostFromUserDto> getPromoPostFromUser(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(productService.getPromoPostFromUser(userId),HttpStatus.OK);
    }
}
