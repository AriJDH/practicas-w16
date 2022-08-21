package com.bootcamp.SocialMeli2.repository;

import com.bootcamp.SocialMeli2.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryTest {

    private PostRepository postRepository;

    @BeforeEach
    public void init() {
        postRepository = new PostRepository();
    }

    @Test
    public void getRepository() {
        Assertions.assertTrue(postRepository.getPosts().size() == 0);

    }

    @Test
    public void correlativoInicial() {
        int correlativoActual = 1;
        int idcontador = postRepository.getCorrelativo();

        Assertions.assertEquals(correlativoActual, idcontador);
    }

    @Test
    public void correlativoPostInsert() {
        Post post = new Post();
        post.setPostId(1);
        List<Post> lstPost = new ArrayList<>();
        lstPost.add(post);
        postRepository.setPosts(lstPost);
        int correlativoActual = 2;
        int idcontador = postRepository.getCorrelativo();

        Assertions.assertEquals(correlativoActual, idcontador);
    }
}
