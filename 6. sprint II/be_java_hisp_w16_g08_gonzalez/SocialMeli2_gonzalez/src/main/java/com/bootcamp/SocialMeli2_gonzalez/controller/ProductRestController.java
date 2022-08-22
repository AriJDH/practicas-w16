package com.bootcamp.SocialMeli2_gonzalez.controller;

import com.bootcamp.SocialMeli2_gonzalez.dto.request.PostDto;
import com.bootcamp.SocialMeli2_gonzalez.service.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProductRestController {

    final
    IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products/post")
    public void publishPost(@Valid @RequestBody PostDto post){
        productService.publishPost(post);
    }

}
