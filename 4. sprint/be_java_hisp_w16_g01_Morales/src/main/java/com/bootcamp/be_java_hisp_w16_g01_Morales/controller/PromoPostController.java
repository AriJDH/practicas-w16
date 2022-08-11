package com.bootcamp.be_java_hisp_w16_g01_Morales.controller;

import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.CountPromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w16_g01_Morales.entities.PromoPost;
import com.bootcamp.be_java_hisp_w16_g01_Morales.service.IPromoPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class PromoPostController {

    @Autowired
    private IPromoPostService promoPostService;

    @PostMapping("/promo-post")
    public ResponseEntity<Integer> createPromoPost(@RequestBody PromoPostDTO promoPostDTO){
        return new ResponseEntity<>(promoPostService.createPromoPost(promoPostDTO), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count{userId}")
    public ResponseEntity<CountPromoPostDTO> getPromoCount(@RequestParam int userId){
        return  new ResponseEntity<>(promoPostService.countPromoPost(userId),HttpStatus.OK);
    }

    @GetMapping("/promo-post/list{userId}")
    public ResponseEntity<List<PromoPost>> getPromoPost(@RequestParam int userId){
        return  new ResponseEntity<>(promoPostService.getPromoPostsByUserId(userId),HttpStatus.OK);
    }
}
