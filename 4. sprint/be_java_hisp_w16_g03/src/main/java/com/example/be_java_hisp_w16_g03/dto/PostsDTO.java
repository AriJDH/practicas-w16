package com.example.be_java_hisp_w16_g03.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsDTO {
    private Integer userId;
    private List<PostWithIDDTO> postDTOList;
}
