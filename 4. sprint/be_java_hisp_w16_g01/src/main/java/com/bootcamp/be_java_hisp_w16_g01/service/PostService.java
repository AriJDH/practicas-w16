package com.bootcamp.be_java_hisp_w16_g01.service;

import com.bootcamp.be_java_hisp_w16_g01.dto.*;
import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.Product;
import com.bootcamp.be_java_hisp_w16_g01.entities.User;
import com.bootcamp.be_java_hisp_w16_g01.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g01.mapper.PostMapper;
import com.bootcamp.be_java_hisp_w16_g01.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g01.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    private PostMapper postMapper = new PostMapper();

    @Override
    public MessageDto createPost(PostDto postDto) {
        if (postDto.getDate() == null)
            throw new BadRequestException("La fecha es un campo obligatorio");

        if (postDto.getDate().isAfter(LocalDate.now()))
            throw new BadRequestException("La fecha es posterior a la fecha actual");

        if (!userRepository.userExists(postDto.getUserId()))
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
                postDto.isHasPromo(),
                postDto.getDiscount());

        int id = postRepository.createPost(post);
        post.setPostId(id);
        userRepository.getUser(postDto.getUserId()).addPost(post);
        return new MessageDto("Publicacion creada correctamente, id: " + id);
    }

    private List<ResponsePostDto> getPosts(User user) {
        List<Post> post = new ArrayList<>();
        for (User u : user.getFollowed()) {
            post.addAll(postRepository.getPostsByUserId(u.getUserId()));
        }

        return post.stream().map(
                x -> new ResponsePostDto(x.getUserId(), x.getPostId(), x.getDate(), new ProductDto(
                        x.getProduct().getProductId(),
                        x.getProduct().getProductName(),
                        x.getProduct().getType(),
                        x.getProduct().getBrand(),
                        x.getProduct().getColor(),
                        x.getProduct().getNotes()),
                        x.getCategory(),
                        x.getPrice(),
                        x.isHasPromo(),
                        x.getDiscount())).collect(Collectors.toList());
    }


    @Override
    public FollowedPostsDto getFollowedPosts(int userId, String order) {
        User user = userRepository.getUser(userId);
        if (user == null)
            throw new BadRequestException("No existe el usuario con Id: " + userId);

        if (order != null) {
            if (order.equalsIgnoreCase("date_desc")) {
                return new FollowedPostsDto(userId, getPosts(user).stream()
                        .sorted(Comparator.comparing(ResponsePostDto::getDate).reversed())
                        .collect(Collectors.toList()));
            } else
                return new FollowedPostsDto(userId, getPosts(user).stream()
                        .sorted(Comparator.comparing(ResponsePostDto::getDate))
                        .collect(Collectors.toList()));
        } else
            return new FollowedPostsDto(userId, getPosts(user));
    }

    @Override
    public PromoProductsCountDto getCountPromoPost(int userId) {
        User user = userRepository.getUser(userId);
        if (user != null) {
            int countPromoPost =  (int) user.getPosts().stream().filter(Post::isHasPromo).count();
            return new PromoProductsCountDto(user.getUserId(), user.getUserName(), countPromoPost);
        }
        throw new BadRequestException("No existe el usuario con Id: " + userId);
    }

    @Override
    public PromoPostListDto findAllPromoProductsBySeller(int userId) {
        User user = userRepository.getUser(userId);
        if (user != null) {
            List<ResponsePostDto> posts = user.getPosts().stream().filter(Post::isHasPromo).map(post -> postMapper.toResponsePostDto(post) ).collect(Collectors.toList());
            return new PromoPostListDto(user.getUserId(),user.getUserName(), posts);
        }
        throw new BadRequestException("No existe el usuario con Id: " + userId);
    }

}
