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

    public static Post mapperToPost(PostDtoWithPromo postDtoWithPromo){
        Post newPost = new Post();
        newPost.setUserId(postDtoWithPromo.getUserId());
        newPost.setProduct(mapperToProduct(postDtoWithPromo.getProduct()));
        newPost.setDate(postDtoWithPromo.getDate());
        newPost.setCategory(postDtoWithPromo.getCategory());
        newPost.setPrice(postDtoWithPromo.getPrice());
        newPost.setHasPromo(postDtoWithPromo.isHasPromo());
        newPost.setDiscount(postDtoWithPromo.getDiscount());
        return newPost;
    }

    public static ProductWithPromoCountDto mapperToProductWithPromoCountDto(User user, Integer promoProductsCount){
        ProductWithPromoCountDto productWithPromoCountDto = new ProductWithPromoCountDto();
        productWithPromoCountDto.setUserId(user.getUserId());
        productWithPromoCountDto.setUserName(user.getUserName());
        productWithPromoCountDto.setPromoProductsCount(promoProductsCount);
        return productWithPromoCountDto;
    }

    public static ProductsListWithPromoDto mapperToProductsListWithPromoDto(User userPromo, List<Post> posts) {
    ProductsListWithPromoDto productsListWithPromoDto = new ProductsListWithPromoDto();
    productsListWithPromoDto.setUserId(userPromo.getUserId());
    productsListWithPromoDto.setUserName(userPromo.getUserName());
    productsListWithPromoDto.setPosts(posts.stream()
            .map(post -> Mapper.postCompletePromoDto(post)).collect(Collectors.toList()));
    return productsListWithPromoDto;

    }

    public static PostCompletePromoDto postCompletePromoDto(Post post){
        PostCompletePromoDto postWithPromotionDto = new PostCompletePromoDto();
        postWithPromotionDto.setPostId(post.getPostId());
        postWithPromotionDto.setUserId(post.getUserId());
        postWithPromotionDto.setDate(post.getDate());
        postWithPromotionDto.setProduct(mapperToProductDto(post.getProduct()));
        postWithPromotionDto.setCategory(post.getCategory());
        postWithPromotionDto.setPrice(post.getPrice());
        postWithPromotionDto.setHasPromo(post.getHasPromo());
        postWithPromotionDto.setDiscount(post.getDiscount());

        return postWithPromotionDto;
    }
}
