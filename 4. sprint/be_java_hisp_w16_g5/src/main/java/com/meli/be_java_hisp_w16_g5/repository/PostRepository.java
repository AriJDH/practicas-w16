package com.meli.be_java_hisp_w16_g5.repository;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository
{
    private List<Post> posts;

    @Autowired
    private UserRepository userRepository;

    public PostRepository() {
        this.posts = new ArrayList<>();
    }

    @Override
    public PostDto savePost(Post post) {
        userRepository.savePost(post);
        this.posts.add(post);
        return new PostDto(post.getUserId(),post.getDate(),post.getProduct(),post.getCategory(),post.getPrice());
    }

    @Override
    public List<PostDto> getPosts() {
        return this.posts.stream().map(p->new PostDto(p.getUserId(),p.getDate(),p.getProduct(),p.getCategory(),p.getPrice())).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> filterByUserIdAndDate(int userId, Date date, Integer sortCondition) {
        List<PostDto> filteredPosts = this.posts.stream().filter(post ->
            post.getUserId() == userId && post.getDate().compareTo(date) >= 0
        )
        .map(p->new PostDto(p.getUserId(),p.getDate(),p.getProduct(),p.getCategory(),p.getPrice()))
        .collect(Collectors.toList());

        if(sortCondition != null)
            filteredPosts.sort(
                (PostDto p1, PostDto p2) -> p1.getDate().compareTo(p2.getDate()) * sortCondition
            );

        return filteredPosts;
    }


}