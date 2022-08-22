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

    //Recibe un PostPromoReqDTO, aplica validaciones y finalemente guarda el post.
    public void save(PostPromoReqDTO postPromoReqDTO) {
        this.userService.findById(postPromoReqDTO.getUserId());
        if(postPromoReqDTO.getDate().isAfter(LocalDate.now()))
            throw new ConstraintViolationException("The date of the post is in the future.");
        this.postRepository.save(Mapper.parseToPost(postPromoReqDTO));
    }

    //Recibe un userID y una String(que puede ser null) para aplicar un formato de ordenamiento
    //devolviendo un PostListResDTO de los post que fueron publicados dentro de los ultimos 14 días.
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

    //Recibe un userID, realiza validaciones y en caso de que esté correcto devuelve un PostPromoCountResDTO con
    //la cantidad de Posts con promo del user.
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

    //Recibe un userID, realiza validaciones y en caso de que esté correcto devuelve un PostPromoListResDTO con
    //con todos los Posts con promo del user.
    @Override
    public PostPromoListResDTO listPromoPost(Integer userId) {
        if(userId == null)
            throw new BadRequestException("Param userId can't be null.");
        User user = this.userService.findById(userId);

        List<Post> posts = this.postRepository.findByUserId(userId);
        if(posts.size() == 0) //valida que sea un vendendor
            throw new BadRequestException(String.format("The user with the id %s is not a seller.", userId));

        posts = posts.stream()
                .filter(post -> post.getHasPromo())
                .collect(Collectors.toList());
        return Mapper.parseToPostPromoListResDTO(user, posts);
    }

    //Devuelve una lista de PostPromoListResDTO agrupado por cada usuario.
    @Override
    public List<PostPromoListResDTO> listPromoPost() {
        return this.postRepository.findAll().stream()
                .filter(post -> post.getHasPromo())
                .collect(Collectors.groupingBy(Post::getUserId, Collectors.toList()))
                .entrySet().stream()
                .map(e -> Mapper.parseToPostPromoListResDTO(this.userService.findById(e.getKey()), e.getValue()))
                .collect(Collectors.toList());
    }

    //Devuelve una PostPromoCountResDTO con el usuario con mas Post con promoción y la cantidad.
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
            throw new NotFoundException("There is no post with promotion yet.");
        return Mapper.parseToPostPromoCountResDTO(
                this.userService.findById(maxCountUserPostPromo.getKey()),
                maxCountUserPostPromo.getValue().intValue()
        );
    }

    //Recibe un postID y aplica el control para verificar que el Post exista.
    private Post validatePost(Integer postID) {
        Post post = this.postRepository.findById(postID);
        if (post == null) //valida si existe el post, sino devuelve un error
            throw new NotFoundException(String.format("The post with id: %s don't exists.", postID));
        return post;
    }

}
