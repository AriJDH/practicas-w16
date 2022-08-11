package com.bootcamp.be_java_hisp_w16_g01.repository;

import com.bootcamp.be_java_hisp_w16_g01.entities.Post;
import com.bootcamp.be_java_hisp_w16_g01.entities.Product;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private List<Post> postList;

    public PostRepository() {
        this.postList = new ArrayList<>();
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

    @Override
    public List<Post> getPromoPost(int user_id) {
        return postList.stream().filter(x -> x.getUserId() == user_id && x.isHas_promo()).collect(Collectors.toList());
    }
}
