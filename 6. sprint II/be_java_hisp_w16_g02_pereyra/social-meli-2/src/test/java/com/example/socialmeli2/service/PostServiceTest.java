package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.PostListLastTwoWeeksDto;
import com.example.socialmeli2.exception.InputNotValidException;
import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.Product;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    // T0005
    @Mock
    private IRepository<Post> mockPostRepository;

    @Mock
    private IUserService mockUserService;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento por fecha exista -- ASC")
    void testGetFollowedPostListLastTwoWeeksByExistOrderAsc() {
        //arrange
        User user1 = Util.getUser(1, "Pamela");
        Product product1 = Util.getProduct(1, "Generic");
        Post post1 = Util.getPost(1, user1.getUserId(), product1);

        User user2 = Util.getUser(2, "Alberto");

        user1.getFollowers().add(user2);
        user2.getFollowed().add(user1);

        when(mockUserService.getById(2)).thenReturn(user2);
        when(mockPostRepository.getAll()).thenReturn(Arrays.asList(post1));

        //act
        PostListLastTwoWeeksDto postListLastTwoWeeksDto = postService.getFollowedPostListLastTwoWeeks(2, Optional.of("date_asc"));

        //assert
        assertEquals(1, postListLastTwoWeeksDto.getPosts().size());
    } //T0005

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento por fecha exista -- DESC")
    void testGetFollowedPostListLastTwoWeeksByExistOrderDesc() {
        //arrange
        User user1 = Util.getUser(1, "Pamela");
        Product product1 = Util.getProduct(1, "Generic");
        Post post1 = Util.getPost(1, user1.getUserId(), product1);

        User user2 = Util.getUser(2, "Alberto");

        user1.getFollowers().add(user2);
        user2.getFollowed().add(user1);

        when(mockUserService.getById(2)).thenReturn(user2);
        when(mockPostRepository.getAll()).thenReturn(Arrays.asList(post1));

        //act
        PostListLastTwoWeeksDto postListLastTwoWeeksDto = postService.getFollowedPostListLastTwoWeeks(2, Optional.of("date_desc"));

        //assert
        assertEquals(1, postListLastTwoWeeksDto.getPosts().size());
    } //T0005

    @Test
    @DisplayName("Verificar que el tipo de ordenamiento por fecha exista -- Ordenamiento Inválido")
    void testGetFollowedPostListLastTwoWeeksWithException() {
        //arrange
        User user1 = Util.getUser(1, "Pamela");
        Product product1 = Util.getProduct(1, "Generic");
        Post post1 = Util.getPost(1, user1.getUserId(), product1);

        User user2 = Util.getUser(2, "Alberto");

        user1.getFollowers().add(user2);
        user2.getFollowed().add(user1);

        when(mockUserService.getById(2)).thenReturn(user2);
        when(mockPostRepository.getAll()).thenReturn(Arrays.asList(post1));

        //act
        //assert
        assertThrows(InputNotValidException.class, () -> postService.getFollowedPostListLastTwoWeeks(2, Optional.of("invalid")));
    } //T0005

    @Test
    @DisplayName("Obtención correcta de la lista de Post ordenados por fecha ascendente Asc")
    void testGetFollowedPostListLastTwoWeeksByOrdersAsc() {
        //arrange
        User user1 = Util.getUser(1, "Pamela");
        Product product1 = Util.getProduct(1, "Teclado");
        Product product2 = Util.getProduct(2, "Mouse");
        Post post1 = Util.getPost(1, user1.getUserId(), product1, LocalDate.now());
        Post post2 = Util.getPost(2, user1.getUserId(), product2, LocalDate.now().minusDays(7));
        Post post3 = Util.getPost(3, user1.getUserId(), product2, LocalDate.now().minusDays(3));

        User user2 = Util.getUser(2, "Alberto");

        user1.getFollowers().add(user2);
        user2.getFollowed().add(user1);

        when(mockUserService.getById(2)).thenReturn(user2);
        when(mockPostRepository.getAll()).thenReturn(Arrays.asList(post1, post2, post3));

        //act
        PostListLastTwoWeeksDto postListLastTwoWeeksDto = postService.getFollowedPostListLastTwoWeeks(2, Optional.of("date_asc"));

        //assert
        assertEquals(LocalDate.now().minusDays(7), postListLastTwoWeeksDto.getPosts().get(0).getDate());
        assertEquals(LocalDate.now().minusDays(3), postListLastTwoWeeksDto.getPosts().get(1).getDate());
        assertEquals(LocalDate.now(), postListLastTwoWeeksDto.getPosts().get(2).getDate());
    } //T0006

    @Test
    @DisplayName("Obtención correcta de la lista de Post ordenados por fecha descendente")
    void testGetFollowedPostListLastTwoWeeksByOrdersDesc() {
        //arrange
        User user1 = Util.getUser(1, "Pamela");
        Product product1 = Util.getProduct(1, "Teclado");
        Product product2 = Util.getProduct(2, "Mouse");
        Post post1 = Util.getPost(1, user1.getUserId(), product1, LocalDate.now());
        Post post2 = Util.getPost(2, user1.getUserId(), product2, LocalDate.now().minusDays(7));
        Post post3 = Util.getPost(3, user1.getUserId(), product2, LocalDate.now().minusDays(3));

        User user2 = Util.getUser(2, "Alberto");

        user1.getFollowers().add(user2);
        user2.getFollowed().add(user1);

        when(mockUserService.getById(2)).thenReturn(user2);
        when(mockPostRepository.getAll()).thenReturn(Arrays.asList(post1, post2, post3));

        //act
        PostListLastTwoWeeksDto postListLastTwoWeeksDto = postService.getFollowedPostListLastTwoWeeks(2, Optional.of("date_desc"));

        //assert
        assertEquals(LocalDate.now(), postListLastTwoWeeksDto.getPosts().get(0).getDate());
        assertEquals(LocalDate.now().minusDays(3), postListLastTwoWeeksDto.getPosts().get(1).getDate());
        assertEquals(LocalDate.now().minusDays(7), postListLastTwoWeeksDto.getPosts().get(2).getDate());
    } //T0006

    @Test
    @DisplayName("Obtención correcta de la lista de Post que estén dentro de las dos semanas concretamente")
    void testGetFollowedPostListLastTwoWeeks() {
        //arrange
        User user1 = Util.getUser(1, "Pamela");
        Product product1 = Util.getProduct(1, "Teclado");
        Product product2 = Util.getProduct(2, "Mouse");
        Product product3 = Util.getProduct(2, "Notebook");
        Product product4 = Util.getProduct(2, "Parlantes");
        Product product5 = Util.getProduct(2, "Silla");
        Post post1 = Util.getPost(1, user1.getUserId(), product1, LocalDate.now());
        Post post2 = Util.getPost(2, user1.getUserId(), product2, LocalDate.now().minusDays(7));
        Post post3 = Util.getPost(3, user1.getUserId(), product3, LocalDate.now().minusDays(20));
        Post post4 = Util.getPost(4, user1.getUserId(), product4, LocalDate.now().minusDays(25));
        Post post5 = Util.getPost(5, user1.getUserId(), product5, LocalDate.now().minusDays(3));

        User user2 = Util.getUser(2, "Alberto");

        user1.getFollowers().add(user2);
        user2.getFollowed().add(user1);

        when(mockUserService.getById(2)).thenReturn(user2);
        when(mockPostRepository.getAll()).thenReturn(Arrays.asList(post1, post2, post3, post4, post5));

        //act
        PostListLastTwoWeeksDto postListLastTwoWeeksDto = postService.getFollowedPostListLastTwoWeeks(2, Optional.of("date_desc"));

        //assert
        assertEquals(3, postListLastTwoWeeksDto.getPosts().size());
        assertEquals(LocalDate.now(), postListLastTwoWeeksDto.getPosts().get(0).getDate());
        assertEquals(LocalDate.now().minusDays(3), postListLastTwoWeeksDto.getPosts().get(1).getDate());
        assertEquals(LocalDate.now().minusDays(7), postListLastTwoWeeksDto.getPosts().get(2).getDate());
    } //T0008

}