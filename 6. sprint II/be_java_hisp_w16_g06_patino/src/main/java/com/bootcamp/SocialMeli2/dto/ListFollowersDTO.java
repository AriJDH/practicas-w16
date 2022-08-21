package com.bootcamp.SocialMeli2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListFollowersDTO {

    private int user_id;
    private String user_name;


}
