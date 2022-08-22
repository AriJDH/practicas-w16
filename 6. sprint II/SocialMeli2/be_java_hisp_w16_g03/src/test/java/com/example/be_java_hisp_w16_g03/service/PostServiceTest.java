package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostWithIdDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.Product;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidOrderTypeException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static com.example.be_java_hisp_w16_g03.utils.Mapper.postToPostWithIdDtoList;
import static com.example.be_java_hisp_w16_g03.utils.MocksPost.*;
import static com.example.be_java_hisp_w16_g03.utils.MocksUser.createSeller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IUserRepository repository;

    @InjectMocks
    PostService postService;

    @DisplayName("Verifica el orden descendente según fecha")//T-0006
    @Test
    public void verifyDateOrderDesc() {

        //arrange
        List<PostWithIdDTO> expectedResult = postToPostWithIdDtoList(createPosts());
        User userSeller = createSeller();
        User userFollower = User.builder().userId(2).followeds(List.of(userSeller)).build();

        when(repository.getFollowedsByUserId(anyInt())).thenReturn(List.of(userSeller));

        //act
        PostsDTO result = postService.getLatestPostsOrderedByUserId(userFollower.getUserId(), DATE_DESC);

        //assert
        verify(repository, times(1)).getFollowedsByUserId(anyInt());
        assertArrayEquals(expectedResult.toArray(), result.getPosts().toArray());

    }

    @DisplayName("Verifica el orden ascendente según fecha")//T-0006
    @Test
    public void verifyDateOrderAsc() {

        //arrange
        List<PostWithIdDTO> expectedResult = postToPostWithIdDtoList(createPosts());
        Collections.reverse(expectedResult);
        User userSeller = createSeller();
        User userFollower = User.builder().userId(2).followeds(List.of(userSeller)).build();

        when(repository.getFollowedsByUserId(anyInt())).thenReturn(List.of(userSeller));

        //act
        PostsDTO result = postService.getLatestPostsOrderedByUserId(userFollower.getUserId(), DATE_ASC);

        //assert
        verify(repository, times(1)).getFollowedsByUserId(anyInt());
        assertArrayEquals(expectedResult.toArray(), result.getPosts().toArray());
    }

    @DisplayName("Verifica que el tipo de ordenamiento por fecha exista")//T-0005
    @Test
    public void verifyCorrectOrderType() {

        //arrange
        User userSeller = createSeller();
        User userFollower = User.builder().userId(2).followeds(List.of(userSeller)).build();

        when(repository.getFollowedsByUserId(Mockito.anyInt())).thenReturn(List.of(userSeller));

        //act
        PostsDTO result = postService.getLatestPostsOrderedByUserId(userFollower.getUserId(), DATE_ASC);

        //assert
        verify(repository, times(1)).getFollowedsByUserId(anyInt());

        assertTrue(result.getPosts().size() > 0);

    }


    @DisplayName("Notifica la no existencia del tipo de ordenamiento mediante una excepción.")//T-0005
    @Test
    public void verifyIncorrectOrderType() {
        assertThrows(InvalidOrderTypeException.class,
                () -> postService.getLatestPostsOrderedByUserId(1, "invalid"));
    }

    @DisplayName("Verifica la consulta de publicaciones realizadas en las últimas dos semanas")//T-0008
    @Test
    public void verifyPostsLastTwoWeeks() {

        //arrange
        List<PostWithIdDTO> expected = postToPostWithIdDtoList(createPosts());
        User userSeller = createSeller();
        userSeller.getPosts().add(Post.builder().date(LocalDate.now().minusWeeks(2).minusDays(1)).product(new Product()).build());
        User userFollower = User.builder().userId(2).followeds(List.of(userSeller)).build();

        when(repository.getFollowedsByUserId(Mockito.anyInt())).thenReturn(List.of(userSeller));

        //act
        PostsDTO result = postService.getLatestPostsOrderedByUserId(userFollower.getUserId(), DATE_DESC);

        //assert
        verify(repository, times(1)).getFollowedsByUserId(Mockito.anyInt());
        assertArrayEquals(expected.toArray(), result.getPosts().toArray());

    }

}
