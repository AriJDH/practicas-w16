package com.bootcamp.SocialMeli2.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserFollowersRepositoryTest {

    private UserFollowersRepository userFollowersRepository;

    @BeforeEach
    public void init() {
        userFollowersRepository = new UserFollowersRepository();
    }

    @Test
    public void loadData() {
        Assertions.assertTrue(userFollowersRepository.getUsersList().size() > 0);
    }
}
