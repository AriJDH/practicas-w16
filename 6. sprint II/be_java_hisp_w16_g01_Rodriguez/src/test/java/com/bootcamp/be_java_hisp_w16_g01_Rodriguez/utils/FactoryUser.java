package com.bootcamp.be_java_hisp_w16_g01_Rodriguez.utils;

import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.response.FollowersCountDTO;
import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.response.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.response.UserFollowerDTO;
import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.entities.User;

import java.util.ArrayList;
import java.util.List;

public class FactoryUser {

    public static List<User> getMockedUsers() {
        User user1 = new User(1, "User1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "User2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        User user4 = new User(4, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user5 = new User(5, "User3", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user1.addFollower(user2);
        user2.addFollowed(user1);

        user2.addFollower(user3);
        user3.addFollowed(user2);

        user3.addFollower(user2);
        user2.addFollowed(user3);

        return List.of(user1, user2, user3, user4, user5);
    }

    public static UserFollowedDTO getUserFollowed(){
        List<UserDTO> followed= new ArrayList<>();
        followed.add(new UserDTO(3, "alberto"));
        followed.add(new UserDTO(2, "sofia"));
        followed.add(new UserDTO(1, "juan"));

        return new UserFollowedDTO(4, "user 4", followed);
    }

    public static UserFollowedDTO getUserFollowedOrderAsc(){
        List<UserDTO> followed= new ArrayList<>();
        followed.add(new UserDTO(3, "alberto"));
        followed.add(new UserDTO(1, "juan"));
        followed.add(new UserDTO(2, "sofia"));

        return new UserFollowedDTO(4, "user 4", followed);
    }

    public static UserFollowedDTO getUserFollowedOrderDesc(){
        List<UserDTO> followed= new ArrayList<>();
        followed.add(new UserDTO(2, "sofia"));
        followed.add(new UserDTO(1, "juan"));
        followed.add(new UserDTO(3, "alberto"));

        return new UserFollowedDTO(4, "user 4", followed);
    }

    public static UserFollowerDTO getUserFollower(){
        List<UserDTO> follower= new ArrayList<>();
        follower.add(new UserDTO(3, "alberto"));
        follower.add(new UserDTO(2, "sofia"));
        follower.add(new UserDTO(1, "juan"));

        return new UserFollowerDTO(4, "user 4", follower);
    }

    public static UserFollowerDTO getUserFollowerAsc(){
        List<UserDTO> follower= new ArrayList<>();
        follower.add(new UserDTO(3, "alberto"));
        follower.add(new UserDTO(1, "juan"));
        follower.add(new UserDTO(2, "sofia"));

        return new UserFollowerDTO(4, "user 4", follower);
    }

    public static UserFollowerDTO getUserFollowerDesc(){
        List<UserDTO> follower= new ArrayList<>();
        follower.add(new UserDTO(2, "sofia"));
        follower.add(new UserDTO(1, "juan"));
        follower.add(new UserDTO(3, "alberto"));

        return new UserFollowerDTO(4, "user 4", follower);
    }

    public static User getUserWithFollowed(){
        List<User> followed= new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(2, "sofia"));
        followed.add(new User(1, "juan"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);

        return user;
    }

    public static User getUserWithFollowedAsc(){
        List<User> followed= new ArrayList<>();
        followed.add(new User(3, "alberto"));
        followed.add(new User(1, "juan"));
        followed.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);

        return user;
    }

    public static User getUserWithFollowedDesc(){
        List<User> followed= new ArrayList<>();
        followed.add(new User(2, "sofia"));
        followed.add(new User(1, "juan"));
        followed.add(new User(3, "alberto"));
        User user = new User(4, "user 4");
        user.setFollowed(followed);

        return user;
    }

    public static User getUserWithFollowers(){
        List<User> followers= new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(2, "sofia"));
        followers.add(new User(1, "juan"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        return user;
    }

    public static User getUserWithFollowersAsc(){
        List<User> followers= new ArrayList<>();
        followers.add(new User(3, "alberto"));
        followers.add(new User(1, "juan"));
        followers.add(new User(2, "sofia"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        return user;
    }

    public static User getUserWithFollowersDesc(){
        List<User> followers= new ArrayList<>();
        followers.add(new User(2, "sofia"));
        followers.add(new User(1, "juan"));
        followers.add(new User(3, "alberto"));
        User user = new User(4, "user 4");
        user.setFollowers(followers);

        return user;
    }

    public static FollowersCountDTO getFollowersCountDTO(User userFollowed){
        User userFollower1 = new User();
        User userFollower2 = new User();

        List<User> followers = new ArrayList<>();

        followers.add(userFollower1);
        followers.add(userFollower2);
        userFollowed.setFollowers(followers);

        return new FollowersCountDTO(userFollowed.getUserId(), userFollowed.getUserName(), userFollowed.getFollowers().size());
    }
}
