package com.bootcamp.be_java_hisp_w16_g01.unit.repositories;

import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g01.unit.utils.FactoryPost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostRepositoryTest {

    PostRepository repository;

    @BeforeEach
    public void emptyRepo(){
        this.repository = new PostRepository(FactoryPost.loadRepoData());
    }

    @Test
    @DisplayName("getPostsByUserId - Devuelve los Post de las ultimas dos semanas por usuarioId")
    public void getPostsByUserIdTest() {

        //Arrange
        int userId = 2;
        List<Post> posts = FactoryPost.generateGetPostsByUserId(userId);

        //Act
        //Assert
        assertEquals(posts, repository.getPostsByUserId(userId));
    }

    @Test
    @DisplayName("getPostsByUserId - Devuelve la lista vacia, el usuario no tiene posts")
    public void getPostsByUserWithNoPostsTest() {

        //Arrange
        int userId = 0;
        List<Post> posts = FactoryPost.generateGetPostsByUserId(userId);

        //Act
        //Assert
        assertEquals(posts, repository.getPostsByUserId(userId));
    }
}
