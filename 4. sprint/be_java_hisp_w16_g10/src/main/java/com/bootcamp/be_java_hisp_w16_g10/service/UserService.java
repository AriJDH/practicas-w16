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
        // TODO verificar que ambos usuarios existan

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
        User user = this.userRepository.findById(userId);
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

        List<UserResDTO> followers = user.getFollowers().stream()
                .map(this::parseToUserResDTO)
                .collect(Collectors.toList());

        var resultado = user.getFollowers().stream()
                .filter(y -> user.getPosts().size() > 0)
                .map(follower -> new FollowersListResDTO(follower.getId(), follower.getUserName(), followers))
                .collect(Collectors.toList());

        if (order.equals("name_asc")) {
            return resultado.stream().sorted(Comparator.comparing(UserResDTO::getUser_name)).collect(Collectors.toList());
        } else if (order.equals("name_desc")) {
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
        if (user == null) throw new NotFoundException("This user with id: $s not found");
        Product product = parseToProductFromProductDTO(model.getProduct());
        List<Post> posts = user.getPosts();
        posts.add(new Post(posts.size() + 1,product,model.getDate(),model.getPrice(),model.getCategory()));
        user.setPosts(posts);
        Integer index = userRepository.getIndexOfUser(model.getUser_id());
        if (index == -1) throw new NotFoundException("This user with id: $s not found");
        userRepository.updateUserInList(index,user);
    }

    @Override
    public List<PostResDTO> listFollowersPosts(Integer userId) {
        LocalDate localDate = LocalDate.now().minusDays(14);
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

        List<PostResDTO> postResDTOS = new ArrayList<>();
        for (User u : user.getFollowed()) {
            if (user.getPosts().size() == 0) continue;
            for (Post p : user.getPosts()) {
                if (p.getDate().compareTo(localDate) < 0) continue;
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

    private PostResDTO parseToPostResDTO(User user, Post post) {
        return PostResDTO.builder()
                .user_id(user.getId())
                .category(post.getCategory())
                .post_id(post.getId())
                .date(post.getDate())
                .price(post.getPrice())
                .product(this.parseToProductResDTO(post.getProduct()))
                .build();
    }

    private ProductResDTO parseToProductResDTO(Product product) {
        return ProductResDTO.builder()
                .product_id(product.getId())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .type(product.getType())
                .product_name(product.getName())
                .build();
    }

    private Product parseToProductFromProductDTO(ProductReqDTO productReqDTO){
        return Product.builder()
                .id(productReqDTO.getProduct_id())
                .name(productReqDTO.getProduct_name())
                .type(productReqDTO.getType())
                .brand(productReqDTO.getBrand())
                .color(productReqDTO.getColor())
                .notes(productReqDTO.getNotes())
                .build();
    }
}
