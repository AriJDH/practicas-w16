package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.*;
import com.bootcamp.SocialMeli2.entity.Follow;
import com.bootcamp.SocialMeli2.entity.User;
import com.bootcamp.SocialMeli2.exceptions.FollowedNotFoundException;
import com.bootcamp.SocialMeli2.exceptions.UserNotFoundException;
import com.bootcamp.SocialMeli2.repository.UserFollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FollowersAndFollowedService implements IFollowersAndFollowedService {

    @Autowired
    UserFollowersRepository repository;

    @Override
    public FollowersCountDTO userFollowers(Integer userId) {
        Optional<UserDTO> user = findById(userId).stream().findFirst();
        if (user.isPresent()) {
            return followersCountDTO(user.get());
        } else {
            throw new UserNotFoundException("No se encuentra el usuario");
        }
    }

    @Override
    public FollowedDTO userFollowed(int userId, String order) {
        FollowedDTO dto = userFollowed(userId);
        List<ListFollowedDTO> followed;

        if (order == null || order.equalsIgnoreCase("name_asc")) {
            followed = dto.getFollowed().stream().sorted((x, y) -> x.getUser_name().compareTo(y.getUser_name())).collect(Collectors.toList());
        } else if (order.equalsIgnoreCase("name_desc")) {
            followed = dto.getFollowed().stream().sorted((x, y) -> y.getUser_name().compareTo(x.getUser_name())).collect(Collectors.toList());
        } else {
            throw new FollowedNotFoundException("La forma de ordenado no existe");
        }
        dto.setFollowed(followed);

        return dto;
    }

    @Override
    public FollowersDTO userFollowersOrder(int userId, String order) {
        FollowersDTO dto = listFollowers(userId);
        List<ListFollowersDTO> followersOrder;

        if (order == null || order.equalsIgnoreCase("name_asc")) {
            followersOrder = dto.getFollowers().stream().sorted((x, y) -> x.getUser_name().compareTo(y.getUser_name())).collect(Collectors.toList());
        } else if (order.equalsIgnoreCase("name_desc")) {
            followersOrder = dto.getFollowers().stream().sorted((x, y) -> y.getUser_name().compareTo(x.getUser_name())).collect(Collectors.toList());
        } else {
            throw new FollowedNotFoundException("La forma de ordenado no existe");
        }
        dto.setFollowers(followersOrder);

        return dto;
    }

    @Override
    public List<UserDTO> findById(int userId) {

        List<User> users = repository.getUsersList()
                .stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .collect(Collectors.toList());

        return listUserDTO(users);
    }

    private List<UserDTO> listUserDTO(List<User> Users) {

        List<UserDTO> userFollowers = Users.stream().map(user -> {
            UserDTO userDto = new UserDTO();
            userDto.setUserId(user.getUserId());
            userDto.setUserName(user.getUserName());
            userDto.setFollowed(user.getFollowed());
            userDto.setFollowers(user.getFollowers());
            return userDto;
        }).collect(Collectors.toList());

        return userFollowers;
    }

    private FollowersCountDTO followersCountDTO(UserDTO userDTO) {
        Integer follower = 0;
        if (userDTO.getFollowers() != null) {
            follower = userDTO.getFollowers().size();
        }
        return new FollowersCountDTO(userDTO.getUserId(), userDTO.getUserName(), follower);

    }

    private FollowedDTO userFollowed(int userId) {

        Optional<UserDTO> user = findById(userId).stream().findFirst();
        if (user.isPresent()) {
            return new FollowedDTO(user.get().getUserId(), user.get().getUserName(), userFollowedDTO(user.get()));
        } else {
            throw new UserNotFoundException("No se encuentra el usuario");
        }

    }

    // Recibe un userDTO y obtiene la lista de seguidores, y si no es null, devuelve una lista de FollowedDTO con el id y el nombre de la lista de seguidores
    private List<ListFollowedDTO> userFollowedDTO(UserDTO userDTO) {

        List<ListFollowedDTO> followedsDTO = new ArrayList<>();

        if (userDTO.getFollowed() != null && !userDTO.getFollowed().isEmpty()) {
            for (Follow f : userDTO.getFollowed()) {
                followedsDTO.add(new ListFollowedDTO(f.getId(), f.getName()));
            }
        } else {
            throw new FollowedNotFoundException("No sigue a ningun vendedor");
        }
        return followedsDTO;
    }

    private List<ListFollowersDTO> userListFollowersDTO(UserDTO userDTO) {

        List<ListFollowersDTO> listFollowersDTO = new ArrayList<>();

        if (userDTO.getFollowers() != null) {
            for (Follow f : userDTO.getFollowers()) {
                listFollowersDTO.add(new ListFollowersDTO(f.getId(), f.getName()));
            }
        } else {
            throw new FollowedNotFoundException("Null followers");
        }
        return listFollowersDTO;
    }

    private FollowersDTO listFollowers(Integer userId) {
        Optional<UserDTO> user = findById(userId).stream().findFirst();
        if (user.isPresent()) {
            return new FollowersDTO(user.get().getUserId(), user.get().getUserName(), userListFollowersDTO(user.get()));
        } else {
            throw new UserNotFoundException("No se encuentra el usuario");
        }
    }

}
