package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.PostDto;
import com.example.socialmeli2.dto.PostListLastTwoWeeksDto;
import com.example.socialmeli2.exception.InputNotValidException;
import com.example.socialmeli2.exception.UserNotFoundException;
import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.Product;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PostService implements IPostService {
    @Autowired
    private IRepository<Post> postRepository;
    @Autowired
    private IUserService userService;
    public void addPost(PostDto newPost) {
        userService.getById(newPost.getUserId());
        Post post = Mapper.mapperToPost(newPost);
        this.postRepository.add(post);
    }
    public PostListLastTwoWeeksDto getFollowedPostListLastTwoWeeks(Integer userId, Optional<String> order) {
        String orderString= order.orElse("");
        User user = userService.getById(userId);

        List<Post> followedPostList = new ArrayList<>();

        List<Post> postList = postRepository.getAll();

        user.getFollowed().stream().forEach(followed -> {
            postList.stream()
                    .filter(post -> post.getUserId() == followed.getUserId())
                    .filter(post -> DAYS.between(post.getDate(), LocalDate.now()) <= 14)
                    .forEach(post -> followedPostList.add(post));
        });
        if(!orderString.equals("")){
            if (orderString.equals("date_asc"))
                followedPostList.sort(Comparator.comparing(Post::getDate));
            else if (orderString.equals("date_desc"))
                followedPostList.sort(Comparator.comparing(Post::getDate).reversed());
            else{
                throw new InputNotValidException("El tipo de orden insertado no es válido.");
            }
        }

        return Mapper.mapperToPostListLastTwoWeeksDto(userId, followedPostList);
    }
}
