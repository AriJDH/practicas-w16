package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.PublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDiscountDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseApiDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @PostMapping("/promo-post")
  public ResponseEntity<PublicationDTO> createProductWithDiscount(@RequestBody RequestCreatePublicationDiscountDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.createProductWithDiscount(publicationDTO), HttpStatus.OK);
  }
}
