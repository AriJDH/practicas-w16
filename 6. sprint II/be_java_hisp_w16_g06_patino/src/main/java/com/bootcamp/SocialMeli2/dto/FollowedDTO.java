package com.bootcamp.SocialMeli2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedDTO {

    private int user_id;
    private String user_name;
    private List<ListFollowedDTO> followed;
}
