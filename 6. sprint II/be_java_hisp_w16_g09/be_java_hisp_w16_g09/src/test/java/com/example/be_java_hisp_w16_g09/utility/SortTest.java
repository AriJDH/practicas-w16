package com.example.be_java_hisp_w16_g09.utility;

import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.utility.sort.Sort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest {

    @Test
    void shouldSortAscByGivenCondition() {
        User user1 = new User(1, "Aperol", new ArrayList(), new ArrayList());
        User user2 = new User(2, "Fernet", new ArrayList(), new ArrayList());
        User user3 = new User(2, "Xe", new ArrayList(), new ArrayList());

        List<User> users = Arrays.asList(user3, user1, user2);

        List<User> sortedUsers = Sort.orderSequenceBasedOn("name_asc", "name").sortingBy(User::getUserName, users);

        List<User> expectedResult = List.of(user1, user2, user3);

        Assertions.assertThat(sortedUsers).isEqualTo(expectedResult);
    }

    @Test
    void shouldSortDescByGivenCondition() {
        User user1 = new User(1, "Aperol", new ArrayList(), new ArrayList());
        User user2 = new User(2, "Fernet", new ArrayList(), new ArrayList());
        User user3 = new User(2, "Xe", new ArrayList(), new ArrayList());

        List<User> users = Arrays.asList(user3, user1, user2);

        List<User> sortedUsers = Sort.orderSequenceBasedOn("name_desc", "name").sortingBy(User::getUserName, users);

        List<User> expectedResult = List.of(user3, user2, user1);

        Assertions.assertThat(sortedUsers).isEqualTo(expectedResult);
    }

    @Test
    void shouldNotSortWithoutOrder() {
        User user1 = new User(1, "Aperol", new ArrayList(), new ArrayList());
        User user2 = new User(2, "Fernet", new ArrayList(), new ArrayList());
        User user3 = new User(2, "Xe", new ArrayList(), new ArrayList());

        List<User> users = Arrays.asList(user3, user1, user2);

        List<User> sortedUsers = Sort.orderSequenceBasedOn(null, "name").sortingBy(User::getUserName, users);

        Assertions.assertThat(sortedUsers).isEqualTo(users);
    }

}
