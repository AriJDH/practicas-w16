package com.bootcamp.be_java_hisp_w16_g7.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class FollowersDTO {
    private int user_id;
    private String user_name;
}
