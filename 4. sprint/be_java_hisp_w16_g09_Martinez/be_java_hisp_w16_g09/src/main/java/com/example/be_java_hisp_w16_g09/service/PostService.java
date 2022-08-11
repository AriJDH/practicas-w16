package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.*;
import com.example.be_java_hisp_w16_g09.exception.InvalidDateException;
import com.example.be_java_hisp_w16_g09.exception.NotSellerException;
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
public class PostService implements IPostService{
    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;

    private DTOMapperUtil dtoMapperUtil;

    //Javi


    //Martin
    public void createPost(PostDto postDto){
        int userId = postDto.getUserId();
        User user = userRepository.searchById(userId);
        if (user == null){
            throw new UserNotFoundException(userId);
        }
        if(LocalDate.now().isBefore(postDto.getDate())){
            throw new InvalidDateException(String.valueOf(postDto.getDate()));
        }
        Post post = dtoMapperUtil.map(postDto, Post.class);
        post.setUser(user);
        postRepository.createElement(post);
    }

    public void createPostWithPromo(PromoPostDto promoPostDto){
        int userId = promoPostDto.getUserId();
        User user = userRepository.searchById(userId);
        if (user == null){
            throw new UserNotFoundException(userId);
        }
        if(LocalDate.now().isBefore(promoPostDto.getDate())){
            throw new InvalidDateException(String.valueOf(promoPostDto.getDate()));
        }
        Post post = dtoMapperUtil.map(promoPostDto, Post.class);
        post.setUser(user);
        postRepository.createElement(post);
    }

    //MaxiM


    //MaxiN
    public RecentPostsDto orderByDate(int id, String order){
        RecentPostsDto posts = getRecentPostsOfSellersFollowedByUserWith(id);
        List<PostDto> listOrder =  posts.getPosts().stream()
                .sorted(Comparator.comparing(PostDto::getDate))
                .collect(Collectors.toList());
        if (order.equals("date_desc"))
            listOrder.sort(Comparator.comparing(PostDto::getDate).reversed());
        posts.setPosts(listOrder);
        return posts;
    }

    @Override
    public PromoPostCountDto countPromoBySeller(int userId) {
        User user = userRepository.searchById(userId);
        if (user == null){throw new UserNotFoundException(userId);}
        else if (postRepository.searchById(userId) == null){throw new NotSellerException(user.getUserId());}
        int promoCount = postRepository.getPostsPromoByUserId(userId).size();
        return new PromoPostCountDto(user.getUserId(), user.getUserName(), promoCount);
    }


    @Override
    public PromoPostsUserDto getPromoPostsOfUser(int userId) {
        User user = userRepository.searchById(userId);
        if (user == null) throw new UserNotFoundException(userId);
        else if (postRepository.searchById(userId) == null){throw new NotSellerException(user.getUserId());}
        List<Post> promoPosts = postRepository.getPostsPromoByUserId(userId);
        List<PromoPostDto> promoPostsDtos = dtoMapperUtil.mapList(promoPosts, PromoPostDto.class);
        return new PromoPostsUserDto(userId, user.getUserName(), promoPostsDtos);
    }

    //Guille


    //Nico
    //Constructor hecho para poder testear - inicializar dependencias
    public PostService(IPostRepository postRepository, IUserRepository userRepository,DTOMapperUtil dtoMapperUtil) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.dtoMapperUtil = dtoMapperUtil;
    }

    @Override
    public RecentPostsDto getRecentPostsOfSellersFollowedByUserWith(int anUserId) {
        User user = userRepository.searchById(anUserId);
        if (user == null) throw new UserNotFoundException(anUserId);
        List<Post> postsOfSellers = postsOfSellersFollowedBy(user);
        postsOfSellers = Filter
                .apply(postsOfSellers, (post -> post.wasPublishedAfter(LocalDate.now().minusWeeks(2))));
        postsOfSellers.sort(Comparator.comparing(Post::getDate).reversed());
        List<PostDto> postDtos = dtoMapperUtil.mapList(postsOfSellers, PostDto.class);
        return new RecentPostsDto(user.getUserId(), postDtos);
    }

    private List<Post> postsOfSellersFollowedBy(User user) {
        List<User> sellers = user.getFollowing();
        List<Integer> sellersIds = sellers.stream().map(User::getUserId).collect(Collectors.toList());
        List<Post> postsOfSellers = postRepository.getPostsByUserIds(sellersIds);
        return postsOfSellers;
    }
}


