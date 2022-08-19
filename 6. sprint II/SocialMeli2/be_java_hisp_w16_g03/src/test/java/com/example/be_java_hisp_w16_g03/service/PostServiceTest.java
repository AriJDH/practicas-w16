package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostWithIdDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.Product;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import org.junit.jupiter.api.Assertions;
import com.example.be_java_hisp_w16_g03.exception.InvalidOrderTypeException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    PostService postService;


    @Test
    public void verifyDateOrderDesc() {

        //arrange
        String DATE_DESC = "date_desc";
        Post post1 = Post.builder().date(LocalDate.now().minusDays(2)).product(new Product()).build();
        Post post2 = Post.builder().date(LocalDate.now().minusDays(3)).product(new Product()).build();

        List<PostWithIdDTO> expectedResult = List.of(Mapper.postToPostWithIdDto(post1), Mapper.postToPostWithIdDto(post2));

        User userSeller = User.builder().userId(1).posts(new ArrayList<>(List.of(post1, post2))).build();
        User userFollower = User.builder().userId(2).followeds(new ArrayList<>(List.of(userSeller))).build();
        when(repository.getFollowedsByUserId(Mockito.anyInt())).thenReturn(List.of(userSeller));

        //act
        PostsDTO result = postService.getLatestPostsOrderedByUserId(userFollower.getUserId(), DATE_DESC);

        //assert
        verify(repository, times(1)).getFollowedsByUserId(Mockito.anyInt());
        assertArrayEquals(expectedResult.toArray(), result.getPosts().toArray());

    }

    @Test
    public void verifyDateOrderAsc() {

        //arrange
        String DATE_ASC = "date_asc";
        Post post1 = Post.builder().date(LocalDate.now().minusDays(2)).product(new Product()).build();
        Post post2 = Post.builder().date(LocalDate.now().minusDays(3)).product(new Product()).build();

        List<PostWithIdDTO> expectedResult = List.of(Mapper.postToPostWithIdDto(post2), Mapper.postToPostWithIdDto(post1));

        User userSeller = User.builder().userId(1).posts(new ArrayList<>(List.of(post1, post2))).build();
        User userFollower = User.builder().userId(2).followeds(new ArrayList<>(List.of(userSeller))).build();
        when(repository.getFollowedsByUserId(Mockito.anyInt())).thenReturn(List.of(userSeller));

        //act
        PostsDTO result = postService.getLatestPostsOrderedByUserId(userFollower.getUserId(), DATE_ASC);

        //assert
        verify(repository, times(1)).getFollowedsByUserId(Mockito.anyInt());
        assertArrayEquals(expectedResult.toArray(), result.getPosts().toArray());
    }

    @Test
    public void verifyCorrectOrderType(){

        //arrange
        String Param = "date_asc";
        Post post1 = Post.builder().date(LocalDate.now().minusDays(2)).product(new Product()).build();
        Post post2 = Post.builder().date(LocalDate.now().minusDays(3)).product(new Product()).build();

        User userSeller = User.builder().userId(1).posts(new ArrayList<>(List.of(post1, post2))).build();
        User userFollower = User.builder().userId(2).followeds(new ArrayList<>(List.of(userSeller))).build();
        when(repository.getFollowedsByUserId(Mockito.anyInt())).thenReturn(List.of(userSeller));

        //act
        PostsDTO result = postService.getLatestPostsOrderedByUserId(userFollower.getUserId(), Param);

        //assert
        verify(repository, times(1)).getFollowedsByUserId(Mockito.anyInt());
        assertEquals(result.getPosts().size(), 2);

    }


    @Test
    public void verifyIncorrectOrderType(){
        assertThrows(InvalidOrderTypeException.class,
                () -> postService.getLatestPostsOrderedByUserId(1, "invalid"));
    }

    @Test
    public void verifyPostsLastTwoWeeks(){

        //arrange
        String Param = "date_desc";
        Post post1 = Post.builder().date(LocalDate.now().minusDays(2)).product(new Product()).build();
        Post post2 = Post.builder().date(LocalDate.now().minusDays(3)).product(new Product()).build();
        Post post3 = Post.builder().date(LocalDate.now().minusWeeks(2).minusDays(1)).product(new Product()).build();

        User userSeller = User.builder().userId(1).posts(new ArrayList<>(List.of(post1, post2, post3))).build();
        User userFollower = User.builder().userId(2).followeds(new ArrayList<>(List.of(userSeller))).build();
        when(repository.getFollowedsByUserId(Mockito.anyInt())).thenReturn(List.of(userSeller));

        List<PostWithIdDTO> expected = new ArrayList<>(List.of(Mapper.postToPostWithIdDto(post1), Mapper.postToPostWithIdDto(post2)));

        //act
        PostsDTO result = postService.getLatestPostsOrderedByUserId(userFollower.getUserId(), Param);

        //assert
        verify(repository, times(1)).getFollowedsByUserId(Mockito.anyInt());

        assertArrayEquals(expected.toArray(), result.getPosts().toArray());

        /*
        assertAll(
                () -> assertFalse(result.getPosts().contains(Mapper.postToPostWithIdDto(post3)), "Assert 1"),
                () -> assertTrue(result.getPosts().contains(Mapper.postToPostWithIdDto(post1)), "Assert 2"),
                () -> assertTrue(result.getPosts().contains(Mapper.postToPostWithIdDto(post2)), "Assert 3")
        );
        */
    }

}
