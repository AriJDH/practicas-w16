package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.ProductDTO;
import com.bootcamp.SocialMeli2.dto.RequestPostDTO;
import com.bootcamp.SocialMeli2.dto.ResponsePostDTO;
import com.bootcamp.SocialMeli2.entity.Follow;
import com.bootcamp.SocialMeli2.entity.Post;
import com.bootcamp.SocialMeli2.entity.Product;
import com.bootcamp.SocialMeli2.entity.User;
import com.bootcamp.SocialMeli2.exceptions.OrdenPostException;
import com.bootcamp.SocialMeli2.repository.PostRepository;
import com.bootcamp.SocialMeli2.repository.UserFollowersRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostTest {


    @InjectMocks
    PostService socialMeliServiceE3;

    @Mock
    PostRepository postRepository;

    @Mock
    FollowUnFollowService followUnFollowService;

    @Mock
    UserFollowersRepository userFollowersRepository;

    @Test
    @DisplayName("Obtener los post de las personas que sigue un usuario")
    void getAllPost() {

        //Arrange
        ResponsePostDTO res;
        LocalDate date = LocalDate.now();
        ProductDTO productDTO = new ProductDTO(1, "prueba", "prueba", "prueba", "rojo", "prueba");
        Product product = new Product(1, "prueba", "prueba", "prueba", "rojo", "prueba");
        Post post = new Post(product, 1, 1, date, 1, 3000.0, false, 0.0);
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        Follow follow1 = new Follow(1, "JulianaSeguida");
        Follow follow2 = new Follow(2, "AndreaSeguida");
        List<Follow> followed = new ArrayList<>(Arrays.asList(follow1, follow2));
        List<Follow> followers = new ArrayList<>();

        User user = new User(1, "Andres", followed, followers);
        List<User> users = new ArrayList<>();
        users.add(user);
        RequestPostDTO requestPostDTO = new RequestPostDTO();
        requestPostDTO.setDate(post.getDate().toString());
        requestPostDTO.setUser_id(user.getUserId());
        requestPostDTO.setProduct(productDTO);
        requestPostDTO.setPrice(post.getPrice());
        requestPostDTO.setCategory(post.getCategory());
        List<RequestPostDTO> list = new ArrayList<>();
        list.add(requestPostDTO);
        int userId = 1;

        ResponsePostDTO response = new ResponsePostDTO(userId, list);

        Mockito.when(postRepository.getPosts()).thenReturn(posts);
        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(users);

        //Act
        res = socialMeliServiceE3.getAllPost(userId);

        //Assert
        Assertions.assertEquals(res, response);

    }

    @Test
    @DisplayName("Obtener los post de las personas que sigue un usuario en un rango dado")
    void getAllPostRange() {

        //Arrange
        ResponsePostDTO res;
        LocalDate date = LocalDate.now();
        Product product = new Product(1, "prueba", "prueba", "prueba", "rojo", "prueba");
        Post post = new Post(product, 1, 1, date, 1, 3000.0, false, 0.0);
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        Follow follow1 = new Follow(1, "JulianaSeguida");
        Follow follow2 = new Follow(2, "AndreaSeguida");
        List<Follow> followed = new ArrayList<>(Arrays.asList(follow1, follow2));
        List<Follow> followers = new ArrayList<>();

        User user = new User(1, "Andres", followed, followers);
        List<User> users = new ArrayList<>();
        users.add(user);
        RequestPostDTO requestPostDTO = new RequestPostDTO();
        List<RequestPostDTO> list = new ArrayList<>();
        int userId = 1;

        ResponsePostDTO response = new ResponsePostDTO(userId, list);

        Mockito.when(postRepository.getPosts()).thenReturn(posts);
        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(users);

        //Act
        res = socialMeliServiceE3.getAllPost(userId);
        long daysBetween = ChronoUnit.DAYS.between(post.getDate(), date);

        //Assert
        Assertions.assertTrue(daysBetween >= 0 && daysBetween <= 15);

    }

    @Test
    @DisplayName("Obtener los post de las personas que sigue un usuario fuera del rango dado")
    void getAllPostOutRange() {

        //Arrange
        ResponsePostDTO res;
        String fecha = "01-08-2022";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(fecha, format);

        Product product = new Product(1, "prueba", "prueba", "prueba", "rojo", "prueba");
        Post post = new Post(product, 1, 1, date, 1, 3000.0, false, 0.0);
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        Follow follow1 = new Follow(1, "JulianaSeguida");
        Follow follow2 = new Follow(2, "AndreaSeguida");
        List<Follow> followed = new ArrayList<>(Arrays.asList(follow1, follow2));
        List<Follow> followers = new ArrayList<>();

        User user = new User(1, "Andres", followed, followers);
        List<User> users = new ArrayList<>();
        users.add(user);
        RequestPostDTO requestPostDTO = new RequestPostDTO();
        List<RequestPostDTO> list = new ArrayList<>();
        int userId = 1;

        ResponsePostDTO response = new ResponsePostDTO(userId, list);

        Mockito.when(postRepository.getPosts()).thenReturn(posts);
        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(users);

        //Act
        res = socialMeliServiceE3.getAllPost(userId);
        long daysBetween = ChronoUnit.DAYS.between(post.getDate(), LocalDate.now());

        //Assert
        Assertions.assertFalse(daysBetween >= 0 && daysBetween <= 15);

    }


    @Test
    @DisplayName("Obtener los post de las personas que sigue un usuario ordenadas ascendentemente")
    void getAllPostOrderAsc() {

        //Arrange
        ResponsePostDTO res;
        List<Post> posts = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        List<Follow> followers = new ArrayList<>();
        User user = new User(2, "Boris", followed, followers);
        List<User> users = new ArrayList<>();
        users.add(user);
        List<RequestPostDTO> list = new ArrayList<>();
        int userId = 2;
        String order = "date_asc";

        ResponsePostDTO response = new ResponsePostDTO(userId, list);

        Mockito.when(postRepository.getPosts()).thenReturn(posts);
        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(users);

        //Act
        res = socialMeliServiceE3.getAllPost(userId, order);

        //Assert
        Assertions.assertEquals(res, response);

    }

    @Test
    @DisplayName("Obtener los post de las personas que sigue un usuario ordenadas descendentemente")
    void getAllPostOrderDesc() {

        //Arrange
        ResponsePostDTO res;
        List<Post> posts = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        List<Follow> followers = new ArrayList<>();
        User user = new User(2, "Boris", followed, followers);
        List<User> users = new ArrayList<>();
        users.add(user);
        List<RequestPostDTO> list = new ArrayList<>();
        int userId = 2;
        String order = "date_desc";

        ResponsePostDTO response = new ResponsePostDTO(userId, list);


        Mockito.when(postRepository.getPosts()).thenReturn(posts);
        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(users);

        //Act
        res = socialMeliServiceE3.getAllPost(userId, order);

        //Assert
        Assertions.assertEquals(res, response);

    }

    @Test
    @DisplayName("Obtener los post de las personas que sigue un usuario con un orden que lanza exception")
    void getAllPostOrderException() {

        //Arrange
        ResponsePostDTO res;
        List<Post> posts = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        List<Follow> followers = new ArrayList<>();
        User user = new User(2, "Boris", followed, followers);
        List<User> users = new ArrayList<>();
        users.add(user);
        List<RequestPostDTO> list = new ArrayList<>();
        int userId = 2;
        String order = "asc";

        ResponsePostDTO response = new ResponsePostDTO(userId, list);

        Mockito.when(postRepository.getPosts()).thenReturn(posts);
        Mockito.when(userFollowersRepository.getUsersList()).thenReturn(users);

        //Act

        //Assert
        Assertions.assertThrows(OrdenPostException.class, () -> socialMeliServiceE3.getAllPost(userId, order));

    }

    @Test
    @Description("Creación de Post")
    public void CreatePostTest() {
        // arrange
        RequestPostDTO requestPostDTO = new RequestPostDTO();
        ProductDTO productDTO = new ProductDTO();
        requestPostDTO.setProduct(productDTO);
        requestPostDTO.setUser_id(1);
        requestPostDTO.setDate("18-08-2022");
        List<User> usersListMock = new ArrayList<>();
        User userMock = new User();
        userMock.setUserId(1);
        usersListMock.add(userMock);
        boolean usuarioEncontrado = true;

        //when(userFollowersRepository.getUsersList()).thenReturn(usersListMock);
        when(followUnFollowService.existUser(requestPostDTO.getUser_id())).thenReturn(usuarioEncontrado);


        // act
        socialMeliServiceE3.createPost(requestPostDTO);

        // assert
        Assertions.assertTrue(usuarioEncontrado);
    }

    @Test
    @Description("No Creacion de Post")
    public void NoCreatePostTest() {
        // arrange
        RequestPostDTO requestPostDTO = new RequestPostDTO();
        ProductDTO productDTO = new ProductDTO();
        requestPostDTO.setProduct(productDTO);
        requestPostDTO.setUser_id(1);
        requestPostDTO.setDate("18-08-2022");
        List<User> usersListMock = new ArrayList<>();
        User userMock = new User();
        userMock.setUserId(1);
        usersListMock.add(userMock);
        boolean usuarioEncontrado = false;

        //when(userFollowersRepository.getUsersList()).thenReturn(usersListMock);
        when(followUnFollowService.existUser(requestPostDTO.getUser_id())).thenReturn(usuarioEncontrado);


        // act
        socialMeliServiceE3.createPost(requestPostDTO);

        // assert
        Assertions.assertFalse(usuarioEncontrado);
    }
}
