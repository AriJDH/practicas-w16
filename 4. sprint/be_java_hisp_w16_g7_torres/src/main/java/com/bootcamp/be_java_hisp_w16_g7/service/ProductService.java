package com.bootcamp.be_java_hisp_w16_g7.service;


import com.bootcamp.be_java_hisp_w16_g7.dto.*;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.InvalidQueryException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserIsNotSellerException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IProductRepository;
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
    private final IProductRepository productRepository;
    private final ModelMapper mapper;
    private int count = 1;

    public ProductService(IUserRepository userRepository, IProductRepository productRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public RecentPostsDTO recentPost(int idUser, String order) {
        List<ResponsePostDTO> responsePostDTOS = new ArrayList<>();
            User user = userRepository.findUserById(idUser);
            if(user == null) throw new UserNotFoundException(idUser);

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
        if (user == null) throw new UserNotFoundException(postDto.getId());

        user.getPosts().add(post);
        count++;
        return new ApiResponseDto("Post created successfully", "Post of user with id: " + post.getId() + " was created successfully");
    }

    @Override
    public ApiResponseDto createPromoPost(PromoPostDTO promoPostDTO) {
        Post post = mapper.map(promoPostDTO, Post.class);

        post.setPostId(count);
        post.setHasPromo(true);
        post.setDiscount(post.getDiscount());
        post.setPrice(post.getPrice()-post.getPrice()*post.getDiscount());

        User user = userRepository.findUserById(promoPostDTO.getId());
        if (user == null) throw new UserNotFoundException(promoPostDTO.getId());

        user.getPosts().add(post);
        count++;
        return new ApiResponseDto("Promo post created successfully", "Post of user with id: " + post.getId() + " was created successfully");
    }

    public PromoPostCountDTO getPromoPostCount(int id) {
        User user = getVerifiedSeller(id);
        return new PromoPostCountDTO(user.getId(), user.getName(), productRepository.getPromoPostsCount(user.getPosts()));
    }

    public PostsSummaryDTO getPostsSummary(int id){
        User user = getVerifiedSeller(id);
        List<Post> userPosts = user.getPosts();
        PostsSummaryDTO postsSummaryDTO = new PostsSummaryDTO();

        postsSummaryDTO.setUserId(user.getId());
        postsSummaryDTO.setPostsId(productRepository.getPostsId(userPosts));
        postsSummaryDTO.setTotalPostsAmount(userPosts.size());
        postsSummaryDTO.setPromoPostsAmount(productRepository.getPromoPostsCount(userPosts));
        postsSummaryDTO.setPostsTotalValue(productRepository.getPostsTotalValue(userPosts));
        postsSummaryDTO.setOldestPostDate(productRepository.getOldestPostDate(userPosts));
        postsSummaryDTO.setNewestPostDate(productRepository.getNewestPostDate(userPosts));

        Post highestPricePost = productRepository.getHighestPricePost(userPosts);
        if(highestPricePost.isHasPromo()) postsSummaryDTO.setHighestPricePost(mapper.map(highestPricePost,PostDTO.class));
        else postsSummaryDTO.setHighestPricePost(highestPricePost);
        return postsSummaryDTO;
    }



    private User getVerifiedSeller(int id){
        User user = userRepository.findUserById(id);
        if (user == null)  throw new UserNotFoundException(id);
        if (!user.isSeller()) throw new UserIsNotSellerException(id);
        return user;
    }
}
