package com.bootcamp.be_java_hisp_w16_g7.service;


import com.bootcamp.be_java_hisp_w16_g7.dto.*;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.InvalidQueryException;
import com.bootcamp.be_java_hisp_w16_g7.exception.NoPromoPostException;
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

        return new ApiResponseDto("Post created successfully", "Post of user with id: " + post.getId() + " was created successfully");
    }

    @Override
    public ApiResponseDto createPostPromo(PostPromoDto promoDto) {

        User user = userRepository.findUserById(promoDto.getId());

        if (user == null) {
            throw new UserNotFoundException(promoDto.getId());
        }

        promoDto.setPrice(getPricewithDiscount(promoDto));

        Post post = mapper.map(promoDto, Post.class);

        post.setPostId(count);


        user.getPosts().add(post);

        count++;
        System.out.println(user);

        return new ApiResponseDto("Promo post created successfully", "Promo post of user with id: " + post.getId() + " was created successfully");
    }

    private double getPricewithDiscount(PostPromoDto promoDto){
        return promoDto.getPrice() - (promoDto.getPrice() * promoDto.getDiscount());
    }

    @Override
    public PromoPostCountDto countPostPromo(int id) {

        User user = userRepository.findUserById(id);

        if (user == null) {
            throw new UserNotFoundException(id);
        }
        if(!user.isSeller()){
            throw new UserIsNotSellerException(id);
        }

        long count =  user.getPosts().stream().filter(Post::isHasPromo).count();

        return new PromoPostCountDto(user.getId(), user.getName(), (int) count);
    }

    @Override
    public PromoPostListDto getPromoPostList(int id) {

        User user = userRepository.findUserById(id);

        if (user == null) {
            throw new UserNotFoundException(id);
        }
        if(!user.isSeller()){
            throw new UserIsNotSellerException(id);
        }

        List<ResponsePostPromoDto> postPromoDtos = user.getPosts().stream()
                .filter(Post::isHasPromo)
                .map(post -> mapper.map(post, ResponsePostPromoDto.class))
                .collect(Collectors.toList());

        if(postPromoDtos.isEmpty()){
            throw new NoPromoPostException(id);
        }


        return new PromoPostListDto(user.getId(), user.getName(), postPromoDtos);
    }

}
