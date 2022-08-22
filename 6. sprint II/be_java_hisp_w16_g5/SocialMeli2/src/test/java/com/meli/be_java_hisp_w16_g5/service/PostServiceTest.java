package com.meli.be_java_hisp_w16_g5.service;


import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostsByUserDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.exceptions.ProducNotFoundException;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.repository.*;
import com.meli.be_java_hisp_w16_g5.util.Util;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private PostService postService;

    @Test 
    public void getAllPosts(){
        //Arrange
        User user = UtilTestTools.createUser("Jhon", 100);
        List<Post> posts = UtilTestTools.getListProductsForUser(user, 3);
        List<PostDto> postsDtos = Util.castTo(posts, PostDto.class);

        when(postRepository.getPosts()).thenReturn(postsDtos);

        //Act
        List<PostDto> postsDto = postService.getPosts();

        //Assert
        assertEquals( postsDtos , postsDto);
        
    }

    @Test
    void givenAPostWithProductReturnPostDto() throws UserNotFoundException, ProducNotFoundException {

        User user = UtilTestTools.createCompletedUser("Gae", 1);

        Post postSilla = UtilTestTools.getPost(user, 1);
        PostDto postDtoTest = Util.castTo(postSilla, PostDto.class);

        when(userRepository.findUserById(1)).thenReturn(user);
        when(productRepository.getProductById(1)).thenReturn(postSilla.getProduct());
        when(postRepository.savePost(postSilla)).thenReturn(postDtoTest);

        PostDto postDto = postService.save(postSilla);

        assertNotNull(postDto);
        assertEquals(postDto.getDate(), postSilla.getDate());
        assertEquals(postDto.getPostId(), postSilla.getPostId());
        assertEquals(postDto.getProduct().getProductId(), postSilla.getPostId());

    }

    @Test
    void savingPostWithANotExistingProductThrowException(){

        List<Post> post = new ArrayList<>();
        User userFollower = new User(2,"Johannes",null,null,null);
        User userFollowing = new User(3,"Sebastian",null,null,null);

        List<User> followers = new ArrayList<>();
        List<User> following = new ArrayList<>();

        followers.add(userFollower);
        following.add(userFollowing);

        User user = new User(1,"Gae",post,followers,following);

        Product productNull= new Product(1,"","","","","");

        LocalDate date = LocalDate.of(2022,8,8);

        Post postSilla = new Post(1,1,date, productNull,1, 2032496.0,false,0.0 );

        when(userRepository.findUserById(1)).thenReturn(user);
        when(productRepository.getProductById(1)).thenReturn(null);

        Exception exception = Assert.assertThrows(ProducNotFoundException.class,()->postService.save(postSilla));

        String expectedMsg = "Producto ingresado no existe";
        String actualMsg = exception.getMessage();

        assertEquals(expectedMsg,actualMsg);
    }

    @Test
    void savingPostWithANotExistingUserThrowException(){

        Product productSilla = new Product(1,"Silla gamer","Silla","Lagotech","Black","Silla gamer lagotech negra");

        LocalDate date = LocalDate.of(2022,8,8);

        Post postSilla = new Post(1,1,date, productSilla,1, 2032496.0,false,0.0 );

        when(userRepository.findUserById(1)).thenReturn(null);

        Exception exception = Assert.assertThrows(UserNotFoundException.class,()->postService.save(postSilla));

        String expectedMsg = "Usuario no encontrado";
        String actualMsg = exception.getMessage();

        assertEquals(expectedMsg,actualMsg);
    }

    @Test
    void givenAUserGetFollowedProductsUnordered() throws UnknownRequestException, UserNotFoundException{
        //Arrange
        User user = UtilTestTools.createCompletedUserWithFollowedPosts("Albert", 4);
        when(userRepository.findUserById(4)).thenReturn(user);

        List<PostDto> followedProducts = user.getFollowing().stream()
        .map(
            following -> { 
                List<PostDto> posts = Util.castTo(following.getPosts(), PostDto.class);

                when(postRepository.filterByUserIdAndDate(following.getUserId(), Util.timeAgo(2)))
                .thenReturn(posts);

                return posts;
            }
        ).collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);

        PostsByUserDto expectedPosts = new PostsByUserDto(user.getUserId(), followedProducts);

        //Act
        PostsByUserDto postsByUserDto = postService.getFollowedProducts(4, null);

        //Assert
        assertEquals(postsByUserDto, expectedPosts);
    }

    @Test
    void givenAUserGetFollowedProductsOrderedAscending() throws UnknownRequestException, UserNotFoundException{
        //Arrange
        String order = "date_asc";
        Integer sortCondition = Util.getSortCondition(order, "date");
        User user = UtilTestTools.createCompletedUserWithFollowedPosts("Albert", 4);
        when(userRepository.findUserById(4)).thenReturn(user);


        List<PostDto> followedProducts = user.getFollowing().stream()
        .map(
            following -> { 
                List<PostDto> posts = Util.castTo(following.getPosts(), PostDto.class);

                when(postRepository.filterByUserIdAndDate(following.getUserId(), Util.timeAgo(2)))
                .thenReturn(posts);

                return posts;
            }
        ).collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        followedProducts.sort((PostDto p1, PostDto p2) -> p1.getDate().compareTo(p2.getDate()) * sortCondition);


        
        PostsByUserDto expectedPosts = new PostsByUserDto(user.getUserId(), followedProducts);
        //Act
        PostsByUserDto postsByUserDto = postService.getFollowedProducts(4, order);

        //Assert
        assertEquals(postsByUserDto, expectedPosts);
    }

    @Test
    void givenAUserGetFollowedProductsOrderedDescending() throws UnknownRequestException, UserNotFoundException{
        //Arrange
        String order = "date_desc";
        Integer sortCondition = Util.getSortCondition(order, "date");
        User user = UtilTestTools.createCompletedUserWithFollowedPosts("Albert", 4);
        when(userRepository.findUserById(4)).thenReturn(user);


        List<PostDto> followedProducts = user.getFollowing().stream()
        .map(
            following -> { 
                List<PostDto> posts = Util.castTo(following.getPosts(), PostDto.class);

                when(postRepository.filterByUserIdAndDate(following.getUserId(), Util.timeAgo(2)))
                .thenReturn(posts);

                return posts;
            }
        ).collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        followedProducts.sort((PostDto p1, PostDto p2) -> p1.getDate().compareTo(p2.getDate()) * sortCondition);


        
        PostsByUserDto expectedPosts = new PostsByUserDto(user.getUserId(), followedProducts);
        //Act
        PostsByUserDto postsByUserDto = postService.getFollowedProducts(4, order);

        //Assert
        assertEquals(postsByUserDto, expectedPosts);
    }

    @Test
    void givenAUserGetFollowedProductsHandleUsertNotFoundException() throws UnknownRequestException, UserNotFoundException{
          //Arrange
          String expectedMessage = "Usuario no encontrado";
  
          //Act
          Exception exception = assertThrows( UserNotFoundException.class, () -> postService.getFollowedProducts(4, null));
  
          //Assert
          assertEquals( exception.getMessage(), expectedMessage);
    }

    @Test
    void givenAUserGetFollowedProductsHandleUnknownRequestOrder() throws UnknownRequestException, UserNotFoundException{
        //Arrange
        User user = UtilTestTools.createCompletedUserWithFollowedPosts("Albert", 4);
        when(userRepository.findUserById(4)).thenReturn(user);
        
        String order = "any_order";
        //Act
        Exception exception = assertThrows( UnknownRequestException.class, () -> postService.getFollowedProducts(4, order));

        //Assert
        assertEquals( exception.getMessage(), "Unknown order: any_order");
    }

}
