package com.example.Sprint1.dto;


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
