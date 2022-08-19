package com.example.be_java_hisp_w16_g09.util;

import com.example.be_java_hisp_w16_g09.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersUtility {

    public static User getUserWith5Followers(){
        User mockUser = new User();
        mockUser.setUserId(1);
        mockUser.setUserName("MockedUser1");
        mockUser.setFollowing(new ArrayList<>());

        User mockFollower1 = new User();
        mockFollower1.setUserId(2);
        mockFollower1.setUserName("Bernardo Lopez");
        mockFollower1.setFollowing(List.of(mockUser));
        mockFollower1.setFollowers(new ArrayList<>());

        User mockFollower2 = new User();
        mockFollower2.setUserId(3);
        mockFollower2.setUserName("Bernardo Alvarez");
        mockFollower2.setFollowing(List.of(mockUser));
        mockFollower2.setFollowers(new ArrayList<>());

        User mockFollower3 = new User();
        mockFollower3.setUserId(4);
        mockFollower3.setUserName("Alberto Jose");
        mockFollower3.setFollowing(List.of(mockUser));
        mockFollower3.setFollowers(new ArrayList<>());

        User mockFollower4 = new User();
        mockFollower4.setUserId(5);
        mockFollower4.setUserName("Carlos Osorio");
        mockFollower4.setFollowing(List.of(mockUser));
        mockFollower4.setFollowers(new ArrayList<>());

        User mockFollower5 = new User();
        mockFollower5.setUserId(6);
        mockFollower5.setUserName("Dario Osorio");
        mockFollower5.setFollowing(List.of(mockUser));
        mockFollower5.setFollowers(new ArrayList<>());

        mockUser.setFollowers(Arrays.asList(mockFollower1,mockFollower2,mockFollower3,mockFollower4,mockFollower5));
        return mockUser;
    }

    public static User getUserWith2Followers(){
        User userMock1 = new User(3, "Agustin", null, null);
        User userMock2 = new User(4, "Mateo", null, null);
        User userMock = new User(2, "Marcos", List.of(userMock1, userMock2), null);
        return userMock;
    }

    public static User getUserWithNoFollowers(){
        return new User(2, "Marcos", new ArrayList<>(), new ArrayList<>());
    }
}
