package com.meli.be_java_hisp_w16_g5.service;


import com.meli.be_java_hisp_w16_g5.dto.*;

import com.meli.be_java_hisp_w16_g5.dto.FollowerDto;
import com.meli.be_java_hisp_w16_g5.dto.UserDto;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowerDto;
import com.meli.be_java_hisp_w16_g5.dto.UserFollowsDto;

import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.User;

import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;

import com.meli.be_java_hisp_w16_g5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository repository;



    @Override
    public UserDto getCountFollows(int userId) throws UserNotFoundException {

        if(repository.findUserById(userId)==null)
        {
            throw new UserNotFoundException("Usuario no encontrado");
        }

        if(repository.findUserById(userId).getFollowers()==null){
            return new UserDto(userId,repository.findUserById(userId).getUserName(),0);
        }
        return new UserDto(userId,repository.findUserById(userId).getUserName(),repository.findUserById(userId).getFollowers().size());
    }

    @Override
    public UserFollowedDto getListFollowers(int userId) throws UserNotFoundException {
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
    public UserFollowedDto getFollowingSorted(int id, String order) throws UserNotFoundException{

        User user = repository.findUserById(id);
        if(user==null){
            throw new UserNotFoundException("Usuario no encontrado");
        }

        if("name_asc".equalsIgnoreCase(order)){
            return new UserFollowedDto(user.getUserId(),user.getUserName(),user.getFollowing().stream()
                    .map(f->new FollowedDto(f.getUserId(),f.getUserName()))
                    .sorted(Comparator.comparing(FollowedDto::getUserName))
                    .collect(Collectors.toList()));
        }

        if("name_desc".equalsIgnoreCase(order)){
            return new UserFollowedDto(user.getUserId(),user.getUserName(),user.getFollowing().stream()
                    .map(f->new FollowedDto(f.getUserId(),f.getUserName()))
                    .sorted(Comparator.comparing(FollowedDto::getUserName).reversed())
                    .collect(Collectors.toList()));
        }

        return new UserFollowedDto(user.getUserId(),user.getUserName(),user.getFollowing().stream()
                .map(f->new FollowedDto(f.getUserId(),f.getUserName())).collect(Collectors.toList()));

    }

    @Override
    public UserFollowerDto getFollowersSorted(int id, String order) throws UserNotFoundException {

        User user = repository.findUserById(id);
        if(user==null){
            throw new UserNotFoundException("Usuario no encontrado");
        }

        if("name_asc".equalsIgnoreCase(order)){
            return new UserFollowerDto(user.getUserId(),user.getUserName(),user.getFollowers().stream()
                    .map(f->new FollowerDto(f.getUserId(),f.getUserName()))
                    .sorted(Comparator.comparing(FollowerDto::getUserName))
                    .collect(Collectors.toList()));
        }

        if("name_desc".equalsIgnoreCase(order)){
            return new UserFollowerDto(user.getUserId(),user.getUserName(),user.getFollowers().stream()
                    .map(f->new FollowerDto(f.getUserId(),f.getUserName()))
                    .sorted(Comparator.comparing(FollowerDto::getUserName).reversed())
                    .collect(Collectors.toList()));
        }

        return new UserFollowerDto(user.getUserId(),user.getUserName(),user.getFollowers().stream()
                .map(f->new FollowerDto(f.getUserId(),f.getUserName())).collect(Collectors.toList()));

    }
    public UserFollowsDto setUserFollowSeller(int userId, int userIdToFollow) throws UserNotFoundException {
        User user = repository.findUserById(userId);
        User userFollow = repository.findUserById(userIdToFollow);

        if(user==null){
            throw new UserNotFoundException("El usuario: " + userId + " no existe.");
        }

        if(userFollow==null){
            throw new UserNotFoundException("El vendedor a seguir: " + userIdToFollow + " no existe.");
        }

        repository.setUserFollowSeller(userId,userIdToFollow);
        repository.setUserFollowersSeller(userIdToFollow,userId);
        return new UserFollowsDto("Usuario: "+user.getUserName()+" siguiendo a: "+userFollow.getUserName());
    }


    public UserFollowsDto setUnfollowUser(int userId, int userIdToUnfollow) throws UserNotFoundException {

        User user = repository.findUserById(userId);
        User userFollow = repository.findUserById(userIdToUnfollow);

        if(user==null){
            throw new UserNotFoundException("El usuario: " + userId + " no existe.");
        }

        if(userFollow==null){
            throw new UserNotFoundException("El vendedor a seguir: " + userIdToUnfollow + " no existe.");
        }

        if(user.getFollowers().stream().filter(x-> x.getUserId()==userIdToUnfollow).findFirst().orElse(null)==null){
            throw new UserNotFoundException("El usuario " + userId+ "no sigue al vendedor");
        }

        this.repository.findUserById(userId).getFollowers().remove(this.repository.findUserById(userIdToUnfollow));
        this.repository.findUserById(userIdToUnfollow).getFollowers().remove(this.repository.findUserById(userId));
        return new UserFollowsDto("Todo ok");
    }

    @Override
    public ProductPromoDtop getCountPromoProduct(int userId) throws UserNotFoundException {
       if(this.repository.findUserById(userId).getPosts()==null)
       {
           throw new UserNotFoundException("El usuario " + userId+ "no tiene posteos");
       }

        User user =this.repository.findUserById(userId);

        if(this.repository.findUserById(userId).getPosts().size()>0){

            List<Post> lista =user.getPosts().stream().filter(x-> x.getHasPromo()!=null).collect(Collectors.toList());
            return new ProductPromoDtop(user.getUserId(),user.getUserName(),lista.stream().filter(x-> x.getHasPromo()==true).collect(Collectors.toList()).size());
        }

        return new ProductPromoDtop(user.getUserId(),user.getUserName(),0);

    }

    @Override
    public PromoListDto getPromoList(int userId) throws UserNotFoundException {

        if(this.repository.findUserById(userId).getPosts()==null)
        {
            throw new UserNotFoundException("El usuario " + userId+ "no tiene posteos");
        }

        User user =this.repository.findUserById(userId);

        if(this.repository.findUserById(userId).getPosts().size()>0){

            List<PostPromoDto> listPromodto = new ArrayList<>();
            user.getPosts().stream().filter(x-> x.getHasPromo()!=null).collect(Collectors.toList())
                    .stream().forEach(x-> {
                        listPromodto.add(new PostPromoDto(x.getUserId(),x.getDate(),x.getProduct(),x.getCategory(),x.getPrice(),x.getHasPromo(),x.getDiscount()));
                    });
            return new PromoListDto(user.getUserId(),user.getUserName(),listPromodto);
        }


        throw new UserNotFoundException("El usuario " + userId+ "no tiene posteos en promo");

    }
}
