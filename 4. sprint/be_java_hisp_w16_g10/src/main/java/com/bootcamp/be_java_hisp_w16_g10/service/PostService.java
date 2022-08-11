package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostPromoReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostPromoResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PromoProductCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.PromoPost;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.ConstraintViolationException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
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
    public void save(PostReqDTO post){
        this.userService.findById(post.getUserId());
        if(post.getDate().isAfter(LocalDate.now()))
            throw new ConstraintViolationException("The date of the post is in the future.");
        if (post instanceof PostPromoReqDTO) {
            PostPromoReqDTO postPromo = (PostPromoReqDTO) post;
            this.postRepository.save(Mapper.parseToPromoPost(postPromo));
        }
        this.postRepository.save(Mapper.parseToPost(post));
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

    @Override
    public PromoProductCountResDTO promoProductCount(Integer user_id) {
        User user = this.userService.findById(user_id);
        List<Post> posts = postRepository.findByUserId(user_id);
        List<PromoPost> promoPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post instanceof PromoPost) promoPosts.add((PromoPost) post);
        }
        return Mapper.parseToPromoCount(user, promoPosts);
    }

    @Override
    public List<PostPromoResDTO> listPostPromo(Integer user_id) {
        User user = userService.findById(user_id);
        List<PromoPost> posts = postRepository.findPromosByUserId(user_id);
        List<PostPromoResDTO> postPromoResDTOS = new ArrayList<>();
        for (PromoPost post: posts) postPromoResDTOS.add(Mapper.parseToPromoResDTO(post,user));
        return postPromoResDTOS;
    }

    private Post validatePost(Integer postID) {
        Post post = this.postRepository.findById(postID);
        if (post == null) //valida si existe el post, sino devuelve un error
            throw new NotFoundException(String.format("The post with id: %s don't exists.", postID));
        return post;
    }

}
