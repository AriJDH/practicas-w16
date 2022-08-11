package com.example.be_java_hisp_w16_g09_bariani.service;

import com.example.be_java_hisp_w16_g09_bariani.dto.*;
import com.example.be_java_hisp_w16_g09_bariani.exception.InvalidDateException;
import com.example.be_java_hisp_w16_g09_bariani.exception.UserIsNotSellerException;
import com.example.be_java_hisp_w16_g09_bariani.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09_bariani.model.Post;
import com.example.be_java_hisp_w16_g09_bariani.model.User;
import com.example.be_java_hisp_w16_g09_bariani.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09_bariani.repository.IUserRepository;
import com.example.be_java_hisp_w16_g09_bariani.utility.DTOMapperUtil;
import com.example.be_java_hisp_w16_g09_bariani.utility.Filter;
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

    @Autowired
    DTOMapperUtil dtoMapperUtil;

    //Javi


    //Martin
    public void createPost(PostDto postDto) {
        Post post = dtoMapperUtil.map(postDto, Post.class);
        createValidatedPost(post, postDto.getUserId());
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
    @Override
    public void createPromoPost(PromoPostDto promoPostDto) {
        Post post = dtoMapperUtil.map(promoPostDto, Post.class);
        createValidatedPost(post, promoPostDto.getUserId());
    }

    @Override
    public PromoPostCountDtoResponse countSellerPromoProducts(int anUserId) {
        User seller = getValidatedUser(anUserId);
        validateUserIsSeller(seller);
        int countPromos = getPromoPostOfSeller(anUserId).size();
        return new PromoPostCountDtoResponse(seller.getUserId(), seller.getUserName(), countPromos);
    }

    @Override
    public PromoPostListDtoResponse getAllPromoPostOfSeller(int user_id, String order) {
        User seller = getValidatedUser(user_id);
        validateUserIsSeller(seller);
        List<Post> promoPostList = getPromoPostOfSeller(seller.getUserId());
        if (order != null){
            promoPostList = orderPostListByDate(promoPostList, order);
        }
        List<PromoPostDto> promosDtoList = dtoMapperUtil.mapList(promoPostList, PromoPostDto.class);
        return new PromoPostListDtoResponse(seller.getUserId(), seller.getUserName(), promosDtoList);
    }

    private List<Post> getPromoPostOfSeller(int userId){
        return postRepository.searchById(userId).stream().filter(Post::isHasPromo).collect(Collectors.toList());
    }

    private void validateUserIsSeller(User user){
        if (postRepository.searchById(user.getUserId()) == null){
            throw new UserIsNotSellerException(user.getUserId());
        }
    }
    private void createValidatedPost(Post post, int userId) {
        User user = getValidatedUser(userId);
        if (LocalDate.now().isBefore(post.getDate())) {
            throw new InvalidDateException(String.valueOf(post.getDate()));
        }
        post.setUser(user);
        postRepository.createElement(post);
    }

    private User getValidatedUser(int userId) {
        User user = userRepository.searchById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    public List<Post> orderPostListByDate(List<Post> list, String order) {
        List<Post> listOrder = list.stream()
                .sorted(Comparator.comparing(Post::getDate))
                .collect(Collectors.toList());
        if (order.equals("date_desc"))
            listOrder.sort(Comparator.comparing(Post::getDate).reversed());
        return listOrder;
    }

    //Nico
    @Override
    public RecentPostsDTO getRecentPostsOfSellersFollowedByUserWith(int anUserId) {
        User user = getValidatedUser(anUserId);
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
        return postRepository.getPostsByUserIds(sellersIds);
    }
}


