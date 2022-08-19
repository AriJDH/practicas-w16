package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.ProductResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;
import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
   @Mock
   UserService userService;
   @Mock
   PostRepository postRepository;
   @InjectMocks
   PostService postService;

   @Test
   void findById() {
   }

   @Test
   void findAll() {
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

   @Test
   void save() {
   }

   @Test
   void listFollowersPosts() {
   }
}
