package com.bootcamp.SocialMeli2.repository;

import com.bootcamp.SocialMeli2.entity.Post;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Repository
public class PostRepository {

    private List<Post> posts;

    public PostRepository() {
        this.posts = new ArrayList<>();
    }


    public int getCorrelativo() {
        Optional<Post> correlativo = posts.stream().sorted((p, x) -> x.getPostId().compareTo(p.getPostId())).findFirst();
        if (correlativo.isPresent())
            return correlativo.get().getPostId() + 1;
        else
            return 1;
    }

}
