package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.PromoPostCounterDto;
import com.example.be_java_hisp_w16_g09.dto.PromoPostDto;
import com.example.be_java_hisp_w16_g09.dto.RecentPostsDTO;
import com.example.be_java_hisp_w16_g09.exception.InvalidDateException;
import com.example.be_java_hisp_w16_g09.exception.UserIsNotSellerException;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.model.Post;
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
public class PostService implements IPostService {
    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;

    private DTOMapperUtil dtoMapperUtil;

    //Javi
    public void createPromoPost(PromoPostDto promoPostDto) {
        Post post = dtoMapperUtil.map(promoPostDto, Post.class);
        Post validatedPost = validatedPost(post, promoPostDto.getUserId());
        postRepository.createElement(validatedPost);
    }

    @Override
    public PromoPostCounterDto countPromoPosts(int userId) {
        User user = userRepository.searchById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        List<Post> posts = postRepository.searchById(userId);
        if (posts == null)
            throw new UserIsNotSellerException(userId);

        int promoCount = Filter.apply(posts,(post -> post.isHasPromo())).size();

        return new PromoPostCounterDto(userId,user.getUserName(),promoCount);
    }

    //Martin
    public void createPost(PostDto postDto) {
        Post post = dtoMapperUtil.map(postDto, Post.class);
        Post validatedPost = validatedPost(post, postDto.getUserId());
        postRepository.createElement(validatedPost);
    }

    private Post validatedPost(Post postToValidate, int userId) {
        User user = userRepository.searchById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        if (LocalDate.now().isBefore(postToValidate.getDate())) {
            throw new InvalidDateException(String.valueOf(postToValidate.getDate()));
        }
        postToValidate.setUser(user);
        return postToValidate;
    }

    //MaxiM


    //MaxiN
    public RecentPostsDTO orderByDate(int id, String order) {
        RecentPostsDTO posts = getRecentPostsOfSellersFollowedByUserWith(id);
        List<PostDto> listOrder = posts.getPosts().stream()
                .sorted(Comparator.comparing(PostDto::getDate))
                .collect(Collectors.toList());
        if (order.equals("date_desc"))
            listOrder.sort(Comparator.comparing(PostDto::getDate).reversed());
        posts.setPosts(listOrder);
        return posts;
    }


    //Guille


    //Nico
    //Constructor hecho para poder testear - inicializar dependencias
    public PostService(IPostRepository postRepository, IUserRepository userRepository, DTOMapperUtil dtoMapperUtil) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.dtoMapperUtil = dtoMapperUtil;
    }

    @Override
    public RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId) {
        User user = userRepository.searchById(anUserId);
        if (user == null) throw new UserNotFoundException(anUserId);
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


