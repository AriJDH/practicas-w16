package com.bootcamp.be_java_hisp_w16_g7_espitia.service;

import com.bootcamp.be_java_hisp_w16_g7_espitia.dto.*;
import org.springframework.http.HttpStatus;


public interface IUserService {
    FollowersSellersDTO getSellersFollowers(int id, String order);


    HttpStatus follow(int userId, int userIdToFollow);

    HttpStatus unfollow(int userId, int userIdToUnfollow);

    ResponseUserFollowedDTO getUserFollowedList(int id, String order);

    FollowersCountDto getFollowersCount(int id);

    ApiResponseDto createUser(CreateUserDTO createUserDTO);
}
