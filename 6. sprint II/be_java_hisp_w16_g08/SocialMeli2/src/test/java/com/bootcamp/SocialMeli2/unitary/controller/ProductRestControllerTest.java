package com.bootcamp.SocialMeli2.unitary.controller;

import com.bootcamp.SocialMeli2.controller.ProductRestController;
import com.bootcamp.SocialMeli2.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRestControllerTest {

    @Mock
    IProductService productService;

    @InjectMocks
    ProductRestController productRestController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void publishPost() {
    }
}