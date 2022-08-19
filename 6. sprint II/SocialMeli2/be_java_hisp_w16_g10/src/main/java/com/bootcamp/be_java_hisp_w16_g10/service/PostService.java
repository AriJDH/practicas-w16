package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostListResDTO;
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

    //Recibe un id como parámetro y devuelve el Post si es que existe, de lo contrario lanza un NotFoundException.
    @Override
    public PostResDTO findById(Integer id) {
        return Mapper.parseToPostResDTO(this.validatePost(id));
    }

    //Devuelve todos los posts
    @Override
    public List<PostResDTO> findAll() {
        return this.postRepository.findAll().stream()
                .map(Mapper::parseToPostResDTO)
                .collect(Collectors.toList());
    }

    //Recibe un id como parámetro y devuelve todos los Posts que corresponden a ese usuario.
    @Override
    public List<PostResDTO> findByUserId(Integer userID){
        return this.postRepository.findByUserId(userID).stream()
                .map(Mapper::parseToPostResDTO)
                .collect(Collectors.toList());
    }

    //Recibe un PostReqDTO, aplica validaciones y finalemente guarda el post.
    @Override
    public void save(PostReqDTO postReqDTO){
        this.userService.findById(postReqDTO.getUserId());
        if(postReqDTO.getDate().isAfter(LocalDate.now()))
            throw new ConstraintViolationException("The date of the post is in the future.");
        this.postRepository.save(Mapper.parseToPost(postReqDTO));
    }

    //Recibe un userID y una String(que puede ser null) para aplicar un formato de ordenamiento
    //devolviendo un PostListResDTO de los post que fueron publicados dentro de los ultimos 14 días.
    @Override
    public PostListResDTO listFollowersPosts(Integer userId, String order) {
        User user = this.userService.findById(userId);
        LocalDate localDate = LocalDate.now().minusDays(14);

        if(!List.of("date_asc", "date_desc").contains(order))throw new BadRequestException("Invalid order parameter");

        var posts = user.getFollowed().stream()
                .map(seller -> this.postRepository.findByUserId(seller.getId()))
                .filter(sellerPosts -> sellerPosts.size() > 0)
                .flatMap(Collection::stream)
                .filter(post -> post.getDate().compareTo(localDate) > 0);

        if (order.equals("date_asc"))
            posts = posts.sorted(Comparator.comparing(Post::getDate));
        else
            posts = posts.sorted(Comparator.comparing(Post::getDate).reversed());

        return Mapper.parseToPostListResDTO(user, posts.collect(Collectors.toList()));
    }

    //Recibe un postID y aplica el control para verificar que el Post exista.
    private Post validatePost(Integer postID) {
        Post post = this.postRepository.findById(postID);
        if (post == null) //valida si existe el post, sino devuelve un error
            throw new NotFoundException(String.format("The post with id: %s don't exists.", postID));
        return post;
    }

}
