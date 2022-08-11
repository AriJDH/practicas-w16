package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.ProductDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.PromoPostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserPromoCountDto;
import com.bootcamp.be_java_hisp_w16_g08.entity.Post;
import com.bootcamp.be_java_hisp_w16_g08.entity.Product;
import com.bootcamp.be_java_hisp_w16_g08.entity.User;
import com.bootcamp.be_java_hisp_w16_g08.exception.NonePromoException;
import com.bootcamp.be_java_hisp_w16_g08.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g08.repository.IUserRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{
    final
    IPostRepository postRepository;
    final
    IUserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();
    private int postIdCount = 0;

    public ProductService(IPostRepository postRepository, IUserRepository userRepository){
        User user1 = new User(1,"User1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"User2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user3 = new User(3,"User3",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user4 = new User(4,"User4",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user5 = new User(5,"User5",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
        userRepository.addUser(user4);
        userRepository.addUser(user5);

        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void publishPost(PostDto post){
        User postUser = getUserIfExist(post.getUserId());
        postIdCount++;
        ProductDto pDto = post.getProduct();
        Product asociatedProduct = new Product(pDto.getProductId(),pDto.getProductName(),
                                                pDto.getType(),pDto.getBrand(),pDto.getColor(),pDto.getNotes());

        Post newPost = new Post(postIdCount,postUser,post.getDate(),post.getCategory(),post.getPrice(),asociatedProduct,false,0);
        postUser.getPostMade().add(newPost);
        postRepository.addPost(newPost);
    }

    @Override
    public void publishPromoPost(PromoPostDto promoPostDto) {
        User promoPostUser = getUserIfExist(promoPostDto.getUserId());
        postIdCount++;

        Post post = modelMapper.map(promoPostDto, Post.class);
        post.setPostId(postIdCount);
        promoPostUser.getPostMade().add(post);
        postRepository.addPost(post);
    }

    public UserPromoCountDto getUserPromoCount(int userId) {
        User user = getUserIfExist(userId);
        List<Post> promoPostList = user.getPostMade()
                .stream()
                .filter(p->isPromo(p))
                .collect(Collectors.toList());

        int promosCount = promoPostList.size();
        if(promosCount == 0){
            throw new NonePromoException(String.valueOf(userId));
        }

        return new UserPromoCountDto(userId, user.getName(), promosCount);
    }

    @Override
    public List<PromoPostDto> getPromoPostByUserId(int userId){

        User postUser = getUserIfExist(userId);
        List<PromoPostDto> promoPostDtoList = new ArrayList<>();
        promoPostDtoList = postUser.getPostMade()
                .stream()
                .filter(p -> isPromo(p))
                .map(x-> {
                    PromoPostDto promoPostDto = modelMapper.map(x,PromoPostDto.class);
                    return promoPostDto;
                })
                .collect(Collectors.toList());
        if(promoPostDtoList.size()==0){
            throw new NonePromoException(String.valueOf(userId));
        }
        return promoPostDtoList;
    }

    private boolean isPromo(Post post){
        return post.isHasPromo();
    }

    private User getUserIfExist(int idUser) {
        if (!userRepository.isPresent(idUser)) {
            throw new UserNotFoundException();
        }
        return userRepository.getUserById(idUser);
    }

}
