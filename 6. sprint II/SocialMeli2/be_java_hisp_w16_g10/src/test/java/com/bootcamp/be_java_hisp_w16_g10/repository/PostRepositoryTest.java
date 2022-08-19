package com.bootcamp.be_java_hisp_w16_g10.repository;

import com.bootcamp.be_java_hisp_w16_g10.entity.Post;
import com.bootcamp.be_java_hisp_w16_g10.util.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {

    private PostRepository postRepository;

    @BeforeEach()
    public void init() {
        this.postRepository = new PostRepository();
        List<Post> posts = Factory.generateListOfPosts(3, 1);
        posts.forEach(post -> this.postRepository.save(post));
    }
    @Test
    void findAll() {
        var posts = this.postRepository.findAll();

        assertNotNull(posts);
        assertEquals(3, posts.size());
    }

    @Test
    void givenAnIdShouldReturnAPostWhenIsCalled() {
        assertNotNull(this.postRepository.findById(1));
    }

    @Test
    void save() {
        var post = Factory.generatePost();

        this.postRepository.save(post);
        assertNotNull(this.postRepository.findById(1));
    }

    @Test
    void findByUserId() {
        var posts = this.postRepository.findByUserId(1);

        assertNotNull(posts);
        assertEquals(3, posts.size());
    }

    @Test
    void notFoundByUserId() {
        var posts = this.postRepository.findByUserId(1000);

        assertEquals("[]",posts.toString());
    }
}