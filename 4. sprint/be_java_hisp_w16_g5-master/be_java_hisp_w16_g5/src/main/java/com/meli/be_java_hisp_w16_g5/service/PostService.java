package com.meli.be_java_hisp_w16_g5.service;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostsByUserDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoPostDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoPostsDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.exceptions.ProducNotFoundException;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.repository.IPostRepository;
import com.meli.be_java_hisp_w16_g5.repository.IProductRepository;
import com.meli.be_java_hisp_w16_g5.repository.IUserRepository;
import com.meli.be_java_hisp_w16_g5.util.Util;
import com.meli.be_java_hisp_w16_g5.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService  implements IPostService{

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public PostDto save(Post post) throws UserNotFoundException, ProducNotFoundException {
        if(userRepository.findUserById(post.getUserId())==null){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        if(productRepository.getProductById(post.getProduct().getProductId())==null){
            throw new ProducNotFoundException("Producto ingresado no existe");
        }

       return postRepository.savePost(post);
    }

    @Override
    public List<PostDto> getPosts() {
        return postRepository.getPosts();
    }

    @Override
    public PostsByUserDto getFollowedProducts(int userId, String order) throws UserNotFoundException, UnknownRequestException{
        User user = userRepository.findUserById(userId);
        if(user == null){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        
        List<User> followedUsers = user.getFollowing();
        List<User> users = followedUsers != null ? followedUsers : new ArrayList<>();
        Integer sortCondition = Util.getSortCondition(order, "date");
        List<PostDto> posts = new ArrayList<>(); 
        
        users.stream().forEach(u -> {
            posts.addAll(postRepository.filterByUserIdAndDate(
                u.getUserId(),
                Util.timeAgo(2)
            ));
        });
           
        if(sortCondition != null)
            posts.sort(
                (PostDto p1, PostDto p2) -> p1.getDate().compareTo(p2.getDate()) * sortCondition
            );

        PostsByUserDto postsByUserDTO = new PostsByUserDto(userId, posts);

        return postsByUserDTO;
    }

    @Override
    public PromoPostDto getPromoPostCount(int userId) throws UserNotFoundException {
        
        User user = userRepository.findUserById(userId);

        if(user == null){
            throw new UserNotFoundException("Usuario no encontrado");
        }

        return new PromoPostDto(userId, user.getUserName(), 
            user.getPosts().stream().filter(p -> p.isHasPromo()).count()
        );
    }

    @Override
    public PromoPostsDto getPromoPostList(int userId) throws UserNotFoundException {
        User user = userRepository.findUserById(userId);
        if(user == null){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        return new PromoPostsDto(userId, user.getUserName(), user.getPosts().stream().filter(p -> p.isHasPromo()).map(
            p -> new PostDto(p.getUserId(), p.getDate(), p.getProduct(), p.getCategory(), p.getPrice(), p.isHasPromo(), p.getDiscount())
        ).collect(Collectors.toList()));
    }
}