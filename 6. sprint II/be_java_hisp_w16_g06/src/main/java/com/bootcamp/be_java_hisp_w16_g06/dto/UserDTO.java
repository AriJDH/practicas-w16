package com.bootcamp.be_java_hisp_w16_g06.dto;

import com.bootcamp.be_java_hisp_w16_g06.entity.Follow;
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
