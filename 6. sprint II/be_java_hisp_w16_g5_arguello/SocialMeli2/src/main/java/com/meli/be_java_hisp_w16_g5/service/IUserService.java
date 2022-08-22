package com.meli.be_java_hisp_w16_g5.service;

import com.meli.be_java_hisp_w16_g5.dto.UserDto;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowedDto;

import com.meli.be_java_hisp_w16_g5.dto.UserFollowerDto;

import com.meli.be_java_hisp_w16_g5.dto.UserFollowsDto;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;

public interface IUserService {


    UserDto getCountFollows(Integer userId) throws UserNotFoundException;

    UserFollowedDto getListFollowers(Integer userId) throws UserNotFoundException;

    UserFollowedDto getFollowingSorted(Integer id, String order) throws UserNotFoundException, UnknownRequestException;

    UserFollowerDto getFollowersSorted(Integer id, String order) throws UserNotFoundException, UnknownRequestException;

    UserFollowsDto setUserFollowSeller(Integer userId, Integer userIdTofollow) throws UserNotFoundException;
    
    UserFollowsDto setUnfollowUser(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException;

}
