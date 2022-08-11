package com.example.Sprint1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoListDTO {
    private int user_id;
    private String user_name;
    private List<PostPromoOfSimpleUserDTO> posts;
}
