package com.bootcamp.SocialMeli2.unitary.service;

import com.bootcamp.SocialMeli2.dto.response.*;
import com.bootcamp.SocialMeli2.entiry.Post;
import com.bootcamp.SocialMeli2.entiry.User;
import com.bootcamp.SocialMeli2.exception.OrderNotPossibleException;
import com.bootcamp.SocialMeli2.exception.UserNotVendorException;
import com.bootcamp.SocialMeli2.repository.IPostRepository;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.service.ProductService;
import com.bootcamp.SocialMeli2.service.UserService;
import com.bootcamp.SocialMeli2.util.MapperProduct;
import com.bootcamp.SocialMeli2.utils.TestUtils;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    MapperProduct mapperProduct;
    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void addFollower() {
    }

    @Test
    @DisplayName("T0007 Verificacion que cantidad sea la correcta US002")
    void getUserFollowerCountTest() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);
        //Act
        UserFollowersCountDto result = userService.getUserFollowerCount(1);
        //Assert
        assertEquals(result.getFollowersCount(),2);
    }
    @Test
    @DisplayName("T0007 Verificar la validacion que sea vendedor US002")
    void getUserFollowerCountisVendor() {
        //Arrange
        User testUser = TestUtils.getOneUser(1,"test user");
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(testUser);
        //Act Assert
        assertThrows(UserNotVendorException.class,()->userService.getUserFollowerCount(1));
    }

    @Test
    void unfollowUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    @DisplayName("T0004 Ordenamiento ascendente US004")
    void orderVendorsFollowedByUserAsc() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);
        //Act
        UserFollowedDto result = userService.getVendorsFollowedByUser(1,"name_asc");
        //Assert
        assertEquals(result.getFollowed().size(),2);
        assertEquals(result.getFollowed().get(0).getUserName(),"juan");
        assertEquals(result.getFollowed().get(1).getUserName(),"pepe");
    }

    @Test
    @DisplayName("T0004 Ordenamiento descendente US004")
    void orderVendorsFollowedByUserDesc() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);

        //Act
        UserFollowedDto result = userService.getVendorsFollowedByUser(1,"name_desc");
        //Assert
        assertEquals(result.getFollowed().size(),2);
        assertEquals(result.getFollowed().get(0).getUserName(),"pepe");
        assertEquals(result.getFollowed().get(1).getUserName(),"juan");

    }

    @Test
    @DisplayName("T0004 ingreso de orden incorrecto US004")
    void getVendorsFollowedByUserIncorrectWord() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);

        //Act Assert
        assertThrows(OrderNotPossibleException.class,()->userService.getVendorsFollowedByUser(1,"lalala"));
    }

    @Test
    @DisplayName("T0004 Ordenamiento ascendente US003")
    void orderAllVendorFollowersAsc() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);
        //Act
        UserFollowers result = userService.getAllVendorFollowers(1,"name_asc");
        //Assert
        assertEquals(result.getFollowers().size(),2);
        assertEquals(result.getFollowers().get(0).getUserName(),"juan");
        assertEquals(result.getFollowers().get(1).getUserName(),"pepe");
    }

    @Test
    @DisplayName("T0004 Ordenamiento descendente US003")
    void orderAllVendorFollowersDesc() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);
        //Act
        UserFollowers result = userService.getAllVendorFollowers(1,"name_desc");
        //Assert
        assertEquals(result.getFollowers().size(),2);
        assertEquals(result.getFollowers().get(0).getUserName(),"pepe");
        assertEquals(result.getFollowers().get(1).getUserName(),"juan");
    }
    @Test
    @DisplayName("T0004 ingreso de orden incorrecto US003")
    void getAllVendorFollowersIncorrectWord() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);

        //Act Assert
        assertThrows(OrderNotPossibleException.class,()->userService.getAllVendorFollowers(1,"lalaland"));
    }
    @Test
    @DisplayName("T0004 usuario no vendedor US003")
    void getAllVendorFollowersUserNotVendor() {
        //Arrange
        User testUser = TestUtils.getOneUser(1,"test user");
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(testUser);
        //Act Assert
        assertThrows(UserNotVendorException.class,()->userService.getAllVendorFollowers(1,"name_asc"));
    }



    @Test
    void isVendor() {
    }


    @Test
    @DisplayName("T0006 Ordenamiento ascendente por fecha US006")
    void orderPostFromFollowedDateAsc() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        ResponsePostDto post1 = new ResponsePostDto(1,3, LocalDate.now(),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post2 = new ResponsePostDto(2,3, LocalDate.now().minusDays(1),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post3 = new ResponsePostDto(3,2, LocalDate.now().minusDays(2),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post4 = new ResponsePostDto(4,2, LocalDate.now().minusDays(3),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);

        List<ResponsePostDto> returnPostList = Arrays.asList(post1,post2,post3,post4);

        when(mapperProduct.mapUserPostDto(luis.getFollowedList())).thenReturn(returnPostList);
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);
        //Act
        ResponsePostFromFollowedDto result = userService.getPostFromFollowed(1,"date_asc");
        //Assert
        assertEquals(result.getPosts().size(),4);
        assertEquals(result.getPosts().get(0).getPostId(),4);
        assertEquals(result.getPosts().get(1).getPostId(),3);
        assertEquals(result.getPosts().get(2).getPostId(),2);
        assertEquals(result.getPosts().get(3).getPostId(),1);
    }
    @Test
    @DisplayName("T0006 Ordenamiento descendente por fecha US006")
    void orderPostFromFollowedDateDesc() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        ResponsePostDto post1 = new ResponsePostDto(1,3, LocalDate.now(),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post2 = new ResponsePostDto(2,3, LocalDate.now().minusDays(1),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post3 = new ResponsePostDto(3,2, LocalDate.now().minusDays(2),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post4 = new ResponsePostDto(4,2, LocalDate.now().minusDays(3),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);

        List<ResponsePostDto> returnPostList = Arrays.asList(post1,post2,post3,post4);

        when(mapperProduct.mapUserPostDto(luis.getFollowedList())).thenReturn(returnPostList);
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);
        //Act
        ResponsePostFromFollowedDto result = userService.getPostFromFollowed(1,"date_desc");
        //Assert
        assertEquals(result.getPosts().size(),4);
        assertEquals(result.getPosts().get(0).getPostId(),1);
        assertEquals(result.getPosts().get(1).getPostId(),2);
        assertEquals(result.getPosts().get(2).getPostId(),3);
        assertEquals(result.getPosts().get(3).getPostId(),4);
    }
    @Test
    @DisplayName("T0006 ingreso de orden incorrecto US006")
    void getPostFromFollowedDateIncorrectWord() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        ResponsePostDto post1 = new ResponsePostDto(1,3, LocalDate.now(),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post2 = new ResponsePostDto(2,3, LocalDate.now().minusDays(1),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post3 = new ResponsePostDto(3,2, LocalDate.now().minusDays(2),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post4 = new ResponsePostDto(4,2, LocalDate.now().minusDays(3),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);

        List<ResponsePostDto> returnPostList = Arrays.asList(post1,post2,post3,post4);

        when(mapperProduct.mapUserPostDto(luis.getFollowedList())).thenReturn(returnPostList);
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);

        //Act Assert
        assertThrows(OrderNotPossibleException.class,()->userService.getPostFromFollowed(1,"lalala2"));
    }
    @Test
    @DisplayName("T0006 no post de mas de 14 dias US006")
    void getPostFromFollowedLessThanTwoWeeks() {
        //Arrange
        User luis = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        ResponsePostDto post1 = new ResponsePostDto(1,3, LocalDate.now(),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post2 = new ResponsePostDto(2,3, LocalDate.now().minusDays(1),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post3 = new ResponsePostDto(3,2, LocalDate.now().minusDays(2),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post4 = new ResponsePostDto(4,2, LocalDate.now().minusDays(3),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);
        ResponsePostDto post5 = new ResponsePostDto(5,2, LocalDate.now().minusDays(15),new ResponseProductDto(1,"Mouse","gamer","razer","black",""),1500,20);

        List<ResponsePostDto> returnPostList = Arrays.asList(post1,post2,post3,post4,post5);

        when(mapperProduct.mapUserPostDto(luis.getFollowedList())).thenReturn(returnPostList);
        when(userRepository.isPresent(1)).thenReturn(true);
        when(userRepository.getUserById(1)).thenReturn(luis);

        //Act
        ResponsePostFromFollowedDto result = userService.getPostFromFollowed(1,"date_desc");
        //Assert
        assertEquals(result.getPosts().size(),4);
    }

    @Test
    void orderPostList() {
    }
}