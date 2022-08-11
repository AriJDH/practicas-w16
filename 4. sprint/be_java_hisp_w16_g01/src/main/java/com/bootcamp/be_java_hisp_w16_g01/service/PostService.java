package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.mapper.Mapper;
import com.bootcamp.be_java_hisp_w16_g01.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public MessageDto createPost(PostDto postDto) {
        if (postDto.getDate() == null)
            throw new BadRequestException("La fecha es un campo obligatorio");

        if (postDto.getDate().isAfter(LocalDate.now()))
            throw new BadRequestException("La fecha es posterior a la fecha actual");

        if(!userRepository.userExists(postDto.getUserId()))
            throw new BadRequestException("No existe el usuario con Id: " + postDto.getUserId());

        Post post = Mapper.toPost(postDto);

        int id = postRepository.createPost(post);
        userRepository.getUser(postDto.getUserId()).addPost(post);

        return new MessageDto("Publicacion creada correctamente, id: " + id);
    }

    @Override
    public MessageDto createPromoPost(PromoPostDto postDto) {
        if (postDto.getDate() == null)
            throw new BadRequestException("La fecha es un campo obligatorio");

        if (postDto.getDate().isAfter(LocalDate.now()))
            throw new BadRequestException("La fecha es posterior a la fecha actual");

        if(!userRepository.userExists(postDto.getUserId()))
            throw new BadRequestException("No existe el usuario con Id: " + postDto.getUserId());

        if (!postDto.isHasPromo())
            throw new BadRequestException("El producto no está marcado como promoción");

        Post post = Mapper.toPost(postDto);
        int id = postRepository.createPost(post);
        userRepository.getUser(postDto.getUserId()).addPost(post);

        return new MessageDto("Publicacion creada correctamente, id: " + id);
    }


    private List<ResponsePostDto> getPosts(User user){
        List<Post> post = new ArrayList<>();
        for (User u : user.getFollowed()) {
            post.addAll(postRepository.getPostsByUserId(u.getUserId()));
        }

        return post.stream().map(Mapper::toResponsePostDto).collect(Collectors.toList());
    }


    @Override
    public FollowedPostsDto getFollowedPosts(int userId, String order) {
        User user = userRepository.getUser(userId);

        if(user == null)
            throw new BadRequestException("No existe el usuario con Id: " + userId);

        if (order!= null){
            if (order.equalsIgnoreCase("date_desc")) {
                return new FollowedPostsDto(userId, getPosts(user).stream()
                        .sorted(Comparator.comparing(ResponsePostDto::getDate).reversed())
                        .collect(Collectors.toList()));
            } else
                return new FollowedPostsDto(userId, getPosts(user).stream()
                        .sorted(Comparator.comparing(ResponsePostDto::getDate))
                        .collect(Collectors.toList()));
        }
        else
            return new FollowedPostsDto(userId, getPosts(user));
    }

    @Override
    public PromoPostCountDto getPromoPostsCount(int userId) {
        if (userRepository.userExists(userId)) {
            User usr = userRepository.getUser(userId);
            return new PromoPostCountDto(usr.getUserId(), usr.getUserName(),
                    postRepository.getPromoPostsByUserId(userId).size());
        }
        else throw new BadRequestException("No existe el usuario con Id: " + userId);
    }

    @Override
    public PromoPostListDto getPromoPostsList(int userId) {
        User user = userRepository.getUser(userId);

        if(user == null)
            throw new BadRequestException("No existe el usuario con Id: " + userId);

        return new PromoPostListDto(userId, user.getUserName(),
                postRepository.getPromoPostsByUserId(userId).stream().map(Mapper::toPromoPostDto).collect(Collectors.toList()));

    }

    public MessageDto deletePost(int postId){
        Post post = postRepository.getPost(postId);
        if (post == null)
            throw new BadRequestException("No existe el post con Id: " + postId);

        userRepository.getUser(post.getUserId()).removePost(postId);

        postRepository.deletePost(postId);

        return new MessageDto("Publicación eliminada correctamente");
    }
}
