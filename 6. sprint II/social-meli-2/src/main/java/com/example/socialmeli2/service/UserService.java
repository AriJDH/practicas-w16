package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.*;
import com.example.socialmeli2.exception.FollowerNotFoundException;
import com.example.socialmeli2.exception.InputNotValidException;
import com.example.socialmeli2.exception.UserAlreadyFollowingException;
import com.example.socialmeli2.exception.UserNotFoundException;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.util.Mapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IRepository<User> userRepository;
    public void add(User user){
        userRepository.add(user);
    }
    public User getById(Integer userId){
        User user = userRepository.getById(userId);
        if (user == null) {
            throw new UserNotFoundException("El usuario con codigo " + userId + " no existe.");
        }
        return user;
    }
    public void addFollower(Integer userId, Integer userIdFollowed) {
        if (userId.equals(userIdFollowed)) {
            throw new InputNotValidException("El usuario no puede seguirse a si mismo.");
        }
        User userFollowing = this.getById(userId);
        User userFollowed = this.getById(userIdFollowed);

        User userToFollow = userFollowing.getFollowed().stream()
                .filter(x -> x.getUserId() == userIdFollowed)
                .findFirst()
                .orElse(null);

        if (userToFollow != null) {
            throw new UserAlreadyFollowingException("El usuario " + userId + " ya sigue al usuario " + userIdFollowed + ".");
        }

        userFollowing.getFollowed().add(userFollowed);
        userFollowed.getFollowers().add(userFollowing);

        userRepository.update(userFollowing);
        userRepository.update(userFollowed);
    } //US0001
    public void removeFollower(Integer userId, Integer userIdToUnfollow) {
        User userFollowing = this.getById(userId);
        User userFollowed = this.getById(userIdToUnfollow);

        User userToUnfollow = userFollowing.getFollowed().stream()
                .filter(x -> x.getUserId() == userIdToUnfollow)
                .findFirst()
                .orElse(null);

        if (userToUnfollow == null) {
            throw new FollowerNotFoundException("No hay un seguidor con el id " + userIdToUnfollow + " en la lista de seguidores del usuario " + userId + ".");
        }

        userFollowing.getFollowed().remove(userFollowed);
        userFollowed.getFollowers().remove(userFollowing);

        userRepository.update(userFollowing);
        userRepository.update(userFollowed);

    }//US0007
    public UserFollowersCountDto getFollowersCountByUserId(Integer userId) {
        User userFollowing = this.getById(userId);
        return Mapper.mapperToUserFollowersCountDto(userFollowing);
    }//US0002
    public UserFollowersListDto getFollowersListByUserId(Integer userId, Optional<String> order) {

        String orderString = order.orElse("");
        User user = this.getById(userId);

        UserFollowersListDto followers = Mapper.mapperToUserFollowersListDto(user);

        if (!orderString.equals("")){
            if (orderString.equals("name_asc"))
                followers.getFollowers().sort(Comparator.comparing(UserDto::getUserName));
            else if (orderString.equals("name_desc"))
                followers.getFollowers().sort(Comparator.comparing(UserDto::getUserName).reversed());
            else{
                throw new InputNotValidException("El tipo de orden insertado no es válido.");
            }
        }


        return followers;

    }//US0003 y US0008
    public UserFollowedListDto getFollowedListByUserId(Integer userId, Optional<String> order) {

        String orderString = order.orElse("");

        User user = this.getById(userId);
        UserFollowedListDto followed = Mapper.mapperToUserFollowedListDto(user);

        if (!orderString.equals("")){
            if (orderString.equals("name_asc"))
                followed.getFollowed().sort(Comparator.comparing(UserDto::getUserName));
            else if (orderString.equals("name_desc"))
                followed.getFollowed().sort(Comparator.comparing(UserDto::getUserName).reversed());
            else{
                throw new InputNotValidException("El tipo de orden insertado no es válido.");
            }
        }

        return followed;

    }//US0004 y US0008
    public List<User> loadUsersFromDatabase(){
        File archivo = null;
        try{
            archivo = ResourceUtils.getFile("classpath:users.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeReference = new TypeReference<>() {};
        List<User> users = null;
        try {
            users = objectMapper.readValue(archivo, typeReference);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return users;
    }
    @PostConstruct
    public void initUserData() {
        if (userRepository.getAll().isEmpty()) {
            /*User user1 = new User(0, "gonza", new ArrayList<User>(), new ArrayList<User>());
            User user2 = new User(0, "sabri", new ArrayList<User>(), new ArrayList<User>());
            User user3 = new User(0, "pame", new ArrayList<User>(), new ArrayList<User>());
            User user4 = new User(0, "mateo", new ArrayList<User>(), new ArrayList<User>());
            User user5 = new User(0, "erika", new ArrayList<User>(), new ArrayList<User>());
            User user6 = new User(0, "claudio", new ArrayList<User>(), new ArrayList<User>());

            userRepository.add(user1);
            userRepository.add(user2);
            userRepository.add(user3);
            userRepository.add(user4);
            userRepository.add(user5);
            userRepository.add(user6);
             */
            List<User> users = this.loadUsersFromDatabase();

            for (User usuarios: users){
                userRepository.add(usuarios);
            }
        }
    }
}
