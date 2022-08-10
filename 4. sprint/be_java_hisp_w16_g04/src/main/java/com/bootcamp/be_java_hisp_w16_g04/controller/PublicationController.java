package com.bootcamp.be_java_hisp_w16_g04.controller;

import com.bootcamp.be_java_hisp_w16_g04.dto.ListProductByDateDTO;
import com.bootcamp.be_java_hisp_w16_g04.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PublicationController {

    @Autowired
    IPublicationService iPublicationService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ListProductByDateDTO> getProductByDate(@PathVariable Integer userId){

        ListProductByDateDTO result = iPublicationService.getListProductByDate(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
