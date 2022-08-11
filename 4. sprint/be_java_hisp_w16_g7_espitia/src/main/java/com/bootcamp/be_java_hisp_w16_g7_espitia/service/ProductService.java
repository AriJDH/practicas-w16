package com.bootcamp.be_java_hisp_w16_g7_espitia.service;


import com.bootcamp.be_java_hisp_w16_g7_espitia.dto.*;
import com.bootcamp.be_java_hisp_w16_g7_espitia.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7_espitia.entity.User;
import com.bootcamp.be_java_hisp_w16_g7_espitia.exception.InvalidQueryException;
import com.bootcamp.be_java_hisp_w16_g7_espitia.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7_espitia.repository.IUserRepository;
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
        //validacion de la existencia del usuario
        if (userRepository.existsUser(idUser)) {
            User user = userRepository.findUserById(idUser);
            //validacion si sigue a alguien
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
    public ApiResponseDto createPromoPost(PromoPostDTO promoPostDTO) {

        Post post = mapper.map(promoPostDTO, Post.class);

        post.setPrice(post.getPrice()/( 1+post.getDiscount()));
        post.setPostId(count);

        User user = userRepository.findUserById(promoPostDTO.getId());

        if (user == null) {
            throw new UserNotFoundException(promoPostDTO.getId());
        }

        user.getPosts().add(post);

        count++;
        System.out.println(user);

        return new ApiResponseDto("Post whit discount created successfully", "Post whit discount of user with id: " + post.getId() + " was created successfully");
    }

    @Override
    public ResponsePromoPostCountDTO countPromoPostByUser(int userId) {

        if(userRepository.existsUser(userId)){
            User user = userRepository.findUserById(userId);
            int promoPost = (int) user.getPosts().stream()
                    .filter(Post::isHasPromo).count();
            return new ResponsePromoPostCountDTO(user.getId(),user.getName(),promoPost);
        }else{
            throw new UserNotFoundException(userId);
        }

    }

    @Override
    public ResponsePomoPostListDTO listPromoPostByUser(int userId) {
        List<ResponsePromoPostDTO> promoPostDTOS ;
        if(userRepository.existsUser(userId)){
            User user = userRepository.findUserById(userId);
             promoPostDTOS = user.getPosts().stream()
                    .filter(Post::isHasPromo)
                    .map(u->mapper.map(u, ResponsePromoPostDTO.class))
                    .collect(Collectors.toList());
            return new ResponsePomoPostListDTO(user.getId(),user.getName(),promoPostDTOS);
        }else{
            throw new UserNotFoundException(userId);
        }
    }


}
