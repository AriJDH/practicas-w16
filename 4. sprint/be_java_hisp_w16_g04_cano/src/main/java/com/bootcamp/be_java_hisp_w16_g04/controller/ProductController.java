package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  public ResponseEntity<ResponseApiDTO> createPublicacion(@RequestBody RequestCreatePublicationDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.createProduct(publicationDTO), HttpStatus.OK);
  }

  @PostMapping("/promo-post")
  public ResponseEntity<ResponseApiDTO> createPublicationWithDiscount(@RequestBody RequestCreatePublicationDiscountDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.createProduct(publicationDTO), HttpStatus.OK);
  }

  @GetMapping("/promo-post/count")
  public ResponseEntity<ResponseCountDiscountDTO> findProductWithDiscountByUserId(@RequestParam("user_id") Integer userId) {
    return new ResponseEntity<>(iProductService.countProductsDiscountByUserId(userId), HttpStatus.OK);
  }

  @GetMapping("/promo-post/list")
  public ResponseEntity<ResponseListDiscountDTO> listProductWithDiscountByUserId(@RequestParam("user_id") Integer userId) {
    return new ResponseEntity<>(iProductService.listProductsDiscountByUserId(userId), HttpStatus.OK);
  }
}
