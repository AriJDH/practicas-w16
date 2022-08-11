package com.bootcamp.be_java_hisp_w16_g08_diaz.service;

import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.request.PromoPostDto;
import com.bootcamp.be_java_hisp_w16_g08_diaz.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g08_diaz.entity.Post;
import com.bootcamp.be_java_hisp_w16_g08_diaz.entity.Product;
import com.bootcamp.be_java_hisp_w16_g08_diaz.entity.PromoPost;
import com.bootcamp.be_java_hisp_w16_g08_diaz.entity.User;
import com.bootcamp.be_java_hisp_w16_g08_diaz.exception.NoPromoPostException;
import com.bootcamp.be_java_hisp_w16_g08_diaz.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08_diaz.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g08_diaz.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    final
    IPostRepository postRepository;
    final
    IUserRepository userRepository;

    private int postIdCount = 0;

    final
    ModelMapper mapper;

    public ProductService(IPostRepository postRepository, IUserRepository userRepository) {
        this.mapper= new ModelMapper();
        User user1 = new User(1, "User1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "User2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user4 = new User(4, "User4", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user5 = new User(5, "User5", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
        userRepository.addUser(user4);
        userRepository.addUser(user5);

        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void publishPost(PostDto post) {
        User postUser = getUserIfExist(post.getUserId());
        postIdCount++;
        ProductDto pDto = post.getProduct();
        Product asociatedProduct = new Product(pDto.getProductId(), pDto.getProductName(),
                pDto.getType(), pDto.getBrand(), pDto.getColor(), pDto.getNotes());

        Post newPost = new Post(postIdCount, postUser, post.getDate(), post.getCategory(), post.getPrice(), asociatedProduct);
        postUser.getPostMade().add(newPost);
        postRepository.addPost(newPost);
    }

    @Override
    public void publishPromoPost(PromoPostDto promoPost) {
        User postUser = getUserIfExist(promoPost.getUserId());
        //cambiar a size
        postIdCount++;
        ProductDto pDto = promoPost.getProduct();
        Product promoProduct = new Product(pDto.getProductId(), pDto.getProductName(),
                pDto.getType(), pDto.getBrand(), pDto.getColor(), pDto.getNotes());

        PromoPost newPromoPost = new PromoPost(postIdCount, postUser, promoPost.getDate(), promoPost.getCategory(), promoPost.getDiscount(), promoProduct, promoPost.getHasPromo(), promoPost.getDiscount());
        postUser.getPromoPost().add(newPromoPost);
        postRepository.addPromoPost(newPromoPost);
    }

    @Override
    public ResponsePromoCounter countPromoPost(int userId) {
        User user = getUserIfExist(userId);
        return new ResponsePromoCounter(userId, user.getName(), user.getPromoPost().size());
    }

    @Override
    public ResponsePromoPostFromUserDto getPromoPostFromUser(int userId) {
        User user = getUserIfExist(userId);
        if(user.getPromoPost().size()<1)
            throw new NoPromoPostException();

       List<ResponsePromoPostDto> list =user.getPromoPost().stream()
                .map(x->mapper.map(x,ResponsePromoPostDto.class))
                .collect(Collectors.toList());

        return new ResponsePromoPostFromUserDto(userId,user.getName(), list);
    }

    private User getUserIfExist(int idUser) {
        if (!userRepository.isPresent(idUser)) {
            throw new UserNotFoundException();
        }
        return userRepository.getUserById(idUser);
    }

}
