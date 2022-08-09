package com.example.be_java_hisp_w16_g09.repository;

import com.example.be_java_hisp_w16_g09.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PostRepository implements IPostRepository{
    private HashMap<Integer, List<Post>> posts = new HashMap<>();

    public void createElement(Post newPost){
        List<Post> newList;
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

    public List<Post> searchById(int id){
        return posts.get(id);
    }

}
