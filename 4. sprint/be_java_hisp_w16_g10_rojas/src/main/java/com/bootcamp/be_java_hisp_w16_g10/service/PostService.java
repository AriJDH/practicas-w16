package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqPromoDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.ProductsPromoCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.SellerPromoProductsListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.SellerPromoProductsResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.Product;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.ConstraintViolationException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g10.repository.UserRepository;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
   @Autowired
   private IPostRepository postRepository;
   @Lazy
   @Autowired
   private IUserService userService;
   @Autowired
   private UserRepository userRepository;

   @Override
   public PostResDTO findById(Integer id) {
      return Mapper.parseToPostResDTO(this.validatePost(id));
   }

   @Override
   public List<PostResDTO> findAll() {
      return this.postRepository.findAll().stream()
            .map(Mapper::parseToPostResDTO)
            .collect(Collectors.toList());
   }

   @Override
   public List<PostResDTO> findByUserId(Integer userID) {
      return this.postRepository.findByUserId(userID).stream()
            .map(Mapper::parseToPostResDTO)
            .collect(Collectors.toList());
   }

   @Override
   public void save(PostReqDTO postReqDTO) {
      this.userService.findById(postReqDTO.getUserId());
      if (postReqDTO.getDate().isAfter(LocalDate.now()))
         throw new ConstraintViolationException("The date of the post is in the future.");
      this.postRepository.save(Mapper.parseToPost(postReqDTO));
   }

   @Override
   public PostListResDTO listFollowersPosts(Integer userId, String order) {
      User user = this.userService.findById(userId);
      LocalDate localDate = LocalDate.now().minusDays(14);

      var posts = user.getFollowed().stream()
            .map(seller -> this.postRepository.findByUserId(seller.getId()))
            .filter(sellerPosts -> sellerPosts.size() > 0)
            .flatMap(Collection::stream)
            .filter(post -> post.getDate().compareTo(localDate) > 0);

      if (order != null && order.equals("date_asc")) // por defecto orden descendente
         posts = posts.sorted(Comparator.comparing(Post::getDate));
      else
         posts = posts.sorted(Comparator.comparing(Post::getDate).reversed());

      return Mapper.parseToPostListResDTO(user, posts.collect(Collectors.toList()));
   }

   @Override
   public void saveWithPromo(PostReqPromoDTO post) {
      User user = this.userService.findById(post.getUserId());

      Product product = Mapper.parseToProduct(post.getProduct());

      postRepository.save(new Post((Integer) 0, user.getId(), product, post.getDate(), post.getPrice(),
            post.getCategory(), post.getHasPromo(), post.getDiscount()));

   }

   @Override
   public SellerPromoProductsListResDTO listSellerPromoProducts(Integer userId) {
      User user = this.userService.findById(userId);
      return sellerPromoProductsListDTOMapper(user);
   }

   @Override
   public List<SellerPromoProductsResDTO> listSellerProductsPromoAll() {
      List<SellerPromoProductsResDTO> promoProductList = new ArrayList<>();
      postRepository.findAll().stream()
            .filter(post -> post.getHasPromo())
            .filter(post -> post.getDate().compareTo(LocalDate.now().minusDays(1)) > 0)
            .forEach(post -> promoProductList.add(sellerPromoProductsListWhitDaysFilterDTOMapper(userService.findById(post.getUserId()), post)));
      return promoProductList;
   }

   @Override
   public ProductsPromoCountResDTO countPromoProducts(Integer userId) {
      User user = userRepository.findById(userId);

      return ProductsPromoCountResDTO.builder()
            .userId(user.getId())
            .userName(user.getUserName())
            .promoProductsCount((Integer) (int) postRepository.findByUserId(userId).stream()
                  .filter(hasPromo -> hasPromo.getHasPromo()).count())
            .build();
   }

   private SellerPromoProductsResDTO sellerPromoProductsListWhitDaysFilterDTOMapper(User user, Post post) {
      return SellerPromoProductsResDTO.builder()
            .userId(user.getId())
            .userName(user.getUserName())
            .posts(findPromoPostAndRetriveListWithDaysFilter(post))
            .build();
   }

   private SellerPromoProductsListResDTO sellerPromoProductsListDTOMapper(User user) {
      return SellerPromoProductsListResDTO.builder()
            .userId(user.getId())
            .userName(user.getUserName())
            .posts(findPromoPostAndRetriveList(user))
            .build();
   }

   private List<PostResDTO> findPromoPostAndRetriveList(User user) {

      List<PostResDTO> listWithPromoTrue = new ArrayList<>();
      postRepository.findByUserId(user.getId())
            .stream()
            .filter(post -> post.getHasPromo())
            .forEach(postFiltred -> listWithPromoTrue.add(Mapper.parseToPostResDTO(postFiltred)));
      return listWithPromoTrue;
   }

   private PostResDTO findPromoPostAndRetriveListWithDaysFilter(Post post) {
      return Mapper.parseToPostResDTO(post);
   }

   private Post validatePost(Integer postID) {
      Post post = this.postRepository.findById(postID);
      if (post == null) // valida si existe el post, sino devuelve un error
         throw new NotFoundException(String.format("The post with id: %s don't exists.", postID));
      return post;
   }
   private void validateThisSHit (Integ)
}
