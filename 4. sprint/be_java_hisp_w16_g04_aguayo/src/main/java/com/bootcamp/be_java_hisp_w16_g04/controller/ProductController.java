package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
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

  /**
   * Method for creating a publication
   * @param publicationDTO DTO of the publication to be created
   * @return ResponseEntity with a DTO to give information to the user
   */
  @PostMapping("/post")
  public ResponseEntity<ResponseApiDTO> createPublicacion(@RequestBody RequestCreatePublicationDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.CreateProduct(publicationDTO), HttpStatus.OK);
  }
  /**
   * US 0010: Carry out the publication of a new product in promotion
   * @param ProductPromoDTO DTO of the publication to be created
   * @return ResponseEntity ResponseApiDTO
   */
  @PostMapping("/promo-post")
  public ResponseEntity<ResponseApiDTO> createProductPromo(@RequestBody RequestCreatePublicationDTO ProductPromoDTO) {
    return new ResponseEntity<>(iProductService.CreateProduct(ProductPromoDTO), HttpStatus.OK);
  }

  /**
   *  US 0011: Get the number of products in promotion of a given seller
   * @param userId of the User
   * @return ResponseEntity RequestCountProductPromo
   */
  @GetMapping("/promo-post/count")
  public ResponseEntity<RequestCountProductPromo> countProductPromo(@RequestParam("user_id") Integer userId) {
    RequestCountProductPromo result = iProductService.countProduct(userId);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  /**
   *  US 0012: Obtain a list of all the products in promotion of a certain seller
   * @param userId userId of the User
   * @return ResponseEntity ResponseListPromoDTO
   */
  @GetMapping("/promo-post/list")
  public ResponseEntity<ResponseListPromoDTO> listProductPromo(@RequestParam("user_id") Integer userId) {
    ResponseListPromoDTO result = iProductService.listProductPromo(userId);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

}
