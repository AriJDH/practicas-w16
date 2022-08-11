package com.meli.be_java_hisp_w16_g5.service;

import com.meli.be_java_hisp_w16_g5.dto.*;

import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;

public interface IUserService {


    UserDto getCountFollows(int userId) throws UserNotFoundException;

    UserFollowedDto getListFollowers(int userId) throws UserNotFoundException;

    UserFollowedDto getFollowingSorted(int id, String order) throws UserNotFoundException;

    UserFollowerDto getFollowersSorted(int id, String order) throws UserNotFoundException;

    public UserFollowsDto setUserFollowSeller(int userId, int userIdTofollow) throws UserNotFoundException;
    
    public UserFollowsDto setUnfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException;

    public ProductPromoDtop getCountPromoProduct(int userId) throws UserNotFoundException;
    public PromoListDto getPromoList(int userId) throws UserNotFoundException;

}
