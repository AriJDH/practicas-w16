package com.example.be_java_hisp_w16_g03.utils;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostWithIdDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.Product;
import com.example.be_java_hisp_w16_g03.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {


    public static Post postDtoToEntity(PostDTO postDto) {
        return Post.builder()
                .userId(postDto.getUserId())
                .date(postDto.getDate())
                .price(postDto.getPrice())
                .product(productDtoToProduct(postDto.getProduct()))
                .category(postDto.getCategory())
                .price(postDto.getPrice()).build();
    }

    public static Product productDtoToProduct(ProductDTO productDTO) {
        return Product.builder().
                productId(productDTO.getProductId())
                .brand(productDTO.getBrand())
                .color(productDTO.getColor())
                .type(productDTO.getType())
                .notes(productDTO.getNotes())
                .productName(productDTO.getProductName())
                .build();
    }

    public static PostWithIdDTO postToPostWithIdDto(Post post) {
        return PostWithIdDTO.builder().postId(post.getPostId())
                .userId(post.getUserId())
                .price(post.getPrice())
                .date(post.getDate())
                .category(post.getCategory())
                .product(productToProductDto(post.getProduct())).build();
    }

    public static ProductDTO productToProductDto(Product product) {
        return ProductDTO.builder().productId(product.getProductId())
                .productName(product.getProductName())
                .type(product.getType())
                .color(product.getColor())
                .brand(product.getBrand())
                .notes(product.getNotes()).build();

    }

    public static List<PostWithIdDTO> postToPostWithIdDtoList(List<Post> posts) {

        return posts
                .stream()
                .map(Mapper::postToPostWithIdDto)
                .collect(Collectors.toList());

    }

    public static List<UserDTO> userToUserDtoList(List<User> users) {

        return users
                .stream()
                .map(user -> new UserDTO(user.getUserId(), user.getUserName()))
                .collect(Collectors.toList());

    }

    public static List<User> userDtoToUser(List<UserDTO> user) {
        return user
                .stream()
                .map(users -> new User(users.getUserId(), users.getUserName()))
                .collect(Collectors.toList());
    }

}
