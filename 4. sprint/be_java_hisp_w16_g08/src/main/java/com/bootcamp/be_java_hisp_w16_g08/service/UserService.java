package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g08.entiry.User;
import com.bootcamp.be_java_hisp_w16_g08.exception.*;
import com.bootcamp.be_java_hisp_w16_g08.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g08.util.MapperProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {
    final
    IUserRepository iUserRepository;

    final
    IPostRepository iPostRepository;

    final MapperProduct utilMapper;

    public UserService(IUserRepository iUserRepository, IPostRepository iPostRepository, MapperProduct utilMapper) {
        this.iUserRepository = iUserRepository;
        this.iPostRepository = iPostRepository;

        this.utilMapper = utilMapper;
    }

    ModelMapper mapper = new ModelMapper();


    @Override
    public void addFollower(int idUser, int idUserToFollow) {
        if (idUser == idUserToFollow) {
            throw new CanNotFollowYourSelfException();
        }
        User follower = getUserIfExist(idUser);
        User followed = getUserIfExist(idUserToFollow);
        if (alreadyFollowAUser(follower, followed)) {
            throw new AlreadyFollowAUserException();
        }
        followed.getFollowerList().add(follower);
        follower.getFollowedList().add(getUserIfExist(idUserToFollow));

    }

    private boolean alreadyFollowAUser(User user, User userToFollow) {
        List<User> followed = user.getFollowedList();
        return followed.contains(userToFollow);
    }

    @Override
    public UserFollowersCountDto getUserFollowerCount(int userId) {
        User user = getUserIfExist(userId);
        if (!isVendor(user)) {
            throw new UserNotVendorException();
        }
        int followersCount = user.getFollowerList().size();
        return new UserFollowersCountDto(user.getUserId(), user.getName(), followersCount);
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        User user = getUserIfExist(userId);
        User userToUnfollow = getUserIfExist(userIdToUnfollow);
        List<User> followers = user.getFollowedList();

        if (!followers.contains(userToUnfollow)) {
            throw new UserNotFolllowException(String.valueOf(userId), String.valueOf(userIdToUnfollow));

        }

        user.getFollowedList().remove(userToUnfollow);
        userToUnfollow.getFollowerList().remove(user);
    }


    private User getUserIfExist(int idUser) {
        if (!iUserRepository.isPresent(idUser)) {
            throw new UserNotFoundException();
        }
        return iUserRepository.getUserById(idUser);
    }


    public UserDto getUserById(int idUser) {
        User user = getUserIfExist(idUser);

        List<ResponseUserInformationDto> followres = user.getFollowerList().stream().map(user1 -> new ResponseUserInformationDto(user1.getUserId(), user1.getName())).collect(Collectors.toList());

        List<ResponseUserInformationDto> followed = user.getFollowedList().stream().map(user1 ->
                new ResponseUserInformationDto(user1.getUserId(), user1.getName())).collect(Collectors.toList());

        return new UserDto(user.getUserId(), user.getName(), followres, followed);


    }

    @Override
    public UserFollowers getVendorsFollowedByUser(int userId) {


        User serchedUser = getUserIfExist(userId);
        List<UserFollowersList> vendorsFollowed = serchedUser.getFollowedList().stream().
                filter(x -> isVendor(x)).
                map(x -> new UserFollowersList(x.getUserId(), x.getName()))
                .collect(Collectors.toList());

        return new UserFollowers(serchedUser.getUserId(), serchedUser.getName(), vendorsFollowed);
    }

    public boolean isVendor(User user) {
        return user.getPostMade().size() > 0;
    }


    @Override
    public UserFollowers getAllVendorFollowers(int id) {
        User user = getUserIfExist(id);
        if (!isVendor(user)) {
            throw new UserNotVendorException();
        }
        return new UserFollowers(id, user.getName(), user.getFollowerList().stream()
                .map(x -> mapper.map(x, UserFollowersList.class))
                .collect(Collectors.toList()));

    }

    @Override
    public ResponsePostFromFollowedDto getPostFromFollowed(int userId) {
        User user = getUserIfExist(userId);
        List<User> list = user.getFollowedList().stream()
                .filter(x -> isVendor(x))
                .collect(Collectors.toList());
        List<ResponsePostDto> orderedList = utilMapper
                .mapUserPostDto(list).stream()
                .filter(x -> x.getDate().isAfter(LocalDate.now().minusDays(14)))
                .collect(Collectors.toList());
        return new ResponsePostFromFollowedDto(userId, orderedList);
    }
}

