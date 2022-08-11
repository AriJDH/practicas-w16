package com.bootcamp.be_java_hisp_w16_g04.controller;


import com.bootcamp.be_java_hisp_w16_g04.dto.ProductPromotionDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.PromotionDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.UserPromosCountDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Promotion;
import com.bootcamp.be_java_hisp_w16_g04.service.IPromotionService;
import com.bootcamp.be_java_hisp_w16_g04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/products/promo-post")
public class PromotionController {

    @Autowired
    IPromotionService ipromotionService;

    @Autowired
    IUserService iuserService;

    @PostMapping
    public ResponseEntity<ProductPromotionDTO> productPromotion(@RequestBody @Valid Promotion promo){
        return new ResponseEntity<>(ipromotionService.productPromotion(promo), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<UserPromosCountDTO> promosCount(@RequestParam Integer user_id){
        return new ResponseEntity<>(iuserService.promosCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<PromotionDTO> listProductsPromotion(@RequestParam Integer user_id, @RequestParam Optional<String> order){
        return new ResponseEntity<>(iuserService.listProductsPromotion(user_id, order.orElse("")), HttpStatus.OK);
    }
}
