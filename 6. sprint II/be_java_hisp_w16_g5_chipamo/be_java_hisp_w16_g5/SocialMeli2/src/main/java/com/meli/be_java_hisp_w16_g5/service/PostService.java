package com.meli.be_java_hisp_w16_g5.service;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostsByUserDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.Product;
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

/**
 * Clase PostService
 */
@Service
public class PostService  implements IPostService{

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IProductRepository productRepository;

    /**
     * Metodo para enviar la solicitud al repo para guardar un post
     * @param post
     * @return PostDto
     * @throws UserNotFoundException
     * @throws ProducNotFoundException
     */
    @Override
    public PostDto save(Post post) throws UserNotFoundException, ProducNotFoundException {
        User user = userRepository.findUserById(post.getUserId());
        Product product = productRepository.getProductById(post.getProduct().getProductId());

        if(user==null){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        if(product==null){
            throw new ProducNotFoundException("Producto ingresado no existe");
        }

       return postRepository.savePost(post);
    }

    /**
     * Metodo para llamar al repo y obtener los post
     * @return List<PostDto>
     */
    @Override
    public List<PostDto> getPosts() {
        return postRepository.getPosts();
    }

    /**
     * metodo para listar los post de las ultimas dos semanas
     * @param userId
     * @param order
     * @return PostsByUserDto
     * @throws UserNotFoundException
     * @throws UnknownRequestException
     */
    @Override
    public PostsByUserDto getFollowedProducts(Integer userId, String order) throws UserNotFoundException, UnknownRequestException{
        User user = userRepository.findUserById(userId);
        if(user == null){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        
        List<User> followedUsers = user.getFollowing();
        List<User> users = followedUsers != null ? followedUsers : new ArrayList<>();
        Integer sortCondition = Util.getSortCondition(order, "date");
        List<PostDto> posts = new ArrayList<>(); 
        
        users.stream().forEach(u -> {
            posts.addAll(
                postRepository.filterByUserIdAndDate(
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
}