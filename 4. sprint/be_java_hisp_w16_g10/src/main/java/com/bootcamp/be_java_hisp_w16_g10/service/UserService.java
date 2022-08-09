package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowedListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersListResDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.PostResDTO;
import com.bootcamp.be_java_hisp_w16_g10.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService{
    @Autowired
    private IRepository userRepository;

    @Override
    public void follow(Integer userId, Integer userIdToFollow) {

    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {

    }

    @Override
    public FollowersCountResDTO countFollowers(Integer userId) {
        return null;
    }

    @Override
    public List<FollowersListResDTO> listFollowers(Integer userId, String order) {
        return null;
    }

    @Override
    public List<FollowedListResDTO> listFollowed(Integer userId, String order) {
        return null;
    }

    @Override
    public void save(PostReqDTO model) {

    }

    @Override
    public List<PostResDTO> listFollowersPosts(Integer userId) {
        return null;
    }
}
