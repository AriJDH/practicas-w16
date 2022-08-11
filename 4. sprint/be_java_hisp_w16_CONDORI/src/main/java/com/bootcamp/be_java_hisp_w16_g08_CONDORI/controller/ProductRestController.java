package com.bootcamp.be_java_hisp_w16_g08_CONDORI.controller;

import com.bootcamp.be_java_hisp_w16_g08_CONDORI.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_CONDORI.dto.response.PromoPostDto;
import com.bootcamp.be_java_hisp_w16_g08_CONDORI.service.IProductService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
    public void publishPromoPost(@RequestBody PromoPostDto post){
        productService.publishPromoPost(post);
    }




}
