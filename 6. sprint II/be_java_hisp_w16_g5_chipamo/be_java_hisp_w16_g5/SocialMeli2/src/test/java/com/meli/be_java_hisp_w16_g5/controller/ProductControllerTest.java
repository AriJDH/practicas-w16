package com.meli.be_java_hisp_w16_g5.controller;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostsByUserDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.exceptions.ProducNotFoundException;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.service.PostService;
import com.meli.be_java_hisp_w16_g5.util.Util;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void getFollowedProducts() throws UnknownRequestException, UserNotFoundException{
        //Arrange
        User user = UtilTestTools.createCompletedUserWithFollowedPosts("Gae", 1);
        List<PostDto> posts = user.getFollowing().stream().map(
            u ->  Util.castTo(u.getPosts(), PostDto.class)
        ).collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        PostsByUserDto postsByUserDto = new PostsByUserDto(user.getUserId(), posts);
        String order = null;

        when(postService.getFollowedProducts(1, order)).thenReturn(postsByUserDto);

        //Act
        //With Optional
        ResponseEntity<PostsByUserDto> result = productController.getFollowedProducts(1, Optional.empty());

        //Assert
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals(result.getBody(), postsByUserDto);
    }

    @Test
    public void getFollowedProductsAscOrder() throws UnknownRequestException, UserNotFoundException{
        //Arrange
        User user = UtilTestTools.createCompletedUserWithFollowedPosts("Gae", 1);
        String order = "date_asc";
        Integer sortCondition = Util.getSortCondition(order, "date");
        List<PostDto> posts = UtilTestTools.sortFollowedPosts(user, sortCondition);
        PostsByUserDto postsByUserDto = new PostsByUserDto(user.getUserId(), posts);

        when(postService.getFollowedProducts(1, order)).thenReturn(postsByUserDto);

        //Act
        //With Optional
        Optional<String> orderOptional = Optional.of(order);
        ResponseEntity<PostsByUserDto> result = productController.getFollowedProducts(1, orderOptional);

        //Assert
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals(result.getBody(), postsByUserDto);
    }

    @Test
    public void getFollowedProductsDescOrder() throws UnknownRequestException, UserNotFoundException{
        //Arrange
        User user = UtilTestTools.createCompletedUserWithFollowedPosts("Gae", 1);
        String order = "date_desc";
        Integer sortCondition = Util.getSortCondition(order, "date");
        List<PostDto> posts = UtilTestTools.sortFollowedPosts(user, sortCondition);
        PostsByUserDto postsByUserDto = new PostsByUserDto(user.getUserId(), posts);

        when(postService.getFollowedProducts(1, order)).thenReturn(postsByUserDto);

        //Act
        //With Optional
        Optional<String> orderOptional = Optional.of(order);
        ResponseEntity<PostsByUserDto> result = productController.getFollowedProducts(1, orderOptional);

        //Assert
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals(result.getBody(), postsByUserDto);
    }


}
