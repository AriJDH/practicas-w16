package com.meli.be_java_hisp_w16_g5.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.util.Util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Clase UserRepository
 */
@Repository
public class UserRepository implements  IUserRepository{

    private String SCOPE;

    private List<User> users;

    public UserRepository()
    {

        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.users = this.leerJson();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * metodo para obtener un usuario por id
     * @param userId
     * @return User
     */
    @Override
    public User findUserById(Integer userId) {
         return users.stream().filter(x-> x.getUserId()==userId).findFirst().orElse(null);
    }

    /**
     * Metodo para crear la relacion cuando se sigue a un usuario
     * @param userIdToFollow
     * @param userId
     */
    @Override
    public void setUserFollowSeller(Integer userIdToFollow, Integer userId) {
        if(this.findUserById(userIdToFollow).getFollowing()==null){
            List<User> follows = new ArrayList<>();
            follows.add(this.findUserById(userId));

            this.findUserById(userIdToFollow).setFollowing(follows);
        }else {
            this.findUserById(userIdToFollow).getFollowing().add(this.findUserById(userId));
        }

    }

    /**
     * Metodo para crear la relacion cuando se sigue a un usuario
     * @param userId
     * @param userIdToFollow
     */
    @Override
    public void setUserFollowersSeller(Integer userId, Integer userIdToFollow) {
        if(this.findUserById(userId).getFollowers()==null) {
            List<User> followers = new ArrayList<>();
            followers.add(this.findUserById(userIdToFollow));

            this.findUserById(userId).setFollowers(followers);
        }else{
            this.findUserById(userId).getFollowers().add(this.findUserById(userIdToFollow));
        }
    }

    /**
     * Metodo para guardar un post
     * @param post
     * @return PostDto
     */
    @Override
    public PostDto savePost(Post post) {
        this.users.stream().filter(u->u.getUserId() == post.getUserId()).findFirst().orElse(null).getPosts().add(post);
        return Util.castTo(post, PostDto.class);
    }

    /**
     * Metodo para filtrar post por id y fecha
     * @param date
     * @param sortCondition
     * @return List<PostDto>
     */
    @Override
    public List<PostDto> filterByUserIdAndDate(LocalDate date, Integer sortCondition) {
        List<PostDto> filteredPosts = this.users.
                stream()
                .findFirst().orElse(null)
                .getPosts()
                .stream().filter(post->post.getDate().compareTo(date) >= 0)
                .map(p-> Util.castTo(p, PostDto.class))
                .collect(Collectors.toList());

        if(sortCondition != null)
            filteredPosts.sort(
                    (PostDto p1, PostDto p2) -> p1.getDate().compareTo(p2.getDate()) * sortCondition
            );

        return filteredPosts;
    }

    @Override
    public void save(List<User> user){
        this.users = user;
    }

    /**
     * Metodo para leer los usuario existentes en los recursos
     * @return
     */
    private List<User> leerJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> userList = null;
        try
        {
            userList=objectMapper.readValue(file,typeRef);
        }catch ( IOException e)
        {
            e.printStackTrace();
        }

        return userList;

    }
}
