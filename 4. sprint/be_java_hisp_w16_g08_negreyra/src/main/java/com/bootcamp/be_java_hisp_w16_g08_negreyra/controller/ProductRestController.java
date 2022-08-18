package com.bootcamp.be_java_hisp_w16_g08_negreyra.controller;

import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.PromoPostAmmountDto;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.PromoPostOfUserDto;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.PromoProductPostDto;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.service.IProductService;
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
    public void publishPost(@RequestBody PromoProductPostDto discountPost){
        productService.publishDiscountPost(discountPost);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoPostAmmountDto> publishPost(@RequestParam int user_id){
        return new ResponseEntity<>(productService.getPromoPostAmmount(user_id), HttpStatus.OK);
    }

    @GetMapping("/products/promo-post/list")
    public ResponseEntity<PromoPostOfUserDto> ListPromoPostOfVendor(@RequestParam int user_id){
        return new ResponseEntity<>(productService.ListPromoPostOfVendor(user_id), HttpStatus.OK);
    }

}
