package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w16_g10.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w16_g10.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Lazy
    @Autowired
    private PostService postService;

    //Recibe un id como parámetro y devuelve el User si es que existe, de lo contrario lanza un NotFoundException.
    @Override
    public User findById(Integer id) {
        return this.validateUser(id);
    }

    //Devuelve todos los Users
    @Override
    public List<UserResDTO> findAll() {
        return this.userRepository.findAll().stream()
                .map(Mapper::parseToUserResDTO)
                .collect(Collectors.toList());
    }

    //Recibe un userID y un userIdToFollow, realiza validaciones y en caso de que esté correcto
    //se añade al user2 a la lista de seguidos por el user1 y se agrega el user1 a la
    //lista de seguidores del user2
    @Override
    public void follow(Integer userId, Integer userIdToFollow) {
        if (userId.equals(userIdToFollow)) //revisa que los dos id sean iguales
            throw new BadRequestException("Cannot follow yourself");

        User user = this.validateUser(userId); //valida que exista el usuario1
        User userToFollow = this.validateUser(userIdToFollow); //valida que exista el usuario2

        if (user.getFollowed().contains(userToFollow)) //revisa si el usuario1 sigue al usuario2
            throw new BadRequestException("Can't follow a user you already follow.");

        if (this.postService.findByUserId(userIdToFollow).size() == 0) //valida que sea un vendendor
            throw new BadRequestException(String.format("The user with the id %s is not a seller.", userIdToFollow));

        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);

        //lineas redundantes, al ser una BD en memoria ya se encuentran actualizados
        //simulamos el funcionamiento del repositorio
        this.userRepository.update(user);
        this.userRepository.update(userToFollow);
    }

    //Recibe un userID y un userIdToFollow, realiza validaciones y en caso de que esté correcto
    //se quita al user2 de la lista de seguidos por el user1 y se quita el user1 de la
    //lista de seguidores del user2
    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) {
        if (userId.equals(userIdToUnfollow)) //revisa que los dos id sean iguales
            throw new BadRequestException("Cannot unfollow yourself");

        User user = this.validateUser(userId); //valida que exista el usuario1
        User userToDelete = this.validateUser(userIdToUnfollow); //valida que exista el usuario2

        if (!userToDelete.getFollowers().contains(user)) //revisa que el usuario1 no siga al usuario2
            throw new BadRequestException("The user is not being followed.");

        user.getFollowed().remove(userToDelete);
        userToDelete.getFollowers().remove(user);

        //lineas redundantes, al ser una BD en memoria ya se encuentran actualizados
        //simulamos el funcionamiento del repositorio
        this.userRepository.update(user);
        this.userRepository.update(userToDelete);
    }

    //Recibe un userID, realiza validaciones y en caso de que esté correcto devuelve un FollowesCountResDTO con
    //la cantidad de seguidores del user.
    @Override
    public FollowersCountResDTO countFollowers(Integer userId) {
        User user = this.validateUser(userId); //valida que exista el usuario1
        if (this.postService.findByUserId(userId).size() == 0) //valida que sea un vendendor
            throw new BadRequestException(String.format("The user with the id %s is not a seller.", userId));
        return Mapper.parseToFollowersCountResDTO(user);
    }

    //Recibe un userID, realiza validaciones y en caso de que esté correcto devuelve un FollowersListResDTO con
    //la todos los users que sigue el user.
    @Override
    public FollowersListResDTO listFollowers(Integer userId, String order) {
        User user = this.validateUser(userId);

        if (this.postService.findByUserId(userId).size() == 0) //valida que sea un vendendor
            throw new BadRequestException(String.format("The user with the id %s is not a seller.", userId));

        var followers = user.getFollowers().stream();
        if (order == null || !order.equals("name_desc")) //por defecto ascendente
            followers = followers.sorted(Comparator.comparing(User::getUserName));
        else
            followers = followers.sorted(Comparator.comparing(User::getUserName).reversed());

        return Mapper.parseToFollowersListResDTO(user, followers.collect(Collectors.toList()));
    }

    //Recibe un userID, realiza validaciones y en caso de que esté correcto devuelve un FollowedListResDTO con
    //la todos los users que siguen al user.
    @Override
    public FollowedListResDTO listFollowed(Integer userId, String order) {
        User user = this.validateUser(userId); //valida que exista el usuario

        var followeds = user.getFollowed().stream();
        if (order == null || !order.equals("name_desc")) //por defecto ascendente
            followeds = followeds.sorted(Comparator.comparing(User::getUserName));
        else
            followeds = followeds.sorted(Comparator.comparing(User::getUserName).reversed());

        return Mapper.parseToFollowedListResDTO(user, followeds.collect(Collectors.toList()));
    }

    //Recibe un userID y aplica el control para verificar que el User exista.
    private User validateUser(Integer userID) {
        User user = this.userRepository.findById(userID);
        if (user == null) //valida si existe un usuario, sino devuelve un error
            throw new NotFoundException(String.format("The user with id: %s don't exists.", userID));
        return user;
    }
}
