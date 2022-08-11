package com.bootcamp.be_java_hisp_w16_g7_cardenas.service;


import com.bootcamp.be_java_hisp_w16_g7_cardenas.dto.*;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.entity.User;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.exception.BadDiscountException;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.exception.InvalidQueryException;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.exception.UserIsNotSellerException;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.util.PostMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {


    private final IUserRepository userRepository;
    private final ModelMapper mapper;
    private int count = 1;

    public ProductService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public RecentPostsDTO recentPost(int idUser, String order) {
        if (userRepository.existsUser(idUser)) {
            User user = userRepository.findUserById(idUser);
            List<ResponsePostDTO> responsePostDTOS = new ArrayList<>();
            for (User users : user.getFollows()) {
                List<ResponsePostDTO> recentPosts = users.getPosts().stream()
                        .filter(x -> x.getCreationDate().isAfter(LocalDate.now().minusDays(14)))
                        .map(PostMapper::mapPostToDto)
                        .collect(Collectors.toList());
                responsePostDTOS.addAll(recentPosts);
            }
            if ("date_asc".equals(order)) {
                return new RecentPostsDTO(idUser, orderByDateAsc(responsePostDTOS));
            } else if ("date_desc".equals(order) || order == null) {
                return new RecentPostsDTO(idUser, orderByDateDes(responsePostDTOS));
            } else {
                throw new InvalidQueryException("order", order);
            }

        } else {
            throw new UserNotFoundException(idUser);
        }
    }


    @Override
    public List<ResponsePostDTO> orderByDateAsc(List<ResponsePostDTO> postList) {
        return postList.stream()
                .sorted(Comparator.comparing(ResponsePostDTO::getDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponsePostDTO> orderByDateDes(List<ResponsePostDTO> postList) {
        return postList.stream()
                .sorted(Comparator.comparing(ResponsePostDTO::getDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponseDto createPost(PostDTO postDto) {

        Post post = mapper.map(postDto, Post.class);

        post.setPostId(count);
        post.setHasPromo(false);
        post.setDiscount(0.0);

        User user = userRepository.findUserById(postDto.getId());
        if (user == null) {
            throw new UserNotFoundException(postDto.getId());
        }

        user.getPosts().add(post);

        count++;
        System.out.println(user);

        return new ApiResponseDto("Post created successfully", "Post of user with id: " + post.getId() +
                " was created successfully");
    }

    @Override
    public ApiResponseDto createPostWithDiscount(PostDiscountDTO postDto) {
        Post post = mapper.map(postDto, Post.class);
        if(!post.isHasPromo() || post.getDiscount() <= 0 || post.getDiscount() > 1)
            throw new BadDiscountException();

        User user = userRepository.findUserById(postDto.getUserId());
        if(user == null)
            throw new UserNotFoundException(postDto.getUserId());

        post.setPostId(count++);
        post.setId(postDto.getUserId());
        userRepository.addToPosts(user, post);

        return new ApiResponseDto("Post created successfully", "Post with id " + post.getPostId() +
                " was created successfully");
    }

    @Override
    public DiscountCountDTO getDiscountCount(int userId) {
        User user = getUserOrNotFound(userId);

        if(!user.isSeller())
            throw new UserIsNotSellerException(userId);

        long counter = user.getPosts().stream()
                .filter(Post::isHasPromo)
                .count();
        return new DiscountCountDTO(userId, user.getName(), counter);
    }

    public List<ResponsePostDTO> getSellerPosts(int userId, String order, String promo) {
        User user = getUserOrNotFound(userId);

        if(!user.isSeller())
            throw new UserIsNotSellerException(userId);

        if (order != null && !order.equals("date_asc") && !order.equals("date_desc")) {
            throw new InvalidQueryException("order", order);
        }

        if (promo != null && !promo.equals("yes") && !promo.equals("no")) {
            throw new InvalidQueryException("promo", promo);
        }

        // comparator for sorting, date_desc is default order
        Comparator<Post> comparator = Comparator.comparing(Post::getCreationDate).reversed();
        if("date_asc".equals(order))
            comparator = comparator.reversed();

        return user.getPosts().stream()
                // promo=yes -> only posts with a promotion
                // promo=false -> only posts without a promotion
                // default -> all posts
                .filter(post -> {
                    if("yes".equals(promo))
                        return post.isHasPromo();
                    else if("no".equals(promo))
                        return !post.isHasPromo();
                    return true;
                })
                .sorted(comparator)
                .map(PostMapper::mapPostToDto)
                .collect(Collectors.toList());
    }

    private User getUserOrNotFound(int userId) {
        User user = userRepository.findUserById(userId);
        if(user == null)
            throw new UserNotFoundException(userId);
        return user;
    }
}
