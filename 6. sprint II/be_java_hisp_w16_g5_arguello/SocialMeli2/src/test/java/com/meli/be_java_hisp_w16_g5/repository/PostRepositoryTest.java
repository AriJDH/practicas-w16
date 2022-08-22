package com.meli.be_java_hisp_w16_g5.repository;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.util.Util;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class PostRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PostRepository postRepository;


    @Test
    public void givenAPostSaveAndReturnPostDTO(){

        Product productSilla = new Product(1,"Silla gamer","Silla","Lagotech","Black","Silla gamer lagotech negra");
        LocalDate date = LocalDate.of(2022,8,8);
        Post postSilla = new Post(1,1,date, productSilla,1, 2032496.0,false,0.0 );

        PostDto postDto = postRepository.savePost(postSilla);

        Assertions.assertEquals(postDto.getPostId(), postSilla.getPostId());
        Assertions.assertEquals(postDto.getProduct().getProductName(),"Silla gamer");

    }

    @Test
    public void getAllPosts() throws NoSuchFieldException, SecurityException{
        //Arrange
        User user = UtilTestTools.createUser("Jhon", 100);
        List<Post> posts = UtilTestTools.getListProductsForUser(user, 3);
        List<PostDto> expected = Util.castTo(posts, PostDto.class);

        posts.forEach(
            post -> postRepository.savePost(post)
        );

        //Act
        List<PostDto> postsDto = postRepository.getPosts();

        //Assert
        //Custom method to compare two lists of objects with the same fields
        assertTrue(UtilTestTools.areEquals(postsDto, expected, PostDto.class, "getPostId"));
    }

    @Test
    public void filterByUserIdAndDate(){
        //Arrange
        User user = UtilTestTools.createUser("Jhon", 100);
        LocalDate date = Util.timeAgo(2);

        List<Post> posts = UtilTestTools.getListProductsForUser(user, 100);
        List<PostDto> expectedPosts =  posts.stream().filter(post ->
            post.getUserId() == user.getUserId()
            && 
            post.getDate().compareTo(date) >= 0
            )    
            .map(p-> Util.castTo(p, PostDto.class))
            .collect(Collectors.toList()
        );

        posts.forEach(
            post -> postRepository.savePost(post)
        );

        //Act

        List<PostDto> filteredPosts = postRepository.filterByUserIdAndDate(user.getUserId(), date);

        //Assert
        assertTrue(UtilTestTools.areEquals(expectedPosts, filteredPosts, PostDto.class, "getPostId"));
    }
}
