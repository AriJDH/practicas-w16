package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostPromoCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostPromoResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
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
    public void save(PostReqDTO postReqDTO){
        this.userService.findById(postReqDTO.getUserId());
        if(postReqDTO.getDate().isAfter(LocalDate.now()))
            throw new ConstraintViolationException("The date of the post is in the future.");

        if (postReqDTO.getDiscount() != null){
            postReqDTO.setDiscount(0.00);
        }

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

        if (order != null && order.equals("date_asc")) //por defecto orden descendente
            posts = posts.sorted(Comparator.comparing(Post::getDate));
        else if((order != null && order.equals("date_desc")) )
            posts = posts.sorted(Comparator.comparing(Post::getDate).reversed());
        else if(!order.equals("name_desc") || !order.equals("name_asc")) //valido q no pasen cualqiur cosa por paramtero
            throw new BadRequestException("Invalid order parameter.");

        return Mapper.parseToPostListResDTO(user, posts.collect(Collectors.toList()));
    }

    private Post validatePost(Integer postID) {
        Post post = this.postRepository.findById(postID);
        if (post == null) //valida si existe el post, sino devuelve un error
            throw new NotFoundException(String.format("The post with id: %s don't exists.", postID));
        return post;
    }

    @Override
    public List<PostPromoResDTO> listPosts(Integer userId) {
        Mapper mapper = new Mapper();
        var user = this.userService.findById(userId);
        var posts = this.postRepository.findByUserId(userId);

        if (posts == null)
            throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

        var res = posts.stream()
                .filter(post -> post.isHasPromo())
                .collect(Collectors.toList());

        return res.stream().map(post -> mapper.parseToPostPromoResDTO(user,post)).collect(Collectors.toList());
    }

    @Override
    public PostPromoCountResDTO countPosts(Integer userId) {

       var posts = postRepository.findByUserId(userId);
       var usuario = userService.findById(userId);

        if (posts == null)
            throw new NotFoundException(String.format("The user with id: %s don't exists.", userId));

        var promos = posts.stream()
                .filter(p -> p.isHasPromo())
                .collect(Collectors.toList());

        System.out.println(posts);
        return PostPromoCountResDTO.builder()
                .postPromoCount(promos.size())
                .userId(usuario.getId())
                .userName(usuario.getUserName())
                .build();
    }
}
