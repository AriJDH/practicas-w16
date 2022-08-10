package com.example.be_java_hisp_w16_g09_bariani.service;

import com.example.be_java_hisp_w16_g09_bariani.dto.RecentPostsDTO;
import com.example.be_java_hisp_w16_g09_bariani.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09_bariani.model.Post;
import com.example.be_java_hisp_w16_g09_bariani.model.Product;
import com.example.be_java_hisp_w16_g09_bariani.model.User;
import com.example.be_java_hisp_w16_g09_bariani.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09_bariani.repository.IUserRepository;
import com.example.be_java_hisp_w16_g09_bariani.utility.DTOMapperUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

public class PostServiceTest {

    private IPostService postService;
    private IPostRepository postRepository;
    private IUserRepository userRepository;

    @BeforeEach
    void setUp() {
        postRepository = Mockito.mock(IPostRepository.class);
        userRepository = Mockito.mock(IUserRepository.class);
        postService = new PostService(postRepository, userRepository, new DTOMapperUtil());
    }

    @Test
    public void shouldRaiseException_whenTryToGetPostsOfSellersForNonExistentUser(){
        int nonExistentUserId = 1;
        when(userRepository.searchById(nonExistentUserId)).thenReturn(null);

        assertThatThrownBy(() -> postService.getRecentPostsOfSellersFollowedByUserWith(nonExistentUserId))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage(String.format("User with id: %d not found", nonExistentUserId));
    }
    @Test
    public void shouldReturnEmptyPostList_whenGetPostsOfSellersForUserWithZeroFollowings() {
        int anUserId = 1;
        when(userRepository.searchById(anUserId)).thenReturn(new User(anUserId, "pedrotest", new ArrayList(), new ArrayList()));
        RecentPostsDTO response = postService.getRecentPostsOfSellersFollowedByUserWith(anUserId);

        assertThat(response.getPosts().isEmpty()).isTrue();
        assertThat(response.getUserId()).isEqualTo(anUserId);
    }

    @Test
    public void shouldReturnListWithOnePost_whenGetPostsOfSellersForUserThatIsFollowingASellerThatPostedOneTime() {
        int anUserId = 1;
        User seller = Mockito.mock(User.class);
        when(seller.getUserId()).thenReturn(2);

        when(userRepository.searchById(anUserId)).thenReturn(new User(anUserId, "pedrotest", new ArrayList(), List.of(seller)));
        when(postRepository.getPostsByUserIds(List.of(seller.getUserId()))).thenReturn(List.of(new Post(1, seller, LocalDate.now(), new Product(), 1, 100)));

        RecentPostsDTO response = postService.getRecentPostsOfSellersFollowedByUserWith(anUserId);

        assertThat(response.getPosts().size()).isEqualTo(1);
        assertThat(response.getUserId()).isEqualTo(anUserId);
    }

    @Test
    public void shouldReturnPostsOrderedByDate_whenGetPostsOfSellersForUserInAPeriodOfTwoWeeks() {
        int anUserId = 1;
        LocalDate publicationDate = LocalDate.now();
        User seller = Mockito.mock(User.class);
        when(seller.getUserId()).thenReturn(2);

        Post outOfRangePost = new Post(1, seller, publicationDate.minusWeeks(3), new Product(), 2, 100);
        Post newestPost = new Post(2, seller, publicationDate, new Product(), 1, 78);
        Post oldestPost = new Post(3, seller, publicationDate.minusWeeks(1), new Product(), 1, 120);

        when(userRepository.searchById(anUserId))
                .thenReturn(new User(anUserId, "pedrotest", new ArrayList(), List.of(seller)));
        when(postRepository.getPostsByUserIds(List.of(seller.getUserId())))
                .thenReturn(List.of(
                        oldestPost,
                        outOfRangePost,
                        newestPost));

        RecentPostsDTO response = postService.getRecentPostsOfSellersFollowedByUserWith(anUserId);

        assertThat(response.getPosts().size()).isEqualTo(2);
        assertThat(response.getUserId()).isEqualTo(anUserId);
    }
}
