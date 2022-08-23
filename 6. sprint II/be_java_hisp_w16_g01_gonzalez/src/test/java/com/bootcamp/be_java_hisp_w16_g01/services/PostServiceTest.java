package com.bootcamp.be_java_hisp_w16_g01.services;

import com.bootcamp.be_java_hisp_w16_g01.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01.service.PostService;
import com.bootcamp.be_java_hisp_w16_g01.utils.FactoryPost;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    IPostRepository postRepository;

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    PostService postService;

    @Test
    @DisplayName("getFollowedPosts - Publicaciones de las ultimas dos semanas (desc)")
    public void getFollowedPostsDescTest(){

        //Arrange
        Integer userId = 1;
        String order = "date_desc";

        FollowedPostsDto response = FactoryPost.generateGetFollowedPostsServiceTestResponse(userId, order);
        List<Post> repositoryResponseVendedor1 = FactoryPost.generateGetPostsByUserIdTestResponse(userId + 1, 5);
        List<Post> repositoryResponseVendedor2 = FactoryPost.generateGetPostsByUserIdTestResponse(userId + 2, 8);
        User follower = FactoryPost.generateFollower(userId);

        when(userRepository.getUser(userId)).thenReturn(follower);
        when(postRepository.getPostsByUserId(userId + 1)).thenReturn(repositoryResponseVendedor1);
        when(postRepository.getPostsByUserId(userId + 2)).thenReturn(repositoryResponseVendedor2);

        //Act
        //Assert
        assertEquals(response, postService.getFollowedPosts(userId, order));
        verify(postRepository, Mockito.atLeastOnce()).getPostsByUserId(userId + 1);
        verify(postRepository, Mockito.atLeastOnce()).getPostsByUserId(userId + 2);
        verify(userRepository, Mockito.atLeastOnce()).getUser(userId);
    }

    @Test
    @DisplayName("getFollowedPosts - Publicaciones de las ultimas dos semanas (asc)")
    public void getFollowedPostsAscTest(){

        //Arrange
        Integer userId = 1;
        String order = "date_asc";

        FollowedPostsDto response = FactoryPost.generateGetFollowedPostsServiceTestResponse(userId, order);
        List<Post> repositoryResponseVendedor1 = FactoryPost.generateGetPostsByUserIdTestResponse(userId + 1, 5);
        List<Post> repositoryResponseVendedor2 = FactoryPost.generateGetPostsByUserIdTestResponse(userId + 2, 8);
        User follower = FactoryPost.generateFollower(userId);

        when(userRepository.getUser(userId)).thenReturn(follower);
        when(postRepository.getPostsByUserId(userId + 1)).thenReturn(repositoryResponseVendedor1);
        when(postRepository.getPostsByUserId(userId + 2)).thenReturn(repositoryResponseVendedor2);

        //Act
        //Assert
        assertEquals(response, postService.getFollowedPosts(userId, order));
        verify(postRepository, Mockito.atLeastOnce()).getPostsByUserId(userId + 1);
        verify(postRepository, Mockito.atLeastOnce()).getPostsByUserId(userId + 2);
        verify(userRepository, Mockito.atLeastOnce()).getUser(userId);
    }

    @Test
    @DisplayName("getFollowedPosts - Publicaciones de las ultimas dos semanas (orden null)")
    public void getFollowedPostsNullOrderTest(){

        //Arrange
        Integer userId = 1;
        String order = null;

        FollowedPostsDto response = FactoryPost.generateGetFollowedPostsServiceTestResponse(userId, order);
        List<Post> repositoryResponseVendedor1 = FactoryPost.generateGetPostsByUserIdTestResponse(userId + 1, 5);
        List<Post> repositoryResponseVendedor2 = FactoryPost.generateGetPostsByUserIdTestResponse(userId + 2, 8);
        User follower = FactoryPost.generateFollower(userId);

        when(userRepository.getUser(userId)).thenReturn(follower);

        //Act
        //Assert
        assertThrows(BadRequestException.class, () -> postService.getFollowedPosts(userId, order));
        verify(userRepository, Mockito.atLeastOnce()).getUser(userId);
    }

    @Test
    @DisplayName("getFollowedPosts - Publicaciones de las ultimas dos semanas (orden no valido)")
    public void getFollowedPostsNotValidOrderTest(){

        //Arrange
        Integer userId = 1;
        String order = "Charly";

        FollowedPostsDto response = FactoryPost.generateGetFollowedPostsServiceTestResponse(userId, order);
        List<Post> repositoryResponseVendedor1 = FactoryPost.generateGetPostsByUserIdTestResponse(userId + 1, 5);
        List<Post> repositoryResponseVendedor2 = FactoryPost.generateGetPostsByUserIdTestResponse(userId + 2, 8);
        User follower = FactoryPost.generateFollower(userId);

        when(userRepository.getUser(userId)).thenReturn(follower);

        //Act
        //Assert
        assertThrows(BadRequestException.class, () -> postService.getFollowedPosts(userId, order));
        verify(userRepository, Mockito.atLeastOnce()).getUser(userId);
    }

    @Test
    @DisplayName("getFollowedPosts - Publicaciones de las ultimas dos semanas (no existe el user)")
    public void getFollowedPostsNullUserTest(){

        //Arrange
        Integer userId = 85;
        String order = "date_desc";

        when(userRepository.getUser(userId)).thenReturn(null);

        //Act
        //Assert
        assertThrows(BadRequestException.class, () -> postService.getFollowedPosts(userId, order));
        verify(userRepository, Mockito.atLeastOnce()).getUser(userId);
    }
}
