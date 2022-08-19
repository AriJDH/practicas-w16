package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.exception.ConstraintViolationException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g10.util.Factory;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.ProductResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    void ShouldFndById() {
        //Arrange
        int id = 1;
        Post post = Factory.generatePost();
        //Act
        when(postRepository.findById(id)).thenReturn(post);
        PostResDTO result = postService.findById(id);
        //Assert
        assertEquals(result.getPostId(), post.getId());
        verify(postRepository,atLeastOnce()).findById(id);
    }

    @Test
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
    void shouldThrowConstraintViolationException_whenDateIsNext() {
        //Arrange
        PostReqDTO postReqDTO = Factory.generateProductReqDTOWithBadDate();
        //Act
        //postService.save(postReqDTO);
        //Assert
        assertThrows(ConstraintViolationException.class, () -> postService.save(postReqDTO));
    }

    @Test
    void listFollowersPosts() {
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
      .id(5)
      .userId(100)
      .date(LocalDate.now())
      .price(2088d)
      .category(320)
      .product(Product.builder()
         .id(234) 
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
      try(MockedStatic<Mapper> mapper = Mockito.mockStatic(Mapper.class)){

         mapper.when(()-> Mapper.parseToPostResDTO(Mockito.any())).thenReturn(postResDTO);   

         lenient().when(postRepository.findByUserId(Mockito.anyInt())).thenReturn(listPost);

         List<PostResDTO> resPostService =  postService.findByUserId(Mockito.anyInt());   

         verify(postRepository,atMostOnce()).findByUserId(Mockito.anyInt());
         Assertions.assertTrue(resPostService.equals(listPostResDTO));

      };


   }

}
