package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.RecentPostsDTO;
import com.example.be_java_hisp_w16_g09.exception.InvalidDateException;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.model.Post;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;
import com.example.be_java_hisp_w16_g09.utility.DTOMapperUtil;
import com.example.be_java_hisp_w16_g09.utility.Filter;
import com.example.be_java_hisp_w16_g09.utility.sort.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    //Maxi

    //Guille


    //Nico
    //Constructor hecho para poder testear - inicializar dependencias
    public PostService(IPostRepository postRepository, IUserRepository userRepository,DTOMapperUtil dtoMapperUtil) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.dtoMapperUtil = dtoMapperUtil;
    }

    @Override
    public RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId, String anOrder) {
        User user = getValidatedUser(anUserId);
        List<Post> postsOfSellers = postsOfSellersFollowedBy(user);
        postsOfSellers = Filter.apply(postsOfSellers, (post -> post.wasPublishedAfter(LocalDate.now().minusWeeks(2))));

        postsOfSellers = Sort.orderSequenceBasedOn(anOrder, "date").sortingBy(Post::getDate, postsOfSellers);

        List<PostDto> postDtos = dtoMapperUtil.mapList(postsOfSellers, PostDto.class);
        return new RecentPostsDTO(user.getUserId(), postDtos);
    }

    private List<Post> postsOfSellersFollowedBy(User user) {
        List<User> sellers = user.getFollowing();
        List<Integer> sellersIds = sellers.stream().map(User::getUserId).collect(Collectors.toList());
        List<Post> postsOfSellers = postRepository.getPostsByUserIds(sellersIds);
        return postsOfSellers;
    }

    private User getValidatedUser(int userId) {
        User user = userRepository.searchById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }
}


