package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostWithIDDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.Product;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidPostRequest;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    @Autowired
    IUserRepository repository;

    @Override
    public void addPost(PostDTO request) {
        // se valida el request en caso que de false se lanza excepcion
        if (!request.validate())
            throw new InvalidPostRequest();
        // se trae usuario del repo para luego castearlo a User y agregarle el post
        User requestUser = repository.getUserById(request.getUserId());
        if (requestUser != null) {
        // se delega responsabilidad a la entidad para agregar post a usuario
            requestUser.addPostToUser(request);
        } else {
            throw new InvalidPostRequest();
        }

    }
    @Override
    public PostsDTO getLatestPostsByUserId(Integer userId) {
        List<User> vendedores = repository.getFollowedsByUserId(userId);

        List<PostWithIDDTO> listaP = new ArrayList<>();

        for(User u : vendedores){
            for(Post p : u.getPosts()){
                if(p.getDate().isBefore(LocalDate.now())
                        && p.getDate().isAfter(LocalDate.now().minusWeeks(2))){

                    listaP.add(PostWithIDDTO.builder().postId(p.getPostId())
                            .userId(p.getUserId())
                            .price(p.getPrice())
                            .date(p.getDate())
                            .category(p.getCategory())
                            .product(ProductDTO.builder().productId(p.getProduct().getProductId())
                                    .productName(p.getProduct().getProductName())
                                    .type(p.getProduct().getType())
                                    .color(p.getProduct().getColor())
                                    .brand(p.getProduct().getBrand())
                                    .notes(p.getProduct().getNotes()).build()).build());
                }
            }
        }

        listaP.sort(Comparator.comparing(PostWithIDDTO::getDate));

        return PostsDTO.builder().userId(userId).postDTOList(listaP).build();
    }


}
