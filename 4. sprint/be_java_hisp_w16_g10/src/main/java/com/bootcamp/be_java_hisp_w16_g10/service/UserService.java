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
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

        User UserToDelete = this.userRepository.findById(userIdToUnfollow);
        if (UserToDelete == null) throw new NotFoundException(String.format("El usuario que se busca eliminar, con id: %s no existe.",userIdToUnfollow));

        // TODO verificar que el usuario a eliminar es seguido por el usuario.
        List<User> followers = UserToDelete.getFollowers();
        boolean isFollowed = followers.stream().anyMatch(u -> u.getId().equals(userId));
        //if (!isFollowed) throw new BadRequestException("The user is not being followed.");
        followers.remove(user);
    }

    @Override
    public FollowersCountResDTO countFollowers(Integer userId) {
      User user =  this.userRepository.findById(userId);   
      if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));
        return FollowersCountResDTO.builder()
               .followers_count(user.getFollowers().size())
               .user_id(user.getId())
               .user_name(user.getUserName())
               .build();   
    }

    @Override
    public List<FollowersListResDTO> listFollowers(Integer userId, String order) {
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

        List<UserResDTO> followers = user.getFollowers().stream().map(u -> new UserResDTO(u.getId(), u.getUserName())).collect(Collectors.toList());

        var resultado = user.getFollowers().stream()
                .filter(y -> user.getPosts().size() > 0)
                .map(follower -> new FollowersListResDTO(follower.getId(), follower.getUserName(), followers))
                .collect(Collectors.toList());

        if(order.equals("name_asc")){
            return resultado.stream().sorted(Comparator.comparing(UserResDTO::getUser_name)).collect(Collectors.toList());
        }
        else if (order.equals("name_desc")) {
            return resultado.stream().sorted(Comparator.comparing(UserResDTO::getUser_name).reversed()).collect(Collectors.toList());
        }

        return resultado;

    }
    @Override
    public List<FollowedListResDTO> listFollowed(Integer userId, String order) {
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

        var resultado = user.getFollowed().stream()
                .filter(seller -> seller.getPosts().size() > 0)
                .map(this::parseToFollowedListResDTO)
                .collect(Collectors.toList());

        switch (order) {
            case "name_asc":
                return resultado.stream().sorted(Comparator.comparing(UserResDTO::getUser_name)).collect(Collectors.toList());
            case "name_desc":
                return resultado.stream().sorted(Comparator.comparing(UserResDTO::getUser_name).reversed()).collect(Collectors.toList());
        }

        return resultado;
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
