package com.bootcamp.be_java_hisp_w16_g7.util;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestUtil {

    public static User userFollow(){
        return new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }
    public static User userSell(){
        Product product = new Product(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        Post post1 = new Post(2222,1,LocalDate.parse("2022-08-12"), product,11,12300,false,0);
        Post post2 = new Post(2222,2,LocalDate.parse("2022-08-11"), product,11,11300,false,0);

        return new User(2222,"Camilo",new ArrayList<>(),new ArrayList<>(),List.of(post1,post2));
    }

    public static List<ResponsePostDTO> responsePostDTOS(){
        ProductDTO productDTO= new ProductDTO(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        ResponsePostDTO postDTO1 = new ResponsePostDTO(2222,1,LocalDate.parse("2022-08-12"), productDTO,11,12300);
        ResponsePostDTO postDTO2 = new ResponsePostDTO(2222,2,LocalDate.parse("2022-08-11"), productDTO,11,11300);

        return List.of(postDTO1,postDTO2);
    }

    public static List<ResponsePostDTO> responsePostAscDTOS(){
        ProductDTO productDTO= new ProductDTO(1,"Moto","Vehiculo","WWW","Rojo","Nuevo");
        ResponsePostDTO postDTO1 = new ResponsePostDTO(2222,1,LocalDate.parse("2022-08-12"), productDTO,11,12300);
        ResponsePostDTO postDTO2 = new ResponsePostDTO(2222,2,LocalDate.parse("2022-08-11"), productDTO,11,11300);

        return List.of(postDTO2,postDTO1);
    }
    public static User createUser(){
        List<Post> posts = List.of(new Post(2222, 1234, LocalDate.of(2022, 8, 10), new Product(), 99, 1000.0, false, 0.0),
                new Post(2222, 1234, LocalDate.of(2022, 7, 10), new Product(), 99, 1000.0, false, 0.0));
        List<User> followed = List.of(new User(2222, "User2", List.of(), List.of(), posts ));
        return new User(1111, "User1", List.of(), followed, List.of());
    }

    //Devuelve un vendedor con seguidores
    public static User expectedUser(){
        User follower1 = new User(88, "Juan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(99, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return new User(9999, "Pepito", Arrays.asList(follower1, follower2), new ArrayList<>(), Collections.singletonList(new Post()));

    }

    //Devuelve una lista de followers ordenados ascendentemente
    public static List<FollowersDTO> followersSortedListAsc(){
        User follower1 = new User(88, "Juan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(99, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        return List.of(
                new FollowersDTO(follower1.getId(), follower1.getName()),
                new FollowersDTO(follower2.getId(), follower2.getName())
        );
    }

    //Devuelve una lista de followers ordenados descendentemente
    public static List<FollowersDTO> followersSortedListDesc(){
        User follower1 = new User(88, "Juan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User follower2 = new User(99, "Pedro", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        return List.of(
                new FollowersDTO(follower2.getId(), follower2.getName()),
                new FollowersDTO(follower1.getId(), follower1.getName())
        );
    }

    public static User createUserFollowersTest(){
        List<Post> post1 = new ArrayList<>();
        post1.add(new Post());
        User user1 = new User(1111, "Seguidor uno", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2222, "Seguidor Dos", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        List<User> followersList = new ArrayList<>();
        followersList.add(user1);
        followersList.add(user2);
        return new User(3333, "Vendedor", followersList, new ArrayList<>(), post1);
    }

    public static RecentPostsDTO createRecentPostsDTO(){
        ResponsePostDTO expectedPost = new ResponsePostDTO(2222, 1234, LocalDate.of(2022, 8, 10), new ProductDTO(), 99, 1000.0);
        return new RecentPostsDTO(1111, List.of(expectedPost) );
    }
}
