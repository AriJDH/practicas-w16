package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.PostDto;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    private final IPostRepository repository;

    private final IUserRepository userRepository;
    private final ModelMapper mapper ;


    public ProductService(IPostRepository repository, IUserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }


    @Override
    public ApiResponseDto createPost(PostDto postDto) {

        Post post = mapper.map(postDto, Post.class);

        post.setHasPromo(false);
        post.setDiscount(0.0);

        User user = userRepository.getUserById(postDto.getId());

        user.getPosts().add(post);

        //List<Post> posts = user.getPosts().stream().map(post1 -> new Post(post1.getId(), post1.getCreationDate(), post1.getProduct(), post1.getCategory(), post1.getPrice(), post1.isHasPromo(), post1.getDiscount())).collect(Collectors.toList());

       // posts.add(post);

       // user.setPosts(posts);

        System.out.println(user);

        return new ApiResponseDto("Post creado exitosamente", "Post del usuario con id " + post.getId() + " creado correctamente");
    }
}
