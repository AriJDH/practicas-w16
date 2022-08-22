package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.ProductResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g10.exception.ConstraintViolationException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g10.util.Factory;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    UserService userService;
    @Mock
    PostRepository postRepository;
    @InjectMocks
    PostService postService;

    @Test
    @DisplayName("Testing find post by id")
    void ShouldFndById() {
        //Arrange
        int id = 1;
        Post post = Factory.generatePost();
        //Act
        when(postRepository.findById(id)).thenReturn(post);
        PostResDTO result = postService.findById(id);
        //Assert
        assertEquals(result.getPostId(), post.getId());
        verify(postRepository, atLeastOnce()).findById(id);
    }

    @Test
    @DisplayName("Throw Not found exception when Post by id not found")
    void shouldThrowNotFoundException_whenPostNotFound() {
        //Arrange
        int id = anyInt();
        //Act
        when(postRepository.findById(id)).thenReturn(null);
        //Assert
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> postService.findById(id));
        verify(postRepository, atLeastOnce()).findById(id);
        assertEquals(String.format("The post with id: %s doesn't exist.", id), notFoundException.getMessage());
    }

    @Test
    @DisplayName("Testing find all post")
    void shouldFindAll() {
        //Arrange
        List<Post> postsMocks = new ArrayList<>();
        //Act
        when(postRepository.findAll()).thenReturn(postsMocks);
        List<PostResDTO> result = postService.findAll();
        //Assert
        assertEquals(result.size(), postsMocks.size());
        verify(postRepository, atLeastOnce()).findAll();
    }


    @Test
    @DisplayName("Testing save post")
    void shouldSavePost() {
        //Arrange
        PostReqDTO postReqDTO = Factory.generateProductReqDTO();
        Post post = Mapper.parseToPost(postReqDTO);
        //Act
        postService.save(postReqDTO);
        //Assert
        verify(postRepository, atLeastOnce()).save(post);
    }

    @Test
    @DisplayName("Testing throw ConstraintViolationException when Date is in the future of post")
    void shouldThrowConstraintViolationException_whenDateIsNext() {
        //Arrange
        PostReqDTO postReqDTO = Factory.generateProductReqDTOWithBadDate();
        //Act
        //postService.save(postReqDTO);
        //Assert
        ConstraintViolationException constraintViolationException = assertThrows(ConstraintViolationException.class, () -> postService.save(postReqDTO));
        assertEquals("The date of the post is in the future.", constraintViolationException.getMessage());
    }

    //Este test no tiene mucho sentido, pero de la manera en la que creamos dependencia entre PostService y UserService
    //no nos permite lograr que el user service actue de manera normal, así que tenemos que mockear el throw de la excepción
    @Test
    void listFollowersPosts() {
        // Arrange
        Integer userID = 100;

        //Act
        when(userService.findById(Mockito.anyInt())).
                thenThrow(new NotFoundException(String.format("The user with id: %s doesn't exist.", userID)));

        //Assert
        assertThrows(NotFoundException.class, () -> postService.listFollowersPosts(userID, "name_asc"));
    }

    @Test
    void shouldRaiseException_whenOrderParamIsNotValid() {
        // Arrange
        User user = Factory.generateUser(1);

        //Act
        when(this.userService.findById(1)).thenReturn(user);

        //Assert
        BadRequestException badRequestException = assertThrows(BadRequestException.class, () -> this.postService.listFollowersPosts(1, "pato"));
        assertEquals("Invalid order parameter", badRequestException.getMessage());
    }

    @Test
    void shouldReturnOrderedByDateAsc_whenIsCalledWithDateAscParam() {
        // Arrange
        User user = Factory.generateUserWithFollowed(1);
        //id uno es el usuario, 2, 3, 4 que tienen que tener posts
        List<Post> postsUser2 = Factory.generateListOfPosts(2, 2);
        List<Post> postsUser3 = Factory.generateListOfPosts(2, 3);
        List<Post> postsUser4 = Factory.generateListOfPosts(2, 4);

        //Act
        when(this.userService.findById(1)).thenReturn(user);
        when(this.postRepository.findByUserId(2)).thenReturn(postsUser2);
        when(this.postRepository.findByUserId(3)).thenReturn(postsUser3);
        when(this.postRepository.findByUserId(4)).thenReturn(postsUser4);

        List<Post> posts = new ArrayList<>();
        posts.addAll(postsUser2);
        posts.addAll(postsUser3);
        posts.addAll(postsUser4);
        LocalDate localDate = LocalDate.now().minusDays(14);
        posts = posts.stream()
                .filter(post -> post.getDate().compareTo(localDate) > 0)
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());

        //Assert
        assertEquals(
                Mapper.parseToPostListResDTO(user, posts),
                this.postService.listFollowersPosts(1, "date_asc")
        );
    }

    @Test
    void shouldReturnOrderedByDateAscAndFilteredWithMinus14Days() {
        User user = Factory.generateUserWithFollowed(1);
        //id uno es el usuario, 2, 3, 4 que tienen que tener posts

        List<Post> postsUser2 = Factory.generateListOfPosts(2, 2);
        List<Post> postsUser3 = Factory.generateListOfPosts(2, 3);
        List<Post> postsUser4 = Factory.generateListOfPosts(2, 4);
        postsUser4.forEach(post -> post.setDate(LocalDate.now().minusDays(30)));

        when(this.userService.findById(1)).thenReturn(user);
        when(this.postRepository.findByUserId(2)).thenReturn(postsUser2);
        when(this.postRepository.findByUserId(3)).thenReturn(postsUser3);
        when(this.postRepository.findByUserId(4)).thenReturn(postsUser4);

        List<Post> posts = new ArrayList<>();
        posts.addAll(postsUser2);
        posts.addAll(postsUser3);
        posts.addAll(postsUser4);
        LocalDate localDate = LocalDate.now().minusDays(14);
        posts = posts.stream()
                .filter(post -> post.getDate().compareTo(localDate) > 0)
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());
        assertEquals(
                Mapper.parseToPostListResDTO(user, posts),
                this.postService.listFollowersPosts(1, "date_asc")
        );
    }

    @Test
    void shouldReturnOrdererdByDateDesc_whenIsCalledWithDateDescParam() {
        User user = Factory.generateUserWithFollowed(1);
        //id uno es el usuario, 2, 3, 4 que tienen que tener posts
        List<Post> postsUser2 = Factory.generateListOfPosts(2, 2);
        List<Post> postsUser3 = Factory.generateListOfPosts(2, 3);
        List<Post> postsUser4 = Factory.generateListOfPosts(2, 4);

        when(this.userService.findById(1)).thenReturn(user);
        when(this.postRepository.findByUserId(2)).thenReturn(postsUser2);
        when(this.postRepository.findByUserId(3)).thenReturn(postsUser3);
        when(this.postRepository.findByUserId(4)).thenReturn(postsUser4);

        List<Post> posts = new ArrayList<>();
        posts.addAll(postsUser2);
        posts.addAll(postsUser3);
        posts.addAll(postsUser4);
        LocalDate localDate = LocalDate.now().minusDays(14);
        posts = posts.stream()
                .filter(post -> post.getDate().compareTo(localDate) > 0)
                .sorted(Comparator.comparing(Post::getDate).reversed())
                .collect(Collectors.toList());
        assertEquals(
                Mapper.parseToPostListResDTO(user, posts),
                this.postService.listFollowersPosts(1, "date_desc")
        );
    }

    @Test
    void shouldReturnUserPostList_whenValidUserIdIsGiven() {

        //arrange

        PostResDTO postResDTO = PostResDTO.builder()
                .userId(1)
                .postId(2)
                .date(LocalDate.now())
                .category(100)
                .price(20d)
                .product(ProductResDTO.builder()
                        .productId(235)
                        .productName("Silla Gammer")
                        .type("Gammer")
                        .brand("Corsair")
                        .color("Red")
                        .notes("")
                        .build()
                )
                .build();

        List<PostResDTO> listPostResDTO = List.of(
                postResDTO
        );


        Post post = Post.builder()
                .id(2)
                .userId(1)
                .date(LocalDate.now())
                .price(20d)
                .category(100)
                .product(Product.builder()
                        .id(235)
                        .name("Silla Gammer")
                        .type("Gammer")
                        .brand("Corsair")
                        .color("Red")
                        .notes("")
                        .build()
                )
                .build();

        List<Post> listPost = List.of(
                post
        );


        //act

        //Este try es para probar realizar un mock sobre la clase Mapper metodo parseToPostResDTO
        //Al hacer esto no importa que lista de post enviemos siempre nos devolvera el postResDTO
        //Para probar su funcionamiento se deben cambiar los valores de los atributos de post que figura mas arriba.

        //try(MockedStatic<Mapper> mapper = Mockito.mockStatic(Mapper.class)){

        //   mapper.when(()-> Mapper.parseToPostResDTO(Mockito.any())).thenReturn(postResDTO);

        //   lenient().when(postRepository.findByUserId(Mockito.anyInt())).thenReturn(listPost);

        //   List<PostResDTO> resPostService =  postService.findByUserId(Mockito.anyInt());

        //   verify(postRepository,atMostOnce()).findByUserId(Mockito.anyInt());
        //   Assertions.assertTrue(resPostService.equals(listPostResDTO));

        //};

        when(postRepository.findByUserId(Mockito.anyInt())).thenReturn(listPost);
        List<PostResDTO> resPostService = postService.findByUserId(Mockito.anyInt());
        verify(postRepository, atMostOnce()).findByUserId(Mockito.anyInt());
        assertEquals(resPostService, listPostResDTO);

    }

}
