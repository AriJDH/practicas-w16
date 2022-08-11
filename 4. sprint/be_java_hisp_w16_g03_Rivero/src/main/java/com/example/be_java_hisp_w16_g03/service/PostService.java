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
    public PostHasPromoCountDTO countPostHasPromoDTO(Integer id) {
        User user = repository.getUserById(id).orElseThrow(() -> new UserNotExistException(id));
        Integer total = user.getterPosts().stream().filter(userWithPromo -> userWithPromo.isHasPromo()).collect(Collectors.toList()).size();
        PostHasPromoCountDTO postHasPromoCountDTO = new PostHasPromoCountDTO(user.getUserId(), user.getUserName(), total);
        return postHasPromoCountDTO;
    }

    @Override
    public PostHasPromoDTO addPostHasPromo(PostHasPromoDTO postHasPromoDTO) {
        if (!postHasPromoDTO.validate())
            throw new InvalidPostRequest();
        User requestUser = repository.getUserById(postHasPromoDTO.getUserId()).orElseThrow(() -> new UserNotExistException(postHasPromoDTO.getUserId()));

        requestUser.addPostHasPromoToUser(postHasPromoDTO);
        return postHasPromoDTO;
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
    public PostsHasPromoDTO getPostWithPromoById(Integer id, String order) {
        User user = repository.getUserById(id).orElseThrow(() -> new UserNotExistException(id));
        if (user.getPosts() == null) {
            return new PostsHasPromoDTO(user.getUserId(), user.getUserName(), new ArrayList<>());
        }
        return new PostsHasPromoDTO(user.getUserId(), user.getUserName(), mapperPostsHasPromoWithId(user.getPosts(), order));
    }

    private List<PostsHasPromoWIthIdDTO> mapperPostsHasPromoWithId(List<Post> posts, String order) {
        List<PostsHasPromoWIthIdDTO> postsPromo = posts.stream().filter(postWithPromo -> postWithPromo.isHasPromo()).map(post ->
                PostsHasPromoWIthIdDTO.builder().userId(post.getUserId()).postId(post.getPostId()).date(post.getDate())
                        .category(post.getCategory()).price(post.getPrice()).hasPromo(post.isHasPromo()).discount(post.getDiscount())
                        .product(ProductDTO.builder().productId(post.getProduct().getProductId())
                                .productName(post.getProduct().getProductName())
                                .type(post.getProduct().getType())
                                .color(post.getProduct().getColor())
                                .brand(post.getProduct().getBrand())
                                .notes(post.getProduct().getNotes()).build()).build()).collect(Collectors.toList());
        if (order != null) {

            if (order.equals(DATE_DESC)) {
                return postsPromo.stream().sorted(Comparator.comparing(PostsHasPromoWIthIdDTO::getDate)).collect(Collectors.toList());
            }
            if (order.equals(DATE_ASC)) {
                return postsPromo.stream().sorted((x, y) -> y.getDate().compareTo(x.getDate())).collect(Collectors.toList());
            }
        }
        return postsPromo;

    }

    private List<Post> getFilterPosts(List<User> vendors) {
        List<Post> filterPosts = new ArrayList<>();
        vendors.forEach(user -> filterPosts.addAll(user.getPostBetweenDate()));
        return filterPosts;
    }


}
