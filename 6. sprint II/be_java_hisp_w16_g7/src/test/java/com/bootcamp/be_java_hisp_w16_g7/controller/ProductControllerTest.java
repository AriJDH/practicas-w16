package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.service.IProductService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    IProductService productService;

    @InjectMocks
    ProductController productController;


    //Test

}