package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

        List<UserResDTO> followers = user.getFollowers().stream().map(u -> new UserResDTO(u.getId(), u.getUserName())).collect(Collectors.toList());

        return user.getFollowers().stream()
                .map(follower -> new FollowersListResDTO(follower.getId(), follower.getUserName(), followers))
                .collect(Collectors.toList());
    }
    @Override
    public List<FollowedListResDTO> listFollowed(Integer userId, String order) {
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));
        return user.getFollowed().stream()
                .filter(seller -> seller.getPosts().size() > 0)
                .map(this::parseToFollowedListResDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(PostReqDTO model) {
        User user = userRepository.findById(model.getUser_id());
        if (user == null) throw new NotFoundException(String.format("User not found id: $s", model.getUser_id()));
        List<Post> posts = user.getPosts();
        Product product = parseToProductFromProductReqtDTO(model.getProduct());
        Integer post_id = posts.size() + 1;
        Post post = new Post(post_id,product,model.getDate(),model.getPrice(),model.getCategory());
        posts.add(post);
        user.setPosts(posts);
        Integer indexUser = userRepository.getIndexOfUser(user.getId());
        if (indexUser < 0) throw new NotFoundException(String.format("User not found id: $s", model.getUser_id()));
        userRepository.updateUserInList(indexUser,user);
    }

    @Override
    public List<PostResDTO> listFollowersPosts(Integer userId) {
        //LocalDate localDate = LocalDate.now().minusDays(14);
        //User user = this.userRepository.findById(userId);
        //if(user == null) throw new NotFoundException(String.format("El usuario con la id: %s no existe.", userId));
        return null;
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

    private PostResDTO parseToPostResDTO(User user){
        return new PostResDTO();
    }

    private Product parseToProductFromProductReqtDTO(ProductReqDTO productReqDTO) {
        return new Product(productReqDTO.getProduct_id(),productReqDTO.getProduct_name(),productReqDTO.getType(), productReqDTO.getBrand(), productReqDTO.getColor(),productReqDTO.getNotes());
    }
}
