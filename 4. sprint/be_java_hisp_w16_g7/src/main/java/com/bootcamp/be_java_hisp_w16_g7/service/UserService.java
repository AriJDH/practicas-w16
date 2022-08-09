package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public FollowersSellersDTO getSellersFollowers(int id) {
        User response = userRepo.getSellersFollowers(id);
        if(response == null){
            throw new RuntimeException("user with id: " + id + " is not a seller");
        }
        List<FollowersDTO> followersToDTO = new ArrayList<>();
        response.getFollowers().stream().forEach(u -> followersToDTO.add(new FollowersDTO(u.getId(), u.getName())));
        FollowersSellersDTO dto = new FollowersSellersDTO(response.getId(), response.getName(), followersToDTO);
        return dto;
    }
}
