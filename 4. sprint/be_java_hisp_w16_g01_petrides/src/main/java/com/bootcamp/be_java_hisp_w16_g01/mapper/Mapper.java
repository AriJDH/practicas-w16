package com.bootcamp.be_java_hisp_w16_g01.mapper;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static UserDTO toUserDTO(User user){
        return  new UserDTO(user.getUserId(), user.getUserName() );
    }

    public static UserFollowerDTO userFollowerDTO(List<User> followers, User user){
        return new UserFollowerDTO(user.getUserId(), user.getUserName(), followers.stream().map(Mapper::toUserDTO).collect(Collectors.toList()));
    }

    public static UserFollowedDTO userFollowedDTO(List<User> followed, User user){
        return new UserFollowedDTO(user.getUserId(), user.getUserName(), followed.stream().map(Mapper::toUserDTO).collect(Collectors.toList()));
    }

    public static Product toProduct(ProductDto productDto){
        return new Product(productDto.getProductId(),
                productDto.getProductName(),
                productDto.getType(),
                productDto.getBrand(),
                productDto.getColor(),
                productDto.getNotes());
    }

    public static ProductDto toProductDto(Product product){
        System.out.println("product = " + product);
        return new ProductDto(product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes());
    }

    public static Post toPost(PromoPostDto postDto){
        System.out.println("dto= " + postDto.getProduct());
        System.out.println("entity= " + toProduct(postDto.getProduct()));
        return new Post(postDto.getUserId(),
                postDto.getDate(),
                toProduct(postDto.getProduct()),
                postDto.getCategory(),
                postDto.getPrice(),
                postDto.isHasPromo(),
                postDto.getDiscount());
    }

    public static Post toPost(PostDto postDto){
        return new Post(0, postDto.getUserId(),
                postDto.getDate(),
                toProduct(postDto.getProduct()),
                postDto.getCategory(),
                postDto.getPrice());
    }

    public static ResponsePostDto toResponsePostDto(Post post){
        return new ResponsePostDto(post.getUserId(),
                post.getPostId(),
                post.getDate(),
                toProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice());
    }

    public static PromoPostResponseDto toPromoPostDto(Post post){
        System.out.println(post.getProduct());
        return new PromoPostResponseDto(post.getPostId(),
                post.getUserId(),
                post.getDate(),
                toProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount()
                );
    }
}
