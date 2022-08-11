package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.*;
import com.example.be_java_hisp_w16_g09.exception.InvalidDateException;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.exception.UserToFollowIsNotSellerException;
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
        User user = validateNewPost(postDto.getDate(), postDto.getUserId());
        Post post = dtoMapperUtil.map(postDto, Post.class);
        post.setUser(user);
        postRepository.createElement(post);
    }
    public User validateNewPost(LocalDate date, int userId){
        User user = userRepository.searchById(userId);
        if (user == null){
            throw new UserNotFoundException(userId);
        }
        if(LocalDate.now().isBefore(date)){
            throw new InvalidDateException(String.valueOf(date));
        }
        return user;
    }
    public void createPostPromo(PostPromoDto postPromoDto){
        User user = validateNewPost(postPromoDto.getDate(), postPromoDto.getUserId());
        Post post = dtoMapperUtil.map(postPromoDto, Post.class);
        post.setUser(user);
        postRepository.createElement(post);
    }

    //MaxiM


    //MaxiN
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


    //Guille


    //Nico
    //Constructor hecho para poder testear - inicializar dependencias
    public PostService(IPostRepository postRepository, IUserRepository userRepository,DTOMapperUtil dtoMapperUtil) {
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
    public PromoPostCountDto getTotalPromoPost(int userId){
        User user = getUserValidatedAndSeller(userId);
        int countPostPromo = postRepository.getPostsPromoByUserId(userId).size();
        PromoPostCountDto promoPostCountDto = new PromoPostCountDto(userId, user.getUserName(), countPostPromo);
        return promoPostCountDto;
    }

    @Override
    public PromoPostSellerListDto getListPromoPostSeller(int userId) {
        User user = getUserValidatedAndSeller(userId);
        List<Post> postsPromo = postRepository.getPostsPromoByUserId(userId);
        List<PostPromoDto> postsPromoDto = dtoMapperUtil.mapList(postsPromo, PostPromoDto.class);
        return new PromoPostSellerListDto(userId, user.getUserName(), postsPromoDto);
    }
    private User getUserValidatedAndSeller(int userId){
        User user = userRepository.searchById(userId);
        if (user == null){
            throw new UserNotFoundException(userId);
        }
        if (postRepository.searchById(userId) == null){
            throw new UserToFollowIsNotSellerException(userId);
        }
        return user;
    }

}


