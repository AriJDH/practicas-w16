package com.meli.be_java_hisp_w16_g5.service;


import com.meli.be_java_hisp_w16_g5.dto.*;

import com.meli.be_java_hisp_w16_g5.dto.FollowerDto;
import com.meli.be_java_hisp_w16_g5.dto.UserDto;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowerDto;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowsDto;

import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;

import com.meli.be_java_hisp_w16_g5.repository.UserRepository;
import com.meli.be_java_hisp_w16_g5.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDto getCountFollows(Integer userId) throws UserNotFoundException {

        User user = repository.findUserById(userId);
        if(user==null)
        {
            throw new UserNotFoundException("Usuario no encontrado");
        }


        if(user.getFollowers()==null){
            return new UserDto(userId,user.getUserName(),0);
        }
        return new UserDto(userId,user.getUserName(),user.getFollowers().size());

    }

    @Override
    public UserFollowedDto getListFollowers(Integer userId) throws UserNotFoundException {
        if (repository.findUserById(userId) == null) {
            throw new UserNotFoundException("Usuario no encontrado");
        }

        List<User> followers = repository.findUserById(userId).getFollowers();
        List<FollowedDto> followedDtos = new ArrayList<>();

        for (User user : followers) {
            followedDtos.add(new FollowedDto(user.getUserId(), user.getUserName()));
        }
        return new UserFollowedDto(userId, repository.findUserById(userId).getUserName(), followedDtos);
    }


    @Override
    public UserFollowedDto getFollowingSorted(Integer id, String order) throws UserNotFoundException, UnknownRequestException{

        User user = repository.findUserById(id);
        if(user==null){
            throw new UserNotFoundException("Usuario no encontrado");
        }

        List<User> followedUsers = user.getFollowing();
        List<FollowedDto> users = followedUsers != null ? 
            followedUsers.stream().map(u -> new FollowedDto(u.getUserId(), u.getUserName()))
            .collect(Collectors.toList()) : new ArrayList<>();
            
        Integer sortCondition = Util.getSortCondition(order, "name");
           
        if(sortCondition != null)
            users.sort(
                (FollowedDto u1, FollowedDto u2) -> u1.getUserName().compareTo(u2.getUserName()) * sortCondition
            );

        UserFollowedDto followedByUserDTO = new UserFollowedDto(user.getUserId(), user.getUserName(), users);

        return followedByUserDTO;
    }

    //Metodo que devuelve los seguidores de un usuario teniendo en cuenta si existe y ordenandolos de acuerdo al order
    @Override
    public UserFollowerDto getFollowersSorted(Integer id, String order) throws UserNotFoundException, UnknownRequestException {

        User user = repository.findUserById(id);
        if(user==null){
            throw new UserNotFoundException("Usuario no encontrado");
        }

        List<User> followedUsers = user.getFollowers();
        List<FollowerDto> users = followedUsers != null ? 
            followedUsers.stream().map(u -> new FollowerDto(u.getUserId(), u.getUserName()))
            .collect(Collectors.toList()) : new ArrayList<>();
            
        Integer sortCondition = Util.getSortCondition(order, "name");
           
        if(sortCondition != null)
            users.sort(
                (FollowerDto u1, FollowerDto u2) -> u1.getUserName().compareTo(u2.getUserName()) * sortCondition
            );

        UserFollowerDto followersOfUserDTO = new UserFollowerDto(user.getUserId(), user.getUserName(), users);

        return followersOfUserDTO;

    }
    public UserFollowsDto setUserFollowSeller(Integer userId, Integer userIdToFollow) throws UserNotFoundException {
        User user = repository.findUserById(userId);
        
        if(user==null){
            throw new UserNotFoundException("El usuario: " + userId + " no existe.");
        }
        
        User userFollow = repository.findUserById(userIdToFollow);
        User userFollowing =  user.getFollowing() != null ? user.getFollowing().stream().filter(x-> x.getUserId()==userIdToFollow).findFirst().orElse(null) : null;
        
        if(userFollow==null){
            throw new UserNotFoundException("El vendedor a seguir: " + userIdToFollow + " no existe.");
        }
        
        if (userFollowing != null) {
            throw new UserNotFoundException("El usuario: " + user.getUserName() + ", ya sigue a: " + userFollowing.getUserName());
        }

        repository.setUserFollowSeller(userId,userIdToFollow);
        repository.setUserFollowersSeller(userIdToFollow,userId);
        return new UserFollowsDto("Usuario: "+user.getUserName()+" siguiendo a: "+userFollow.getUserName());
    }


    public UserFollowsDto setUnfollowUser(Integer userId, Integer userIdToUnfollow) throws UserNotFoundException {

        User user = repository.findUserById(userId);
        User userFollow = repository.findUserById(userIdToUnfollow);

        if(user==null){
            throw new UserNotFoundException("El usuario: " + userId + " no existe.");
        }

        if(userFollow==null){
            throw new UserNotFoundException("El vendedor a seguir: " + userIdToUnfollow + " no existe.");
        }

        if(user.getFollowers().stream().filter(x-> x.getUserId()==userIdToUnfollow).findFirst().orElse(null)==null){
            throw new UserNotFoundException("El usuario " + userId+ " no sigue al vendedor");
        }


        user.getFollowers().remove(userFollow);
        userFollow.getFollowing().remove(user);

        return new UserFollowsDto("Todo ok");
    }
}
