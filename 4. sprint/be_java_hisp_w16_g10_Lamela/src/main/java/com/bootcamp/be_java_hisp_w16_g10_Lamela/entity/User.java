package com.bootcamp.be_java_hisp_w16_g10_Lamela.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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
}
