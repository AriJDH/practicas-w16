package com.example.be_java_hisp_w16_g09_bariani.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersCountDTO {
    private int user_id;
    private String user_name;
    private int followers_count;
}
