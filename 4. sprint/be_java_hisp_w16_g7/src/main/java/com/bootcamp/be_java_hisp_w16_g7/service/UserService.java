package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import org.springframework.http.HttpStatus;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.FollowsNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserIsNotSellerException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import org.modelmapper.ModelMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    private final IUserRepository userRepository;
    private final ModelMapper mapper;


    @Override
    public RecentPostsDTO recentPost(int idUser) {
        Map<Integer,List<Post>> postMap = new HashMap<>();
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


    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        mapper = new ModelMapper();
    }

    @Override
    public HttpStatus follow(int userId, int userIdToFollow) {
        User user = userRepository.findUserById(userId);
        User target = userRepository.findUserById(userIdToFollow);

        if(user == null) throw new UserNotFoundException(userId);
        if(target == null) throw new UserNotFoundException(userIdToFollow);
        if(!target.isSeller() || target.getFollowers().contains(user)) return HttpStatus.BAD_REQUEST;

        userRepository.addToUserFollows(target, user);
        userRepository.addToUserFollowers(user, target);

        return HttpStatus.OK;
    }

    @Override
    public HttpStatus unfollow(int userId, int userIdToUnfollow){
        User user = userRepository.findUserById(userId);
        User target = userRepository.findUserById(userIdToUnfollow);

        if(user == null) throw new UserNotFoundException(userId);
        if(target == null) throw new UserNotFoundException(userIdToUnfollow);
        if(!target.getFollowers().contains(user)) return HttpStatus.BAD_REQUEST;

        userRepository.removeFromUserFollows(target, user);
        userRepository.removeFromUserFollowers(user, target);

        return HttpStatus.OK;
    }

    @Override
    public ResponseUserFollowedDTO getUserFollowedList(int id, String order) {
        User user = userRepository.findUserById(id);
        if(user == null)
            throw new UserNotFoundException(id);
        Comparator<ResponseUserDTO> userComp = Comparator.comparing(ResponseUserDTO::getUserName);
        if("name_desc".equals(order))
            userComp = userComp.reversed();
        List<ResponseUserDTO> followed = user.getFollows().stream()
                .map(u -> mapper.map(u, ResponseUserDTO.class))
                .sorted(userComp)
                .collect(Collectors.toList());
        return new ResponseUserFollowedDTO(user.getId(), user.getName(), followed);
    }

    @Override
    public FollowersCountDto getFollowersCount(int id) {
        int countFollowers = 0;
        User userFound = userRepository.findUserById(id);
        if (userFound == null) {
            throw new UserNotFoundException(id);
        }
        int countPost = userFound.getPosts().size();
        if (countPost > 0) {
            countFollowers = userFound.getFollowers().size();
        } else {
            throw new UserIsNotSellerException(id);
        }
        FollowersCountDto userFoundWithFollowers = new FollowersCountDto(userFound.getId(), userFound.getName(), countFollowers);
        return userFoundWithFollowers;
    }
}
