package com.example.be_java_hisp_w16_g03.service;

import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;

import java.util.List;

public interface IUserService {
    FollowedsDTO getFollowedUsers(int userId);
}
