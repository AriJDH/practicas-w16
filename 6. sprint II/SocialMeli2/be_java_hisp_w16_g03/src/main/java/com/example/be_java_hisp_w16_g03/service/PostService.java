package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostWithIdDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.exception.InvalidOrderTypeException;
import com.example.be_java_hisp_w16_g03.repository.IUserRepository;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    public static final String DATE_DESC = "date_desc";
    public static final String DATE_ASC = "date_asc";

    @Autowired
    IUserRepository repository;

    @Autowired
    IUserService userService;

    @Override
    public void addPost(PostDTO request) {

        User requestUser = userService.getUser(request.getUserId());
        requestUser.addPostToUser(Mapper.postDtoToEntity(request));
    }


    private PostsDTO getLatestPostsByUserId(Integer userId) {
        List<User> sellers = repository.getFollowedsByUserId(userId);
        if (sellers != null) {
            List<Post> filterPosts = getFilterPosts(sellers);

            List<PostWithIdDTO> postsWithIdDtos = filterPosts
                    .stream()
                    .map(Mapper::postToPostWithIdDto)
                    .sorted((x, y) -> y.getDate().compareTo(x.getDate()))
                    .collect(Collectors.toList());

            return PostsDTO.builder().userId(userId).posts(postsWithIdDtos).build();
        }
        return PostsDTO.builder().userId(userId).posts(new ArrayList<>()).build();
    }

    @Override
    public PostsDTO getLatestPostsOrderedByUserId(Integer userId, String order) {

        if (order == null || order.equals(DATE_DESC))
            return getLatestPostsByUserId(userId);
        else if (order.equals(DATE_ASC)) {
            List<PostWithIdDTO> postsWithIdDtos = getLatestPostsByUserId(userId).getPosts()
                    .stream()
                    .sorted(Comparator.comparing(PostWithIdDTO::getDate))
                    .collect(Collectors.toList());

            return PostsDTO.builder().userId(userId).posts(postsWithIdDtos).build();
        }

        throw new InvalidOrderTypeException(order);
    }

    private List<Post> getFilterPosts(List<User> sellers) {
        List<Post> filterPosts = new ArrayList<>();
        sellers.forEach(user -> filterPosts.addAll(user.getPostLastTwoWeeks()));
        return filterPosts;
    }


}
