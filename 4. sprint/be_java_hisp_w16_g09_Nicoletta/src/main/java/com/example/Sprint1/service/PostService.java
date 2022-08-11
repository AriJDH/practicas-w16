package com.example.Sprint1.service;

import com.example.Sprint1.dto.*;
import com.example.Sprint1.dto.PostDto;
import com.example.Sprint1.dto.RecentPostsDTO;
import com.example.Sprint1.exception.InvalidDateException;
import com.example.Sprint1.exception.UserNotFoundException;
import com.example.Sprint1.model.Post;
import com.example.Sprint1.model.PostPromo;
import com.example.Sprint1.model.User;
import com.example.Sprint1.repository.IPostRepository;
import com.example.Sprint1.repository.IUserRepository;
import com.example.Sprint1.utility.DTOMapperUtil;
import com.example.Sprint1.utility.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public void createPostPromo(PostPromoDto promoDto){
        int userId = promoDto.getUser_id();
        User user = userRepository.searchById(userId);
        if (user == null){
            throw new UserNotFoundException(userId);
        }
        if(LocalDate.now().isBefore(promoDto.getDate()))
            throw new InvalidDateException(String.valueOf(promoDto.getDate()));
        PostPromo post = dtoMapperUtil.map(promoDto, PostPromo.class);
        post.setUser(user);
        post.setHas_promo(true);
        post.setDiscount(promoDto.getDiscount());
        postRepository.createElement(post);
    }
    public PostPromoResponseDTO calculatePromoCount(int id){
        User user = userRepository.searchById(id);
        if (user == null)throw new UserNotFoundException(id);
        PostPromoResponseDTO res = new PostPromoResponseDTO();
        res.setUser_id(id);
        res.setUser_name(user.getUserName());
        if (postRepository.searchById(id)!= null) {
            int count = (int) postRepository.searchById(id).stream()
                    .filter(x -> x.getClass() == PostPromo.class).count();
            res.setPromo_products_count(count);
        }
        else
            res.setPromo_products_count(0);
        return res;
    }
    public PostPromoListDTO getPromoOfSeller(int id) {
        User user = userRepository.searchById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        PostPromoListDTO res = new PostPromoListDTO();
        res.setUser_id(id);
        res.setUser_name(user.getUserName());
        if (postRepository.searchById(id) != null) {
            List<PostPromoOfSimpleUserDTO> listDTO = postRepository.searchById(id).stream()
                    .filter(x -> x.getClass() == PostPromo.class)
                    .map(post-> dtoMapperUtil.map(post, PostPromoOfSimpleUserDTO.class))
                    .collect(Collectors.toList());
            res.setPosts(listDTO);
        }
        return res;
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
}


