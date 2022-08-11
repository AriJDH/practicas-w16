package com.bootcamp.be_java_hisp_w16_g08_bracco.controller;

import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.PromoDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> publishPromoPost (@RequestBody PromoDto promoPost){
        productService.publishPromoPost(promoPost);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
