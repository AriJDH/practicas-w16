package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.ListProductByDateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseApiDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
import com.bootcamp.be_java_hisp_w16_g04.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Service in charge of product-related functionalities
 */
@Validated
@RestController
@RequestMapping("/products")
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
  public ResponseEntity<ResponseApiDTO> createPublicacion(@Valid @RequestBody RequestCreatePublicationDTO publicationDTO) {
    return new ResponseEntity<>(iProductService.CreateProduct(publicationDTO), HttpStatus.OK);
  }

  //Publicacion

  /**
   * Method to obtain a list of the publications of the users followed by a user.
   * @param userId current user id
   * @param order Order in which the list will be submitted
   * @return ResponseEntity with a DTO to give information to the user
   */
  @GetMapping("/followed/{userId}/list")
  public ResponseEntity<ListProductByDateDTO> getProductByDate(@PathVariable
                                                                 @Min(value = 1, message = "El ID deber ser mayor a cero.")
                                                                 @NotNull(message = "El ID no puede estar vacio.")
                                                                 Integer userId,
                                                               @RequestParam
                                                               Optional<String> order) {

    ListProductByDateDTO result = iPublicationService.getListProductByDate(userId, order.orElse(""));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
