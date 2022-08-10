package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        if(!userRepository.userExists(postDto.getUserId()))
            throw new BadRequestException("No existe el usuario con Id: " + postDto.getUserId());

        ProductDto productDto = postDto.getProduct();
        Product product = new Product(productDto.getProductId(),
                productDto.getProductName(),
                productDto.getType(),
                productDto.getBrand(),
                productDto.getColor(),
                productDto.getNotes());
        Post post = new Post(0, postDto.getUserId(),
                postDto.getDate(),
                product,
                postDto.getCategory(),
                postDto.getPrice());

        int id = postRepository.createPost(post);
        post.setPostId(id);
        userRepository.getUser(postDto.getUserId()).addPost(post);

        return new MessageDto("Publicacion creada correctamente, id: " + id);
    }

    @Override
    public FollowedPostsDto getFollowedPosts(int userId) {
        User user = userRepository.getUser(userId);

        if(user == null)
            throw new BadRequestException("No existe el usuario con Id: " + userId);

        List<Post> post = new ArrayList<>();
        for (User u : user.getFollowed()) {
            post.addAll(postRepository.getPostsByUserId(u.getUserId()));
        }

        FollowedPostsDto followedPostsDto = new FollowedPostsDto(userId,post.stream().map(
                x-> new ResponsePostDto(x.getUserId(),x.getPostId(),x.getDate(),new ProductDto(
                        x.getProduct().getProductId(),
                        x.getProduct().getProductName(),
                        x.getProduct().getType(),
                        x.getProduct().getBrand(),
                        x.getProduct().getColor(),
                        x.getProduct().getNotes()),
                        x.getCategory(),
                        x.getPrice())
                ).collect(Collectors.toList()));

        return followedPostsDto;
    }


}
