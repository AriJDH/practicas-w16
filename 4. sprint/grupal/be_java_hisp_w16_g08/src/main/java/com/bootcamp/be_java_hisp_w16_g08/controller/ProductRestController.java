package com.bootcamp.be_java_hisp_w16_g08.controller;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08.service.IProductService;
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

}
