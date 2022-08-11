package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
import com.bootcamp.be_java_hisp_w16_g04.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Service in charge of product-related functionalities
 */
@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @Autowired
    IPublicationService iPublicationService;

    /**
     * Method for creating a publication
     *
     * @param publicationDTO DTO of the publication to be created
     * @return ResponseEntity with a DTO to give information to the user
     */
    @PostMapping("/post")
    public ResponseEntity<ResponseApiDTO> createPublicacion(@RequestBody RequestCreatePublicationDTO publicationDTO) {
        return new ResponseEntity<>(iProductService.CreateProduct(publicationDTO), HttpStatus.OK);
    }
    /**
     * Method to create a publication with promotion
     *
     * @param publicationPromoDTO DTO of the publication to be created
     * @return ResponseEntity with a DTO to give information to the user
     */
    @PostMapping("/promo-post")
    public ResponseEntity<ResponseApiDTO> createPublicationPromo(@RequestBody RequestCreatePublicationPromoDTO publicationPromoDTO) {
        return new ResponseEntity<>(iProductService.createProductPromo(publicationPromoDTO), HttpStatus.OK);
    }

    /**
     * Method to obtain the amount of products in promotion of a certain seller.
     * @param userId current user id
     * @return ResponseEntity with a result to give information to the user
     */
    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountDTO> productPromoCount(@RequestParam Integer userId) {
        PostPromoCountDTO result = iPublicationService.ProductPromoCount(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Method to obtain a list of all the products in promotion of a certain seller
     * @param userId current user id
     * @return ResponseEntity with a result to give information to the user
     */
    @GetMapping("/promo-post/list")
    public ResponseEntity<ProductPromoDTO> ListProductsPromo(@RequestParam Integer userId) {
        ProductPromoDTO result = iPublicationService.getListPostByUserId(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

