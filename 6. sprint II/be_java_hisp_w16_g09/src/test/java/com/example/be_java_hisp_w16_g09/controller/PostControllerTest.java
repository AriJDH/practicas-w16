package com.example.be_java_hisp_w16_g09.controller;

import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.ProductDto;
import com.example.be_java_hisp_w16_g09.dto.RecentPostsDTO;
import com.example.be_java_hisp_w16_g09.exception.OrderNotExist;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.service.IPostService;
import com.example.be_java_hisp_w16_g09.service.IUserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {
    @Mock
    IPostService postService;

    @InjectMocks
    PostController postController;

    @Test
    void createPost() {
    }

    @Test
    void getRecentPostsOfSellersFollowedByUserWith() {
    }

    // T0006
    @Test
    void getRecentPostsOfSellersFollowedByUserSortedByDateAsc() {
        var order = "date_asc";
        var oldestPost = new PostDto(1, 1, LocalDate.now().minusDays(1), new ProductDto(), 1, 1);
        var newestPost = new PostDto(1, 2, LocalDate.now(), new ProductDto(), 1, 1);
        List<PostDto> postsDtos =List.of(oldestPost, newestPost);

        when(postService.orderByDate(1, order)).thenReturn(new RecentPostsDTO(1, postsDtos));

        RecentPostsDTO response = postController.getRecentPostsOfSellersFollowedByUserWith(1, order).getBody();

        verify(postService, Mockito.atMostOnce()).orderByDate(1, order);
        assertThat(
                response.getPosts().get(0).getDate()
                        .isBefore(response.getPosts().get(1).getDate())).isTrue();
    }

    // T0006
    @Test
    void getRecentPostsOfSellersFollowedByUserSortedByDateDesc() {
        var order = "date_desc";
        var oldestPost = new PostDto(1, 1, LocalDate.now().minusDays(1), new ProductDto(), 1, 1);
        var newestPost = new PostDto(1, 2, LocalDate.now(), new ProductDto(), 1, 1);
        List<PostDto> postsDtos =List.of(newestPost, oldestPost);

        when(postService.orderByDate(1, order)).thenReturn(new RecentPostsDTO(1, postsDtos));

        RecentPostsDTO response = postController.getRecentPostsOfSellersFollowedByUserWith(1, order).getBody();

        verify(postService, Mockito.atMostOnce()).orderByDate(1, order);
        assertThat(
                response.getPosts().get(0).getDate()
                        .isAfter(response.getPosts().get(1).getDate())).isTrue();
    }

    @Test
    public void shouldReturnPostsOrderedByDateOrderNotExistException() {
        int id = 1;
        String order = "date_asc";

        doThrow(new OrderNotExist()).when(postService).orderByDate(id, order);

        assertThrows(OrderNotExist.class, () -> postController.getRecentPostsOfSellersFollowedByUserWith(id, order));

        verify(postService, Mockito.atMostOnce()).orderByDate(id, order);
    }
}