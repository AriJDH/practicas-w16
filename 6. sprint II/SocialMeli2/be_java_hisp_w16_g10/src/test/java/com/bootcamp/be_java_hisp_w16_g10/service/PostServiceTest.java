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
import com.bootcamp.be_java_hisp_w16_g10.dto.response.ProductResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.lenient;
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
        assertThrows(NotFoundException.class, () -> postService.findById(id));
        verify(postRepository, atLeastOnce()).findById(id);

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
        assertThrows(ConstraintViolationException.class, () -> postService.save(postReqDTO));
    }

    //TODO check findById in the listFollowersPosts
    @Test
    void listFollowersPosts() {

    }

    @Test
    void shouldRaiseExceptionWhenOrderParamIsNotValid() {
        User user = Factory.generateUser(1);
        when(this.userService.findById(1)).thenReturn(user);
        assertThrows(BadRequestException.class, () -> {
            this.postService.listFollowersPosts(1, "pato");
        });
    }

    @Test
    void shouldReturnOrdererdByDateAscWhenIsCalledWithDateAscParam() {
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
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());
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
        postsUser4.stream().forEach(post -> post.setDate(LocalDate.now().minusDays(30)));

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
    void shouldReturnOrdererdByDateDescWhenIsCalledWithDateDescParam() {
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
   void findByUserId() {

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


      Post post =  Post.builder()
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
      List<PostResDTO> resPostService =  postService.findByUserId(Mockito.anyInt());
      verify(postRepository,atMostOnce()).findByUserId(Mockito.anyInt());
      Assertions.assertTrue(resPostService.equals(listPostResDTO));

   }

}
