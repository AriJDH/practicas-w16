package com.bootcamp.be_java_hisp_w16_g01_rodriguez.service;

import com.bootcamp.be_java_hisp_w16_g01_rodriguez.dto.*;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.entities.User;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g01_rodriguez.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private Utils utils;

    public PostService(){
        this.utils = new Utils();
    }

    @Override
    public MessageDTO createPost(PostDTO postDto) {

        utils.validatePostDto(postDto);

        Product product = utils.mapProductDto(postDto.getProduct());

        Post post = new Post(0,
                postDto.getUserId(),
                postDto.getDate(),
                product,
                postDto.getCategory(),
                postDto.getPrice(),
                false,
                0
        );

        int id = addPostToRepo(post);
        return new MessageDTO("Publicacion creada correctamente, id: " + id);
    }

    @Override
    public MessageDTO createPromoPost(PromoPostDTO postDto) {

        utils.validatePostDto(postDto.onlyDataPostDTO());
        utils.validatePromo(postDto);

        Product product = utils.mapProductDto(postDto.getProduct());

        Post post = new Post(0,
                postDto.getUserId(),
                postDto.getDate(),
                product,
                postDto.getCategory(),
                postDto.getPrice(),
                postDto.isHasPromo(),
                postDto.getDiscount()
        );

        int id = addPostToRepo(post);
        return new MessageDTO("Publicacion creada correctamente, id: " + id);
    }

    @Override
    public FollowedPostsDTO getFollowedPosts(int userId, String order) {
        User user = validateUser(userId);

        if (order!= null){
            if (order.equalsIgnoreCase("date_desc")) {
                return new FollowedPostsDTO(userId, getPosts(user).stream()
                        .sorted(Comparator.comparing(ResponsePostDTO::getDate).reversed())
                        .collect(Collectors.toList()));
            } else
                return new FollowedPostsDTO(userId, getPosts(user).stream()
                        .sorted(Comparator.comparing(ResponsePostDTO::getDate))
                        .collect(Collectors.toList()));
        }
        else
            return new FollowedPostsDTO(userId, getPosts(user));
    }

    @Override
    public PromoPostCountDTO getPromoPostCount(int userId) {

        User user = validateUser(userId);
        return new PromoPostCountDTO(
                user.getUserId(),
                user.getUserName(),
                postRepository.getPromoPostCount(userId)
        );
    }

    @Override
    public UserPromoPostsDTO getUserPromoPosts(int userId) {

        User user = validateUser(userId);
        List<PromoPostDTO> posts = postRepository.getPromoPost(userId).stream()
                .map(x -> utils.mapPromoPost(x)
                ).collect(Collectors.toList());

        return new UserPromoPostsDTO(
                user.getUserId(),
                user.getUserName(),
                posts
        );
    }

    private User validateUser(int userId){
        User user = userRepository.getUser(userId);

        if(user == null)
            throw new BadRequestException("No existe el usuario con Id: " + userId);

        return user;
    }

    private int addPostToRepo(Post post){
        int id = postRepository.createPost(post);
        post.setPostId(id);
        userRepository.getUser(post.getUserId()).addPost(post);
        return id;
    }

    private List<ResponsePostDTO> getPosts(User user){
        List<Post> post = new ArrayList<>();
        for (User u : user.getFollowed()) {
            post.addAll(postRepository.getPostsByUserId(u.getUserId()));
        }

        return post.stream()
                .map(x-> utils.mapPost(x))
                .collect(Collectors.toList());
    }
}
