package com.example.be_java_hisp_w16_g09_Nicoletta.dto;

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
