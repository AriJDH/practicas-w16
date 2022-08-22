package com.meli.be_java_hisp_w16_g5.repository;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostPromoDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase PostRepository
 */
@Repository
public class PostRepository implements IPostRepository {

    /**
     * Lista de post
     */
    private List<Post> posts;

    @Autowired
    private UserRepository userRepository;

    /**
     * Constructor
     */
    public PostRepository() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void save(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Metodo para guardar un post
     * @param post
     * @return PostDto
     */
    @Override
    public PostDto savePost(Post post) {
        userRepository.savePost(post);
        this.posts.add(post);

        return Util.castTo(post, PostDto.class);
    }

    /**
     * Metodo para obtener todos los post
     * @return List<PostDto>
     */
    @Override
    public List<PostDto> getPosts() {
        return this.posts.stream().map(p-> Util.castTo(p, PostDto.class)).collect(Collectors.toList());
    }

    /**
     * Metodo para filtrar los post por usuario
     * @param userId
     * @param date
     * @return ist<PostDto>
     */
    @Override
    public List<PostDto> filterByUserIdAndDate(Integer userId, LocalDate date) {
        List<PostDto> filteredPosts = this.posts.stream().filter(post ->
            post.getUserId() == userId
            && 
            post.getDate().compareTo(date) >= 0
        )
        .map(p-> Util.castTo(p, PostDto.class))
        .collect(Collectors.toList());

        return filteredPosts;
    }

    @Override
    public List<PostPromoDto> getPostsPromo() {
        return this.posts.stream().map(p->new PostPromoDto(p.getUserId(),p.getDate(),p.getProduct(),p.getCategory(),p.getPrice(),p.getHasPromo(),p.getDiscount())).collect(Collectors.toList());
    }

    @Override
    public PostPromoDto savePostPromo(Post post) {
        this.posts.add(post);
        return new PostPromoDto(post.getUserId(),post.getDate(),post.getProduct(),post.getCategory(),post.getPrice(), post.getHasPromo(), post.getDiscount());
    }
}