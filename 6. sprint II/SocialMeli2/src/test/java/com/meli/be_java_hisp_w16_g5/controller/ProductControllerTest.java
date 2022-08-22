package com.meli.be_java_hisp_w16_g5.controller;

import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import com.meli.be_java_hisp_w16_g5.exceptions.ProducNotFoundException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    PostService postService;

    @InjectMocks
    ProductController productController;

    @Test
    public void savePost() throws UserNotFoundException, ProducNotFoundException {
        Product productSilla = new Product(1,"Silla gamer","Silla","Lagotech","Black","Silla gamer lagotech negra");
        LocalDate date = LocalDate.of(2022,8,8);
        Post postSilla = new Post(1,1,date, productSilla,1, 2032496.0,false,0.0 );

        productController.savePost(postSilla);

        verify(postService, atLeastOnce()).save(postSilla);
    }


}
