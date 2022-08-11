package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostPromoReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g10.exception.ConstraintViolationException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;
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
    public void save(PostReqDTO postReqDTO){
        this.userService.findById(postReqDTO.getUserId());
        if(postReqDTO.getDate().isAfter(LocalDate.now()))
            throw new ConstraintViolationException("The date of the post is in the future.");
        this.postRepository.save(Mapper.parseToPost(postReqDTO));
    }

    public void save(PostPromoReqDTO postPromoReqDTO) {
        this.userService.findById(postPromoReqDTO.getUserId());
        if(postPromoReqDTO.getDate().isAfter(LocalDate.now()))
            throw new ConstraintViolationException("The date of the post is in the future.");
        this.postRepository.save(Mapper.parseToPost(postPromoReqDTO));
    }

    @Override
    public PostListResDTO listFollowersPosts(Integer userId, String order) {
        User user = this.userService.findById(userId);
        LocalDate localDate = LocalDate.now().minusDays(14);

        var postResDTOS = user.getFollowed().stream()
                .map(seller -> this.postRepository.findByUserId(seller.getId()))
                .filter(posts -> posts.size() > 0)
                .flatMap(Collection::stream)
                .filter(post -> post.getDate().compareTo(localDate) > 0)
                .map(Mapper::parseToPostResDTO);

        if (order != null && order.equals("date_asc")) //por defecto orden descendente
            postResDTOS = postResDTOS.sorted(Comparator.comparing(PostResDTO::getDate));
        else
            postResDTOS = postResDTOS.sorted(Comparator.comparing(PostResDTO::getDate).reversed());

        return Mapper.parseToPostListResDTO(user, postResDTOS.collect(Collectors.toList()));
    }

    @Override
    public PostPromoCountResDTO countPromoPost(Integer userId) {
        if(userId == null)
            throw new BadRequestException("Param userId can't be null.");
        User user = this.userService.findById(userId);
        List<Post> posts = this.postRepository.findByUserId(userId).stream()
                .filter(post -> post.getHasPromo())
                .collect(Collectors.toList());
        return Mapper.parseToPostPromoCountResDTO(user, posts);
    }

    @Override
    public PostPromoListResDTO listPromoPost(Integer userId) {
        if(userId == null)
            throw new BadRequestException("Param userId can't be null.");
        User user = this.userService.findById(userId);
        List<Post> posts = this.postRepository.findByUserId(userId).stream()
                .filter(post -> post.getHasPromo())
                .collect(Collectors.toList());
        return Mapper.parseToPostPromoListResDTO(user, posts);
    }

    @Override
    public List<PostPromoListResDTO> listPromoPost() {
        return this.postRepository.findAll().stream()
                .filter(post -> post.getHasPromo())
                .collect(Collectors.groupingBy(Post::getUserId, Collectors.toList()))
                .entrySet().stream()
                .map(e -> Mapper.parseToPostPromoListResDTO(this.userService.findById(e.getKey()), e.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public PostPromoCountResDTO maxCountUserPromoPost() {
        var maxCountUserPostPromo = this.postRepository.findAll().stream()
                .filter(post -> post.getHasPromo())
                .collect(Collectors.groupingBy(Post::getUserId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
                .findFirst()
                .orElse(null);
        if(maxCountUserPostPromo == null)
            throw new NotFoundException("No existe ningún post con promoción aún.");
        return Mapper.parseToPostPromoCountResDTO(
                this.userService.findById(maxCountUserPostPromo.getKey()),
                maxCountUserPostPromo.getValue().intValue()
        );
    }

    private Post validatePost(Integer postID) {
        Post post = this.postRepository.findById(postID);
        if (post == null) //valida si existe el post, sino devuelve un error
            throw new NotFoundException(String.format("The post with id: %s don't exists.", postID));
        return post;
    }

}
