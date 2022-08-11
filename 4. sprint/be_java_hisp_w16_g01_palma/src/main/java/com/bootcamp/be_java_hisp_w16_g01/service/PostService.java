package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import org.modelmapper.ModelMapper;
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
    private ModelMapper mapper = new ModelMapper();
    @Override
    public MessageDto createPost(PostDto postDto) {
        if (postDto.getDate() == null)
            throw new BadRequestException("La fecha es un campo obligatorio");

        if (postDto.getDate().isAfter(LocalDate.now()))
            throw new BadRequestException("La fecha es posterior a la fecha actual");

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
                postDto.getPrice(),
                postDto.isHas_promo(),
                postDto.getDiscount());

        int id = postRepository.createPost(post);
        post.setPostId(id);
        userRepository.getUser(postDto.getUserId()).addPost(post);

        return new MessageDto("Publicacion creada correctamente, id: " + id);
    }



    private List<ResponsePostDto> getPosts(User user){
        List<Post> post = new ArrayList<>();
        for (User u : user.getFollowed()) {
            post.addAll(postRepository.getPostsByUserId(u.getUserId()));
        }

        return post.stream().map(
                x-> new ResponsePostDto(x.getUserId(),x.getPostId(),x.getDate(),new ProductDto(
                        x.getProduct().getProductId(),
                        x.getProduct().getProductName(),
                        x.getProduct().getType(),
                        x.getProduct().getBrand(),
                        x.getProduct().getColor(),
                        x.getProduct().getNotes()),
                        x.getCategory(),
                        x.getPrice())
        ).collect(Collectors.toList());
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
    public PromoCountDTO getCantPromo(int user_id) {

        User user = userRepository.getUser(user_id);
        if (user != null) {
            List<Post> posts = postRepository.getPromoPost(user_id);
            return new PromoCountDTO(user.getUserId(), user.getUserName(), posts.size());

        } else throw new BadRequestException("Usuario con id: " + user_id + " no existe");
    }

    @Override
    public PromoPostDTO getPromoList(int user_id) {
        User user = userRepository.getUser(user_id);
        if (user != null) {
            List<Post> posts = postRepository.getPromoPost(user_id);
            List<PostDto> postsDto = posts.stream().map(post -> mapper.map(post, PostDto.class)).collect(Collectors.toList());
            return new PromoPostDTO(user.getUserId(), user.getUserName(), postsDto);

        } else throw new BadRequestException("Usuario con id: " + user_id + " no existe");
    }


}
