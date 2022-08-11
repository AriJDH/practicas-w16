package com.bootcamp.be_java_hisp_w16_g7_cardenas.service;

import com.bootcamp.be_java_hisp_w16_g7_cardenas.dto.*;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.entity.User;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g7_cardenas.exception.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final ModelMapper mapper;


    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        mapper = new ModelMapper();
    }

    @Override
    public HttpStatus follow(int userId, int userIdToFollow) {
        if(userId == userIdToFollow) throw new SameUserException(userId);
        User user = userRepository.findUserById(userId);
        User target = userRepository.findUserById(userIdToFollow);

        if (user == null) throw new UserNotFoundException(userId);
        if (target == null) throw new UserNotFoundException(userIdToFollow);
        if (!target.isSeller()) throw new UserIsNotSellerException(userIdToFollow);
        if (target.getFollowers().contains(user)) throw new AlreadyFollowingException(userIdToFollow, userId);

        userRepository.addToUserFollows(target, user);
        userRepository.addToUserFollowers(user, target);

        return HttpStatus.OK;
    }

    @Override
    public HttpStatus unfollow(int userId, int userIdToUnfollow) {
        if(userId == userIdToUnfollow) throw new SameUserException(userId);
        User user = userRepository.findUserById(userId);
        User target = userRepository.findUserById(userIdToUnfollow);

        if (user == null) throw new UserNotFoundException(userId);
        if (target == null) throw new UserNotFoundException(userIdToUnfollow);
        if (!target.getFollowers().contains(user)) throw new NotFollowingException(userIdToUnfollow, userId);

        userRepository.removeFromUserFollows(target, user);
        userRepository.removeFromUserFollowers(user, target);

        return HttpStatus.OK;
    }

    @Override
    public ResponseUserFollowedDTO getUserFollowedList(int id, String order) {
        User user = userRepository.findUserById(id);
        if (user == null) throw new UserNotFoundException(id);
        Comparator<ResponseUserDTO> userComp = Comparator.comparing(ResponseUserDTO::getUserName);

        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")) {
            throw new InvalidQueryException("order", order);
        }
        if ("name_desc".equals(order))
            userComp = userComp.reversed();
        List<ResponseUserDTO> followed = user.getFollows().stream()
                .map(u -> mapper.map(u, ResponseUserDTO.class))
                .sorted(userComp)
                .collect(Collectors.toList());

        return new ResponseUserFollowedDTO(user.getId(), user.getName(), followed);
    }

    @Override
    public FollowersSellersDTO getSellersFollowers(int id, String order) {
        User response = userRepository.findUserById(id);
        if (response == null) {
            throw new UserNotFoundException(id);
        }
        // Check if query is valid
        if (order != null && !order.equals("name_asc") && !order.equals("name_desc")) {
            throw new InvalidQueryException("order", order);
        }
        Comparator<FollowersDTO> comparator = Comparator.comparing(FollowersDTO::getName);
        if ("name_desc".equals(order)) {
            comparator = comparator.reversed();
        }
        if (response.isSeller()) {
            List<FollowersDTO> followersToDTO = new ArrayList<>();
            response.getFollowers().forEach(u -> followersToDTO.add(new FollowersDTO(u.getId(), u.getName())));
            followersToDTO.sort(comparator);
            return new FollowersSellersDTO(response.getId(), response.getName(), followersToDTO);
        }

        throw new UserIsNotSellerException(id);
    }

    public FollowersCountDto getFollowersCount(int id) {
        int countFollowers = 0;
        User userFound = userRepository.findUserById(id);
        if (userFound == null) {
            throw new UserNotFoundException(id);
        }
        if (userFound.isSeller()) {
            countFollowers = userFound.getFollowers().size();
        } else {
            throw new UserIsNotSellerException(id);
        }
        return new FollowersCountDto(userFound.getId(), userFound.getName(), countFollowers);
    }
}
