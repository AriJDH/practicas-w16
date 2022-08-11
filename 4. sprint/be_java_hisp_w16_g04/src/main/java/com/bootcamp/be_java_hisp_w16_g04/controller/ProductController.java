package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
import com.bootcamp.be_java_hisp_w16_g04.service.IPublicationService;
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
  @Autowired
  IPublicationService iPublicationService;

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
   * Method for create a new publication with a promotion
   * @param publicationDTO DTO of the publication to be created
   * @return ResponseEntity with a DTO to give information to the user
   */
  @PostMapping("/promo-post")
  public ResponseEntity<ResponseApiDTO> createPublicacionPromo(@RequestBody RequestCreatePublicationPromoDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.CreateProductPromo(publicationDTO), HttpStatus.OK);
  }
  /**
   * Method for get number promotion by user
   * @param user_id user identification
   * @return ResponseEntity with a DTO to give information to the user
   */
  @GetMapping("/promo-post/count")
  public ResponseEntity<ResponseNumberPromoProductsDTO> getNumberPromoProductsById(@RequestParam Integer user_id){
    return new ResponseEntity<>(iPublicationService.getNumberPromoPublicationById(user_id),HttpStatus.OK);
  }
  /**
   * Method for get list promotion by user
   * @param user_id user identification
   * @return ResponseEntity with a DTO to give information to the user
   */
  @GetMapping("/promo-post/list")
  public ResponseEntity<ResponseListPromoPublicationDTO> getListPromoProductsById(@RequestParam Integer user_id){
    return new ResponseEntity<>(iPublicationService.getListPromoPublication(user_id),HttpStatus.OK);
  }

}
