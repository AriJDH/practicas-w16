package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
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
        List<Post> posts = List.of(new Post(2222, 1234, LocalDate.of(2022, 8, 10), new Product(), 99, 1000.0, false, 0.0),
                new Post(2222, 1234, LocalDate.of(2022, 7, 10), new Product(), 99, 1000.0, false, 0.0));
        List<User> followers = List.of(new User(2222, "User2", List.of(), List.of(), posts ));
        User userToMock = new User(1111, "User1", List.of(), followers, List.of());

        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(userToMock);


        //Act
        var actual = productService.recentPost(1111, "date_asc");

        //Assert
        ResponsePostDTO expectedPost = new ResponsePostDTO(2222, 1234, LocalDate.of(2022, 8, 10), new ProductDTO(), 99, 1000.0);
        RecentPostsDTO expected = new RecentPostsDTO(1111, List.of(expectedPost) );

        assertEquals(expected, actual);
    }

}