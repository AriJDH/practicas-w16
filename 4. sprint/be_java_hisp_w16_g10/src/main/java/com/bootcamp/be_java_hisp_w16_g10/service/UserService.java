package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IService {
    @Autowired
    private IRepository userRepository;

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {

    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        // TODO verificar que ambos usuarios existan

        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

        User toDelete = this.userRepository.findById(userIdToUnfollow);
        if (toDelete == null) throw new NotFoundException(String.format("El usuario que se busca eliminar, con id: %s no existe.",userIdToUnfollow));

        // TODO verificar que el usuario a eliminar esté en la lista de follows.

    }

    @Override
    public FollowersCountResDTO countFollowers(Integer userId) {
        return null;
    }

    @Override
    public List<FollowersListResDTO> listFollowers(Integer userId, String order) {
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));

        List<UserResDTO> followers = user.getFollowers().stream().map(u -> new UserResDTO(u.getId(), u.getUserName())).collect(Collectors.toList());

        return user.getFollowers().stream()
                .filter(y -> user.getPosts().size() > 0)
                .map(follower -> new FollowersListResDTO(follower.getId(), follower.getUserName(), followers))
                .collect(Collectors.toList());
    }
    @Override
    public List<FollowedListResDTO> listFollowed(Integer userId, String order) {
        User user = this.userRepository.findById(userId);
        if (user == null) throw new NotFoundException(String.format("El usuario con el id: %s no existe.", userId));
        return user.getFollowed().stream()
                .filter(seller -> seller.getPosts().size() > 0)
                .map(this::parseToFollowedListResDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(PostReqDTO model) {

    }

    @Override
    public List<PostResDTO> listFollowersPosts(Integer userId) {
        //LocalDate localDate = LocalDate.now().minusDays(14);
        //User user = this.userRepository.findById(userId);
        //if(user == null) throw new NotFoundException(String.format("El usuario con la id: %s no existe.", userId));
        return null;
    }

    private FollowedListResDTO parseToFollowedListResDTO(User user) {
        return FollowedListResDTO.builder()
                .user_id(user.getId())
                .user_name(user.getUserName())
                .followed(user.getFollowed().stream()
                        .map(this::parseToUserResDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    private UserResDTO parseToUserResDTO(User user) {
        return UserResDTO.builder()
                .user_id(user.getId())
                .user_name(user.getUserName())
                .build();
    }

    private PostResDTO parseToPostResDTO(User user){
        return new PostResDTO();
    }
}
