package com.example.socialmeli.util;

import com.example.socialmeli.dto.*;
import com.example.socialmeli.model.Post;
import com.example.socialmeli.model.Product;
import com.example.socialmeli.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static UserFollowersCountDto mapperToUserFollowersCountDto(User user){

        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setFollowersCount(user.getFollowers().size());
        userFollowersCountDto.setUserId(user.getUserId());
        userFollowersCountDto.setUserName(user.getUserName());

        return userFollowersCountDto;
    }
    public static List<UserDto> mapperToUserDtoList(List<User> userList){

        return userList.stream().map(f->{
            UserDto userDto = new UserDto();
            userDto.setUserName(f.getUserName());
            userDto.setUserId(f.getUserId());
            return userDto;
        }).collect(Collectors.toList());
    }
    public static UserFollowersListDto mapperToUserFollowersListDto(User user){
        UserFollowersListDto userFollowersListDto = new UserFollowersListDto();
        userFollowersListDto.setUserId(user.getUserId());
        userFollowersListDto.setUserName(user.getUserName());
        userFollowersListDto.setFollowers(mapperToUserDtoList(user.getFollowers()));

        return userFollowersListDto;
    }
    public static UserFollowedListDto mapperToUserFollowedListDto(User user){

        UserFollowedListDto userFollowedListDto = new UserFollowedListDto();
        userFollowedListDto.setUserId(user.getUserId());
        userFollowedListDto.setUserName(user.getUserName());
        userFollowedListDto.setFollowed(mapperToUserDtoList(user.getFollowed()));

        return userFollowedListDto;
    }
    public static Post mapperToPost(PostDto postDto){
        Post newPost = new Post();
        newPost.setUserId(postDto.getUserId());
        newPost.setProduct(mapperToProduct(postDto.getProduct()));
        newPost.setDate(postDto.getDate());
        newPost.setCategory(postDto.getCategory());
        newPost.setPrice(postDto.getPrice());

        return newPost;
    }
    public static Post mapperToPromoPost(PostPromoDto postPromoDto){
        Post newPostPromo = new Post();
        newPostPromo.setUserId(postPromoDto.getUserId());
        newPostPromo.setProduct(mapperToProduct(postPromoDto.getProduct()));
        newPostPromo.setDate(postPromoDto.getDate());
        newPostPromo.setCategory(postPromoDto.getCategory());
        newPostPromo.setPrice(postPromoDto.getPrice());
        newPostPromo.setHasPromo(postPromoDto.isHasPromo());
        newPostPromo.setDiscount(postPromoDto.getDiscount());

        return newPostPromo;
    }
    public static Product mapperToProduct(ProductDto productDto){
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setType(productDto.getType());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setNotes(productDto.getNotes());

        return product;
    }
    public static PostListLastTwoWeeksDto mapperToPostListLastTwoWeeksDto(int userId, List<Post> postList){
        PostListLastTwoWeeksDto postListLastTwoWeeksDto = new PostListLastTwoWeeksDto();
        postListLastTwoWeeksDto.setUserId(userId);
        postListLastTwoWeeksDto.setPosts(
                postList.stream().map(post -> mapperToPostLastTwoWeeksDto(post)).collect(Collectors.toList())
        );

        return postListLastTwoWeeksDto;
    }
    public static PostLastTwoWeeksDto mapperToPostLastTwoWeeksDto(Post post){
        PostLastTwoWeeksDto postLastTwoWeeksDto = new PostLastTwoWeeksDto();
        postLastTwoWeeksDto.setUserId(post.getUserId());
        postLastTwoWeeksDto.setPostId(post.getPostId());
        postLastTwoWeeksDto.setDate(post.getDate());
        postLastTwoWeeksDto.setProduct(mapperToProductDto(post.getProduct()));
        postLastTwoWeeksDto.setCategory(post.getCategory());
        postLastTwoWeeksDto.setPrice(post.getPrice());

        return postLastTwoWeeksDto;
    }
    public static ProductDto mapperToProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setType(product.getType());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        productDto.setNotes(product.getNotes());

        return productDto;
    }
    public static PostPromoCountDto mapperToPostPromoDto(User user, int count){

        PostPromoCountDto postPromoCountDto = new PostPromoCountDto();
        postPromoCountDto.setUserId(user.getUserId());
        postPromoCountDto.setUserName(user.getUserName());
        postPromoCountDto.setPromoProductsCount(count);

        return postPromoCountDto;

    }
    public static PostPromoIdDto mapperToPostPromoIdDto(Post post){
        PostPromoIdDto postPromoIdDto = new PostPromoIdDto();
        postPromoIdDto.setPostId(post.getPostId());
        postPromoIdDto.setUserId(post.getUserId());
        postPromoIdDto.setDate(post.getDate());
        postPromoIdDto.setProduct(mapperToProductDto(post.getProduct()));
        postPromoIdDto.setCategory(post.getCategory());
        postPromoIdDto.setPrice(post.getPrice());
        postPromoIdDto.setHasPromo(post.getHasPromo());
        postPromoIdDto.setDiscount(post.getDiscount());

        return postPromoIdDto;
    }

    public static PostPromoListDto  mapperToPostPromoListDto(User user, List<Post> listPostPromo){
        PostPromoListDto listPost = new PostPromoListDto();
        listPost.setUserId(user.getUserId());
        listPost.setUserName(user.getUserName());
        listPost.setPosts(listPostPromo.stream()
                .map(post -> Mapper.mapperToPostPromoIdDto(post))
                .collect(Collectors.toList()));
        return listPost;
    }
}
