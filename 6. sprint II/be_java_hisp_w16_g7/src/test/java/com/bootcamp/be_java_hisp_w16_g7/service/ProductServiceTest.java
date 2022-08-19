package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.InvalidQueryException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g7.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    ProductService productService;


    //Test

    @Test
    public void testThatRecentPostAreFromLastTwoWeek(){

        //Arrange

        User userToMock = TestUtil.createUser();

        ResponsePostDTO expectedPost = new ResponsePostDTO(2222, 1234, LocalDate.of(2022, 8, 10), new ProductDTO(), 99, 1000.0);
        RecentPostsDTO expected = new RecentPostsDTO(1111, List.of(expectedPost) );

        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(userToMock);


        //Act
        var actual = productService.recentPost(1111, "date_asc");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void orderByDateAscTest(){
        //Arrange
        User user2 = TestUtil.userSell();
        User user1 = new User(1111,"Juan",new ArrayList<>(),List.of(user2),new ArrayList<>());

        List<ResponsePostDTO> expected = TestUtil.responsePostAscDTOS();

        //Act
        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(user1);

        RecentPostsDTO response = productService.recentPost(1111,"date_asc");
        //Assert

        Assertions.assertEquals(expected,response.getResponsePostDTOS());
    }

    @Test
    void orderByDateDesTest(){
        //Arrange

        User user2 = TestUtil.userSell();
        User user1 = new User(1111,"Juan",new ArrayList<>(),List.of(user2),new ArrayList<>());

        List<ResponsePostDTO> expected = TestUtil.responsePostDTOS();

        //Act
        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(user1);

        RecentPostsDTO response = productService.recentPost(1111,"date_desc");
        //Assert

        Assertions.assertEquals(expected,response.getResponsePostDTOS());
    }

    @Test
    void orderByDateNullTest(){
        //Arrange
        User user2 = TestUtil.userSell();
        User user1 = new User(1111,"Juan",new ArrayList<>(),List.of(user2),new ArrayList<>());

        List<ResponsePostDTO> expected = TestUtil.responsePostDTOS();

        //Act
        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(user1);

        RecentPostsDTO response = productService.recentPost(1111,null);
        //Assert

        Assertions.assertEquals(expected,response.getResponsePostDTOS());
    }

    @Test
    public void recentPostWithNonExistingUserTest(){

        //Arrange
        when(userRepository.existsUser(5555)).thenReturn(false);

        //Act & Assert
        assertThrows(UserNotFoundException.class, () -> productService.recentPost(5555, "date_desc" ));

    }

    @Test
    public void recentPostWithWrongOrder(){

        //Arrange
        User userToMock = TestUtil.createUser();

        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(userToMock);


        //Act & Assert
        assertThrows(InvalidQueryException.class, () -> productService.recentPost(1111, "desc" ));

    }

}