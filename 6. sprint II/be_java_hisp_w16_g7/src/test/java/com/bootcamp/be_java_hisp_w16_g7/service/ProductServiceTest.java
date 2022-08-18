package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.InvalidQueryException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
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

    @Test
    void orderByDateAscTest(){
        //Arrange
        Product product = new Product(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        Post post1 = new Post(2222,1,LocalDate.parse("2022-08-12"), product,11,12300,false,0);
        Post post2 = new Post(2222,2,LocalDate.parse("2022-08-11"), product,11,11300,false,0);
        User user2 = new User(2222,"Camilo",new ArrayList<>(),new ArrayList<>(),List.of(post1,post2));
        User user1 = new User(1111,"Juan",new ArrayList<>(),List.of(user2),new ArrayList<>());

        ProductDTO productDTO= new ProductDTO(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        ResponsePostDTO postDTO1 = new ResponsePostDTO(2222,1,LocalDate.parse("2022-08-12"), productDTO,11,12300);
        ResponsePostDTO postDTO2 = new ResponsePostDTO(2222,2,LocalDate.parse("2022-08-11"), productDTO,11,11300);

        RecentPostsDTO expected = new RecentPostsDTO(1111,List.of(postDTO2,postDTO1));

        //Act
        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(user1);

        RecentPostsDTO response = productService.recentPost(1111,"date_asc");
        //Assert

        Assertions.assertEquals(expected,response);
    }

    @Test
    void orderByDateDesTest(){
        //Arrange
        Product product = new Product(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        Post post1 = new Post(2222,1,LocalDate.parse("2022-08-12"), product,11,12300,false,0);
        Post post2 = new Post(2222,2,LocalDate.parse("2022-08-11"), product,11,11300,false,0);
        User user2 = new User(2222,"Camilo",new ArrayList<>(),new ArrayList<>(),List.of(post1,post2));
        User user1 = new User(1111,"Juan",new ArrayList<>(),List.of(user2),new ArrayList<>());

        ProductDTO productDTO= new ProductDTO(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        ResponsePostDTO postDTO1 = new ResponsePostDTO(2222,1,LocalDate.parse("2022-08-12"), productDTO,11,12300);
        ResponsePostDTO postDTO2 = new ResponsePostDTO(2222,2,LocalDate.parse("2022-08-11"), productDTO,11,11300);

        RecentPostsDTO expected = new RecentPostsDTO(1111,List.of(postDTO1,postDTO2));

        //Act
        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(user1);

        RecentPostsDTO response = productService.recentPost(1111,"date_desc");
        //Assert

        Assertions.assertEquals(expected,response);
    }

    @Test
    void orderByDateNullTest(){
        //Arrange
        Product product = new Product(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        Post post1 = new Post(2222,1,LocalDate.parse("2022-08-12"), product,11,12300,false,0);
        Post post2 = new Post(2222,2,LocalDate.parse("2022-08-11"), product,11,11300,false,0);
        User user2 = new User(2222,"Camilo",new ArrayList<>(),new ArrayList<>(),List.of(post1,post2));
        User user1 = new User(1111,"Juan",new ArrayList<>(),List.of(user2),new ArrayList<>());

        ProductDTO productDTO= new ProductDTO(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        ResponsePostDTO postDTO1 = new ResponsePostDTO(2222,1,LocalDate.parse("2022-08-12"), productDTO,11,12300);
        ResponsePostDTO postDTO2 = new ResponsePostDTO(2222,2,LocalDate.parse("2022-08-11"), productDTO,11,11300);

        RecentPostsDTO expected = new RecentPostsDTO(1111,List.of(postDTO1,postDTO2));

        //Act
        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(user1);

        RecentPostsDTO response = productService.recentPost(1111,null);
        //Assert

        Assertions.assertEquals(expected,response);
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
        List<Post> posts = List.of(new Post(2222, 1234, LocalDate.of(2022, 8, 10), new Product(), 99, 1000.0, false, 0.0),
                new Post(2222, 1234, LocalDate.of(2022, 7, 10), new Product(), 99, 1000.0, false, 0.0));
        List<User> followers = List.of(new User(2222, "User2", List.of(), List.of(), posts ));
        User userToMock = new User(1111, "User1", List.of(), followers, List.of());

        when(userRepository.existsUser(1111)).thenReturn(true);
        when(userRepository.findUserById(1111)).thenReturn(userToMock);


        //Act & Assert
        assertThrows(InvalidQueryException.class, () -> productService.recentPost(1111, "desc" ));

    }

}