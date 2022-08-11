package com.bootcamp.be_java_hisp_w16_g7.service;


import com.bootcamp.be_java_hisp_w16_g7.dto.*;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.InvalidDiscountException;
import com.bootcamp.be_java_hisp_w16_g7.exception.InvalidQueryException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserIsNotSellerException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
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
        List<ResponsePostDTO> responsePostDTOS = new ArrayList<>();
        if (userRepository.existsUser(idUser)) {
            User user = userRepository.findUserById(idUser);
            for (User users : user.getFollows()) {
                List<Post> recentPost = users.getPosts().stream()
                        .filter(x -> x.getCreationDate().isAfter(LocalDate.now().minusDays(14)))
                        .collect(Collectors.toList());
                for (Post post : recentPost) {
                    responsePostDTOS.add(mapper.map(post, ResponsePostDTO.class));
                }
            }
            if ("date_asc".equals(order)) {
                return new RecentPostsDTO(idUser, orderByDateAsc(responsePostDTOS));
            } else if ("date_desc".equals(order) || order == null) {
                return new RecentPostsDTO(idUser, orderByDateDes(responsePostDTOS));
            } else {
                throw new InvalidQueryException("Unknown query");
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
    public ApiResponseDTO createPost(PostDTO postDto) {

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

        return new ApiResponseDTO("Post created successfully", "Post of user with id: " + post.getId() + " was created successfully");
    }

    @Override
    public ApiResponseDTO postOfProductWithDiscount(PostDTO postDto) {

        Post postWithDiscount = mapper.map(postDto, Post.class);

        if(postWithDiscount.getDiscount() <= 0){
            throw new InvalidDiscountException(postWithDiscount.getDiscount());
        }

        postWithDiscount.setPostId(count);

        User userWhoDiscounts = userRepository.findUserById(postDto.getId());
        if (userWhoDiscounts == null) {
            throw new UserNotFoundException(postDto.getId());
        }

        userWhoDiscounts.getPosts().add(postWithDiscount);

        count++;
        System.out.println(userWhoDiscounts);

        return new ApiResponseDTO("Post created successfully", "Post with discount of user with id: " + postWithDiscount.getId() + " was created successfully");
    }

    @Override
    public PromoProductsCountDTO getCountProductsWithDiscount(int userId) {
        System.out.println("Holaaaaaa");
        int promoProductsCount = 0;

        User user = userRepository.findUserById(userId);

        if (user == null) {
            throw new UserNotFoundException(userId);
        }

        if (!user.isSeller()) {
            throw new UserIsNotSellerException(userId);
        }

        List<Post> postList = user.getPosts();
        for (Post post : postList){
            if (post.getHasPromo() == true)
                promoProductsCount++;
        }

        return new PromoProductsCountDTO(userId, user.getName(), promoProductsCount);
    }

}
