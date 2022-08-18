package com.bootcamp.be_java_hisp_w16_g7.util;

import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {


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
}
