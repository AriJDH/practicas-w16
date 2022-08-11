package com.bootcamp.be_java_hisp_w16_g10.util;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostPromoReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static FollowedListResDTO parseToFollowedListResDTO(User user, List<User> followed) {
        return FollowedListResDTO.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .followed(followed.stream()
                        .map(Mapper::parseToUserResDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public static FollowersListResDTO parseToFollowersListResDTO(User user, List<User> followers) {
        return FollowersListResDTO.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .followers(followers.stream()
                        .map(Mapper::parseToUserResDTO)
                        .collect(Collectors.toList()))
                .build();
    }

    public static UserResDTO parseToUserResDTO(User user) {
        return UserResDTO.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .build();
    }

    public static PostResDTO parseToPostResDTO(Post post) {
        return PostResDTO.builder()
                .userId(post.getUserId())
                .category(post.getCategory())
                .postId(post.getId())
                .date(post.getDate())
                .price(post.getPrice())
                .product(Mapper.parseToProductResDTO(post.getProduct()))
                .build();
    }

    public static ProductResDTO parseToProductResDTO(Product product) {
        return ProductResDTO.builder()
                .productId(product.getId())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .type(product.getType())
                .productName(product.getName())
                .build();
    }

    public static Product parseToProduct(ProductReqDTO productReqDTO) {
        return Product.builder()
                .id(productReqDTO.getProductId())
                .name(productReqDTO.getProductName())
                .type(productReqDTO.getType())
                .brand(productReqDTO.getBrand())
                .color(productReqDTO.getColor())
                .notes(productReqDTO.getNotes())
                .build();
    }

    public static FollowersCountResDTO parseToFollowersCountResDTO(User user) {
        return FollowersCountResDTO.builder()
                .followersCount(user.countFollowers())
                .userId(user.getId())
                .userName(user.getUserName())
                .build();
    }

    public static PostListResDTO parseToPostListResDTO(User user, List<PostResDTO> posts){
        return PostListResDTO.builder()
                .userId(user.getId())
                .posts(posts)
                .build();
    }

    public static Post parseToPost(PostReqDTO postReqDTO){
        return Post.builder()
                .date(postReqDTO.getDate())
                .userId(postReqDTO.getUserId())
                .product(parseToProduct(postReqDTO.getProduct()))
                .category(postReqDTO.getCategory())
                .price(postReqDTO.getPrice())
                .build();
    }

    public static Post parseToPost(PostPromoReqDTO postPromoReqDTO) {
        return Post.builder()
                .userId(postPromoReqDTO.getUserId())
                .product(parseToProduct(postPromoReqDTO.getProduct()))
                .category(postPromoReqDTO.getCategory())
                .date(postPromoReqDTO.getDate())
                .price(postPromoReqDTO.getPrice())
                .discount(postPromoReqDTO.getDiscount())
                .hasPromo(postPromoReqDTO.getHasPromo())
                .build();
    }

    public static PostPromoCountResDTO parseToPostPromoCountResDTO(User user, List<Post> posts){
        return PostPromoCountResDTO.builder()
                .promoProductsCount(posts.size())
                .userId(user.getId())
                .userName(user.getUserName())
                .build();
    }

    public static PostPromoCountResDTO parseToPostPromoCountResDTO(User user, Integer postCount){
        return PostPromoCountResDTO.builder()
                .promoProductsCount(postCount)
                .userId(user.getId())
                .userName(user.getUserName())
                .build();
    }

    public static PostPromoListResDTO parseToPostPromoListResDTO(User user, List<Post> posts){
        return PostPromoListResDTO.builder()
                .posts(posts.stream()
                        .map(post -> parseToPostPromoResDTO(user, post))
                        .collect(Collectors.toList()))
                .userId(user.getId())
                .userName(user.getUserName())
                .build();
    }

    public static PostPromoResDTO parseToPostPromoResDTO(User user, Post post) {
        return PostPromoResDTO.builder()
                .userId(user.getId())
                .category(post.getCategory())
                .postId(post.getId())
                .date(post.getDate())
                .price(post.getPrice())
                .product(parseToProductResDTO(post.getProduct()))
                .hasPromo(post.getHasPromo())
                .discount(post.getDiscount())
                .build();
    }
}
