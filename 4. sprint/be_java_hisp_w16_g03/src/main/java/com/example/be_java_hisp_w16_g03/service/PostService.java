package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostWithIDDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidPostRequest;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        //Se obtiene vendedores del repo
        List<User> vendors = repository.getFollowedsByUserId(userId);
        // Se filtran post segun reglas de negocio detalladas en el requerimiento US006
        if (vendors != null) {
            List<Post> filterPosts = getFilterPosts(vendors);

            //Se mapea lista a DTO, luego se ordena y se retorna en el Dto correspondiente al requerimietno US006
            List<PostWithIDDTO> postsWithIdDtos = filterPosts.stream().map(post -> PostWithIDDTO.builder().postId(post.getPostId())
                    .userId(post.getUserId())
                    .price(post.getPrice())
                    .date(post.getDate())
                    .category(post.getCategory())
                    .product(ProductDTO.builder().productId(post.getProduct().getProductId())
                            .productName(post.getProduct().getProductName())
                            .type(post.getProduct().getType())
                            .color(post.getProduct().getColor())
                            .brand(post.getProduct().getBrand())
                            .notes(post.getProduct().getNotes()).build()).build()).sorted(Comparator.comparing(PostWithIDDTO::getDate)).collect(Collectors.toList());

            return PostsDTO.builder().userId(userId).posts(postsWithIdDtos).build();
        }
        // si no hay vendedores retorno dto con lista vacia
        return PostsDTO.builder().userId(userId).posts(new ArrayList<>()).build();
    }

    private List<Post> getFilterPosts(List<User> vendors) {
        List<Post> filterPosts = new ArrayList<>();
        vendors.forEach(user -> filterPosts.addAll(user.getPostBetweenDate()));
        return filterPosts;
    }


}
