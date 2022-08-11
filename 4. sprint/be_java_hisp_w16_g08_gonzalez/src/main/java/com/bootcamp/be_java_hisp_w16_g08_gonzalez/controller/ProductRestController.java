package com.bootcamp.be_java_hisp_w16_g08_gonzalez.controller;

import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.PostPromoCounterDTO;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.PostPromoDTO;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.ResponseProductPromoDTO;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.service.IProductService;
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
    public void publishPromoPost(@RequestBody PostPromoDTO postPromo){
        productService.publishPostPromo(postPromo);
    }

    @GetMapping("products/promo-post/count")
    public ResponseEntity<PostPromoCounterDTO> getProductsInPromo(@RequestParam ("user_id") int userId){
        return new ResponseEntity<>(productService.getProductsInPromo(userId), HttpStatus.OK);
    }

    @GetMapping("products/promo-post/list")
    public ResponseEntity<ResponseProductPromoDTO> getAllProductsInPromo(@RequestParam ("user_id") int userId){
        return new ResponseEntity<>(productService.getAllProductsInPromo(userId), HttpStatus.OK);
    }
}
