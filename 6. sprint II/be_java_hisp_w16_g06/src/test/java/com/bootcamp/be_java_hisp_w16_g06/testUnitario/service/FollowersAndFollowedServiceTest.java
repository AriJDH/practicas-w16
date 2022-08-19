package com.bootcamp.be_java_hisp_w16_g06.testUnitario.service;

import com.bootcamp.be_java_hisp_w16_g06.dto.FollowedDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g06.dto.FollowersDTO;
import com.bootcamp.be_java_hisp_w16_g06.entity.Follow;
import com.bootcamp.be_java_hisp_w16_g06.entity.User;
import com.bootcamp.be_java_hisp_w16_g06.exceptions.FollowedNotFoundException;
import com.bootcamp.be_java_hisp_w16_g06.exceptions.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g06.repository.UserFollowersRepository;
import com.bootcamp.be_java_hisp_w16_g06.service.FollowersAndFollowedService;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FollowersAndFollowedServiceTest {

    @InjectMocks
    FollowersAndFollowedService socialMeli;

    @Mock
    UserFollowersRepository userFollowersRepository;

    @Test
    @Description("Modo ordenamiento no existe")
    // T-003 Verificar que el tipo de ordenamiento alfabético exista (US-0008)
    public void noExisteOrdenamientoTest() {
        // arrange
        Integer idUser = 1;
        Boolean exception = false;
        String order = "asc";
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(1, "Manuel"));
        users.add(new User(1, "Juan", followed, followers));

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);

        // assert
        Assertions.assertThrows(FollowedNotFoundException.class, () -> socialMeli.userFollowed(idUser, order));

    }

    @Test
    @Description("Modo ordenamiento ascendente")
    public void ExisteOrdenamientoAscendenteTest() {
        // arrange
        Integer idUser = 1;
        Boolean exception = false;
        String order = "name_asc";
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        followed.add(new Follow(2, "Marco"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(1, "Manuel"));
        users.add(new User(1, "Juan", followed, followers));
        String first = "Andres";

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowedDTO followedDto = socialMeli.userFollowed(idUser, order);

        // assert
        Assertions.assertTrue(followedDto.getFollowed().stream().findFirst().get().getUser_name() == first);

    }

    @Test
    @Description("Modo ordenamiento descendente")
    public void ExisteOrdenamientoDescendenteTest() {
        // arrange
        Integer idUser = 1;
        Boolean exception = false;
        String order = "name_desc";
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        followed.add(new Follow(2, "Marco"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(1, "Manuel"));
        users.add(new User(1, "Juan", followed, followers));
        String first = "Marco";

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowedDTO followedDto = socialMeli.userFollowed(idUser, order);

        // assert
        Assertions.assertTrue(followedDto.getFollowed().stream().findFirst().get().getUser_name() == first);

    }

    @Test
    @Description("Modo ordenamiento null")
    public void ExisteOrdenamientoNullTest() {
        // arrange
        Integer idUser = 1;
        Boolean exception = false;
        String order = null;
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        followed.add(new Follow(2, "Marco"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(1, "Manuel"));
        users.add(new User(1, "Juan", followed, followers));
        String first = "Andres";

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowedDTO followedDto = socialMeli.userFollowed(idUser, order);

        // assert
        Assertions.assertTrue(followedDto.getFollowed().stream().findFirst().get().getUser_name() == first);

    }

    @Test
    @Description("No se encuentra el usuario")
    public void NoExisteUsuario() {
        // arrange
        Integer idUser = 333;
        Boolean exception = false;
        String order = "name_asc";
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        followed.add(new Follow(2, "Marco"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(1, "Manuel"));
        users.add(new User(1, "Juan", followed, followers));

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);

        // assert
        Assertions.assertThrows(UserNotFoundException.class, () -> socialMeli.userFollowed(idUser, order));

    }

    @Test
    @Description("No sigue vendedores")
    public void NoExisteFollowedDeUsuario() {
        // arrange
        Integer idUser = 1;
        Boolean exception = false;
        String order = "name_asc";
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        List<Follow> followers = new ArrayList<>();
        //followers.add(new Follow(1,"Manuel"));
        users.add(new User(1, "Juan", followed, followers));

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);

        // assert
        Assertions.assertThrows(FollowedNotFoundException.class, () -> socialMeli.userFollowed(idUser, order));

    }

    /* LISTA DE ORDENAMIENTO DE SEGUIDERS */

    @Test
    public void sinOrdenEnSeguidoresTest() {
        // arrange
        Integer idUser = 1;
        String order = "asc";
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(2, "Manuel"));
        followers.add(new Follow(3, "Carlos"));
        followers.add(new Follow(4, "Jorge"));
        users.add(new User(idUser, "Juan", followed, followers));

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);

        // assert
        Assertions.assertThrows(FollowedNotFoundException.class, () -> socialMeli.userFollowersOrder(idUser, order));

    }

    @Test
    public void ordenAscedenteSeguidoresTest() {
        // arrange
        Integer idUser = 1;
        String order = "name_asc";
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(2, "Manuel"));
        followers.add(new Follow(3, "Carlos"));
        followers.add(new Follow(4, "Aldo"));
        users.add(new User(idUser, "Juan", followed, followers));
        String first = "Aldo";

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowersDTO followersDTO = socialMeli.userFollowersOrder(idUser, order);

        // assert
        Assertions.assertTrue(followersDTO.getFollowers().stream().findFirst().get().getUser_name() == first);

    }

    @Test
    public void ordenDescendenteSeguidoresTest() {
        // arrange
        Integer idUser = 1;
        String order = "name_desc";
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(2, "Manuel"));
        followers.add(new Follow(3, "Carlos"));
        followers.add(new Follow(4, "Aldo"));
        users.add(new User(idUser, "Juan", followed, followers));
        String lastet = "Manuel";

        // act

        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowersDTO followersDTO = socialMeli.userFollowersOrder(idUser, order);

        // assert
        Assertions.assertTrue(followersDTO.getFollowers().stream().findFirst().get().getUser_name() == lastet);

    }

    @Test
    public void ordenNuloSeguidoresTest() {
        // arrange
        Integer idUser = 1;
        String order = null;
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(1, "Andres"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(2, "Manuel"));
        followers.add(new Follow(3, "Carlos"));
        followers.add(new Follow(4, "Aldo"));
        users.add(new User(idUser, "Juan", followed, followers));
        String lastet = "Manuel";

        // act
        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowersDTO followersDTO = socialMeli.userFollowersOrder(idUser, order);

        // assert
        Assertions.assertFalse(followersDTO.getFollowers().stream().findFirst().get().getUser_name() == lastet);
    }

    /*LISTA DE SEGUIDORES CORRECTOS*/

    @Test
    public void seguidoresCorrectosTest() {

        //Arage
        Integer idUser = 1;
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(10, "Carlos"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(20, "Saul"));
        followers.add(new Follow(21, "Pedro"));
        followers.add(new Follow(22, "Juan"));
        followers.add(new Follow(23, "Karla"));
        users.add(new User(idUser, "Juan", followed, followers));

        //Act
        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowersCountDTO followersCountDTO = socialMeli.userFollowers(1);

        //Assert
        Assertions.assertTrue(followersCountDTO.getFollowers_count() == 4);

    }

    @Test
    public void seguidoresNullTest() {

        //Arage
        Integer idUser = 1;
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        List<Follow> followers = null;
        //followers.add(new Follow(20,"Saul"));
        //followers.add(new Follow(21,"Pedro"));
        //followers.add(new Follow(22,"Juan"));
        //followers.add(new Follow(23,"Karla"));
        users.add(new User(idUser, "Juan", followed, followers));

        //Act
        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowersCountDTO followersCountDTO = socialMeli.userFollowers(1);

        //Assert
        Assertions.assertTrue(followersCountDTO.getFollowers_count() == 0);

    }

    @Test
    public void seguidoresErroneoTest() {

        //Arage
        Integer idUser = 1;
        List<User> users = new ArrayList<>();
        List<Follow> followed = new ArrayList<>();
        followed.add(new Follow(10, "Carlos"));
        List<Follow> followers = new ArrayList<>();
        followers.add(new Follow(20, "Saul"));
        followers.add(new Follow(21, "Pedro"));
        followers.add(new Follow(22, "Juan"));
        followers.add(new Follow(23, "Karla"));
        users.add(new User(idUser, "Juan", followed, followers));

        //Act
        when(userFollowersRepository.getUsersList()).thenReturn(users);
        FollowersCountDTO followersCountDTO = socialMeli.userFollowers(1);

        //Assert
        Assertions.assertFalse(followersCountDTO.getFollowers_count() == 6);

    }
}
