package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.util.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {
    private PostRepository postRepository;
    private List<Post> posts;

    @BeforeEach()
    public void init() {
        this.postRepository = new PostRepository();
        this.posts = Factory.generateListOfPosts(3, 1);
        this.posts.forEach(post -> this.postRepository.save(post));
    }
    @Test
    void findAll() {
    }
    @Test
    void givenAnIdShouldReturnAPostWhenIsCalled() {
        Post post = this.postRepository.findById(1);
        assertNotNull(post);
        assertInstanceOf(Post.class, post);
    }
    @Test
    void givenANonExistentIdShouldReturnNullWhenIsCalled() {
        Post post = this.postRepository.findById(321321);
        assertNull(post);
    }
    @Test
    void save() {
    }

    @Test
    void findByUserId() {
    }
}