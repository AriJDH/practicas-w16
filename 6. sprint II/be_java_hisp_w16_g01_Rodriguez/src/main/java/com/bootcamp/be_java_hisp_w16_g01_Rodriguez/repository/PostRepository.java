package com.bootcamp.be_java_hisp_w16_g01_Rodriguez.repository;

import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.entities.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private List<Post> postList;

    public PostRepository() {
        this.postList = new ArrayList<>();
    }

    public PostRepository(List<Post> list) {
        this.postList = list;
    }

    @Override
    public int createPost(Post post) {
        int id = postList.size()+1;
        post.setPostId(id);
        postList.add(post);
        return post.getPostId();
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        LocalDate dateWeek = LocalDate.now().minusWeeks(2);
        return postList.stream().filter(x ->x.getUserId()==userId && x.getDate().isAfter(dateWeek)).collect(Collectors.toList());
    }
}
