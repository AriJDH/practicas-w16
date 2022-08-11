package com.example.be_java_hisp_w16_g03.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromoPostsDTO {
    private Integer userId;
    private String userName;
    private List<PromoPostWithIdDTO> posts;
}
