package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IService {
    @Autowired
    private IRepository userRepository;

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {

    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {

    }

    @Override
    public FollowersCountResDTO countFollowers(Integer userId) {
        return null;
    }

    @Override
    public List<FollowersListResDTO> listFollowers(Integer userId, String order) {
        return null;
    }

    @Override
    public List<FollowedListResDTO> listFollowed(Integer userId, String order) {
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));
        return user.getFollowed().stream()
                .filter(seller -> seller.getPosts().size() > 0)
                .map(this::parseToFollowedListResDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(PostReqDTO model) {

    }

    @Override
    public List<PostResDTO> listFollowersPosts(Integer userId) {
        LocalDate localDate = LocalDate.now().minusDays(14);
        User user = this.userRepository.findById(userId);
        if(user == null) throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

        List<PostResDTO> postResDTOS = new ArrayList<>();
        for (User u : user.getFollowed()){
            if(user.getPosts().size() == 0) continue;
            for(Post p : user.getPosts()){
                if(p.getDate().compareTo(localDate) < 0) continue;
                postResDTOS.add(this.parseToPostResDTO(u, p));
            }
        }
        return postResDTOS.stream()
                .sorted(Comparator.comparing(PostResDTO::getDate).reversed())
                .collect(Collectors.toList());
    }

    private FollowedListResDTO parseToFollowedListResDTO(User user) {
        return FollowedListResDTO.builder()
                .user_id(user.getId())
                .user_name(user.getUserName())
                .followed(user.getFollowed().stream()
                        .map(this::parseToUserResDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    private UserResDTO parseToUserResDTO(User user) {
        return UserResDTO.builder()
                .user_id(user.getId())
                .user_name(user.getUserName())
                .build();
    }

    private PostResDTO parseToPostResDTO(User user, Post post){
        return PostResDTO.builder()
                .user_id(user.getId())
                .category(post.getCategory())
                .post_id(post.getId())
                .date(post.getDate())
                .price(post.getPrice())
                .product(this.parseToProductResDTO(post.getProduct()))
                .build();
    }

    private ProductResDTO parseToProductResDTO(Product product){
        return ProductResDTO.builder()
                .product_id(product.getId())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .type(product.getType())
                .product_name(product.getName())
                .build();
    }
}
