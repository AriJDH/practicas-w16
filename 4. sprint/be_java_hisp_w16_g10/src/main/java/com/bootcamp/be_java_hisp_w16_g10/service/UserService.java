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
import java.util.UUID;
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
      if(userId.equals(userIdToFollow))
         throw new BadRequestException("Cannot follow yourself");   

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
      if(userId.equals(userIdToUnfollow))
         throw new BadRequestException("Cannot unfollow yourself");
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

      User userToDelete = this.userRepository.findById(userIdToUnfollow);
      if (userToDelete == null)
         throw new NotFoundException(String.format("The user with id: %s don't exists.", userIdToUnfollow));
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
         throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

      return FollowersCountResDTO.builder()
            .followersCount(user.getFollowers().size())
            .userId(user.getId())
            .userName(user.getUserName())
            .build();
   }

   @Override
   public FollowersListResDTO listFollowers(Integer userId, String order) {
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

      List<UserResDTO> followers = user.getFollowers().stream()
            .map(this::parseToUserResDTO)
            .collect(Collectors.toList());

      var listFollowers = new FollowersListResDTO(user.getId(), user.getUserName(), followers);

      if (order != null) {
         if (order.equals("name_asc")) {
            listFollowers.setFollowers(listFollowers.getFollowers().stream()
                  .sorted(Comparator.comparing(UserResDTO::getUserName)).collect(Collectors.toList()));
         }
         if (order.equals("name_desc")) {
            listFollowers.setFollowers(listFollowers.getFollowers().stream()
                  .sorted(Comparator.comparing(UserResDTO::getUserName).reversed()).collect(Collectors.toList()));
         }
      }

      return listFollowers;
   }

   @Override
   public FollowedListResDTO listFollowed(Integer userId, String order) {
      User user = this.userRepository.findById(userId);
      if (user == null)
         throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

      List<UserResDTO> followeds = user.getFollowed().stream()
            .map(this::parseToUserResDTO)
            .collect(Collectors.toList());

      var listFollowed = new FollowedListResDTO(user.getId(), user.getUserName(), followeds);

      if (order != null) {
         if (order.equals("name_asc")) {
            listFollowed.setFollowed(listFollowed.getFollowed().stream().sorted(Comparator.comparing(UserResDTO::getUserName)).collect(Collectors.toList()));
         }
         if (order.equals("name_desc")) {
            listFollowed.setFollowed(listFollowed.getFollowed().stream().sorted(Comparator.comparing(UserResDTO::getUserName).reversed()).collect(Collectors.toList()));
         }
      }

      return listFollowed;
   }

   @Override
   public void save(PostReqDTO post) {
      User user = userRepository.findById(post.getUserId());
      if (user == null)
         throw new NotFoundException(String.format("The user with id: %s don't exists.", post.getUserId()));
      Product product = parseToProductFromProductDTO(post.getProduct());
      List<Post> posts = user.getPosts();
      posts.add(new Post(UUID.randomUUID().toString(), product, post.getDate(), post.getPrice(), post.getCategory()));
      user.setPosts(posts);
      Integer index = userRepository.getIndexOfUser(post.getUserId());
      if (index == -1)
         throw new NotFoundException(String.format("This user with id: %s not found", post.getUserId()));
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
            .userId(user.getId())
            .userName(user.getUserName())
            .followed(user.getFollowed().stream()
                  .map(this::parseToUserResDTO)
                  .collect(Collectors.toList()))
            .build();
   }

   private UserResDTO parseToUserResDTO(User user) {
      return UserResDTO.builder()
            .userId(user.getId())
            .userName(user.getUserName())
            .build();
   }

   private PostResDTO parseToPostResDTO(User user, Post post) {
      return PostResDTO.builder()
            .userId(user.getId())
            .category(post.getCategory())
            .postId(post.getId())
            .date(post.getDate())
            .price(post.getPrice())
            .product(this.parseToProductResDTO(post.getProduct()))
            .build();
   }

   private ProductResDTO parseToProductResDTO(Product product) {
      return ProductResDTO.builder()
            .productId(product.getId())
            .brand(product.getBrand())
            .color(product.getColor())
            .notes(product.getNotes())
            .type(product.getType())
            .productName(product.getName())
            .build();
   }

   private Product parseToProductFromProductDTO(ProductReqDTO productReqDTO) {
      return Product.builder()
            .id(productReqDTO.getProductId())
            .name(productReqDTO.getProductName())
            .type(productReqDTO.getType())
            .brand(productReqDTO.getBrand())
            .color(productReqDTO.getColor())
            .notes(productReqDTO.getNotes())
            .build();
   }
}
