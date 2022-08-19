package com.bootcamp.be_java_hisp_w16_g10.entity;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private List<User> followers;
    private List<User> followed;

    public Integer countFollowers(){
        return this.followers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && userName.equals(user.userName) && followers.equals(user.followers) && followed.equals(user.followed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, followers, followed);
    }
}
