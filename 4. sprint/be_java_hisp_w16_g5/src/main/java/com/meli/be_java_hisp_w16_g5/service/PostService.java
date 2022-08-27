package com.meli.be_java_hisp_w16_g5.service;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostsByUserDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoDiscountDto;
import com.meli.be_java_hisp_w16_g5.dto.PromoProductsCounts;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.exceptions.NoPostException;
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

       return userRepository.savePost(post);
    }

    @Override
    public PromoDiscountDto savePostDiscount(Post post) throws UserNotFoundException, ProducNotFoundException {
        if(userRepository.findUserById(post.getUserId())==null){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        if(productRepository.getProductById(post.getProduct().getProductId())==null){
            throw new ProducNotFoundException("Producto ingresado no existe");
        }

        return userRepository.savePostDiscount(post);
    }

    @Override
    public PromoProductsCounts getPostDiscountCount(int id) throws UserNotFoundException, NoPostException {

        if(userRepository.findUserById(id)==null){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        User user = userRepository.findUserById(id);
        List<Post> filterPost = new ArrayList<>();
        user.getPosts().stream().forEach(p->{
            if(p.getUserId()==id) filterPost.add(p);
        });
        List<Post> posts = filterPost.stream().filter(post -> post.getHasPromo() &&post.getUserId()==id).collect(Collectors.toList());
        if(posts.size()==0){
            throw new NoPostException("No hay post con descuentos");
        }
        return new PromoProductsCounts(user.getUserId(), user.getUserName(), posts.size());
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
        users = users.stream().filter(u->getPosts()!=null ||!u.getPosts().isEmpty()).collect(Collectors.toList());
        users.stream().forEach(u->{
            posts.addAll(u.getPosts()
                    .stream().filter(post->post.getDate()
                            .compareTo(Util.timeAgo(2,Util.WEEK_VALUE))>=0)
                    .map(p-> new PostDto(p.getUserId(),p.getDate(),p.getProduct()
                            ,p.getCategory(),p.getPrice())).collect(Collectors.toList()));
        });

        if(sortCondition != null){
            posts.sort(
                    (PostDto p1, PostDto p2) -> p1.getDate().compareTo(p2.getDate()) * sortCondition);
        }

        PostsByUserDto postsByUserDTO = new PostsByUserDto(userId, posts);

        return postsByUserDTO;
    }
}