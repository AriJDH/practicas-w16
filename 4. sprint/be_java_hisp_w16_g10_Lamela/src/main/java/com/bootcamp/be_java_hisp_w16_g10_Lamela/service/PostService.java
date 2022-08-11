package com.bootcamp.be_java_hisp_w16_g10_Lamela.service;

import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.request.PostReqPromoDTO;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Discount;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.entity.User;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.exception.ConstraintViolationException;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g10_Lamela.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;
    @Lazy
    @Autowired
    private UserService userService;

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
    public List<PostResDTO> findByUserId(Integer userID){
        return this.postRepository.findByUserId(userID).stream()
                .map(Mapper::parseToPostResDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Post save(PostReqDTO postReqDTO){
        this.userService.findById(postReqDTO.getUserId());
        if(postReqDTO.getDate().isAfter(LocalDate.now()))
            throw new ConstraintViolationException("The date of the post is in the future.");
        return this.postRepository.save(Mapper.parseToPost(postReqDTO));
    }
    @Override
    public void saveWithPromo(PostReqPromoDTO postReqPromoDTO) {
        Post post = this.save(postReqPromoDTO);
        this.postRepository.savePromo(post.getId(), Discount
                .builder()
                .discount(postReqPromoDTO.getDiscount())
                .hasPromo(postReqPromoDTO.getHasPromo())
                .build()
        );
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

        if (order != null && order.equals("date_asc")) //por defecto orden descendente
            posts = posts.sorted(Comparator.comparing(Post::getDate));
        else
            posts = posts.sorted(Comparator.comparing(Post::getDate).reversed());

        return Mapper.parseToPostListResDTO(user, posts.collect(Collectors.toList()));
    }

    private Post validatePost(Integer postID) {
        Post post = this.postRepository.findById(postID);
        if (post == null) //valida si existe el post, sino devuelve un error
            throw new NotFoundException(String.format("The post with id: %s don't exists.", postID));
        return post;
    }
    @Override
    public PostPromoCountResDTO countPostsWithPromo(Integer userId) {
        User user = this.userService.findById(userId);
        List<Post> posts = this.postRepository.findByUserIdWithPromo(userId);
        return PostPromoCountResDTO
                .builder()
                .userName(user.getUserName())
                .userId(user.getId())
                .promoProductsCount(posts.size())
                .build();
    }
    public PostPromoListResDTO listPostsWithPromo(Integer userId) {
        User user = this.userService.findById(userId);
        List<Post> posts = this.postRepository.findByUserIdWithPromo(userId);
        Map<Integer, Discount> discounts = this.postRepository.getDiscountsByPosts(posts);
        return Mapper.parsePostPromoResDTO(posts, discounts, user);
    }
}
