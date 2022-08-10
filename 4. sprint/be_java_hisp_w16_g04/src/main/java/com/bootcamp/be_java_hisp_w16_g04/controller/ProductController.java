package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IProductService;
import com.bootcamp.be_java_hisp_w16_g04.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping("/post")
    public ResponseEntity<String> createPublicacion(@RequestBody RequestCreatePublicationDTO publicationDTO){
        return new ResponseEntity<>(iProductService.CreateProduct(publicationDTO),HttpStatus.OK);
    }
}
