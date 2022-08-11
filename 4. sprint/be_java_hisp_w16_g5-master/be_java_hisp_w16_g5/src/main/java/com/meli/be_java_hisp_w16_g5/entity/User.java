package com.meli.be_java_hisp_w16_g5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private  int  userId;
    private String userName;
    private List<Post> posts;
    private List<User> followers;//los que me siguen
    private List<User> following;//los que sigo

}
