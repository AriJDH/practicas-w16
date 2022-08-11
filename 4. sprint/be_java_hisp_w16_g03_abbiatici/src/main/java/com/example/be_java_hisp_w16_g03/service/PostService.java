package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.*;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidPostRequest;
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
        requestUser.addPostToUser(request);
    }

    @Override
    public PostsDTO getLatestPostsByUserId(Integer userId) {
        List<User> vendors = repository.getFollowedsByUserId(userId);
        if (vendors != null) {
            List<Post> filterPosts = getFilterPosts(vendors);

            List<PostWithIdDTO> postsWithIdDtos = filterPosts.stream().map(post -> PostWithIdDTO.builder().postId(post.getPostId())
                    .userId(post.getUserId())
                    .price(post.getPrice())
                    .date(post.getDate())
                    .category(post.getCategory())
                    .product(ProductDTO.builder().productId(post.getProduct().getProductId())
                            .productName(post.getProduct().getProductName())
                            .type(post.getProduct().getType())
                            .color(post.getProduct().getColor())
                            .brand(post.getProduct().getBrand())
                            .notes(post.getProduct().getNotes()).build()).build()).sorted((x, y) -> y.getDate().compareTo(x.getDate())).collect(Collectors.toList());

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
        requestUser.addPromoPostToUser(request);
    }

    @Override
    public PromoPostCountDTO getPromoPostCount(Integer user_id) {
        User vendor = repository.getUserById(user_id).orElseThrow(() -> new UserNotExistException(user_id));

        List<Post> promoPosts = vendor.getterPosts().stream().filter(Post::isHasPromo).collect(Collectors.toList());

        return PromoPostCountDTO.builder().userId(vendor.getUserId()).userName(vendor.getUserName())
                .promoProductsCount(promoPosts.size()).build();
    }

    @Override
    public PromoPostsDTO getPromoPostsByUserId(Integer userId) {
        User vendor = repository.getUserById(userId).orElseThrow(() -> new UserNotExistException(userId));

        List<PromoPostWithIdDTO> promoPostsWithIdDtos = vendor.getterPosts().stream()
                .filter(Post::isHasPromo) //filtro para mostrar solo los posts con promo
                .map(post -> PromoPostWithIdDTO.builder().postId(post.getPostId())
                .userId(post.getUserId())
                .price(post.getPrice())
                .date(post.getDate())
                .category(post.getCategory())
                .product(ProductDTO.builder().productId(post.getProduct().getProductId())
                        .productName(post.getProduct().getProductName())
                        .type(post.getProduct().getType())
                        .color(post.getProduct().getColor())
                        .brand(post.getProduct().getBrand())
                        .notes(post.getProduct().getNotes()).build())
                        .hasPromo(post.isHasPromo())
                        .discount(post.getDiscount()).build())
                .sorted((x, y) -> y.getDate().compareTo(x.getDate())).collect(Collectors.toList());

        return PromoPostsDTO.builder().userId(userId).userName(vendor.getUserName()).posts(promoPostsWithIdDtos).build();

    }

    private List<Post> getFilterPosts(List<User> vendors) {
        List<Post> filterPosts = new ArrayList<>();
        vendors.forEach(user -> filterPosts.addAll(user.getPostBetweenDate()));
        return filterPosts;
    }


}
