package com.bootcamp.SocialMeli2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListFollowedDTO {

    private int user_id;
    private String user_name;
}
