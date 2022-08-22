package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
import com.bootcamp.be_java_hisp_w16_g04.service.IPublicationService;
import com.bootcamp.be_java_hisp_w16_g04.service.ProductService;
import com.bootcamp.be_java_hisp_w16_g04.service.PublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Service in charge of product-related functionalities
 */
@RestController
@RequestMapping("products")
public class ProductController {

  private final IProductService iProductService;
  private final IPublicationService iPublicationService;

  public ProductController(ProductService productService, PublicationService publicationService) {
    this.iProductService = productService;
    this.iPublicationService = publicationService;
  }

  /**
   * Method for creating a publication
   * @param publicationDTO DTO of the publication to be created
   * @return ResponseEntity of status
   */
  @PostMapping("/post")
  public ResponseEntity<ResponseApiDTO> createPublicacion(@Valid @RequestBody RequestCreatePublicationDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.createProduct(publicationDTO), HttpStatus.OK);
  }

  /**
   * Method for creating a publication with discount
   * @param publicationDTO DTO of the publication to be created
   * @return ResponseEntity of status
   */
  @PostMapping("/promo-post")
  public ResponseEntity<ResponseApiDTO> createPublicationWithDiscount(@RequestBody RequestCreatePublicationDiscountDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.createProduct(publicationDTO), HttpStatus.OK);
  }

  /**
   * Method for creating a publication with discount
   * @param userId user id to consult
   * @return ResponseEntity with information about count products with discount by userId
   */
  @GetMapping("/promo-post/count")
  public ResponseEntity<ResponseCountDiscountDTO> findProductWithDiscountByUserId(@RequestParam("user_id") Integer userId) {
    return new ResponseEntity<>(iProductService.countProductsDiscountByUserId(userId), HttpStatus.OK);
  }

  /**
   * Method for creating a publication with discount
   * @param userId DTO of the publication to be created
   * @return ResponseEntity with information about products with discount by userId
   */
  @GetMapping("/promo-post/list")
  public ResponseEntity<ResponseListDiscountDTO> listProductWithDiscountByUserId(@RequestParam("user_id") Integer userId) {
    return new ResponseEntity<>(iProductService.listProductsDiscountByUserId(userId), HttpStatus.OK);
  }

  /**
   * Method to obtain a list of the publications of the users followed by a user.
   * @param userId current user id
   * @param order Order in which the list will be submitted
   * @return ResponseEntity with a DTO to give information to the user
   */
  @GetMapping("/followed/{userId}/list")
  public ResponseEntity<ListProductByDateDTO> getProductByDate(@PathVariable Integer userId, @RequestParam Optional<String> order) {

    ListProductByDateDTO result = iPublicationService.getListProductByDate(userId, order.orElse(""));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
