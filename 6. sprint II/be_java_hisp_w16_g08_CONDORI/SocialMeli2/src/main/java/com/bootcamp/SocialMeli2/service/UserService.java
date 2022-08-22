package com.bootcamp.SocialMeli2.service;

import com.bootcamp.SocialMeli2.dto.response.*;
import com.bootcamp.SocialMeli2.entiry.User;
import com.bootcamp.SocialMeli2.exception.*;
import com.bootcamp.SocialMeli2.repository.IPostRepository;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.util.MapperProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.time.LocalDate;
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
    public UserFollowedDto getVendorsFollowedByUser(int userId, String order) {


        User serchedUser = getUserIfExist(userId);
        List<UserBasicInfoDto> vendorsFollowed = serchedUser.getFollowedList().stream().
                filter(x -> isVendor(x)).
                map(x -> new UserBasicInfoDto(x.getUserId(), x.getName()))
                .collect(Collectors.toList());


        return new UserFollowedDto(serchedUser.getUserId(), serchedUser.getName(), OrderListFollowers(vendorsFollowed, order));

    }

    public boolean isVendor(User user) {
        return user.getPostMade().size() > 0;
    }


    @Override
    public UserFollowers getAllVendorFollowers(int id, String order) {
        User user = getUserIfExist(id);
        if (!isVendor(user)) {
            throw new UserNotVendorException();
        }
        return new UserFollowers(id, user.getName(), OrderListFollowers(user.getFollowerList().stream()
                .map(x -> mapper.map(x, UserBasicInfoDto.class))
                .collect(Collectors.toList()), order));

    }

    private List<UserBasicInfoDto> OrderListFollowers(List<UserBasicInfoDto> list, String order) {
        if (order != null) {
            if (order.equalsIgnoreCase("name_asc")) {
                return list.stream().sorted(Comparator.comparing(UserBasicInfoDto::getUserName)).collect(Collectors.toList());
            } else if (order.equalsIgnoreCase("name_desc")) {
                return list.stream().sorted(Comparator.comparing(UserBasicInfoDto::getUserName).reversed()).collect(Collectors.toList());
            } else {
                throw new OrderNotPossibleException();
            }
        }
        return list;
    }

    @Override
    public ResponsePostFromFollowedDto getPostFromFollowed(int userId, String order) {


        User user = getUserIfExist(userId);
        List<User> list = user.getFollowedList().stream()
                .filter(x -> isVendor(x))
                .collect(Collectors.toList());

        List<ResponsePostDto> orderedList = utilMapper
                .mapUserPostDto(list).stream()
                .filter(x -> x.getDate().isAfter(LocalDate.now().minusDays(14)))
                .collect(Collectors.toList());

        return new ResponsePostFromFollowedDto(userId, orderPostList(orderedList, order));
    }

    public List<ResponsePostDto> orderPostList(List<ResponsePostDto> postList, String order) {
        if (order != null) {
            if (order.equalsIgnoreCase("date_asc")) {
                return postList.stream()
                        .sorted(Comparator.comparing(ResponsePostDto::getDate))
                        .collect(Collectors.toList());
            } else if (order.equalsIgnoreCase("date_desc")) {
                return postList.stream()
                        .sorted(Comparator.comparing(ResponsePostDto::getDate).reversed())
                        .collect(Collectors.toList());
            } else {
                throw new OrderNotPossibleException();
            }
        }
        return postList;

    }
}
