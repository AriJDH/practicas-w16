package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.DiscountedProductSellerDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseApiDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Service in charge of product-related functionalities
 */
@RestController
@RequestMapping("products")
public class ProductController {

  @Autowired
  IProductService iProductService;

  /**
   * Method for creating a publication
   * @param publicationDTO DTO of the publication to be created
   * @return ResponseEntity with a DTO to give information to the user
   */
  @PostMapping("/post")
  public ResponseEntity<ResponseApiDTO> createPublicacion(@RequestBody @Valid RequestCreatePublicationDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.CreateProduct(publicationDTO), HttpStatus.OK);
  }

  /**
   * Method for creating a promo publication
   * @param publicationDTO DTO of the publication to be created
   * @return ResponseEntity with a DTO to give information to the user
   */
  @PostMapping("/promo-post")
  public ResponseEntity<ResponseApiDTO> createPromoPublication(@RequestBody RequestCreatePublicationDTO publicationDTO){
    return new ResponseEntity<>(iProductService.CreateProduct(publicationDTO), HttpStatus.OK);
  }

  /**
   * Method to obtain the amount of promotional products from a user.
   * @param user_id current user id
   * @return ResponseEntity with a DTO to give information to the user
   */
  @GetMapping("/promo-post/count")
  public ResponseEntity<DiscountedProductSellerDTO> discountedProducts(@RequestParam Integer user_id){
    return new ResponseEntity<>(iProductService.discountedProducts(user_id), HttpStatus.OK);
  }
}
