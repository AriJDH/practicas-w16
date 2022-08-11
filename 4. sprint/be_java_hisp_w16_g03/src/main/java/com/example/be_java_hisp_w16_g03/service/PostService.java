package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.*;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.PostPromo;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidPostRequest;
import com.example.be_java_hisp_w16_g03.exception.NotSellerException;
import com.example.be_java_hisp_w16_g03.exception.UserNotExistException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    public static final String DATE_DESC = "date_desc";
    public static final String DATE_ASC = "date_asc";
    @Autowired
    IUserRepository repository;

    @Override
    public void addPost(PostDTO request) {
        if (!request.validate())
            throw new InvalidPostRequest();
        User requestUser = repository.getUserById(request.getUserId()).orElseThrow(() -> new UserNotExistException(request.getUserId()));
        requestUser.addPostWithOutPromo(request);

    }

    @Override
    public PostsDTO getLatestPostsByUserId(Integer userId) {
        List<User> vendors = repository.getFollowedsByUserId(userId);
        if (vendors != null) {
            List<Post> filterPostWithOutPromos = getFilterPosts(vendors);

            List<PostWithIdDTO> postsWithIdDtos = filterPostWithOutPromos.stream().map(postWithOutPromo -> PostWithIdDTO.builder().postId(postWithOutPromo.getPostId())
                    .userId(postWithOutPromo.getUserId())
                    .price(postWithOutPromo.getPrice())
                    .date(postWithOutPromo.getDate())
                    .category(postWithOutPromo.getCategory())
                    .product(ProductDTO.builder().productId(postWithOutPromo.getProduct().getProductId())
                            .productName(postWithOutPromo.getProduct().getProductName())
                            .type(postWithOutPromo.getProduct().getType())
                            .color(postWithOutPromo.getProduct().getColor())
                            .brand(postWithOutPromo.getProduct().getBrand())
                            .notes(postWithOutPromo.getProduct().getNotes()).build()).build()).sorted((x, y) -> y.getDate().compareTo(x.getDate())).collect(Collectors.toList());

            return PostsDTO.builder().userId(userId).posts(postsWithIdDtos).build();
        }
        return PostsDTO.builder().userId(userId).posts(new ArrayList<>()).build();
    }

    public PostsDTO getLatestPostsOrderedByUserId(Integer userId, String order) {

        if (order == null || order.equals(DATE_DESC))
            return getLatestPostsByUserId(userId);
        else if (order.equals(DATE_ASC)) {
            List<PostWithIdDTO> postsWithIdDtos = getLatestPostsByUserId(userId).getPosts().stream().sorted(Comparator.comparing(PostWithIdDTO::getDate)).collect(Collectors.toList());
            return PostsDTO.builder().userId(userId).posts(postsWithIdDtos).build();
        }

        return PostsDTO.builder().userId(userId).posts(new ArrayList<>()).build();
    }

    @Override
    public void addPromoPost(PromoPostDTO request) {

        if (!request.validate())
            throw new InvalidPostRequest();
        User requestUser = repository.getUserById(request.getUserId()).orElseThrow(() -> new UserNotExistException(request.getUserId()));
        requestUser.addPostWithPromo(request);


    }

    @Override
    public PromoCountDTO countSellerPromoPost(Integer userId) {
        User user = repository.getUserById(userId).orElseThrow(() -> new UserNotExistException(userId));
        if (user.getPosts() != null && user.getPosts().size() <= 0)
            throw new NotSellerException(userId);

        return PromoCountDTO.builder()
                .userId(userId)
                .userName(user.getUserName())
                .promoProductsCount((int) user.getPosts().stream().filter(post -> post instanceof PostPromo && ((PostPromo) post).getHasPromo()).count()).build();
    }

    @Override
    public UserPost getSellerPostPromo(Integer userId) {
        User user = repository.getUserById(userId).orElseThrow(() -> new UserNotExistException(userId));
        if (user.getPosts() != null && user.getPosts().size() <= 0)
            throw new NotSellerException(userId);

        return UserPost.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .posts(user.getPosts()
                        .stream().filter(post -> post instanceof PostPromo && ((PostPromo) post).getHasPromo()).collect(Collectors.toList())
                        .stream().map(post -> PromoPostDTO.builder()
                                .hasPromo(post instanceof PostPromo && ((PostPromo) post).getHasPromo() ? ((PostPromo) post).getHasPromo() : null)
                                .product(ProductDTO.builder()
                                        .productId(post.getProduct().getProductId())
                                        .productName(post.getProduct().getProductName())
                                        .brand(post.getProduct().getBrand())
                                        .color(post.getProduct().getColor())
                                        .type(post.getProduct().getType())
                                        .notes(post.getProduct().getNotes()).build())
                                .price(post.getPrice())
                                .category(post.getCategory())
                                .date(post.getDate())
                                .discount(post instanceof PostPromo && ((PostPromo) post).getDiscount() > 0 ? ((PostPromo) post).getDiscount() : null)
                                .userId(post.getUserId()).build()).collect(Collectors.toList())).build();
    }

    private List<Post> getFilterPosts(List<User> vendors) {
        List<Post> filterPostWithOutPromos = new ArrayList<>();
        vendors.forEach(user -> filterPostWithOutPromos.addAll(user.getPostBetweenDate()));
        return filterPostWithOutPromos;
    }


}
