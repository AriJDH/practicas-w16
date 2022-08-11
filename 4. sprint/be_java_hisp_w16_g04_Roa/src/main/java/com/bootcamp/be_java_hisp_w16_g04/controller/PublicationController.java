package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.*;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Service in charge of publication-related functionalities
 */
@RestController
@RequestMapping("/products")
public class PublicationController {

  @Autowired
  IPublicationService iPublicationService;

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

  @GetMapping("/promo-post/count")
  public ResponseEntity<PromoPotsDTO> getPromoProductPost(@RequestParam Integer user_id){
    return new ResponseEntity<>(iPublicationService.getListPromoProduct(user_id), HttpStatus.OK);
  }

}
