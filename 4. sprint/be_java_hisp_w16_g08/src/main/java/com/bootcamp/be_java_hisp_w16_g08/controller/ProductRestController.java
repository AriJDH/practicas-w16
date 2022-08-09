package com.bootcamp.be_java_hisp_w16_g08.controller;

import com.bootcamp.be_java_hisp_w16_g08.service.IProductService;
import com.bootcamp.be_java_hisp_w16_g08.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

    final
    IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }
}
