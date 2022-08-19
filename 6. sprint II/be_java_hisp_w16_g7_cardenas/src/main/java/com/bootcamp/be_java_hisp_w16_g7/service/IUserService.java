package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.dto.ApiResponseDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersCountDto;
import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersSellersDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;
import org.springframework.http.HttpStatus;


public interface IUserService {
    FollowersSellersDTO getSellersFollowers(int id, String order);


    ApiResponseDto follow(int userId, int userIdToFollow);

    ApiResponseDto unfollow(int userId, int userIdToUnfollow);

    ResponseUserFollowedDTO getUserFollowedList(int id, String order);

    FollowersCountDto getFollowersCount(int id);
}
