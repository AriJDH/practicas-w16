package com.bootcamp.be_java_hisp_w16_g7.service;


import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.FollowsNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{


    private final IUserRepository userRepository;
    private final ModelMapper mapper ;
    private int count=1;

    public ProductService( IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.mapper = new ModelMapper();
    }



    @Override
    public RecentPostsDTO recentPost(int idUser) {
        Map<Integer, List<Post>> postMap = new HashMap<>();
        //validacion de la existencia del usuario
        if(userRepository.existsUser(idUser)) {
            User user = userRepository.findUserById(idUser);
            //validacion si sigue a alguien
            if (!user.getFollows().isEmpty()) {
                for (User users: user.getFollowers()) {
                    if (!users.getPosts().isEmpty()) {
                        List<Post> recentPost = users.getPosts().stream()
                                .filter(x -> x.getCreationDate().isAfter(LocalDate.now().minusDays(14)))
                                .collect(Collectors.toList());
                        postMap.put(users.getId(),orderByDateDes(recentPost));
                    }
                }
                return new RecentPostsDTO(idUser,postMap);
            }else{
                throw new FollowsNotFoundException();
            }
        }else{
            throw new UserNotFoundException(idUser);
        }
    }

    @Override
    public List<Post> orderByDateAsc(List<Post> postList) {
        return postList.stream()
                .sorted(Comparator.comparing(Post::getCreationDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> orderByDateDes(List<Post> postList) {
        return postList.stream()
                .sorted(Comparator.comparing(Post::getCreationDate).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponseDto createPost(PostDTO postDto) {

        Post post = mapper.map(postDto, Post.class);

        post.setPostId(count);
        post.setHasPromo(false);
        post.setDiscount(0.0);

        User user = userRepository.findUserById(postDto.getId());
        if(user == null){
            throw new UserNotFoundException(postDto.getId());
        }

        user.getPosts().add(post);

        count++;
        System.out.println(user);

        return new ApiResponseDto("Post created successfully", "Post of user with id: " + post.getId() + " was created successfully");
    }
}
