package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.BadRequestException;
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
   public List<UserResDTO> findAll() {
      return this.userRepository.findAll().stream()
            .map(this::parseToUserResDTO)
            .collect(Collectors.toList());
   }

   @Override
   public void follow(Integer userId, Integer userIdToFollow) {
      if(userId.equals(userIdToFollow)){
         throw new BadRequestException("Cannot follow yourself");   
      }
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));
      User userToFollow = this.userRepository.findById(userIdToFollow);
      if (userToFollow == null)
         throw new NotFoundException(String.format("The user with id: %s don't exists.", userIdToFollow));
      if(userToFollow.getPosts().size() <= 0){
         throw new BadRequestException("This is not a seller");   
      }


      this.userRepository.addUserToList(user.getFollowed(), userToFollow);
      this.userRepository.addUserToList(userToFollow.getFollowers(), user);
   }

   @Override
   public void unfollow(Integer userId, Integer userIdToUnfollow) {
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

      User userToDelete = this.userRepository.findById(userIdToUnfollow);
      if (userToDelete == null)
         throw new NotFoundException(
               String.format("El usuario que se busca eliminar, con id: %s no existe.", userIdToUnfollow));

      List<User> followers = userToDelete.getFollowers();
      boolean isFollowed = followers.stream().anyMatch(u -> u.getId().equals(userId));
      if (!isFollowed)
         throw new BadRequestException("The user is not being followed.");
      user.getFollowed().remove(userToDelete);   
      followers.remove(user);
   }

   @Override
   public FollowersCountResDTO countFollowers(Integer userId) {
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));
      return FollowersCountResDTO.builder()
            .followers_count(user.getFollowers().size())
            .user_id(user.getId())
            .user_name(user.getUserName())
            .build();
   }

   @Override
   public FollowersListResDTO listFollowers(Integer userId, String order) {
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

      List<UserResDTO> followers = user.getFollowers().stream()
            .map(this::parseToUserResDTO)
            .collect(Collectors.toList());

      // var resultado = user.getFollowers().stream()
      // .filter(y -> user.getPosts().size() > 0)
      // .map(follower -> new FollowersListResDTO(follower.getId(),
      // follower.getUserName(), followers));
      //
      var resultado = new FollowersListResDTO(user.getId(), user.getUserName(), followers);

      if (order != null) {
         if (order.equals("name_asc")) {
            resultado.setFollowers(resultado.getFollowers().stream()
                  .sorted(Comparator.comparing(UserResDTO::getUser_name)).collect(Collectors.toList()));
         }
         if (order.equals("name_desc")) {
            resultado.setFollowers(resultado.getFollowers().stream()
                  .sorted(Comparator.comparing(UserResDTO::getUser_name).reversed()).collect(Collectors.toList()));
         }
      }

      return resultado;

   }

   @Override
   public FollowedListResDTO listFollowed(Integer userId, String order) {
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

      // var resultado = user.getFollowed().stream()
      // .filter(seller -> seller.getPosts().size() > 0)
      // .map(this::parseToFollowedListResDTO);
      List<UserResDTO> followeds = user.getFollowed().stream()
            .map(this::parseToUserResDTO)
            .collect(Collectors.toList());


      var resultado = new FollowedListResDTO(user.getId(), user.getUserName(), followeds);

      if (order != null) {
         if (order.equals("name_asc")) {

            resultado.setFollowed(resultado.getFollowed().stream().sorted(Comparator.comparing(UserResDTO::getUser_name)).collect(Collectors.toList()));
         }
         if (order.equals("name_desc")) {
            resultado.setFollowed(resultado.getFollowed().stream().sorted(Comparator.comparing(UserResDTO::getUser_name).reversed()).collect(Collectors.toList()));
         }
      }

      return resultado;
   }

   @Override
   public void save(PostReqDTO model) {
      User user = userRepository.findById(model.getUser_id());
      if (user == null)
         throw new NotFoundException("This user with id: $s not found");
      Product product = parseToProductFromProductDTO(model.getProduct());
      List<Post> posts = user.getPosts();
      posts.add(new Post(posts.size() + 1, product, model.getDate(), model.getPrice(), model.getCategory()));
      user.setPosts(posts);
      Integer index = userRepository.getIndexOfUser(model.getUser_id());
      if (index == -1)
         throw new NotFoundException(String.format("This user with id: %s not found", model.getUser_id()));
      userRepository.updateUserInList(index, user);
   }

   @Override
   public List<PostResDTO> listFollowersPosts(Integer userId, String order) {
      LocalDate localDate = LocalDate.now().minusDays(14);
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

      List<PostResDTO> postResDTOS = new ArrayList<>();
      for (User u : user.getFollowed()) {
         if (u.getPosts().size() == 0)
            continue;
         for (Post p : u.getPosts()) {
            if (p.getDate().compareTo(localDate) < 0)
               continue;
            postResDTOS.add(this.parseToPostResDTO(u, p));
         }
      }

      var listFollowers = postResDTOS.stream();
      if(order != null && order.equals("date_asc")){
          listFollowers = listFollowers.sorted(Comparator.comparing(PostResDTO::getDate));
      }else{
          listFollowers = listFollowers.sorted(Comparator.comparing(PostResDTO::getDate).reversed());
      }

      return listFollowers
            .collect(Collectors.toList());
   }

   private FollowedListResDTO parseToFollowedListResDTO(User user) {
      return FollowedListResDTO.builder()
            .user_id(user.getId())
            .user_name(user.getUserName())
            .followed(user.getFollowed().stream()
                  .map(this::parseToUserResDTO)
                  .collect(Collectors.toList()))
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

   private Product parseToProductFromProductDTO(ProductReqDTO productReqDTO) {
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
