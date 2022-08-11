package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.*;
import com.example.be_java_hisp_w16_g09.exception.InvalidDateException;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.model.Post;
import com.example.be_java_hisp_w16_g09.model.PromotedPost;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;
import com.example.be_java_hisp_w16_g09.utility.DTOMapperUtil;
import com.example.be_java_hisp_w16_g09.utility.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{

    private IPostRepository postRepository;
    private IUserService userService;
    private DTOMapperUtil dtoMapperUtil;

    @Autowired
    public PostService(IPostRepository postRepository, IUserService userService,DTOMapperUtil dtoMapperUtil) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.dtoMapperUtil = dtoMapperUtil;
    }

    public void createPost(PostDto postDto){
        int userId = postDto.getUserId();
        User user = userService.getValidatedUser(userId);
        if(LocalDate.now().isBefore(postDto.getDate())){
            throw new InvalidDateException(String.valueOf(postDto.getDate()));
        }
        Post post = dtoMapperUtil.map(postDto, Post.class);
        post.setUser(user);
        postRepository.createElement(post);
    }

    public RecentPostsDTO orderByDate(int id, String order){
        RecentPostsDTO posts = getRecentPostsOfSellersFollowedByUserWith(id);
        List<PostDto> listOrder =  posts.getPosts().stream()
                .sorted(Comparator.comparing(PostDto::getDate))
                .collect(Collectors.toList());
        if (order.equals("date_desc"))
            listOrder.sort(Comparator.comparing(PostDto::getDate).reversed());
        posts.setPosts(listOrder);
        return posts;
    }

    @Override
    public void createPromotedPost(PromotedPostDTO promotedPostDTO) {
        int userId = promotedPostDTO.getUserId();
        User user = userService.getValidatedUser(userId);
        if(LocalDate.now().isBefore(promotedPostDTO.getDate())){
            throw new InvalidDateException(String.valueOf(promotedPostDTO.getDate()));
        }
        PromotedPost post = dtoMapperUtil.map(promotedPostDTO, PromotedPost.class);
        post.setUser(user);
        postRepository.createElement(post);
    }

    @Override
    public PromotedPostsCountDTO amountOfPromoPostsPublishedByUserWith(int userId) {
        User user = userService.getValidatedUser(userId);
        List<Post> posts = postRepository.getPromotedPostsOfUser(userId);

        return new PromotedPostsCountDTO(userId, user.getUserName(), posts.size());
    }

    @Override
    public PromotedPostsOfUserDTO getPromotedPostsOfUser(int anUserId) {
        var user = userService.getValidatedUser(anUserId);
        var promotedPosts = postRepository.getPromotedPostsOfUser(anUserId);
        var promotedPostsDtos = dtoMapperUtil.mapList(promotedPosts, PromotedPostDTO.class);
        return new PromotedPostsOfUserDTO(anUserId, user.getUserName(), promotedPostsDtos);
    }

    @Override
    public RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId) {
        User user = userService.getValidatedUser(anUserId);
        List<Post> postsOfSellers = postsOfSellersFollowedBy(user);
        postsOfSellers = Filter
                .apply(postsOfSellers, (post -> post.wasPublishedAfter(LocalDate.now().minusWeeks(2))));
        postsOfSellers.sort(Comparator.comparing(Post::getDate).reversed());
        List<PostDto> postDtos = dtoMapperUtil.mapList(postsOfSellers, PostDto.class);
        return new RecentPostsDTO(user.getUserId(), postDtos);
    }

    private List<Post> postsOfSellersFollowedBy(User user) {
        List<User> sellers = user.getFollowing();
        List<Integer> sellersIds = sellers.stream().map(User::getUserId).collect(Collectors.toList());
        List<Post> postsOfSellers = postRepository.getPostsByUserIds(sellersIds);
        return postsOfSellers;
    }
}


