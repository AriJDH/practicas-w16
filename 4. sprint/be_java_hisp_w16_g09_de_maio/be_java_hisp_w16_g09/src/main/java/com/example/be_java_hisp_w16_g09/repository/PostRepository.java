package com.example.be_java_hisp_w16_g09.repository;

import com.example.be_java_hisp_w16_g09.model.Post;
import com.example.be_java_hisp_w16_g09.utility.DataLoader;
import com.example.be_java_hisp_w16_g09.utility.Filter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private HashMap<Integer, List<Post>> posts;
    private int postIdCounter;

    public PostRepository() {
        postIdCounter = 0;
        posts = new HashMap<>();
        DataLoader.loadProducts(this);
    }

    public void createElement(Post newPost){
        newPost.setPostId(getNewPostId());
        int userId = newPost.getUser().getUserId();
        var newList = posts.getOrDefault(userId, new ArrayList());

        newList.add(newPost);
        posts.put(userId,newList);
    }

    private int getNewPostId() {
        postIdCounter++;
        return postIdCounter;
    }

    public List<Post> searchById(int id){
        return posts.get(id);
    }

    @Override
    public List<Post> getPostsByUserIds(List<Integer> userIds) {
        return userIds
                .stream()
                .map(userId -> posts.getOrDefault(userId, new ArrayList<>()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getPromotedPostsOfUser(int userId) {
        List<Post> posts = searchById(userId);
        if (posts == null) return new ArrayList();
        return Filter.apply(posts, post -> post.isPromo());
    }

}
