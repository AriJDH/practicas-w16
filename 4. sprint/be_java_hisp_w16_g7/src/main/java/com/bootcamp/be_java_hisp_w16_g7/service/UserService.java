package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.FollowsNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
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


    @Autowired
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
}
