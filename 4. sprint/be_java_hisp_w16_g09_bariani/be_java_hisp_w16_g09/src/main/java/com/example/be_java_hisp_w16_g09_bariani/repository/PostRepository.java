package com.example.be_java_hisp_w16_g09_bariani.repository;

import com.example.be_java_hisp_w16_g09_bariani.model.Post;
import com.example.be_java_hisp_w16_g09_bariani.utility.DataLoader;
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
        List<Post> newList;
        newPost.setPostId(getNewPostId());
        int userId = newPost.getUser().getUserId();
        if(posts.containsKey(userId))
        {
            newList = posts.get(userId);
        }else{
            newList = new ArrayList<>();
        }
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
        return userIds.stream().map(userId -> posts.getOrDefault(userId, new ArrayList<>())).flatMap(List::stream).collect(Collectors.toList());
    }

}
