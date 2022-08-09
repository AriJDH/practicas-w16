package com.bootcamp.be_java_hisp_w16_g7.dto;

import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FollowersSellersDTO{
    private int user_id;
    private String user_name;
    private List<FollowersDTO> followers;

}
