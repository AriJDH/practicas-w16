package com.bootcamp.SocialMeli2.dto;

import com.bootcamp.SocialMeli2.entity.Follow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int userId;
    private String userName;
    private List<Follow> followed;
    private List<Follow> followers;
}
